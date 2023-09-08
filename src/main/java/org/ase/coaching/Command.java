package org.ase.coaching;

import java.util.List;

public class Command {
    private final String command;

    List<String> validColumns = List.of("A", "B", "C");
    List<String> validRows = List.of("0", "1", "2");

    public Command(String command) {
        this.command = command;
    }

    public boolean isValid() {
        if (command.length() != 2) {
            return false;
        }
        var firstLetter = command.substring(0, 1);
        var secondLetter = command.substring(1, 2);

        return validColumns.contains(firstLetter) && validRows.contains(secondLetter);
    }

    public int getColumn() {
        return validColumns.indexOf(command.substring(0, 1));
    }

    public int getRow() {
        return validRows.indexOf(command.substring(1, 2));
    }
}
