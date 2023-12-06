package com.l02gr01.escape.viewer;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.PreGame;

public class PreGameViewer extends Viewer<PreGame> {
    public PreGameViewer(PreGame model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(11, 5), "Welcome", "#FFFFFF");
        gui.drawText(new Position(6, 10), "What's your name?", "#FFFFFF");
        gui.drawText(new Position(10, 14), getModel().getName(), "#FFFFF6");
    }
}
