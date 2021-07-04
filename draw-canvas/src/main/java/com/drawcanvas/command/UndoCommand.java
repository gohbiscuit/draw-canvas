package com.drawcanvas.command;

import com.drawcanvas.exception.DrawCanvasErrorCodes;
import com.drawcanvas.exception.DrawCanvasException;

public class UndoCommand extends AbstractCommand {

    @Override
    public void execute(String[] params) throws DrawCanvasException {
        if (!isCanvasCreated())
            throw new DrawCanvasException(DrawCanvasErrorCodes.CANVAS_NOT_CREATED_ERROR,
                    DrawCanvasErrorCodes.CANVAS_NOT_CREATED_ERROR.getDescription());


        canvas.undo();
        System.out.println(canvas.render());
        System.out.println();
    }
}
