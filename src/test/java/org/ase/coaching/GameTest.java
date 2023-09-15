package org.ase.coaching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class GameTest {
    @Test
    void getInitialState() {
        Game sut = new Game();

        String actual = sut.getState();

        assertThat(actual).isEqualTo("""
                 A B C\s
                0 | |\s
                 -+-+- \s
                1 | |\s
                 -+-+- \s
                2 | |\s
                Kommando:""");
    }

    @Test
    void getStateAfterFirstMove() {
        Game sut = new Game();
        sut.makeMove(Command.A0);

        String actual = sut.getState();

        assertThat(actual).isEqualTo("""
                 A B C\s
                0X| |\s
                 -+-+- \s
                1 | |\s
                 -+-+- \s
                2 | |\s
                Kommando:""");
    }

    @Test
    void gameStartsWithPlayerX() {
        Game sut = new Game();

        Player actual = sut.getPlayer();

        assertThat(actual).isEqualTo(Player.X);
    }

    @Test
    void getStateWhenPlayerXWinsShowPlayerXAsWinner() {
        Game sut = new Game();
        sut.makeMove(Command.A0);
        sut.makeMove(Command.B0);
        sut.makeMove(Command.A1);
        sut.makeMove(Command.B1);
        sut.makeMove(Command.A2);

        var actual = sut.getState();

        assertThat(sut.getWinner()).isEqualTo(Player.X);
        assertThat(actual).isEqualTo("""
                 A B C\s
                0X|O|\s
                 -+-+- \s
                1X|O|\s
                 -+-+- \s
                2X| |\s
                *** Spieler 1 gewinnt
                Kommando:""");
    }

    @Test
    void getStateWhenPlayerOWinsShowPlayerOAsWinner() {
        Game sut = new Game();
        sut.makeMove(Command.A0);
        sut.makeMove(Command.B0);
        sut.makeMove(Command.A1);
        sut.makeMove(Command.B1);
        sut.makeMove(Command.C0);
        sut.makeMove(Command.B2);

        var actual = sut.getState();

        assertThat(sut.getWinner()).isEqualTo(Player.O);
        assertThat(actual).isEqualTo("""
                 A B C\s
                0X|O|X
                 -+-+- \s
                1X|O|\s
                 -+-+- \s
                2 |O|\s
                *** Spieler 2 gewinnt
                Kommando:""");
    }

    @Test
    void cannotStartGameAfterWinning() {
        Game sut = new Game();
        sut.makeMove(Command.A0);
        sut.makeMove(Command.B0);
        sut.makeMove(Command.A1);
        sut.makeMove(Command.B1);
        sut.makeMove(Command.A2);

        var actual = sut.makeMove(Command.B2);

        assertThat(actual).isEqualTo(Operation.GAME_OVER);
    }

    @Test
    void movingToAlreadyUsedCellRepeatsCurrentPlayerTurn() {
        Game sut = new Game();

        sut.makeMove(Command.A0);
        var move = sut.makeMove(Command.A0);
        Player player = sut.getPlayer();

        assertThat(move).isEqualTo(Operation.INVALID_MOVE);
        assertThat(player).isEqualTo(Player.O);
    }

    @Test
    void whenResetingThenReturnEmptyField() {
        Game sut = new Game();

        sut.makeMove(Command.A0);
        sut.makeMove(Command.NEU);

        assertThat(sut.getState()).isEqualTo("""
                 A B C\s
                0 | |\s
                 -+-+- \s
                1 | |\s
                 -+-+- \s
                2 | |\s
                Kommando:""");
    }

    @Test
    void stalemate() {
        Game sut = new Game();


        sut.makeMove(Command.A0);
        sut.makeMove(Command.B0);
        sut.makeMove(Command.A1);
        sut.makeMove(Command.B1);
        sut.makeMove(Command.B2);
        sut.makeMove(Command.A2);
        sut.makeMove(Command.C0);
        sut.makeMove(Command.C1);
        sut.makeMove(Command.C2);

        sut.getState();

        assertThat(sut.getState()).isEqualTo("""
                 A B C\s
                0X|O|X
                 -+-+- \s
                1X|O|O
                 -+-+- \s
                2O|X|X
                *** Kein Gewinner
                Kommando:""");
    }

    @Test
    void makeMoveWhenCommandEndeProvidedThenReturnControlWithoutPlayer() {
        Game sut = new Game();

        Operation actual = sut.makeMove(Command.ENDE);

        assertThat(actual).isEqualTo(Operation.CONTROL);
        assertThat(sut.getPlayer()).isEqualTo(Player.Empty);
    }

}