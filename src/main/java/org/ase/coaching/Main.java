package org.ase.coaching;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner in = new Scanner(System.in);

        Player player = Player.X;
        do {
            System.out.println(game.getState());
            var command = new Command(in.nextLine());

            game.makeMove(player, command);
            player = player == Player.X ? Player.O : Player.X;

        } while (1 == 1);
    }

}