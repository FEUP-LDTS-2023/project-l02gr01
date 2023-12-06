package com.l02gr01.escape.model.history;

import com.l02gr01.escape.model.history.event.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class History {
    private static final History instance = new History();
    private List<Event> history;

    private HistoryLoader historyLoader = new HistoryLoader();

    private long lastStartTime = 0;

    private String username;

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public static History getInstance(){
        return instance;
    }

    private History(){
        // Load history from file
        try {
            history = historyLoader.loadMemory();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Event> listEvents(){
        return history;
    }
    public void push(Event event){
        history.add(event);
        try {
            historyLoader.storeMemory(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setHistory(List<Event> history) {
        this.history = history;
    }

    public void sort() {
        history.sort(Comparator.comparingInt(Event::getPoints).reversed());
    }
  
    public long getStartTime() {
        return lastStartTime;
    }

    public void setStartTime(long lastStartTime) {
        this.lastStartTime = lastStartTime;
    }
}
