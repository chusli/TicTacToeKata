package org.ase.coaching;

public enum Player {
    X("X"),
    O("O"),
    Empty(" ");

    private final String representation;

    Player(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public Player toggle() {
        return switch (this) {
            case Empty -> Player.X;
            case X -> Player.O;
            case O -> Player.X;
        };
    }
}
