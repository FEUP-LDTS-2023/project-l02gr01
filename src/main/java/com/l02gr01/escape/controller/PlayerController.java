package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Key;
import com.l02gr01.escape.model.elements.enemies.Enemy;
import com.l02gr01.escape.model.elements.powers.Power;
import com.l02gr01.escape.model.elements.powers.Power.PowerType;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PlayerController extends GameController {

    public PlayerController(Level level) {
        super(level);
    }

    public void movePlayerLeft(long time) {
        movePlayer(getModel().getPlayer().getPosition().getLeft(), time);
    }

    public void movePlayerRight(long time) {
        movePlayer(getModel().getPlayer().getPosition().getRight(), time);
    }

    public void movePlayerUp(long time) {
        movePlayer(getModel().getPlayer().getPosition().getUp(), time);
    }

    public void movePlayerDown(long time) {
        movePlayer(getModel().getPlayer().getPosition().getDown(), time);
    }

    private void movePlayer(Position position, long time) {
        if(((position.getX() < getModel().getWidth() && position.getY() < getModel().getHeight()) && (position.getY() >= 0 && position.getX() >= 0))){
            if (getModel().isEmpty(position)) {
                getModel().getPlayer().setPosition(position);
                Key key = getModel().getKeys().getKey(position);
                if (key != null) {
                    if(!key.isPickedUp()){
                        getModel().getPlayer().addbullets();
                    }
                    key.setPickedUp(true);
                }
                Enemy enemy = getModel().getEnemy(position);
                if (enemy != null) {
                    getModel().getPlayer().changeHealth(-1 * enemy.getDamage());
                }
                Power power = getModel().getPower(position);
                if (power != null) {
                    getModel().getPlayer().addPower(power, time + power.getPowerLength());
                    getModel().removePower(power);
                }
            }
        }

    }

    public void shoot(){
        getModel().shoot();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePlayerUp(time);
        if (action == GUI.ACTION.RIGHT) movePlayerRight(time);
        if (action == GUI.ACTION.DOWN) movePlayerDown(time);
        if (action == GUI.ACTION.LEFT) movePlayerLeft(time);
        if (action == GUI.ACTION.TAB) shoot();
        checkPowers(time);
    }

    private void checkPowers(long time) {
        Map<PowerType, Long> powers = new HashMap<>(getModel().getPlayer().getActivePowers());
        for (Entry<PowerType, Long> power : getModel().getPlayer().getActivePowers().entrySet()) {
            if (time >= power.getValue()) {
                powers.remove(power.getKey());
            }
        }
        getModel().getPlayer().setPowers(powers);
    }

}
