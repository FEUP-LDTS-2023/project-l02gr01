package com.l02gr01.escape.viewer;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Leaderboard;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.history.History;

public class LeaderboardViewer extends Viewer<Leaderboard> {

    public LeaderboardViewer(Leaderboard model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(7, 1), "Leaderboard", "#FFD700");
        gui.drawText(new Position(0,3), "Rank", "#FFFFFF");
        gui.drawText(new Position(6,3), "Name", "#FFFFFF");
        gui.drawText(new Position(17,3), "Level", "#FFFFFF");
        gui.drawText(new Position(25,3), "Score", "#FFFFFF");
        for (int i = 1; i < 11 && i <= History.getInstance().listEvents().size(); i++) {
            String username = History.getInstance().listEvents().get(i-1).getName();
            int finalLevel = History.getInstance().listEvents().get(i-1).getFinalLevel();
            int score = History.getInstance().listEvents().get(i-1).getPoints();

            gui.drawText(new Position(0, 3+i), i + ".", "#FFFFFF");
            gui.drawText(new Position(6,3+i), username, "#FFFFFF");
            gui.drawText(new Position(17,3+i), Integer.toString(finalLevel), "#FFFFFF");
            gui.drawText(new Position(25,3+i), Integer.toString(score), "#FFFFFF");
        }
    }
}
