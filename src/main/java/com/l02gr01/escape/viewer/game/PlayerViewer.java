package com.l02gr01.escape.viewer.game;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.elements.Player;

public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player hero, GUI gui) {
        gui.drawPlayer(hero.getPosition());
    }
}
