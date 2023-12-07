package com.l02gr01.escape.gui.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextManipulatorTest {

    TextManipulator textManipulator;

    @BeforeEach
    void setUp() {
        textManipulator = TextManipulator.getInstance();
        textManipulator.setReading(true);
    }

    @Test
    void returnSameInstance() {
        TextManipulator instance1 = TextManipulator.getInstance();
        assertSame(instance1, textManipulator);
    }

    @Test
    void testSetReading() {
        assertTrue(textManipulator.isReading());
        textManipulator.setReading(false);
        assertFalse(textManipulator.isReading());
        assertEquals("", textManipulator.read());
    }

    @Test
    void testAddCharacter() {
        textManipulator.addCharacter('X');
        assertEquals("X", textManipulator.read());
        textManipulator.addCharacter('Y');
        assertEquals("XY", textManipulator.read());

        textManipulator.setReading(false);
        textManipulator.addCharacter('X');
        assertEquals("", textManipulator.read());
    }

    @Test
    void testUsernameLength() {
        for (int i = 0; i < 15; i++) {
            textManipulator.addCharacter('X');
        }
        assertEquals(9, textManipulator.read().length());
    }

    @Test
    void testRemoveCharacter() {
        textManipulator.addCharacter('X');
        textManipulator.addCharacter('Y');
        assertEquals("XY", textManipulator.read());
        textManipulator.removeCharacter();
        assertEquals("X", textManipulator.read());
    }
}