package org.opcode.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opcode.enums.Instructions;
import org.opcode.factory.OperationFactory;
import org.opcode.model.Register;
import org.opcode.model.RegisterState;
import org.opcode.service.IPerformOperation;
import static org.junit.jupiter.api.Assertions.*;

class AddOperationTest {

    private IPerformOperation operation;

    private RegisterState registerState;
    @BeforeEach
    void setup() {
        registerState = getRegisterState();
        operation = OperationFactory.createOperation(Instructions.ADD, registerState);
    }

    private RegisterState getRegisterState() {
        Register registerA = new Register('A');
        Register registerB = new Register('B');
        Register registerC = new Register('C');
        Register registerD = new Register('D');
        List<Register> registers = Arrays.asList(registerA, registerB, registerC, registerD);
        return new RegisterState(registers);
    }

    @Test
    void executionInstruction() {
        List<String> instructions = new ArrayList<>();
        instructions.add("RST");
        instructions.add("ADD A 10");
        String[] instructionStr = instructions.get(1).split("\\s+");
        operation.executionInstruction(instructionStr);
        assertEquals(10, registerState.getRegister('A').getValue());
    }

    @Test
    void validateInstruction() {
    }
}