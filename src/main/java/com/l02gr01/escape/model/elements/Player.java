package com.l02gr01.escape.model.elements;

import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.powers.Power;
import com.l02gr01.escape.model.elements.powers.Power.PowerType;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Player extends Element {
    private int health;
    private int bulletsAvailable = 5;

    private Position lastDirection = new Position(1,0);

    // Map active power to expiration time
    private Map<PowerType, Long> activePowers = new ConcurrentHashMap<>();

    public Player(int x, int y) {
        super(x, y);
        this.health = 100;
    }

    @Override
    public void setPosition(Position position){
        int xd = position.getX() - getPosition().getX();
        int yd = position.getY() - getPosition().getY();
        lastDirection = new Position(xd, yd);

        super.setPosition(position);
    }

    public Position getDirection(){
        return lastDirection;
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

    public void setPowers(Map<PowerType, Long> power) {
        this.activePowers = power;
    }


    public void addbullets(){
        bulletsAvailable += 5;
    }
    public int getBulletsAvailable(){
        return bulletsAvailable;
    }
    public void usedBullet(){
        bulletsAvailable--;
        if(bulletsAvailable < 0){
            bulletsAvailable = 0;
        }
    }



    public boolean isBulletAvailable(){
      return bulletsAvailable > 0;
    }



}
