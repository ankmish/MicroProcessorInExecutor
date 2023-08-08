package org.opcode.service.impl;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;
import org.opcode.service.IPerformOperation;
import static org.opcode.utils.InstructionsValidator.validRegister;

public class MovOperation implements IPerformOperation {

    private RegisterState registerState;

    public MovOperation(RegisterState registerState) {
        this.registerState = registerState;
    }
    @Override
    public void executionInstruction(String[] instructionStr) {
        Register firstRegister = registerState.getRegister(instructionStr[1].charAt(0));
        Register secondRegister = registerState.getRegister(instructionStr[2].charAt(0));
        firstRegister.setValue(secondRegister.getValue());
        registerState.updateValue(firstRegister);
    }

    @Override
    public boolean validateInstruction(String[] instructionStr) {
        if (instructionStr.length != 3 || instructionStr[1].isEmpty() || instructionStr[2].isEmpty() || !validRegister(instructionStr[1].charAt(0)) || !validRegister(instructionStr[2].charAt(0))) {
            return false;
        }
        return true;
    }
}
