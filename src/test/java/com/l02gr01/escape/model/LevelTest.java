package com.l02gr01.escape.model;

import com.l02gr01.escape.model.elements.Exit;
import com.l02gr01.escape.model.elements.Key;
import com.l02gr01.escape.model.elements.Wall;

import java.util.List;

import com.l02gr01.escape.model.elements.enemies.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {
    private Level level;

    @BeforeEach
    void setUp() {
        level = new Level(10, 10,1);
    }

    @Test
    public void testRemainingKeys() {
        Key key1 = new Key(1, 1);
        Key key2 = new Key(5, 10);

        level.getKeys().setKeys(Arrays.asList(key1, key2));
        assertEquals(2, level.getKeys().getRemainingKeys());
        key1.setPickedUp(true);
        assertEquals(1, level.getKeys().getRemainingKeys());
    }

    @Test
    void testWalls() {
        Wall wall1 = new Wall(1,1);
        Wall wall2 = new Wall(2,1);
        Wall wall3 = new Wall(3,3);

        level.setWalls(Arrays.asList(wall1,wall2,wall3));
        assertEquals(3, level.getWalls().size());

        assertFalse(level.isEmpty(new Position(1,1)));
        assertTrue(level.isEmpty(new Position(5,7)));
    }

    @Test
    void testExit() {
        assertEquals(level.getExit().getPosition(), new Position(5, 0));
        level.setExit(new Exit(1,1));
        assertEquals(level.getExit().getPosition(), new Position(1, 1));

    }

    @Test
    void testEnemy() {
        Enemy troll = new Enemy(9,10);
        level.setEnemies(List.of(troll));
        assertEquals(level.getEnemies().get(0).getPosition(), new Position(9,10));
        assertNotNull(level.getEnemy(new Position(9,10)));
        assertNull(level.getEnemy(new Position(0,0)));
    }
}