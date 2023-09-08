package org.ase.coaching;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class FieldTest {

    @Test
    void initialFieldIsEmpty() {
        Field sut = new Field();

        assertThat(sut.isEmpty()).isTrue();
    }

    @ParameterizedTest
    @EnumSource(Player.class)
    void setFieldToCross(Player inputPlayer) {
        Field sut = new Field();

        sut.setPlayer(inputPlayer);

        assertThat(sut.getPlayer()).isEqualTo(inputPlayer);
    }

    @Test
    void isEmptyWhenPlayerIsSetThenReturnFalse() {
        Field sut = new Field();

        sut.setPlayer(Player.O);

        assertThat(sut.isEmpty()).isFalse();
    }
}