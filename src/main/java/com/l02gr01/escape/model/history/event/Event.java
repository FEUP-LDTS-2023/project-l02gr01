package com.l02gr01.escape.model.history.event;

public abstract class Event {
    private String name;
    private long time;
    private int finallevel;


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
        // Will either return the points or 0 (if calculated points are negative)
        int result = (int)( finallevel * 45L - (time / 4000 ));
        return Math.max(result, 0);
    }

    public abstract String getInfo();
}
