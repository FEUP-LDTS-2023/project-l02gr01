package com.l02gr01.escape.controller;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Exit;
import com.l02gr01.escape.model.elements.Key;
import com.l02gr01.escape.model.elements.Player;
import com.l02gr01.escape.model.elements.Wall;
import com.l02gr01.escape.model.elements.enemies.Troll;
import com.l02gr01.escape.model.elements.powers.Shield;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlayerControllerTest {
    private Level level;
    private Player player;
    private PlayerController playerController;
    @BeforeEach
    void setUp() {
        level = new Level(15,15);
        player = new Player(5,5);
        playerController = new PlayerController(level);

        level.setPlayer(player);
        level.setEnemies(Arrays.asList(new Troll(6,5)));
        level.setExit(new Exit(1,1));
        level.setWalls(Arrays.asList(new Wall(5,6)));
        //level.setPowers(Arrays.asList(new Shield(4,5)));
        //level.setKeys(Arrays.asList(new Key(4,5)));
    }

    @Test
    void testMoveHeroUp() {
        playerController.movePlayerUp(100);
        assertEquals(player.getPosition(), new Position(5, 4));
    }
    @Test
    void testMoveHeroWithWall() {
        playerController.movePlayerDown(100);
        assertEquals(player.getPosition(), new Position(5, 5));
    }

    @Test
    void testPickUpKey() {
        level.getKeys().setKeys(Arrays.asList(new Key(4,5)));
        playerController.movePlayerLeft(100);
        assertTrue(level.getKeys().getList().get(0).isPickedUp());
    }

    @Test
    void testDamage() {
        playerController.movePlayerRight(100);
        assertEquals(player.getHealth(), 90);
    }

}