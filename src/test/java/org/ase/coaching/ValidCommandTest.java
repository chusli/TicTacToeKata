package org.ase.coaching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ValidCommandTest {
    @ParameterizedTest
    @ValueSource(strings = {"A0", "A1", "A2", "B0", "B1", "B2", "C0", "C1", "C2", "ENDE", "START", "NEU",
            "a0", "a1", "a2", "b0", "b1", "b2", "c0", "c1", "c2", "ende", "start", "neu"})
    void getEnum(String command) {
        assertDoesNotThrow(() -> ValidCommand.getEnum(command));
    }
    
}