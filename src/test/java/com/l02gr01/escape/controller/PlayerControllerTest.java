package com.l02gr01.escape.controller;

import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Exit;
import com.l02gr01.escape.model.elements.Key;
import com.l02gr01.escape.model.elements.Player;
import com.l02gr01.escape.model.elements.Wall;
import com.l02gr01.escape.model.elements.enemies.Troll;
import com.l02gr01.escape.model.elements.powers.Shield;
import java.util.List;
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
        level = new Level(15,15,1);
        player = new Player(5,5);
        playerController = new PlayerController(level);
        level.setPlayer(player);
        level.setExit(new Exit(0,0));
    }

    @Test
    void testMoveHeroUp() {
        playerController.movePlayerUp(100);
        assertEquals(player.getPosition(), new Position(5, 4));
    }

    @Test
    void testMoveHeroDown() {
        playerController.movePlayerDown(100);
        assertEquals(player.getPosition(), new Position(5, 6));
    }

    @Test
    void testMoveHeroLeft() {
        playerController.movePlayerLeft(100);
        assertEquals(player.getPosition(), new Position(4, 5));
    }

    @Test
    void testMoveHeroRight() {
        playerController.movePlayerRight(100);
        assertEquals(player.getPosition(), new Position(6, 5));
    }

    @Test
    void testMoveHeroWithWall() {
        level.setWalls(List.of(new Wall(5, 6)));
        playerController.movePlayerDown(100);
        assertEquals(player.getPosition(), new Position(5, 5));
    }

    @Test
    void testPickUpKey() {
        level.getKeys().setKeys(List.of(new Key(4, 5)));
        playerController.movePlayerLeft(100);
        assertTrue(level.getKeys().getList().get(0).isPickedUp());
    }

    @Test
    void testDamage() {
        level.setEnemies(List.of(new Troll(6, 5)));
        playerController.movePlayerRight(100);
        assertEquals(player.getHealth(), 90);
    }

    @Test
    void testShield() {
        level.setEnemies(List.of(new Troll(6, 5)));
        player.addPower(new Shield(4,5), 100);
        playerController.movePlayerLeft(100);
        assertEquals(1, player.getActivePowers().size());
        playerController.movePlayerRight(100);
        playerController.movePlayerRight(100);
        assertEquals(player.getPosition(), level.getEnemies().get(0).getPosition());
        assertEquals(100, player.getHealth());
    }
}