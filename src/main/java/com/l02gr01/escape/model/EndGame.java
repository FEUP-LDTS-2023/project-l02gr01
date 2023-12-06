package com.l02gr01.escape.model;

public class EndGame {

    private int finallevel;
    private int time;


    public EndGame(int finallevel, int time){
        this.finallevel = finallevel;
        this.time = time;
    }


    public int level(){
        return finallevel;
    }

    public int time(){
        return time / 1000;
    }
}
