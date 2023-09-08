package org.ase.coaching;

public class Field {
    private Player player;

    public boolean isEmpty() {
        return player == null;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
