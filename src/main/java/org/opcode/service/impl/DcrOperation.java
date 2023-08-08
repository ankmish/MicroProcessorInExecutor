package org.opcode.service.impl;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;
import org.opcode.service.IPerformOperation;
import static org.opcode.utils.InstructionsValidator.is32BitSignedInteger;
import static org.opcode.utils.InstructionsValidator.validRegister;

public class DcrOperation implements IPerformOperation {

    private RegisterState registerState;

    public DcrOperation(RegisterState registerState) {
        this.registerState = registerState;
    }
    @Override
    public void executionInstruction(String[] instructionStr) {
        Register firstRegister = registerState.getRegister(instructionStr[1].charAt(0));
        int number = 1;
        long sum = firstRegister.getValue() - number;
        if(is32BitSignedInteger(sum)) {
            firstRegister.setValue((int) sum);
            registerState.updateValue(firstRegister);
        }
    }

    @Override
    public boolean validateInstruction(String[] instructionStr) {
        if (instructionStr.length != 2 || instructionStr[1].isEmpty() || !validRegister(instructionStr[1].charAt(0))) {
            return false;
        }
        return true;
    }
}
