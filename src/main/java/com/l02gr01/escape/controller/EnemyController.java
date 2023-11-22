package com.l02gr01.escape.controller;


import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.enemies.Enemy;
import java.io.IOException;

public class EnemyController extends GameController {
    private long lastMovement;

    public EnemyController(Level Level) {
        super(Level);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Enemy enemy : getModel().getEnemies())
                moveEnemy(enemy, enemy.getPosition().getRandomNeighbour());
            this.lastMovement = time;
        }
    }

    private void moveEnemy(Enemy enemy, Position position) {
        if (getModel().isEmpty(position)) {
            enemy.setPosition(position);
            if (getModel().getPlayer().getPosition().equals(position)) {
                getModel().getPlayer().changeHealth(-1 * enemy.getDamage());
            }
        }
    }
}
