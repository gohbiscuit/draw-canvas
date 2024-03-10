package com.drawcanvas.command;

import com.drawcanvas.exception.DrawCanvasErrorCodes;
import com.drawcanvas.exception.DrawCanvasException;
import com.drawcanvas.graphics.Canvas;
import lombok.Getter;

@Getter
public class CreateCanvasCommand extends AbstractCommand {
	private static final int MAX_WIDTH = 80;
	private static final int MAX_HEIGHT = 80;
	@Override
	public void execute(String[] params) throws DrawCanvasException {
		if (!this.validateArgumentsLength(params, CommandType.CREATE_CANVAS))
			throw new DrawCanvasException(DrawCanvasErrorCodes.CREATE_CANVAS_ARGUMENTS_LENGTH_ERROR,
					DrawCanvasErrorCodes.CREATE_CANVAS_ARGUMENTS_LENGTH_ERROR.getDescription());

		if (!this.validateArgumentsType(params)) {
			throw new DrawCanvasException(DrawCanvasErrorCodes.CREATE_CANVAS_ARGUMENTS_TYPE_ERROR,
					DrawCanvasErrorCodes.CREATE_CANVAS_ARGUMENTS_TYPE_ERROR.getDescription());
		}
		if(!this.validateWidthAndHeight(Integer.parseInt(params[0]), Integer.parseInt(params[1])) ) {
			throw new DrawCanvasException(DrawCanvasErrorCodes.CREATE_CANVAS_SIZE_EXCEED_ERROR,
					DrawCanvasErrorCodes.CREATE_CANVAS_SIZE_EXCEED_ERROR.getDescription());
		}
		super.canvas = new Canvas(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
		System.out.println(canvas.render());
		System.out.println();
	}
	
	private boolean validateWidthAndHeight(int width, int height) {
		return width <= MAX_WIDTH && height <= MAX_HEIGHT;
	}
}
