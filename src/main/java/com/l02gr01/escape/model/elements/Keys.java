package com.l02gr01.escape.model.elements;

import com.l02gr01.escape.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Keys {
    private List<Key> keys = new ArrayList<>();


    public void add(Key key){
        keys.add(key);
    }

    public Key getKey(Position position) {
        for (Key key : keys) {
            if (key.getPosition().equals(position)) {
                return key;
            }
        }
        return null;
    }
    public void setKeys(List<Key> keys){
        this.keys = keys;
    }
    public List<Key> getList(){
        return keys;
    }

    public int getRemainingKeys() {
        int remainingKeys = keys.size();
        for (Key key : keys) {
            if (key.isPickedUp()) {
                remainingKeys--;
            }
        }
        return remainingKeys;
    }
}
