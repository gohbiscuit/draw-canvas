package com.drawcanvas.command;

import java.util.List;

import com.drawcanvas.exception.DrawCanvasErrorCodes;
import com.drawcanvas.exception.DrawCanvasException;
import com.drawcanvas.graphics.IShape;

public class RedoCommand extends AbstractCommand {
	
	@Override
	public void execute(String[] params) throws DrawCanvasException {
		if (!isCanvasCreated())
			throw new DrawCanvasException(DrawCanvasErrorCodes.CANVAS_NOT_CREATED_ERROR,
					DrawCanvasErrorCodes.CANVAS_NOT_CREATED_ERROR.getDescription());

		this.canvas.setShapes(this.canvas.getPreviousShape());
		System.out.println(this.canvas.render());
		System.out.println();
	}
}
