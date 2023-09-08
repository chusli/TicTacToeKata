package org.ase.coaching;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @Test
    void getRepresentationWhenPlayerEmpty() {
        final var sut = Player.Empty;

        assertThat(sut.getRepresentation()).isEqualTo(" ");
    }

    @Test
    void togglePlayerX() {
        assertThat(Player.X.toggle()).isEqualTo(Player.O);
        assertThat(Player.O.toggle()).isEqualTo(Player.X);
        assertThat(Player.Empty.toggle()).isEqualTo(Player.X);
    }
}