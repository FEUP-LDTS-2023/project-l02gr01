package com.l02gr01.escape.viewer.game;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.elements.Key;
import com.l02gr01.escape.viewer.game.KeyViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class KeyViewerTest {

    private GUI gui;
    private KeyViewer keyViewer;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        keyViewer = new KeyViewer();
    }

    @Test
    void testDrawKeyNotPickedUp() {
        Key key = new Key(1, 1);
        key.setPickedUp(false);

        keyViewer.draw(key, gui);

        Mockito.verify(gui, Mockito.times(1)).drawKey(key.getPosition());
    }

    @Test
    void testDrawKeyPickedUp() {
        Key key = new Key(2, 2);
        key.setPickedUp(true);

        keyViewer.draw(key, gui);

        Mockito.verify(gui, Mockito.never()).drawKey(key.getPosition());
    }
}