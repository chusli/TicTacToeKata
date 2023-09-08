package org.ase.coaching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @Test
    void getRepresentationWhenPlayerEmpty() {
        final var sut = Player.Empty;

        assertThat(sut.getRepresentation()).isEqualTo(" ");
    }
}