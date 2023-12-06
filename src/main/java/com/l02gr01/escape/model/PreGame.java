package com.l02gr01.escape.model;

import com.l02gr01.escape.gui.text.TextManipulator;
import com.l02gr01.escape.gui.text.TextObserver;

public class PreGame implements TextObserver {

    String username = new String();

    public String getName(){
        return username;
    }


    @Override
    public void beNotified(String text) {
        username = text;
    }
}
