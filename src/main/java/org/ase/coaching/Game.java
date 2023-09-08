package org.ase.coaching;

public class Game {

    private final Field field = new Field();
    String action = "Kommando:";
    private Player currentPlayer = Player.X;
    private Player winner;

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
                action;
    }


    public void makeMove(Command command) {
        field.getCell(command.getRow(), command.getColumn()).setPlayer(currentPlayer);
        winner = field.getWinner();
        switch (winner) {
            case X -> action = "Winner = X";
            case O -> action = "Winner = O";
            case Empty -> action = "Kommando:";
        }
        currentPlayer = currentPlayer.toggle();
    }

    public Player getPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }
}
