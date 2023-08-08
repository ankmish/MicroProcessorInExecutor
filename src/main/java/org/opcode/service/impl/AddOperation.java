package org.opcode.service.impl;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;
import org.opcode.service.IPerformOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.opcode.utils.InstructionsValidator.is32BitSignedInteger;
import static org.opcode.utils.InstructionsValidator.validRegister;

public class AddOperation implements IPerformOperation {
    private final static Logger LOGGER = LoggerFactory.getLogger(AddOperation.class);
    private RegisterState registerState;

    public AddOperation(RegisterState registerState) {
        this.registerState = registerState;
    }
    @Override
    public void executionInstruction(String[] instructionStr) {
        Register firstRegister = registerState.getRegister(instructionStr[1].charAt(0));
        int number = Integer.parseInt(instructionStr[2]);
        long sum = firstRegister.getValue() + number;
        if(is32BitSignedInteger(sum)) {
            firstRegister.setValue((int) sum);
            registerState.updateValue(firstRegister);
        }
        else {
            LOGGER.info("Register" +firstRegister.getName() + "can't hold value as it's out of range");
        }
    }

    @Override
    public boolean validateInstruction(String[] instructionStr) {
        if (instructionStr.length != 3 || instructionStr[1].isEmpty() || instructionStr[2].isEmpty() || !validRegister(instructionStr[1].charAt(0)) || !is32BitSignedInteger(Long.parseLong(instructionStr[2]))) {
            return false;
        }

        return true;
    }
}
