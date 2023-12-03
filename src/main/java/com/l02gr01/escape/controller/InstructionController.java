package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Instruction;
import com.l02gr01.escape.model.LevelBuilder;
import com.l02gr01.escape.model.Menu;
import com.l02gr01.escape.states.GameState;
import com.l02gr01.escape.states.MenuState;

import java.io.IOException;
import java.net.URISyntaxException;

public class InstructionController extends Controller<Instruction> {

    public InstructionController(Instruction model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action) {
            case SELECT:
                game.setState(new MenuState(new Menu()));
                break;
            default:
                break;
        }
    }
}
