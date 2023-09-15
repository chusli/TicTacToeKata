package org.ase.coaching;

public class Game {

    String winnerNotification = "";
    private Field field;
    private Player currentPlayer;
    private Player winner;

    public Game() {
        reset();
    }

    public String getState() {
        return " A B C \n0%s|%s|%s\n -+-+-  \n1%s|%s|%s\n -+-+-  \n2%s|%s|%s\n"
                .formatted(field.getCells().stream().map(Cell::getPlayer).map(Player::getRepresentation).toArray()) +
                winnerNotification +
                "Kommando:";
    }


    public Operation makeMove(Command command) {
        if (gameOver()) {
            return Operation.GAME_OVER;
        }

        switch (command) {
            case ENDE -> {
                currentPlayer = Player.Empty;
                return Operation.CONTROL;
            }
            case START, NEU -> {
                reset();
                return Operation.CONTROL;
            }
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
