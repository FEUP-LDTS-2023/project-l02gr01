package com.l02gr01.escape.states;

import com.l02gr01.escape.audio.AudioManager;
import com.l02gr01.escape.controller.Controller;
import com.l02gr01.escape.controller.MenuController;
import com.l02gr01.escape.model.Menu;
import com.l02gr01.escape.viewer.Viewer;
import com.l02gr01.escape.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
        AudioManager.getInstance().playBackgroundMusic();
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }

    // TBContinued

}
