package com.l02gr01.escape.model.history.event;

public class Win extends Event{

    public Win(String name, long time, int finalLevel) {
        super(name, time, finalLevel);
    }

    @Override
    public String getInfo() {
        return getName() + "finished level " + getFinalLevel() + " with " + getPoints() + " points.";
    }
}
