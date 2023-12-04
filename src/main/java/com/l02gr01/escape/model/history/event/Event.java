package com.l02gr01.escape.model.history.event;

public abstract class Event {
    private final String name;
    private final long time;
    private final int finalLevel;


    public Event(String name, long time, int finalLevel){
        this.finalLevel = finalLevel;
        this.time = time;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public long getTime(){
        return time;
    }
    public int getFinalLevel(){
        return finalLevel;
    }

    public int getPoints(){
        return (int) (finalLevel * 7L - (time / 5 ));
    }

    public abstract String getInfo();
}
