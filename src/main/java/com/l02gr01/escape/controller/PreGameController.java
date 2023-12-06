package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.gui.text.TextManipulator;

import com.l02gr01.escape.model.LevelBuilder;
import com.l02gr01.escape.model.PreGame;
import com.l02gr01.escape.model.history.History;
import com.l02gr01.escape.states.GameState;

import java.io.IOException;
import java.net.URISyntaxException;

public class PreGameController extends Controller<PreGame> {
    public PreGameController(PreGame model) {
        super(model);
        TextManipulator.getInstance().setListener(model);
        TextManipulator.getInstance().setReading(true);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        if(action == GUI.ACTION.SELECT){
            if(!getModel().getName().isEmpty()) {
                History.getInstance().setUsername(getModel().getName());
                TextManipulator.getInstance().setReading(false);
                game.setState(new GameState(new LevelBuilder(1)));
                History.getInstance().setStartTime(time);
            }
        }

    }
}
