package com.drawcanvas.factory;

import com.drawcanvas.command.*;

/*
 * Factory Design Pattern
 */
public class CommandFactory {
	public AbstractCommand getCommand(CommandType cmdType) {
		switch (cmdType) {
		case CREATE_CANVAS:
			return new CreateCanvasCommand();
		case DRAW_LINE:
			return new DrawLineCommand();
		case DRAW_RECT:
			return new DrawRectangleCommand();
		case FILL_AREA:
			return new FillAreaCommand();
		case QUIT:
			return new QuitCommand();
		/* Additional Commands (clear canvas and help) */
		case CLEAR_CANVAS:
			return new ClearCanvasCommand();
		case UNDO:
			return new UndoCommand();
		case REDO:
			return new RedoCommand();
		case HELP:
			return new HelpCommand();
		}
		return null;
    }
}
