package org.ase.coaching;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner in = new Scanner(System.in);

        Player player = Player.X;
        do {
            System.out.println(game.getState());
            var command = in.nextLine();
            game.makeMove(player, getRow(command), getColumn(command));
            player = player == Player.X ? Player.O : Player.X;

        } while (1 == 1);
    }

    private static int getRow(String command) {
        return switch (command.substring(0, 1)) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            default -> throw new RuntimeException("invalid row provided = " + command);
        };
    }

    private static int getColumn(String command) {
        return switch (command.substring(1, 2)) {
            case "0" -> 0;
            case "1" -> 1;
            case "2" -> 2;
            default -> throw new RuntimeException("invalid column provided = " + command);
        };
    }
}