package com.drawcanvas.command;

import java.util.List;

import com.drawcanvas.exception.DrawCanvasErrorCodes;
import com.drawcanvas.exception.DrawCanvasException;
import com.drawcanvas.graphics.IShape;

public class UndoCommand extends AbstractCommand {

	@Override
	public void execute(String[] params) throws DrawCanvasException {
		if (!isCanvasCreated())
			throw new DrawCanvasException(DrawCanvasErrorCodes.CANVAS_NOT_CREATED_ERROR,
					DrawCanvasErrorCodes.CANVAS_NOT_CREATED_ERROR.getDescription());
		
		List<IShape> canvasShape = this.canvas.getShapes();
		this.canvas.storeShape(canvasShape);
		
		if(canvasShape.isEmpty()) {
			throw new DrawCanvasException(DrawCanvasErrorCodes.CANVAS_HAS_NO_SHAPES_ERROR,
					DrawCanvasErrorCodes.CANVAS_HAS_NO_SHAPES_ERROR.getDescription());
		}
		
		canvasShape.remove(canvasShape.size()-1);
		this.canvas.setShapes(canvasShape);
		System.out.println(this.canvas.render());
		System.out.println();
	}
}
