package org.opcode.service;

import java.util.List;
import org.opcode.model.RegisterState;

public interface OpcodeSimulator {
    RegisterState execute(List<String> instructions);
}


/*
 Handle:
 1. Validation on current registers value
 2. Validation on input parameters (if ADD then A and B should be present too)
 2. Executor logic based on instructions name
 3. Write more negative test cases
 4. Implement the execution part and handling of more registers (can be added)
 5. Instructions type should be extensible
 6. 32-signed integers check
 */