package com.l02gr01.escape.gui.text;

import java.util.ArrayList;
import java.util.List;

public class TextManipulator {
    private static TextManipulator instance = new TextManipulator();
    private boolean reading = false;

    List<TextObserver> observerList = new ArrayList<>();

    private StringBuilder text = new StringBuilder();

    public static TextManipulator getInstance(){
        return instance;
    }

    public void setReading(boolean read){
        reading = read;
        if(read == false){
            text = new StringBuilder();
        }
    }
    public void addCharacter(char character){
        if(reading){
            text.append(character);
        }
    }
    public String read(){
        return text.toString();
    }

    public void updateListeners(){
        for(TextObserver obs : observerList){
            obs.beNotified();
        }
    }
}
