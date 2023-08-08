package org.opcode.service.impl;

import java.util.List;
import org.opcode.enums.Instructions;
import org.opcode.factory.OperationFactory;
import org.opcode.model.RegisterState;
import org.opcode.service.IPerformOperation;
import org.opcode.service.OpcodeSimulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpCodeSimulatorImpl implements OpcodeSimulator {
    private final RegisterState registerState;

    public OpCodeSimulatorImpl(RegisterState registerState) {
        this.registerState = registerState;
    }

    @Override
    public RegisterState execute(List<String> instructions) {
        for (String instruction : instructions) {
            String[] instructionStr = instruction.split("\\s+");
            Instructions currentInstruction = Instructions.valueOf(instructionStr[0]);
            executeCurrentInstruction(currentInstruction, instructionStr);
        }
        return registerState;
    }

    private void executeCurrentInstruction(Instructions currentInstruction, String[] instructionStr) {
        IPerformOperation operation = OperationFactory.createOperation(currentInstruction, registerState);
        if(operation.validateInstruction(instructionStr)) {
            operation.executionInstruction(instructionStr);
        }
    }
}
