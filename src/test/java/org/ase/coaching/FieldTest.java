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
}