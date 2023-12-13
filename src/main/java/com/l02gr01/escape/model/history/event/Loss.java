package com.l02gr01.escape.model.history.event;

public class Loss extends Event{

    public Loss(String name, long time, int finallevel) {
        super(name, time, finallevel);
    }

    @Override
    public int getPoints() {
            // Will either return the points or 0 (if calculated points are negative)
            int result = (int)( getFinalLevel() * 45L - (getTime() / 4000 ));
            return Math.max(result, 0);

    }

    @Override
    public String getInfo() {
        return getName() + " lost on level " + getFinalLevel() + " with " + getPoints();
    }
}
