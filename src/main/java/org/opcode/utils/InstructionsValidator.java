package org.opcode.utils;

import java.util.Arrays;
import java.util.List;
import org.opcode.service.impl.OpCodeSimulatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstructionsValidator {

    public static List<Character> getSupportedRegisters() {
        return Arrays.asList('A', 'B', 'C', 'D');
    }

    public static boolean is32BitSignedInteger(long num) {
        return (num <= 2147483647) && (num >= -2147483648);
    }

    public static boolean validRegister(Character ch) {
        if(!getSupportedRegisters().contains(ch)) {
            return false;
        }
        return true;
    }
}
