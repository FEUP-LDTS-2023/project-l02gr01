package com.l02gr01.escape.model.history.event;

public class Loss extends Event{

    public int keysgrabbed;
    public Loss(String name, long time, int finallevel, int keysgrabbed) {
        super(name, time, finallevel);
        this.keysgrabbed = keysgrabbed;
    }

    public int getKeysgrabbed(){
        return keysgrabbed;
    }
    @Override
    public String getInfo() {
        return getName() + " lost on level " + getFinallevel() + " with " + getPoints() + " and " + keysgrabbed + " keys grabbed.";
    }
}
