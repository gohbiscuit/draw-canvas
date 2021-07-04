package com.drawcanvas.exception;


import lombok.Getter;

@Getter
public enum DrawCanvasErrorCodes {

	CANVAS_NOT_CREATED_ERROR("CANVAS_NOT_CREATED_ERROR-001", "Canvas Not Created", "Please create a new canvas."),
	
    CREATE_CANVAS_ARGUMENTS_LENGTH_ERROR("CREATE-CANVAS-ERROR-001", "Invalid Arguments Length", "Please enter 2 arguments to create a canvas, in the following format 'C w h'."),
    CREATE_CANVAS_ARGUMENTS_TYPE_ERROR("CREATE-CANVAS-ERROR-002", "Invalid Arguments Type", "Please ensure your input is only positive numbers."),
    CREATE_CANVAS_SIZE_EXCEED_ERROR("CREATE-CANVAS-ERROR-003", "Exceed Max Width/Height", "Canvas width/height cannot be more than 80 units"),

    DRAW_LINE_ARGUMENTS_LENGTH_ERROR("DRAW-LINE-ERROR-001", "Invalid Arguments Length", "Please enter 4 arguments to draw a line, in the following format 'L x1 y1 x2 y2'."),
    DRAW_LINE_ARGUMENTS_TYPE_ERROR("DRAW-LINE-ERROR-002", "Invalid Arguments Type", "Please ensure your input (x1,y1,x2,y2) is only positive numbers."),
    DRAW_LINE_OUT_OF_BOUNDARY_ERROR("DRAW-LINE-ERROR-003", "Out of Canvas Boundary", "Please specify correct x1 y1 x2 y2 that is within canvas boundary."),
    DRAW_LINE_DIAGONAL_LINE_ERROR("DRAW-LINE-ERROR-004", "Diagonal Line not Supported", "Please specify correct x1 y1 x2 y2 that is linear and not diagonal."),

    DRAW_RECT_ARGUMENTS_LENGTH_ERROR("DRAW-RECT-ERROR-001", "Invalid Arguments Length", "Please enter 4 arguments to draw a rectangle, in the following format 'R x1 y1 x2 y2'."),
    DRAW_RECT_ARGUMENTS_TYPE_ERROR("DRAW-RECT-ERROR-002", "Invalid Arguments Type", "Please ensure your input (x1,y1,x2,y2) is only positive numbers."),
    DRAW_RECT_OUT_OF_BOUNDARY_ERROR("DRAW-RECT-ERROR-003", "Out of Canvas Boundary", "Please specify correct x1 y1 x2 y2 that is within canvas boundary."),

    FILL_AREA_ARGUMENTS_LENGTH_ERROR("FILL-AREA-ERROR-001", "Invalid Arguments Length", "Please enter 3 arguments to fill an area at a point (x,y) with color c, in the following format 'B x y c'."),
    FILL_AREA_ARGUMENTS_TYPE_ERROR("FILL-AREA-ERROR-002", "Invalid Arguments Type", "Please ensure your input (x1,y1) is only positive numbers, and color c is a single digit alphabet"),
    FILL_AREA_OUT_OF_BOUNDARY_ERROR("FILL-AREA-ERROR-003", "Out of Canvas Boundary", "Please specify point (x1,y1) is within canvas boundary."),

    INVALID_COMMAND_ERROR("INVALID-COMMAND-ERROR-001", "Invalid Command", "Please ensure you have entered a valid command."),

    INVALID_ARGUMENTS_ERROR("INVALID-ARGUMENTS-001", "Invalid Point Value", "Please ensure you only accept positive integers that is more than 0.");

    private String code;
    private String title;
    private String description;

    DrawCanvasErrorCodes(String code, String title, String description){
        this.code = code;
        this.title = title;
        this.description = description;
    }
}
