package org.ase.coaching;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();


        Player player = Player.X;
        do {
            System.out.println(game.getState());
            var command = readCommand();

            game.makeMove(player, command);
            player = player == Player.X ? Player.O : Player.X;

        } while (1 == 1);
    }

    private static Command readCommand() {
        Scanner in = new Scanner(System.in);
        Command command;
        do {
            command = new Command(in.nextLine());
        } while (command == null || !command.isValid());
        return command;
    }

}