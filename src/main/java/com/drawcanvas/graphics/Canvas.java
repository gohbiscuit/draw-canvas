package com.drawcanvas.graphics;

import com.drawcanvas.exception.DrawCanvasException;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private static final char HORIZONTAL_WALL_EDGE        = '-';
    private static final char VERTICAL_WALL_EDGE          = '|';
    private static final char CANVAS_BODY_CONTENT         = ' ';

    private char[][] canvasBoardArray;
    
    @Getter
    private int drawableWidth;	
    @Getter
	private int drawableHeight;
    @Getter
    private int width;
    @Getter
	private int height;
    
    @Getter @Setter
    private List<IShape> shapes;
    
    @Getter @Setter
    private List<IShape> previousShape;
    
    public Canvas() {}
    
    public Canvas(int width, int height) {
    	this.drawableWidth = width;
    	this.drawableHeight = height;
        this.width = width + 2;					// include borders
        this.height = height + 2;				// include borders
        canvasBoardArray = new char[this.height][this.width];
        this.shapes = new ArrayList<IShape>();
        this.previousShape = new ArrayList<IShape>();
    }
    
    public boolean addShape(IShape shape) {
        return shapes.add(shape);
    }
    
    public void storeShape(List<IShape> shapes){
    	for(IShape s : shapes) {
    		previousShape.add(s);
    	}
    }
    
    /**
     * Method to render the canvas in the console
     * @throws DrawCanvasException 
     */
    public String render()  {
    	// create borders
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                if (row == 0 || row == this.height - 1) {
                	canvasBoardArray[row][col] = HORIZONTAL_WALL_EDGE;
                } else if (col == 0 || col == this.width - 1) {
                	canvasBoardArray[row][col] = VERTICAL_WALL_EDGE;
                } else {
                	canvasBoardArray[row][col] = CANVAS_BODY_CONTENT;
                }
            }
        }
    	
        // append shapes
        for (IShape shape : shapes) {
            canvasBoardArray = shape.draw(canvasBoardArray);
        }
        
        // render to console
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
            	builder.append((char) canvasBoardArray[i][j]);
            }
            builder.append("\n");
        }
        return builder.toString().trim();
    }
}
