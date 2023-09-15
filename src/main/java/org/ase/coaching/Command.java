package org.ase.coaching;

import java.util.Scanner;

public enum Command {
    A0("A0", Operation.VALID_MOVE),
    B0("B0", Operation.VALID_MOVE),
    C0("C0", Operation.VALID_MOVE),
    A1("A1", Operation.VALID_MOVE),
    B1("B1", Operation.VALID_MOVE),
    C1("C1", Operation.VALID_MOVE),
    A2("A2", Operation.VALID_MOVE),
    B2("B2", Operation.VALID_MOVE),
    C2("C2", Operation.VALID_MOVE),
    ENDE("ENDE", Operation.GAME_OVER),
    START("START", Operation.CONTROL),
    NEU("NEU", Operation.CONTROL);

    private final String s;
    private final Operation op;

    Command(String s, Operation op) {
        this.s = s;

        this.op = op;
    }

    public static Command getEnum(String value) {
        return valueOf(value.toUpperCase());
    }

    public static Command readCommand() {
        Scanner in = new Scanner(System.in);
        Command command;
        do {
            try {
                command = Command.getEnum(in.nextLine());
            } catch (IllegalArgumentException exception) {
                command = null;
            }
        } while (command == null);
        return command;
    }

    public int getRow() {
        if (op != Operation.VALID_MOVE) {
            return -1;
        }
        return switch (s.substring(1, 2)) {
            case "0" -> 0;
            case "1" -> 1;
            case "2" -> 2;
            default -> throw new IllegalStateException("Unexpected value: " + s.substring(0, 1));
        };
    }

    public int getColumn() {
        if (op != Operation.VALID_MOVE) {
            return -1;
        }
        return switch (s.substring(0, 1)) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            default -> throw new IllegalStateException("Unexpected value: " + s.substring(0, 1));
        };
    }

    public Operation getOperation() {
        return op;
    }
}
