package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Menu;
import com.l02gr01.escape.states.InstructionState;
import com.l02gr01.escape.states.LeaderBoardState;
import com.l02gr01.escape.states.PreGameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URISyntaxException;

class MenuControllerTest {

    MenuController menuController;
    Game gameMock;
    Menu menuMock;

    @BeforeEach
    void setUp() {
        menuMock = Mockito.mock(Menu.class);
        menuController = new MenuController(menuMock);
        gameMock = Mockito.mock(Game.class);
    }

    @Test
    void testSelectExit() throws IOException, URISyntaxException {
        Mockito.when(menuMock.isSelectedExit()).thenReturn(true);
        menuController.step(gameMock, GUI.ACTION.SELECT, 100);
        Mockito.verify(gameMock).setState(null);
    }

    @Test
    void testSelectPreGame() throws IOException, URISyntaxException {
        Mockito.when(menuMock.isSelectedStart()).thenReturn(true);
        menuController.step(gameMock, GUI.ACTION.SELECT, 100);
        Mockito.verify(gameMock).setState(Mockito.any(PreGameState.class));
    }

    @Test
    void testSelectInstructions() throws IOException, URISyntaxException {
        Mockito.when(menuMock.isSelectedInstruction()).thenReturn(true);
        menuController.step(gameMock, GUI.ACTION.SELECT, 100);
        Mockito.verify(gameMock).setState(Mockito.any(InstructionState.class));
    }

    @Test
    void testSelectLeaderboard() throws IOException, URISyntaxException {
        Mockito.when(menuMock.isSelectedLeaderboard()).thenReturn(true);
        menuController.step(gameMock, GUI.ACTION.SELECT, 100);
        Mockito.verify(gameMock).setState(Mockito.any(LeaderBoardState.class));
    }

    @Test
    void testMoveToPreviousEntry() throws IOException, URISyntaxException {
        Mockito.when(menuMock.isSelectedExit()).thenReturn(true);
        menuController.step(gameMock, GUI.ACTION.UP, 100);
        Mockito.verify(menuMock).previousEntry();
    }

    @Test
    void testMoveToNextEntry() throws IOException, URISyntaxException {
        Mockito.when(menuMock.isSelectedExit()).thenReturn(true);
        menuController.step(gameMock, GUI.ACTION.DOWN, 100);
        Mockito.verify(menuMock).nextEntry();
    }
    
}