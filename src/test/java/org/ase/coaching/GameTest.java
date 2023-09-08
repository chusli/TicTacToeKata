package org.ase.coaching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class GameTest {
    @Test
    void getInitialState() {
        Game sut = new Game();

        String actual = sut.getState();

        assertThat(actual).isEqualTo(" A B C \n" +
                "0 | | \n" +
                " -+-+-  \n" +
                "1 | | \n" +
                " -+-+-  \n" +
                "2 | | \n" +
                "Kommando:");
    }

    @Test
    void getStateAfterFirstMove() {
        Game sut = new Game();
        sut.makeMove(Player.X, 0, 0);

        String actual = sut.getState();

        assertThat(actual).isEqualTo(" A B C \n" +
                "0X| | \n" +
                " -+-+-  \n" +
                "1 | | \n" +
                " -+-+-  \n" +
                "2 | | \n" +
                "Kommando:");
    }
}