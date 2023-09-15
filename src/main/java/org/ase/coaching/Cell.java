package org.ase.coaching;

import java.util.Objects;

public class Cell {
    private Player player = Player.Empty;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return player == cell.player;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "player=" + player +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
