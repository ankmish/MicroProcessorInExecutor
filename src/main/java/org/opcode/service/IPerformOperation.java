package org.opcode.service;


public interface IPerformOperation {
    void executionInstruction(String[] instructionStr);

    boolean validateInstruction(String[] instructionStr);
}
