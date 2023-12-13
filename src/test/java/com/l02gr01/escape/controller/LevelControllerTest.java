package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Exit;
import com.l02gr01.escape.model.elements.Player;
import com.l02gr01.escape.model.history.History;
import com.l02gr01.escape.model.history.event.Loss;
import com.l02gr01.escape.states.EndGameState;
import com.l02gr01.escape.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URISyntaxException;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class LevelControllerTest {

    LevelController levelController;
    Level levelMock;
    Game gameMock;
    Player playerMock;
    Exit exitMock;
    History historyMock;

    @BeforeEach
    void setUp() {
        gameMock = Mockito.mock(Game.class);
        levelMock = Mockito.mock(Level.class);
        playerMock = Mockito.mock(Player.class);
        exitMock = Mockito.mock(Exit.class);
        historyMock = Mockito.mock(History.class);
        Mockito.when(levelMock.getPlayer()).thenReturn(playerMock);
        Mockito.when(levelMock.getExit()).thenReturn(exitMock);
        levelController = new LevelController(levelMock);
    }

    @Test
    void testEndGame() throws IOException, URISyntaxException {
        try (MockedStatic<History> history = Mockito.mockStatic(History.class)) {
            history.when(History::getInstance).thenReturn(historyMock);

            levelController.step(gameMock, GUI.ACTION.QUIT, 1000);

            Mockito.verify(historyMock, Mockito.times(1)).getUsername();
            Mockito.verify(historyMock).push(Mockito.any(Loss.class));
            Mockito.verify(gameMock).setState(Mockito.any(EndGameState.class));
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Test
    void testLossByHealth() {
        try (MockedStatic<History> history = Mockito.mockStatic(History.class)) {
            history.when(History::getInstance).thenReturn(historyMock);

            Mockito.when(levelMock.getPlayer().getHealth()).thenReturn(0);

            levelController.step(gameMock, GUI.ACTION.SELECT, 1000);

            Mockito.verify(historyMock, Mockito.times(1)).getUsername();
            Mockito.verify(historyMock).push(Mockito.any(Loss.class));
            Mockito.verify(gameMock).setState(Mockito.any(EndGameState.class));
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    @Test
    void testWinNextLevel() {
        try (MockedStatic<History> history = Mockito.mockStatic(History.class)) {
            history.when(History::getInstance).thenReturn(historyMock);

            Mockito.when(exitMock.getPosition()).thenReturn(new Position(5,5));
            Mockito.when(playerMock.getPosition()).thenReturn(new Position(5,5));

            levelController.step(gameMock, GUI.ACTION.QUIT, 1000);

            levelController.step(gameMock, GUI.ACTION.NONE, 1000);
            Mockito.verify(gameMock).setState(Mockito.any(EndGameState.class));
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}