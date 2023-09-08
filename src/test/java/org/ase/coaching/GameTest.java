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
        sut.makeMove(new Command("A0"));

        String actual = sut.getState();

        assertThat(actual).isEqualTo(" A B C \n" +
                "0X| | \n" +
                " -+-+-  \n" +
                "1 | | \n" +
                " -+-+-  \n" +
                "2 | | \n" +
                "Kommando:");
    }

    @Test
    void gameStartsWithPlayerX() {
        Game sut = new Game();

        Player actual = sut.getPlayer();

        assertThat(actual).isEqualTo(Player.X);
    }

    @Test
    void gameShowsWinner() {
        Game sut = new Game();
        sut.makeMove(new Command("A0"));
        sut.makeMove(new Command("B0"));
        sut.makeMove(new Command("A1"));
        sut.makeMove(new Command("B1"));
        sut.makeMove(new Command("A2"));

        var actual = sut.getState();

        assertThat(sut.getWinner()).isEqualTo(Player.X);
        assertThat(actual).isEqualTo(" A B C \n" +
                "0X|O| \n" +
                " -+-+-  \n" +
                "1X|O| \n" +
                " -+-+-  \n" +
                "2X| | \n" +
                "*** Spieler 1 gewinnt\n" +
                "Kommando:");
    }

    @Test
    void cannotStartGameAfterWinning() {
        Game sut = new Game();
        sut.makeMove(new Command("A0"));
        sut.makeMove(new Command("B0"));
        sut.makeMove(new Command("A1"));
        sut.makeMove(new Command("B1"));
        sut.makeMove(new Command("A2"));

        var actual = sut.makeMove(new Command("B2"));

        assertThat(actual).isEqualTo(Operation.GAME_OVER);
    }

    @Test
    void movingToAlreadyUsedCellRepeatsCurrentPlayerTurn() {
        Game sut = new Game();

        sut.makeMove(new Command("A0"));
        var move = sut.makeMove(new Command("A0"));
        Player player = sut.getPlayer();

        assertThat(move).isEqualTo(Operation.INVALID_MOVE);
        assertThat(player).isEqualTo(Player.O);
    }

    @Test
    void whenResetingThenReturnEmptyField() {
        Game sut = new Game();

        sut.makeMove(new Command("A0"));
        sut.makeMove(new Command("neu"));

        assertThat(sut.getState()).isEqualTo(" A B C \n" +
                "0 | | \n" +
                " -+-+-  \n" +
                "1 | | \n" +
                " -+-+-  \n" +
                "2 | | \n" +
                "Kommando:");
    }
}