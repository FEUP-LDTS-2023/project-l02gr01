package com.l02gr01.escape.viewer.instruction;


import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Instruction;
import com.l02gr01.escape.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

class InstructionViewerTest {

    private InstructionViewer instructionViewer;
    private GUI gui;
    private Instruction instruction;

    @BeforeEach
    void setUp() {
        instruction = Mockito.mock(Instruction.class);
        instructionViewer = new InstructionViewer(instruction);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void testDrawLines() throws IOException {
        Mockito.when(instruction.getLines()).thenReturn(Arrays.asList("Line1", "Line2"));
        instructionViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(2)).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
        Mockito.verify(gui).drawText(Mockito.eq(new Position(0, 0)), Mockito.eq("Line1"), Mockito.eq("#FFD700"));
    }

}