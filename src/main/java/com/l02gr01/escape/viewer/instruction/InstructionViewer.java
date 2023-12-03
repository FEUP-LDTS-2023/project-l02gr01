package com.l02gr01.escape.viewer.instruction;

import com.l02gr01.escape.gui.GUI;
import com.l02gr01.escape.model.Instruction;
import com.l02gr01.escape.model.Position;
import com.l02gr01.escape.viewer.Viewer;


public class InstructionViewer extends Viewer<Instruction> {

    public InstructionViewer(Instruction model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        for (int y = 0; y < getModel().getLines().size(); y++) {
            gui.drawText(new Position(0, y), getModel().getLines().get(y), "#FFD700");
        }
    }
}
