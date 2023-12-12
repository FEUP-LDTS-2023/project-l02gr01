package com.l02gr01.escape.viewer;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.EndGame;
import com.l02gr01.escape.model.Instruction;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.viewer.instruction.InstructionViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EndGameViewerTest {
    private EndGameViewer endGameViewer;
    private GUI mockGUI;
    private EndGame endGame;

    @BeforeEach
    void setUp() {
        endGame = new EndGame(1,1);
        endGameViewer = new EndGameViewer(endGame);
        mockGUI = Mockito.mock(GUI.class);
    }

    @Test
    void testDrawLines() {
        endGameViewer.drawElements(mockGUI);
        Mockito.verify(mockGUI).drawText(new Position(10, 2), "GAME OVER", "#FF1100");
        Mockito.verify(mockGUI).drawText(new Position(10, 8), "YOUR STATS", "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(11, 10), "Level:" + endGame.level(), "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(10, 12), "Time (s):" + endGame.time(), "#FFFFFF");

        Mockito.verify(mockGUI).drawText(new Position(5, 18), "ENTER", "#FFD700");
        Mockito.verify(mockGUI).drawText(new Position(11, 18), "to go to", "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(20, 18), "MENU", "#3333FF");

        Mockito.verify(mockGUI).drawText(new Position(3, 20), "TAB", "#FFD700");
        Mockito.verify(mockGUI).drawText(new Position(7, 20), "to go to", "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(16, 20), "LEADERBOARD", "#3333FF");
    }

}