package org.ase.coaching;

public class Game {

    private final Field field = new Field();

    public String getState() {
        return " A B C \n" +
                "0%s|%s|%s\n".formatted(field.getCell(0, 0).getPlayer().getRepresentation(),
                        field.getCell(0, 1).getPlayer().getRepresentation(),
                        field.getCell(0, 2).getPlayer().getRepresentation()) +
                " -+-+-  \n" +
                "1%s|%s|%s\n".formatted(field.getCell(1, 0).getPlayer().getRepresentation(),
                        field.getCell(1, 1).getPlayer().getRepresentation(),
                        field.getCell(1, 2).getPlayer().getRepresentation()) +
                " -+-+-  \n" +
                "2%s|%s|%s\n".formatted(field.getCell(2, 0).getPlayer().getRepresentation(),
                        field.getCell(2, 1).getPlayer().getRepresentation(),
                        field.getCell(2, 2).getPlayer().getRepresentation()) +
                "Kommando:";
    }

    public void makeMove(Player player, int row, int column) {
        field.getCell(row, column).setPlayer(player);
    }
}
