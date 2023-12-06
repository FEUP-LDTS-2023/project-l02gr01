package com.l02gr01.escape.gui.text;

import java.util.ArrayList;
import java.util.List;

public class TextManipulator {
    private static TextManipulator instance = new TextManipulator();
    private boolean reading = false;

    TextObserver observer;

    private StringBuilder text = new StringBuilder();

    public static TextManipulator getInstance(){
        return instance;
    }

    public void setReading(boolean read){
        reading = read;
        if(!read){
            text = new StringBuilder(); // Empty string
        }
    }
    public void addCharacter(char character){
        if(reading){
            text.append(character);
            updateListeners();
        }
    }
    public String read(){
        return text.toString();
    }

    public void setListener(TextObserver obs){
        observer = obs;
    }

    public void updateListeners(){
        if(observer != null){
            observer.beNotified(text.toString());
        }
    }
}
