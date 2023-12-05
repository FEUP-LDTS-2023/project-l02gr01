package com.l02gr01.escape.states;

import com.l02gr01.escape.controller.Controller;
import com.l02gr01.escape.controller.PreGameController;
import com.l02gr01.escape.model.PreGame;
import com.l02gr01.escape.viewer.PreGameViewer;
import com.l02gr01.escape.viewer.Viewer;

public class PreGameState extends State<PreGame> {
    public PreGameState(PreGame model) {
        super(model);
    }

    @Override
    protected Viewer<PreGame> getViewer() {
        return new PreGameViewer(getModel());
    }

    @Override
    protected Controller<PreGame> getController() {
        return new PreGameController(getModel());
    }
}
