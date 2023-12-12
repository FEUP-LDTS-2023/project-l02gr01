package com.l02gr01.escape.viewer;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.PreGame;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PreGameViewerTest {

    @Test
    void testDrawElements() {
        GUI mockGUI = Mockito.mock(GUI.class);
        PreGame preGame = new PreGame();
        PreGameViewer preGameViewer = new PreGameViewer(preGame);
        preGame.beNotified("Teste");

        preGameViewer.drawElements(mockGUI);

        Mockito.verify(mockGUI).drawText(new Position(11, 5), "Welcome", "#FFD700");
        Mockito.verify(mockGUI).drawText(new Position(6, 10), "What's your name?", "#FFDDBB");
        Mockito.verify(mockGUI).drawText(new Position(11, 14), "Teste", "#FFFFF6");
    }
}