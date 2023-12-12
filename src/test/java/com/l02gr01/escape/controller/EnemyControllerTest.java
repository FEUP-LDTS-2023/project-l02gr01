package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Player;
import com.l02gr01.escape.model.elements.Wall;
import com.l02gr01.escape.model.elements.enemies.Enemy;
import com.l02gr01.escape.model.elements.enemies.MovingStrategy.RandomMovingStrategy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EnemyControllerTest {
    private Level level;
    private Player player;
    private EnemyController enemyController;
    private Game game;

    @BeforeEach
    void setUp() {
        level = new Level(15,15,1);
        player = new Player(1,2);
        enemyController = new EnemyController(level);
        level.setPlayer(player);
        game = Mockito.mock(Game.class);
    }

    @Test
    void testMoveEnemy() {
        Enemy enemy = Mockito.mock(Enemy.class);
        Mockito.when(enemy.getStrategy()).thenReturn(new RandomMovingStrategy());
        Mockito.when(enemy.getPosition()).thenReturn(new Position(1, 1));

        level.setEnemies(List.of(enemy));

        enemyController.step(game, GUI.ACTION.NONE, 1000);
        enemyController.step(game, GUI.ACTION.NONE, 1500);
        Mockito.verify(enemy, Mockito.times(1)).getStrategy();
        Mockito.verify(enemy, Mockito.times(2)).getPosition();
        Mockito.verify(enemy, Mockito.times(1)).setPosition(Mockito.argThat(position -> position.getX() != 1 || position.getY() != 1));
    }

    @Test
    void testMonsterMove() {
        Enemy troll = new Enemy(2,2);
        level.setEnemies(List.of(troll));
        level.setWalls(Arrays.asList(new Wall(3,2), new Wall(2,3), new Wall(2,1)));

        long time = 0;
        while (troll.getPosition().equals(new Position(2,2))) {
            enemyController.step(game, GUI.ACTION.NONE, time);
            time += 1000;
        }

        assertEquals(troll.getPosition(), new Position(1,2));
        assertEquals(90, player.getHealth());
    }
}