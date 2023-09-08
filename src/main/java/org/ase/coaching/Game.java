package org.ase.coaching;

public class Game {

    String action;
    private Field field;
    private Player currentPlayer;
    private Player winner;

    public Game() {
        reset();
    }

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


    public Operation makeMove(Command command) {
        if (command.equals(new Command("ende"))) {
            currentPlayer = Player.Empty;
            return Operation.CONTROL;
        }
        if (command.equals(new Command("start"))) {
            reset();
            return Operation.CONTROL;
        }
        Cell cell = field.getCell(command.getRow(), command.getColumn());
        if (cell.getPlayer() != Player.Empty) {
            return Operation.INVALID_MOVE;
        }
        cell.setPlayer(currentPlayer);
        winner = field.getWinner();
        switch (winner) {
            case X -> action = "Winner = X";
            case O -> action = "Winner = O";
            case Empty -> action = "Kommando:";
        }
        currentPlayer = currentPlayer.toggle();
        return Operation.VALID_MOVE;
    }

    private void reset() {
        currentPlayer = Player.X;
        action = "Kommando:";
        field = new Field();
    }

    public Player getPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }
}
