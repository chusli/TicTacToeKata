package org.ase.coaching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {


    @ParameterizedTest
    @EnumSource(Player.class)
    void setFieldToCross(Player inputPlayer) {
        Cell sut = new Cell();

        sut.setPlayer(inputPlayer);

        assertThat(sut.getPlayer()).isEqualTo(inputPlayer);
    }

}