package com.l02gr01.escape.viewer;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Leaderboard;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.history.History;
import com.l02gr01.escape.model.history.event.Event;

import java.util.List;

public class LeaderboardViewer extends Viewer<Leaderboard> {

    public LeaderboardViewer(Leaderboard model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(9, 1), "Leaderboard", "#ffd700");
        gui.drawText(new Position(0,4), "Rank", "#3333FF");
        gui.drawText(new Position(6,4), "Name", "#3333FF");
        gui.drawText(new Position(17,4), "Level", "#3333FF");
        gui.drawText(new Position(25,4), "Score", "#3333FF");

        List<Event> events = getModel().getEvents();

        for (int i = 1; i < 11 && i <= events.size(); i++) {
            // get data and show it in the screen
            String username = events.get(i-1).getName();
            int finalLevel = events.get(i-1).getFinalLevel();
            int score = events.get(i-1).getPoints();

            gui.drawText(new Position(0, 4+i), i + ".", "#03fbff");
            gui.drawText(new Position(6,4+i), username, "#FFFFFF");
            gui.drawText(new Position(17,4+i), Integer.toString(finalLevel), "#FFFFFF");
            gui.drawText(new Position(25,4+i), Integer.toString(score), "#FFFFFF");

        }

        gui.drawText(new Position(5,  20), "ENTER", "#FFD700");
        gui.drawText(new Position(11,  20), "to go to", "#FFFFFF");
        gui.drawText(new Position(20,  20), "MENU", "#3333FF");
    }
}
