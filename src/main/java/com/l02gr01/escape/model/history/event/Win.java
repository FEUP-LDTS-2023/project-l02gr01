package com.l02gr01.escape.model.history.event;

public class Win extends Event{

    public Win(String name, long time, int finalLevel) {
        super(name, time, finalLevel);
    }

    @Override
    public int getPoints() {

            // Will either return the points or 0 (if calculated points are negative)
            int result = (int)( getFinalLevel() * 45L - (getTime() / 4000 )) + 40;
            return Math.max(result, 0);

    }

    @Override
    public String getInfo() {
        return getName() + "finished level " + getFinalLevel() + " with " + getPoints() + " points.";
    }
}
