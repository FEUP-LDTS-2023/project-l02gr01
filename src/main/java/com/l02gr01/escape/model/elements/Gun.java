package com.l02gr01.escape.model.elements;

public class Gun extends Element{
    private final int MAXBULLETS = 5;
    private int bullets = 0;
    public Gun(int x, int y) {
        super(x, y);
    }

    public void addbullets(int n){
        // This adds some bullets to the gun, until a fixed limit
        bullets = bullets + n;
        if(bullets > MAXBULLETS){
            bullets = MAXBULLETS;
        }
    }

    public void shoot(){
        if(bullets > 0){
            // Implement logic to have shooting - create a bullet that moves.
            bullets--;
        }
    }



}
