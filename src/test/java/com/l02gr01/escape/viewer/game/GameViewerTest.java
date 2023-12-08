package com.l02gr01.escape.viewer.game;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Exit;
import com.l02gr01.escape.model.elements.Key;
import com.l02gr01.escape.model.elements.Player;
import com.l02gr01.escape.model.elements.Wall;
import com.l02gr01.escape.model.elements.enemies.Enemy;
import com.l02gr01.escape.model.elements.powers.FreezeEnemy;
import com.l02gr01.escape.model.elements.powers.Power;
import com.l02gr01.escape.model.elements.powers.Shield;
import com.l02gr01.escape.model.elements.powers.SuperVision;
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


        level.setPowers(Arrays.asList(new Shield(3,4), new FreezeEnemy(7,2), new SuperVision(2,8), new SuperVision(10,5)));
        level.setWalls(Arrays.asList(new Wall(3,3), new Wall(6,5), new Wall(4,1)));
        level.getKeys().setKeys(Arrays.asList(new Key(8,8), new Key(7,7)));
        level.setEnemies(Arrays.asList(new Enemy(0,0), new Enemy(5, 7)));
        level.setPlayer(new Player(5,5));
        level.setExit(new Exit(2,5));

    }

    @Test
    void testDrawPower() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawPower(level.getPowers().get(0));
        Mockito.verify(gui, Mockito.times(1)).drawPower(level.getPowers().get(1));
        Mockito.verify(gui, Mockito.times(1)).drawPower(level.getPowers().get(2));
        Mockito.verify(gui, Mockito.times(0)).drawPower(level.getPowers().get(3));
        Mockito.verify(gui, Mockito.times(3)).drawPower(Mockito.any(Power.class));
    }

    @Test
    void testDrawWalls() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(level.getWalls().get(0).getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawWall(level.getWalls().get(1).getPosition());
        Mockito.verify(gui, Mockito.times(0)).drawWall(level.getWalls().get(2).getPosition());
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
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(level.getEnemy(new Position(5,7)));
        Mockito.verify(gui, Mockito.times(0)).drawEnemy(level.getEnemy(new Position(0,0)));
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(Mockito.any(Enemy.class));
    }

    @Test
    void testDrawPlayer() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(level.getPlayer());
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(Mockito.any(Player.class));
    }

    @Test
    void testDrawRange() throws IOException {
        level.getPlayer().addPower(new SuperVision(5,5), 1000);
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawEnemy(level.getEnemy(new Position(0,0)));
        Mockito.verify(gui, Mockito.times(2)).drawEnemy(Mockito.any(Enemy.class));

        Mockito.verify(gui, Mockito.times(1)).drawWall(level.getWalls().get(2).getPosition());
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));

        Mockito.verify(gui, Mockito.times(1)).drawPower(level.getPowers().get(3));
        Mockito.verify(gui, Mockito.times(4)).drawPower(Mockito.any(Power.class));
    }
}