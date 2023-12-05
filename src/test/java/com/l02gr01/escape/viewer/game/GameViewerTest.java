package com.l02gr01.escape.viewer.game;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Key;
import com.l02gr01.escape.model.elements.Player;
import com.l02gr01.escape.model.elements.Wall;
import com.l02gr01.escape.model.elements.enemies.Enemy;
import com.l02gr01.escape.model.elements.powers.Power;
import com.l02gr01.escape.model.elements.powers.Shield;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

class GameViewerTest {

    private GameViewer gameViewer;
    private GUI gui;
    private Level level;

    @BeforeEach
    void setUp() {
        level = new Level(15,15,1);
        gui = Mockito.mock(GUI.class);
        gameViewer = new GameViewer(level);


        level.setPowers(Arrays.asList(new Shield(1,3), new Shield(2,5)));
        level.setWalls(Arrays.asList(new Wall(1,7), new Wall(9,9)));
        level.getKeys().setKeys(Arrays.asList(new Key(8,8), new Key(7,7)));
        level.setEnemies(Arrays.asList(new Enemy(1,2), new Enemy(0,0)));
        level.setEnemies(Arrays.asList(new Enemy(1,2), new Enemy(0,0)));
        level.setPlayer(new Player(5,5));

    }

    @Test
    void testDrawPower() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawPower(level.getPowers().get(0));
        Mockito.verify(gui, Mockito.times(1)).drawPower(level.getPowers().get(1));
        Mockito.verify(gui, Mockito.times(2)).drawPower(Mockito.any(Power.class));
    }

    @Test
    void testDrawWalls() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1,7));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(9,9));
        Mockito.verify(gui, Mockito.times(2)).drawWall(Mockito.any(Position.class));
    }

    @Test
    void testDrawKeys() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawKey(new Position(8,8));
        Mockito.verify(gui, Mockito.times(1)).drawKey(new Position(7,7));
        Mockito.verify(gui, Mockito.times(2)).drawKey(Mockito.any(Position.class));
    }

    @Test
    void testDrawExit() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawExit(level.getExit().getPosition(), level.getExit().isOpen());
        Mockito.verify(gui, Mockito.times(1)).drawExit(Mockito.any(Position.class), Mockito.anyBoolean());
    }

    @Test
    void testDrawEnemies() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(level.getEnemy(new Position(1,2)));
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(level.getEnemy(new Position(0,0)));
        Mockito.verify(gui, Mockito.times(2)).drawEnemy(Mockito.any(Enemy.class));
    }

    @Test
    void testDrawPlayer() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(level.getPlayer());
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(Mockito.any(Player.class));
    }
}