package com.l02gr01.escape.model.history;

import com.l02gr01.escape.model.history.event.Event;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Event> history = new ArrayList<Event>();

    public List<Event> listEvents(){
        return history;
    }
    public void push(Event event){
        history.add(event);
    }


}
