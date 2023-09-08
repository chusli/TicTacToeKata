package org.ase.coaching;

public class Game {

    final String action = "Kommando:";
    String winnerNotification = "";
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
                winnerNotification +
                action;
    }


    public Operation makeMove(Command command) {
        if (gameOver()) {
            return Operation.GAME_OVER;
        }

        if (command.equals(new Command("ende"))) {
            currentPlayer = Player.Empty;
            return Operation.CONTROL;
        }
        if (command.equals(new Command("start")) || command.equals(new Command("neu"))) {
            reset();
            return Operation.CONTROL;
        }
        Cell cell = field.getCell(command.getRow(), command.getColumn());
        if (cell.getPlayer() != Player.Empty) {
            return Operation.INVALID_MOVE;
        }
        cell.setPlayer(currentPlayer);
        if (stalemate()) {
            winnerNotification = "*** Kein Gewinner\n";
            return Operation.GAME_OVER;
        }
        winner = field.getWinner();
        switch (winner) {
            case X -> winnerNotification = "*** Spieler 1 gewinnt\n";
            case O -> winnerNotification = "*** Spieler 2 gewinnt\n";
        }
        currentPlayer = currentPlayer.toggle();
        return Operation.VALID_MOVE;
    }

    private boolean stalemate() {
        return field.getCells().stream().allMatch(cell -> cell.getPlayer() != Player.Empty);
    }

    private boolean gameOver() {
        return getWinner() != Player.Empty;
    }

    private void reset() {
        currentPlayer = Player.X;
        winner = Player.Empty;
        winnerNotification = "";
        field = new Field();
    }

    public Player getPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }
}
