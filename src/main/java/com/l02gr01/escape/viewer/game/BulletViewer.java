package com.l02gr01.escape.viewer.game;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.elements.Bullet;

public class BulletViewer implements ElementViewer<Bullet> {

    @Override
    public void draw(Bullet element, GUI gui) {
        gui.drawBullet(element.getPosition());
    }
}
