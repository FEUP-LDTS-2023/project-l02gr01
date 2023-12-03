package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Leaderboard;
import com.l02gr01.escape.model.Menu;
import com.l02gr01.escape.states.MenuState;

import java.io.IOException;
import java.net.URISyntaxException;

public class LeaderboardController extends Controller<Leaderboard> {

    public LeaderboardController(Leaderboard model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action) {
            case SELECT:
                getModel().clearHistory();
                game.setState(new MenuState(new Menu()));
                break;
            default:
                break;
        }
    }
}
