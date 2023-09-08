package org.ase.coaching;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FieldTest {

    @Test
    void initialFieldIsEmpty() {
        Field sut = new Field();

        List<Cell> cells = sut.getCells();

        assertThat(cells).isNotEmpty();
        assertThat(cells).allMatch(cell -> cell.getPlayer() == Player.Empty);
    }

    @Test
    void initialFieldContains9Fields() {
        Field sut = new Field();

        List<Cell> cells = sut.getCells();

        assertThat(cells).hasSize(9);
    }

    @Test
    void changeCell() {
        Field sut = new Field();
        sut.getCell(1, 1).setPlayer(Player.X);

        var actual = sut.getCell(1, 1);

        assertThat(actual.getPlayer()).isEqualTo(Player.X);
    }

    @Test
    void playerXWins() {
        Field sut = new Field();
        sut.getCell(0, 0).setPlayer(Player.X);
        sut.getCell(0, 1).setPlayer(Player.X);
        sut.getCell(0, 2).setPlayer(Player.X);

        Player winner = sut.getWinner();

        assertThat(winner).isEqualTo(Player.X);
    }
}