package com.l02gr01.escape.model;

import com.l02gr01.escape.model.history.History;
import com.l02gr01.escape.model.history.HistoryLoader;
import com.l02gr01.escape.model.history.event.Event;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Leaderboard {

    private final History history = History.getInstance();

    public Leaderboard() throws URISyntaxException, IOException {
        history.sort();
    }
    public List<Event> getEvents(){
        return history.listEvents();
    }

}
