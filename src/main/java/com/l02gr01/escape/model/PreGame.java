package com.l02gr01.escape.model;

public class PreGame {

    String username;

    public void addChar(char c){
        username = username + c;
    }
    public String getName(){
        return username;
    }

}
