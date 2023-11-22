package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Key;
import com.l02gr01.escape.model.elements.enemies.Enemy;
import com.l02gr01.escape.model.elements.powers.Power;
import com.l02gr01.escape.model.elements.powers.Power.PowerType;
import java.util.Map.Entry;

public class PlayerController extends GameController {
    final long powerExpiration = 5000;

    public PlayerController(Level Level) {
        super(Level);
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
        if (getModel().isEmpty(position)) {
            getModel().getPlayer().setPosition(position);
            Key key = getModel().getKey(position);
            if (key != null) {
                key.setPickedUp(true);
            }
            Enemy enemy = getModel().getEnemy(position);
            if (enemy != null) {
                getModel().getPlayer().changeHealth(-1 * enemy.getDamage());
            }
            Power power = getModel().getPower(position);
            if (power != null) {
                getModel().getPlayer().addPower(power, time);
                getModel().removePower(power);
            }
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePlayerUp(time);
        if (action == GUI.ACTION.RIGHT) movePlayerRight(time);
        if (action == GUI.ACTION.DOWN) movePlayerDown(time);
        if (action == GUI.ACTION.LEFT) movePlayerLeft(time);

        checkPowers(time);
    }

    private void checkPowers(long time) {
        for (Entry<PowerType, Long> power : getModel().getPlayer().getActivePowers().entrySet()) {
            if (time - power.getValue() > powerExpiration) {
                getModel().getPlayer().removePower(power.getKey());;
            }
        }
    }
}
