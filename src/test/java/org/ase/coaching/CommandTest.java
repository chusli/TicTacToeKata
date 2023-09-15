package org.ase.coaching;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class CommandTest {
    private static Stream<Arguments> provideRows() {
        return Stream.of(
                Arguments.of(Command.A0, 0),
                Arguments.of(Command.A1, 1),
                Arguments.of(Command.A2, 2),
                Arguments.of(Command.B0, 0),
                Arguments.of(Command.B1, 1),
                Arguments.of(Command.B2, 2),
                Arguments.of(Command.C0, 0),
                Arguments.of(Command.C1, 1),
                Arguments.of(Command.C2, 2));
    }

    private static Stream<Arguments> provideColumns() {
        return Stream.of(
                Arguments.of(Command.A0, 0),
                Arguments.of(Command.A1, 0),
                Arguments.of(Command.A2, 0),
                Arguments.of(Command.B0, 1),
                Arguments.of(Command.B1, 1),
                Arguments.of(Command.B2, 1),
                Arguments.of(Command.C0, 2),
                Arguments.of(Command.C1, 2),
                Arguments.of(Command.C2, 2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"A0", "A1", "A2", "B0", "B1", "B2", "C0", "C1", "C2", "ENDE", "START", "NEU",
            "a0", "a1", "a2", "b0", "b1", "b2", "c0", "c1", "c2", "ende", "start", "neu"})
    void getEnum(String command) {
        assertDoesNotThrow(() -> Command.getEnum(command));
    }

    @Test
    void readCommandWhenValidInputProvidedThenReturnCommand() {
        final String input = "A0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Command actual = Command.readCommand();

        assertThat(actual).isEqualTo(Command.A0);
    }

    @Test
    void readCommandWhenInvalidInputProvidedThenAwaitNewCommand() {
        final String input = "EEEEE";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatException().isThrownBy(Command::readCommand).isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @MethodSource("provideRows")
    void getRowWhenMoveCommandProvidedThenReturnRow(Command command, int expectedRow) {
        assertThat(command.getRow()).isEqualTo(expectedRow);
    }

    @ParameterizedTest
    @MethodSource("provideColumns")
    void getColumnWhenMoveCommandProvidedThenReturnColumn(Command command, int expectedColumn) {
        assertThat(command.getColumn()).isEqualTo(expectedColumn);
    }

    @TestFactory
    Stream<DynamicTest> getRowWhenNotMoveCommandProvidedThenReturnMinusOne() {
        return Arrays.stream(Command.values())
                .filter(command -> command.getOperation() != Operation.VALID_MOVE)
                .map(command -> dynamicTest("GIVEN %s WHEN getRow THEN -1".formatted(command.name()),
                        () -> assertThat(command.getRow()).isEqualTo(-1)));
    }

    @Test
    Stream<DynamicTest> getColumnWhenNotMoveCommandProvidedThenReturnMinusOne() {
        return Arrays.stream(Command.values())
                .filter(command -> command.getOperation() != Operation.VALID_MOVE)
                .map(command -> dynamicTest("GIVEN %s WHEN getColumn THEN -1".formatted(command.name()),
                        () -> assertThat(command.getColumn()).isEqualTo(-1)));
    }
}