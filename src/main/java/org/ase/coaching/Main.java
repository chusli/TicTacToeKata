package org.ase.coaching;


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        do {
            System.out.println(game.getState());
            var command = Command.readCommand();
            game.makeMove(command);

        } while (game.getPlayer() != Player.Empty);
    }

}