package com.l02gr01.escape.states;

import com.l02gr01.escape.controller.Controller;
import com.l02gr01.escape.controller.EndGameController;
import com.l02gr01.escape.model.EndGame;
import com.l02gr01.escape.viewer.EndGameViewer;
import com.l02gr01.escape.viewer.Viewer;

public class EndGameState extends State<EndGame>{
    public EndGameState(EndGame model) {
        super(model);
    }

    @Override
    protected Viewer<EndGame> getViewer() {
        return new EndGameViewer(getModel());
    }

    @Override
    protected Controller<EndGame> getController() {
        return new EndGameController(getModel());
    }
}
