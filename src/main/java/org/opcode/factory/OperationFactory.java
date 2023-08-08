package org.opcode.factory;

import org.opcode.enums.Instructions;
import org.opcode.model.RegisterState;
import org.opcode.service.impl.ADROperation;
import org.opcode.service.impl.AddOperation;
import org.opcode.service.impl.DcrOperation;
import org.opcode.service.impl.INROperation;
import org.opcode.service.IPerformOperation;
import org.opcode.service.impl.MovOperation;
import org.opcode.service.impl.RstOperation;
import org.opcode.service.impl.SetOperation;

public class OperationFactory {
    public static IPerformOperation createOperation(Instructions instructionType, RegisterState registerState) {
        switch (instructionType) {
            case SET:
                return new SetOperation(registerState);
            case ADR:
                return new ADROperation(registerState);
            case ADD:
                return new AddOperation(registerState);
            case MOV:
                return new MovOperation(registerState);
            case INR:
                return new INROperation(registerState);
            case DCR:
                return new DcrOperation(registerState);
            case RST:
                return new RstOperation(registerState);
            default:
                throw new IllegalArgumentException("Unsupported instruction type: " + instructionType);
        }
    }
}
