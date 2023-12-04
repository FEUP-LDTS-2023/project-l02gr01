package com.l02gr01.escape.model.history.event;

public abstract class Event {
    private final String name;
    private final long time;
    private final int finallevel;


    public Event(String name, long time, int finallevel){
        this.finallevel = finallevel;
        this.time = time;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public long getTime(){
        return time;
    }
    public int getFinallevel(){
        return finallevel;
    }

    public int getPoints(){
        return (int) (finallevel * 7L - (time / 5 ));
    }

    public abstract String getInfo();
}
