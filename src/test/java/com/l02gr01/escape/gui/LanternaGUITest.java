package com.l02gr01.escape.gui;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Player;
import com.l02gr01.escape.model.elements.powers.Shield;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LanternaGUITest {
    private Screen screen;
    private TextGraphics tgraph;
    private LanternaGUI gui;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tgraph = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tgraph);
        gui = new LanternaGUI(screen);
    }


    @Test
    void drawText() {
        gui.drawText(new Position(5,5), "Player", "#000001");
        Mockito.verify(tgraph, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 0, 1));
        Mockito.verify(tgraph, Mockito.times(1)).putString(5, 5, "Player");
    }

    @Test
    void testDrawPlayer() {
        Player player1 = new Player(5,5);
        gui.drawPlayer(player1);
        Mockito.verify(tgraph, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tgraph, Mockito.times(1)).setCharacter(5,6, Symbols.FACE_WHITE);

        Player player2 = new Player(8,9);
        player2.addPower(new Shield(8,9), 100);
        gui.drawPlayer(player2);
        Mockito.verify(tgraph, Mockito.times(1)).setForegroundColor(new TextColor.RGB(168, 148, 255));
        Mockito.verify(tgraph, Mockito.times(1)).setCharacter(8,10, Symbols.FACE_WHITE);
    }

    @Test
    void testDrawExit() {

        gui.drawExit(new Position(1, 1), false);
        Mockito.verify(tgraph, Mockito.times(1)).setForegroundColor(new TextColor.RGB(92, 1, 46));
        Mockito.verify(tgraph, Mockito.times(1)).setCharacter(1,2,Symbols.BLOCK_SPARSE);

        gui.drawExit(new Position(0,0), true);
        Mockito.verify(tgraph, Mockito.times(1)).setForegroundColor(new TextColor.RGB(27, 242, 7));
        Mockito.verify(tgraph, Mockito.times(1)).setCharacter(0,1,Symbols.BLOCK_SPARSE);

    }
}