package com.l02gr01.escape.viewer.game;


import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
