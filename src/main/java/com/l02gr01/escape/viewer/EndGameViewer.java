package com.l02gr01.escape.viewer;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.EndGame;
import com.l02gr01.escape.model.Position;

public class EndGameViewer extends Viewer<EndGame>{

    public EndGameViewer(EndGame model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(2, 2), "YOUR STATS", "#FFFFFF");
        gui.drawText(new Position(2, 4),"Level:" + getModel().level(), "#FFFFFF");
        gui.drawText(new Position(2, 6), "Time (s):" + getModel().time(), "#FFFFFF");

        gui.drawText(new Position(2, 9), "TAB to go to LEADERBOARD", "#FFFFFF");
        gui.drawText(new Position(2,  11), "ENTER to go to MENU", "#FFFFFF");
    }
}
