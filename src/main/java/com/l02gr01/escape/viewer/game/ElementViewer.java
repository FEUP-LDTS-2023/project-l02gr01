package com.l02gr01.escape.viewer.game;


import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
