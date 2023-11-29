package com.l02gr01.escape.model.elements;

import com.l02gr01.escape.controller.BulletController;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.powers.Power;
import com.l02gr01.escape.model.elements.powers.Power.PowerType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends Element {
    private int health;
    private int bulletsAvailable = 5;

    private Position lastdirection;

    Map<PowerType, Long> activePowers = new HashMap<>();

    public Player(int x, int y) {
        super(x, y);
        this.health = 100;
    }

    @Override
    public void setPosition(Position position){
        int xd = position.getX() - getPosition().getX();
        int yd = position.getY() - getPosition().getY();
        lastdirection = new Position(xd, yd);

        super.setPosition(position);
    }

    public Position getDirection(){
        return lastdirection;
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


    public void usedBullet(){
        bulletsAvailable--;
        if(bulletsAvailable < 0){
            bulletsAvailable = 0;
        }
    }
    public boolean isBulletAvailable(){
        if(bulletsAvailable > 0){
            return true;
        }
        return false;
    }



}
