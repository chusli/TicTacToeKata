package org.ase.coaching;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"A0", "A1", "A2", "B0", "B1", "B2", "C0", "C1", "C2", "end", "start"})
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

    @Test
    void getColumn() {
        Command sut = new Command("B2");

        assertThat(sut.getColumn()).isEqualTo(1);
    }

    @Test
    void getRow() {
        Command sut = new Command("B2");

        assertThat(sut.getRow()).isEqualTo(2);
    }

    @Test
    void getMovingCommands() {
        List<Command> sut = Command.getMovingCommands();

        assertThat(sut).containsExactlyInAnyOrder(
                new Command("A0"),
                new Command("A1"),
                new Command("A2"),
                new Command("B0"),
                new Command("B1"),
                new Command("B2"),
                new Command("C0"),
                new Command("C1"),
                new Command("C2"));
    }
}