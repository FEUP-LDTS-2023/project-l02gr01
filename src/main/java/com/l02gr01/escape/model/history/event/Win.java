package com.l02gr01.escape.model.history.event;

public class Win extends Event{

    public Win(String name, long time, int finallevel) {
        super(name, time, finallevel);
    }

    @Override
    public String getInfo() {
        return getName() + "finished level " + getFinallevel() + " with " + getPoints() + " points.";
    }
}
