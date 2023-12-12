package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Bullet;
import com.l02gr01.escape.model.elements.Wall;
import com.l02gr01.escape.model.elements.enemies.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BulletControllerTest {

    BulletController bulletController;

    @BeforeEach
    void setUp() {
        bulletController = new BulletController(new Level(15,15,1));
        Bullet bullet = new Bullet(5, 5, new Position(1, 0), 20);
        bulletController.getModel().addBullet(bullet);
    }

    @Test
    void testMoveBullet() {
        Bullet bullet = bulletController.getModel().getBullets().get(0);
        bulletController.moveBullet(bullet);
        assertEquals(new Position(6, 5), bullet.getPosition());
    }

    @Test
    void testStep() {
        Bullet bullet = bulletController.getModel().getBullets().get(0);
        Bullet bullet1 = new Bullet(10,9, new Position(0,1), 20);
        bulletController.getModel().addBullet(bullet1);

        Enemy enemy = new Enemy(6, 5);
        bulletController.getModel().setEnemies(List.of(enemy));

        Wall wall = new Wall(10, 10);
        bulletController.getModel().setWalls(List.of(wall));

        bulletController.step(null, GUI.ACTION.NONE, 200);
        assertEquals(new Position(6, 5), bullet.getPosition());
        assertEquals(new Position(10, 10), bullet1.getPosition());

        assertEquals(0, bulletController.getModel().getBullets().size());
        assertEquals(0, bulletController.getModel().getEnemies().size());
        assertEquals(1, bulletController.getModel().getWalls().size());
    }

    @Test
    void testStepTime() {
        bulletController.step(null, GUI.ACTION.NONE, 200);
        assertEquals(new Position(6,5), bulletController.getModel().getBullets().get(0).getPosition());

        bulletController.step(null, GUI.ACTION.NONE, 300);
        assertEquals(new Position(6,5), bulletController.getModel().getBullets().get(0).getPosition());
    }
}