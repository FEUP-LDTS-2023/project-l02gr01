package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.audio.AudioManager;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.EndGame;
import com.l02gr01.escape.states.LeaderBoardState;
import com.l02gr01.escape.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class EndGameControllerTest {

    Game mockGame;
    EndGameController endGameController;

    @BeforeEach
    void setUp() {
        mockGame = Mockito.mock(Game.class);
        endGameController = new EndGameController(Mockito.mock(EndGame.class));
    }

    @Test
    void testSelectStep() throws IOException, URISyntaxException {
        Mockito.doNothing().when(Mockito.mock(AudioManager.class)).playSound(Mockito.anyString());
        endGameController.step(mockGame, GUI.ACTION.SELECT, 0);
        Mockito.verify(mockGame).setState(Mockito.any(MenuState.class));
        Mockito.verifyNoMoreInteractions(mockGame);

    }

    @Test
    void testTabStep() throws IOException, URISyntaxException {
        endGameController.step(mockGame, GUI.ACTION.TAB, 0);
        Mockito.verify(mockGame).setState(Mockito.any(LeaderBoardState.class));
        Mockito.verifyNoMoreInteractions(mockGame);

    }

    @Test
    void testOtherActionStep() throws IOException, URISyntaxException {
        endGameController.step(mockGame, GUI.ACTION.QUIT, 0);
        Mockito.verifyNoInteractions(mockGame);
    }
}