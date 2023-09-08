package org.ase.coaching;

import java.util.List;
import java.util.Objects;

public class Command {
    private static final List<String> VALIDCOLUMNS = List.of("A", "B", "C");
    private static final List<String> VALIDROWS = List.of("0", "1", "2");
    private static final List<String> VALID_GAME_COMMANDS = List.of("ende", "start", "neu");
    private final String command;

    public Command(String command) {
        this.command = command;
    }

    public static List<Command> getMovingCommands() {
        return VALIDCOLUMNS.stream()
                .flatMap(column -> VALIDROWS.stream().map(row -> new Command(column + row)))
                .toList();
    }

    public boolean isValid() {
        if (command.length() != 2) {
            return VALID_GAME_COMMANDS.contains(command);
        }
        var firstLetter = command.substring(0, 1);
        var secondLetter = command.substring(1, 2);

        return VALIDCOLUMNS.contains(firstLetter) && VALIDROWS.contains(secondLetter);
    }

    public int getColumn() {
        return VALIDCOLUMNS.indexOf(command.substring(0, 1));
    }

    public int getRow() {
        return VALIDROWS.indexOf(command.substring(1, 2));
    }

    @Override
    public String toString() {
        return "Command{" +
                "command='" + command + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Command command1 = (Command) o;
        return Objects.equals(command, command1.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command);
    }
}
