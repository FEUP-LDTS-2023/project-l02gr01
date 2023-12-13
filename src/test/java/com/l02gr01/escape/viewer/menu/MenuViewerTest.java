package com.l02gr01.escape.viewer.menu;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Menu;
import com.l02gr01.escape.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class MenuViewerTest {

    GUI mockGUI;
    Menu menu;
    MenuViewer menuViewer;

    @BeforeEach
    void setUp() {
        mockGUI = Mockito.mock(GUI.class);
        menu = new Menu();
        menuViewer = new MenuViewer(menu);
    }

    @Test
    void testDrawElements() {
        menuViewer.drawElements(mockGUI);

        Mockito.verify(mockGUI).drawText(new Position(11, 5), "Menu", "#3333FF");
        Mockito.verify(mockGUI).drawText(new Position(11, 8), "Start", "#FFD700");
        Mockito.verify(mockGUI).drawText(new Position(11, 9), "Instructions", "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(11, 10), "Leaderboard", "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(11, 11), "Exit", "#FFFFFF");
    }

    @Test
    void testDrawElementsWithSelection() {
        menu.nextEntry();
        menuViewer.drawElements(mockGUI);

        Mockito.verify(mockGUI).drawText(new Position(11, 5), "Menu", "#3333FF");
        Mockito.verify(mockGUI).drawText(new Position(11, 8), "Start", "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(11, 9), "Instructions", "#FFD700");
        Mockito.verify(mockGUI).drawText(new Position(11, 10), "Leaderboard", "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(11, 11), "Exit", "#FFFFFF");
    }
}