package org.ase.coaching;

public class Cell {
    private Player player = Player.Empty;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}