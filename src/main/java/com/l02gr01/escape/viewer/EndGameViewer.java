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
        gui.drawText(new Position(10, 2), "GAME OVER", "#FF1100");
        gui.drawText(new Position(10, 8), "YOUR STATS", "#FFFFFF");
        gui.drawText(new Position(11, 10),"Level:" + getModel().level(), "#FFFFFF");
        gui.drawText(new Position(10, 12), "Time (s):" + getModel().time(), "#FFFFFF");

        gui.drawText(new Position(5,  18), "ENTER", "#FFD700");
        gui.drawText(new Position(11,  18), "to go to", "#FFFFFF");
        gui.drawText(new Position(20,  18), "MENU", "#3333FF");

        gui.drawText(new Position(3, 20), "TAB", "#FFD700");
        gui.drawText(new Position(7, 20), "to go to", "#FFFFFF");
        gui.drawText(new Position(16, 20), "LEADERBOARD", "#3333FF");

    }
}
