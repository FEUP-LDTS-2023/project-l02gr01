package com.l02gr01.escape.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstructionTest {

    Instruction instruction;

    @BeforeEach
    void setUp() throws URISyntaxException, IOException {
        instruction = new Instruction();
    }

    @Test
    void linesNotEmpty() {
        assertNotNull(instruction.getLines());
        assertFalse(instruction.getLines().isEmpty());
    }

    @Test
    public void getLines_doesNotContainNull() {
        List<String> lines = instruction.getLines();
        assertFalse(lines.contains(null));
    }

    @Test
    public void getLines_containsCorrectLines() {
        List<String> lines = instruction.getLines();
        assertEquals("         INSTRUCTIONS", lines.get(1));
        assertEquals("        GAME OBJECTIVE:", lines.get(3));
    }
}