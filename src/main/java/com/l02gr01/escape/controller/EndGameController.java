package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.EndGame;
import com.l02gr01.escape.model.Leaderboard;
import com.l02gr01.escape.model.Menu;
import com.l02gr01.escape.states.LeaderBoardState;
import com.l02gr01.escape.states.MenuState;

import java.io.IOException;
import java.net.URISyntaxException;

public class EndGameController extends Controller<EndGame> {

    public EndGameController(EndGame model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        if(action == GUI.ACTION.SELECT){
            game.setState(new MenuState(new Menu()));
        }
        if(action == GUI.ACTION.TAB){
            game.setState(new LeaderBoardState(new Leaderboard()));
        }
    }
}
