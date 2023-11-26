package com.l02gr01.escape.controller;

import com.l02gr01.escape.Game;
import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Level;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.model.elements.Bullet;

public class BulletController extends GameController{

    private int lastMovement = 0;

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
        if (time - lastMovement > 200) {
            for(Bullet b : getModel().getBullets()){
                moveBullet(b);
            }
        }
    }


}
