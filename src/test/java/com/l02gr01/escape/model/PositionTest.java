package com.l02gr01.escape.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    void testPosition() {
        Position pos = new Position(5,6);
        assertEquals(5, pos.getX());
        assertEquals(6, pos.getY());
    }

    @Test
    void moveRight() {
        Position pos = new Position(0,0);
        pos = pos.getRight();
        assertEquals(1, pos.getX());
        assertEquals(0, pos.getY());
    }

    @Test
    void moveLeft() {
        Position pos = new Position(10,15);
        pos = pos.getLeft();
        assertEquals(9, pos.getX());
        assertEquals(15, pos.getY());
    }

    @Test
    void moveDown() {
        Position pos = new Position(0,0);
        pos = pos.getDown();
        assertEquals(0, pos.getX());
        assertEquals(1, pos.getY());
    }

    @Test
    void moveUp() {
        Position pos = new Position(10000,0);
        pos = pos.getUp();
        assertEquals(10000, pos.getX());
        assertEquals(-1, pos.getY());
    }
}