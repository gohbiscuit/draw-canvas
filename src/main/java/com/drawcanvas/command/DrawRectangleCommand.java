package com.drawcanvas.command;

import com.drawcanvas.exception.DrawCanvasErrorCodes;
import com.drawcanvas.exception.DrawCanvasException;
import com.drawcanvas.graphics.IShape;
import com.drawcanvas.graphics.Point;
import com.drawcanvas.graphics.Rectangle;

public class DrawRectangleCommand extends AbstractCommand {
	@Override
	public void execute(String[] params) throws DrawCanvasException {
		if (!isCanvasCreated())
			throw new DrawCanvasException(DrawCanvasErrorCodes.CANVAS_NOT_CREATED_ERROR,
					DrawCanvasErrorCodes.CANVAS_NOT_CREATED_ERROR.getDescription());

		if (!this.validateArgumentsLength(params, CommandType.DRAW_RECT))
			throw new DrawCanvasException(DrawCanvasErrorCodes.DRAW_RECT_ARGUMENTS_LENGTH_ERROR,
					DrawCanvasErrorCodes.DRAW_RECT_ARGUMENTS_LENGTH_ERROR.getDescription());

		if (!this.validateArgumentsType(params)) {
			throw new DrawCanvasException(DrawCanvasErrorCodes.DRAW_RECT_ARGUMENTS_TYPE_ERROR,
					DrawCanvasErrorCodes.DRAW_RECT_ARGUMENTS_TYPE_ERROR.getDescription());
		}

		int x1 = Integer.parseInt(params[0]);
		int y1 = Integer.parseInt(params[1]);
		int x2 = Integer.parseInt(params[2]);
		int y2 = Integer.parseInt(params[3]);
		Point p1 = new Point(x1, y1); 
		Point p2 = new Point(x2, y2); 

		if (!this.validateBoundary(p1) || !this.validateBoundary(p2)) {
			throw new DrawCanvasException(DrawCanvasErrorCodes.DRAW_RECT_OUT_OF_BOUNDARY_ERROR,
					DrawCanvasErrorCodes.DRAW_RECT_OUT_OF_BOUNDARY_ERROR.getDescription());
		}
		
		IShape rectangle = new Rectangle(p1, p2);
		canvas.addShape(rectangle);
		
		this.canvas.storeShape(canvas.getShapes());

		System.out.println(canvas.render());
		System.out.println();
	}
}
