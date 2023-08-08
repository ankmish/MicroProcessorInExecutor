package org.opcode.service.impl;

import org.opcode.model.RegisterState;
import org.opcode.service.IPerformOperation;

public class RstOperation  implements IPerformOperation {

    private RegisterState registerState;

    public RstOperation(RegisterState registerState) {
        this.registerState = registerState;
    }
    @Override
    public void executionInstruction(String[] instructionStr) {
        registerState.reset();
    }

    @Override
    public boolean validateInstruction(String[] instructionStr) {
        if(instructionStr.length > 1) {
            return false;
        }
        return true;
    }

}
