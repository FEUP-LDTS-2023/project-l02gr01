package com.l02gr01.escape.states;

import com.l02gr01.escape.controller.Controller;
import com.l02gr01.escape.controller.LeaderboardController;
import com.l02gr01.escape.model.Leaderboard;
import com.l02gr01.escape.viewer.LeaderboardViewer;
import com.l02gr01.escape.viewer.Viewer;

public class LeaderBoardState extends State<Leaderboard> {

    public LeaderBoardState(Leaderboard model) {
        super(model);
    }

    @Override
    protected Viewer<Leaderboard> getViewer() {
        return new LeaderboardViewer(getModel());
    }

    @Override
    protected Controller<Leaderboard> getController() {
        return new LeaderboardController(getModel());
    }
}
