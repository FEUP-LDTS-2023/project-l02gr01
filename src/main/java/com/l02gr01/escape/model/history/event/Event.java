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
        // Will either return the points or 0 (if calculated points are negative)
        int winextra = 0;
        if(this instanceof Win){
            winextra += 40;
        }
        int result = (int)( finalLevel * 45L - (time / 4000 )) + winextra;
        return Math.max(result, 0);
    }

    public abstract String getInfo();
}
