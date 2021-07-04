package com.drawcanvas.command;

import com.drawcanvas.exception.DrawCanvasErrorCodes;
import com.drawcanvas.exception.DrawCanvasException;
import com.drawcanvas.graphics.Fill;
import com.drawcanvas.graphics.IShape;
import com.drawcanvas.graphics.Point;

public class FillAreaCommand extends AbstractCommand {
	private static final String ALPHABETS_ONLY_PATTERN = "[A-Za-z]";
	
	public FillAreaCommand() {
	}

	@Override
	public void execute(String[] params) throws DrawCanvasException {
		if (!isCanvasCreated())
			throw new DrawCanvasException(DrawCanvasErrorCodes.CANVAS_NOT_CREATED_ERROR,
					DrawCanvasErrorCodes.CANVAS_NOT_CREATED_ERROR.getDescription());
		
		if (!this.validateArgumentsLength(params, CommandType.FILL_AREA))
			throw new DrawCanvasException(DrawCanvasErrorCodes.FILL_AREA_ARGUMENTS_LENGTH_ERROR,
					DrawCanvasErrorCodes.FILL_AREA_ARGUMENTS_LENGTH_ERROR.getDescription());
		
		if (!this.validateArgumentsType(params)) {
			throw new DrawCanvasException(DrawCanvasErrorCodes.FILL_AREA_ARGUMENTS_TYPE_ERROR,
					DrawCanvasErrorCodes.FILL_AREA_ARGUMENTS_TYPE_ERROR.getDescription());
		}

		int x1 = Integer.parseInt(params[0]);
		int y1 = Integer.parseInt(params[1]);
		char color = params[2].charAt(0);
		Point p1 = new Point(x1, y1); 
		if (!this.validateBoundary(p1)) {
			throw new DrawCanvasException(DrawCanvasErrorCodes.FILL_AREA_OUT_OF_BOUNDARY_ERROR,
					DrawCanvasErrorCodes.FILL_AREA_OUT_OF_BOUNDARY_ERROR.getDescription());
		}
		IShape fill = new Fill(new Point(x1, y1), color, canvas.getDrawableWidth(), canvas.getDrawableHeight());
		canvas.addShape(fill);
		System.out.println(this.canvas.render());
		System.out.println();
	}

	@Override
	public boolean validateArgumentsType(String[] parameters) throws DrawCanvasException {
		for (int i = 0; i < parameters.length - 1; i++) {
			if (!isPositiveInteger(parameters[i])) {
				return false;
			}
		}
		if(parameters[2] == null || parameters[2].length() != 1 || !parameters[2].matches(ALPHABETS_ONLY_PATTERN) ) {
			return false;
		}
		return true;
	}
}
