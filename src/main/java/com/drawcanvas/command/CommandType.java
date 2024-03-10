package com.drawcanvas.command;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {
    CREATE_CANVAS("C", 2),
    DRAW_LINE("L", 4),
    DRAW_RECT("R", 4),
    FILL_AREA("B", 3),
    CLEAR_CANVAS("O"),
    UNDO("U"),
    REDO("E"),
    HELP("H"),
    QUIT("Q");

	@Getter
    private final String type;
	@Getter
    private final int argumentsLength;
    
    private static final Map<String, CommandType> lookup = new HashMap<>();

	static {
		for (CommandType cmdType : CommandType.values()) {
			lookup.put(cmdType.type, cmdType);
		}
	}

    /**
     * @param type
     */
    CommandType(final String type) {
        this.type = type;
        this.argumentsLength = 0;
    }
    CommandType(final String type, final int argumentsLength) {
        this.type = type;
        this.argumentsLength = argumentsLength;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return type;
    }
    
    public static CommandType get(String commandType) {
		return lookup.get(commandType);
	}
}
