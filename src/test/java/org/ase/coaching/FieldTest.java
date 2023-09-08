package org.ase.coaching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class FieldTest {


    @ParameterizedTest
    @EnumSource(Player.class)
    void setFieldToCross(Player inputPlayer) {
        Field sut = new Field();

        sut.setPlayer(inputPlayer);

        assertThat(sut.getPlayer()).isEqualTo(inputPlayer);
    }

}