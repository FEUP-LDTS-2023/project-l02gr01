package com.l02gr01.escape.states;

import com.l02gr01.escape.controller.Controller;
import com.l02gr01.escape.controller.InstructionController;
import com.l02gr01.escape.model.Instruction;
import com.l02gr01.escape.viewer.Viewer;
import com.l02gr01.escape.viewer.instruction.InstructionViewer;

public class InstructionState extends State<Instruction>{

    public InstructionState(Instruction model) {
        super(model);
    }

    @Override
    protected Viewer<Instruction> getViewer() {
        return new InstructionViewer(getModel());
    }

    @Override
    protected Controller<Instruction> getController() {
        return new InstructionController(getModel());
    }
}
