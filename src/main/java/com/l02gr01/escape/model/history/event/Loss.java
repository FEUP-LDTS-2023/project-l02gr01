package com.l02gr01.escape.model.history.event;

public class Loss extends Event{

    public Loss(String name, long time, int finallevel) {
        super(name, time, finallevel);
    }

    @Override
    public String getInfo() {
        return getName() + " lost on level " + getFinalLevel() + " with " + getPoints();
    }
}
