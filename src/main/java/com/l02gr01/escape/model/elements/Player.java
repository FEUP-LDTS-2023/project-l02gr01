package com.l02gr01.escape.model.elements;

import com.l02gr01.escape.model.elements.powers.Power;
import com.l02gr01.escape.model.elements.powers.Power.PowerType;
import java.util.HashMap;
import java.util.Map;

public class Player extends Element {
    private int health;
    Map<PowerType, Long> activePowers = new HashMap<>();

    public Player(int x, int y) {
        super(x, y);
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }

    public void changeHealth(int change) {
        if (!activePowers.containsKey(PowerType.SHIELD)) {
            health += change;
        }
    }

    public Map<PowerType, Long> getActivePowers() {
        return activePowers;
    }

    public void addPower(Power power, long currentTime) {
        this.activePowers.put(power.getType(), currentTime);
    }

    public void removePower(PowerType power) {
        this.activePowers.remove(power);
    }
}
