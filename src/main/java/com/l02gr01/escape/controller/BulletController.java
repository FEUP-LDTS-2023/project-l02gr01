package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Bullet;
import com.l02gr01.escape.model.elements.Wall;
import com.l02gr01.escape.model.elements.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class BulletController extends GameController{

    private long lastMovement = 0;

    public BulletController(Level level) {
        super(level);
    }


    public void moveBullet(Bullet b){
        Position d = b.getDirection();
        Position p = b.getPosition();
        Position f = new Position(p.getX() +d.getX(), p.getY() + d.getY());
        b.setPosition(f);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        // Could this code be different??? Or more optimized. TO THINK!!
        List<Bullet> finalbullets = new ArrayList<>(getModel().getBullets());
        if (time - lastMovement > 100) {
            for(Bullet b : getModel().getBullets()){

                // Move the bullet in the direction
                moveBullet(b);
                boolean contact = false;

                // Check if it contacts with enemy
                List<Enemy> enemiesfinal = new ArrayList<>(getModel().getEnemies());
                for(Enemy e : getModel().getEnemies()){
                    if(b.getPosition().equals(e.getPosition())){
                        if(e.removeLife(b.getDamage())){
                            enemiesfinal.remove(e);
                        }
                        contact = true;
                    }
                }
                getModel().setEnemies(enemiesfinal);

                // Check if it contacts with walls
                for(Wall w : getModel().getWalls()){
                  if (w.getPosition().equals(b.getPosition())) {
                    contact = true;
                    break;
                  }
                }
                if(contact){
                    finalbullets.remove(b);
                }
            }
            getModel().setBullets(finalbullets);
            lastMovement = time;
        }
    }


}
