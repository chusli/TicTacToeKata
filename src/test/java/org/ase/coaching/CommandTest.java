package org.ase.coaching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"A0", "A1", "A2", "B0", "B1", "B2", "C0", "C1", "C2"})
    void valid(String command) {
        Command sut = new Command(command);

        assertThat(sut.isValid()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"A3", "D0", "abc", "00", "AA"})
    void invalid(String command) {
        Command sut = new Command(command);

        assertThat(sut.isValid()).isFalse();
    }
}