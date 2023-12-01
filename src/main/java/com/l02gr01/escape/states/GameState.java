package com.l02gr01.escape.states;

import com.l02gr01.escape.audio.AudioManager;
import com.l02gr01.escape.controller.Controller;
import com.l02gr01.escape.controller.LevelController;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.LevelBuilder;
import com.l02gr01.escape.viewer.Viewer;
import com.l02gr01.escape.viewer.game.GameViewer;

public class GameState extends State<Level>{
    public GameState(LevelBuilder levelBuilder) {
        super(levelBuilder.createLevel());
        // Example for playing game music when the level starts
//        AudioManager.getInstance().stopAllSounds();
//        AudioManager.getInstance().startGameSound();
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
