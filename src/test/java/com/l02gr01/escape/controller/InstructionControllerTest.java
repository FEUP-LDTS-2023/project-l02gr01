package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.audio.AudioManager;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Instruction;
import com.l02gr01.escape.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InstructionControllerTest {

    Game mockGame;
    InstructionController instructionController;

    @BeforeEach
    void setUp() {
        mockGame = Mockito.mock(Game.class);
        instructionController = new InstructionController(Mockito.mock(Instruction.class));
    }

    @Test
    void testSelectStep() {
        System.out.println("aqui bitch  inst");
        Mockito.doNothing().when(Mockito.mock(AudioManager.class)).playSound(Mockito.anyString());
        instructionController.step(mockGame, GUI.ACTION.SELECT, 0);
        Mockito.verify(mockGame).setState(Mockito.any(MenuState.class));
        Mockito.verifyNoMoreInteractions(mockGame);

    }

    @Test
    void testOtherActionStep() {
        instructionController.step(mockGame, GUI.ACTION.QUIT, 0);
        Mockito.verifyNoInteractions(mockGame);
    }
}