package com.l02gr01.escape.states;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.controller.Controller;
import com.l02gr01.escape.controller.LevelController;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.viewer.Viewer;
import com.l02gr01.escape.viewer.game.GameViewer;

public class GameState extends State<Level>{
    public GameState(Level level) {
        super(level);
    }

    @Override
    protected Viewer<Level> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Level> getController() {
        return new LevelController(getModel());
    }

}
