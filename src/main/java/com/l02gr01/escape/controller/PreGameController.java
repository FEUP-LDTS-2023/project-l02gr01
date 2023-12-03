package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Instruction;
import com.l02gr01.escape.model.LevelBuilder;
import com.l02gr01.escape.model.PreGame;
import com.l02gr01.escape.model.history.User;
import com.l02gr01.escape.model.history.History;
import com.l02gr01.escape.states.GameState;
import com.l02gr01.escape.states.InstructionState;
import com.l02gr01.escape.states.PreGameState;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class PreGameController extends Controller<PreGame> {
    public PreGameController(PreGame model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        if(action == GUI.ACTION.SELECT){
            User.getInstance().setUsername(getModel().getName());
            game.setState(new GameState(new LevelBuilder(1)));
            History.getInstance().setStartTime(time);
        }

    }
}
