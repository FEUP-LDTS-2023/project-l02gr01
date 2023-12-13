package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.elements.Exit;
import com.l02gr01.escape.model.elements.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ExitControllerTest {

    Level levelMock;
    Keys keysMock;
    Exit exitMock;
    Game gameMock;
    ExitController exitController;

    @BeforeEach
    void setUp() {
        levelMock = Mockito.mock(Level.class);
        keysMock = Mockito.mock(Keys.class);
        exitMock = Mockito.mock(Exit.class);
        gameMock = Mockito.mock(Game.class);
        exitController = new ExitController(levelMock);
        Mockito.when(levelMock.getKeys()).thenReturn(keysMock);
        Mockito.when(levelMock.getExit()).thenReturn(exitMock);
    }

    @Test
    void testSetOpen() {
        Mockito.when(keysMock.getRemainingKeys()).thenReturn(0);
        exitController.step(gameMock, GUI.ACTION.NONE, 100);
        Mockito.verify(exitMock).setOpen(true);
    }

    @Test
    void testNeverSetOpen() {
        Mockito.when(keysMock.getRemainingKeys()).thenReturn(2);
        exitController.step(gameMock, GUI.ACTION.NONE, 100);
        Mockito.verify(exitMock, Mockito.never()).setOpen(true);
    }
}