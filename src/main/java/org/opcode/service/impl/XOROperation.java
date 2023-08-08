package org.opcode.service.impl;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;
import org.opcode.service.IPerformOperation;
import static org.opcode.utils.InstructionsValidator.is32BitSignedInteger;
import static org.opcode.utils.InstructionsValidator.validRegister;

/*
 XOR a  b c
     a = b^c
   */
public class XOROperation implements IPerformOperation {

    private RegisterState registerState;

    public XOROperation(RegisterState registerState) {
        this.registerState = registerState;
    }
    @Override
    public void executionInstruction(String[] instructionStr) {
        Register register = registerState.getRegister(instructionStr[1].charAt(0));
        register.setValue(Integer.parseInt(instructionStr[2]));
        registerState.updateValue(register);
    }

    @Override
    public boolean validateInstruction(String[] instructionStr) {
        if (instructionStr.length != 3 || instructionStr[1].isEmpty() || instructionStr[2].isEmpty() || !validRegister(instructionStr[1].charAt(0)) || !is32BitSignedInteger(Long.parseLong(instructionStr[2]))) {
            return false;
        }
        return true;
    }
}
