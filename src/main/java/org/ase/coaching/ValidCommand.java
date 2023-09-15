package org.ase.coaching;

public enum ValidCommand {
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

    ValidCommand(String s, Operation op) {
        this.s = s;

        this.op = op;
    }

    public static ValidCommand getEnum(String value) {
        return valueOf(value.toUpperCase());
    }

}
