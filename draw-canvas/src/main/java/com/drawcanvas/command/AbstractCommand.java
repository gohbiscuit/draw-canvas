package com.drawcanvas.command;

import java.util.Optional;

import com.drawcanvas.exception.DrawCanvasException;
import com.drawcanvas.graphics.Canvas;
import com.drawcanvas.graphics.Point;

public abstract class AbstractCommand {
	protected Canvas canvas;
	
	private static final String POSITIVE_INT_PATTERN = "^[1-9]\\d*$";

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	protected boolean validateArgumentsType(String[] parameters) throws DrawCanvasException {
		for (String param : parameters) {
			if (!isPositiveInteger(param)) {
				return false;
			}
		}
		return true;
	}
	
	protected boolean validateArgumentsLength(String[] parameters, CommandType command) throws DrawCanvasException {
		return parameters.length == command.getArgumentsLength();
	}
	
	/*
	 * Returns true if canvas is created, otherwise false
	 */
	protected boolean isCanvasCreated() {
		return Optional.ofNullable(canvas).isPresent();
	}

	/*
	 * Returns true if Point p is within canvas boundary, otherwise false
	 */
	protected boolean validateBoundary(Point p) {
		return p.getX() <= canvas.getDrawableWidth() && p.getX() >= 1 && p.getY() <= canvas.getDrawableHeight() && p.getY() >= 1;
	}

	protected boolean isPositiveInteger(String input) {
		return input.matches(POSITIVE_INT_PATTERN);
	}

	public abstract void execute(String[] params) throws DrawCanvasException;
}
