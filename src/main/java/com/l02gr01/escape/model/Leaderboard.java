package com.l02gr01.escape.model;

import com.l02gr01.escape.model.history.History;
import com.l02gr01.escape.model.history.HistoryLoader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Leaderboard {

    HistoryLoader historyLoader = new HistoryLoader();

    public Leaderboard() throws URISyntaxException, IOException {
        historyLoader.loadMemory();
        //History.getInstance().sort() (Fazer sort)
    }

    public void clearHistory() throws URISyntaxException, IOException {
        historyLoader.storeMemory(History.getInstance().listEvents());
        History.getInstance().setHistory(new ArrayList<>());
    }

}