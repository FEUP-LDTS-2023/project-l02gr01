package com.l02gr01.escape.viewer;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Leaderboard;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.history.event.Event;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeaderboardViewerTest {

    @Test
    void testDrawElements() throws URISyntaxException, IOException {

        GUI mockGUI = Mockito.mock(GUI.class);
        Leaderboard leaderboard = Mockito.mock(Leaderboard.class);
        LeaderboardViewer leaderboardViewer = new LeaderboardViewer(leaderboard);
        List<Event> events = new ArrayList<>();
        events.add(new Event("User1", 4000, 1) {
            @Override
            public String getInfo() {
                return null;
            }
        });
        events.add(new Event("User2", 8000, 2) {
            @Override
            public String getInfo() {
                return null;
            }
        });
        Mockito.when(leaderboard.getEvents()).thenReturn(events);

        leaderboardViewer.drawElements(mockGUI);


        Mockito.verify(mockGUI).drawText(new Position(9, 1), "Leaderboard", "#ffd700");
        Mockito.verify(mockGUI).drawText(new Position(0, 4), "Rank", "#3333FF");
        Mockito.verify(mockGUI).drawText(new Position(6, 4), "Name", "#3333FF");
        Mockito.verify(mockGUI).drawText(new Position(17, 4), "Level", "#3333FF");
        Mockito.verify(mockGUI).drawText(new Position(25, 4), "Score", "#3333FF");

        Mockito.verify(mockGUI).drawText(new Position(0, 5), "1.", "#03fbff");
        Mockito.verify(mockGUI).drawText(new Position(6, 5), "User1", "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(17, 5), "1", "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(25, 5), "44", "#FFFFFF");

        Mockito.verify(mockGUI).drawText(new Position(0, 6), "2.", "#03fbff");
        Mockito.verify(mockGUI).drawText(new Position(6, 6), "User2", "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(17, 6), "2", "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(25, 6), "88", "#FFFFFF");

        Mockito.verify(mockGUI).drawText(new Position(5, 20), "ENTER", "#FFD700");
        Mockito.verify(mockGUI).drawText(new Position(11, 20), "to go to", "#FFFFFF");
        Mockito.verify(mockGUI).drawText(new Position(20, 20), "MENU", "#3333FF");
    }
}