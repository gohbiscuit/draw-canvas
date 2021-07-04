package com.drawcanvas.command;

import com.drawcanvas.exception.DrawCanvasException;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DrawRectangleCommandTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    private CreateCanvasCommand create;
    
    @Before
    public void init() throws Exception {
        create = new CreateCanvasCommand();
        create.execute(new String[]{"20","4"});
    }

    @Test
    public void drawRectangleCommand() throws DrawCanvasException{
        DrawRectangleCommand drawRect = new DrawRectangleCommand();
        drawRect.setCanvas(create.getCanvas());
        drawRect.execute(new String[]{"14", "1", "18", "3"});
        
        assertEquals("----------------------\n" + 
        			"|             xxxxx  |\n" + 
        			"|             x   x  |\n" + 
        			"|             xxxxx  |\n" + 
        			"|                    |\n" + 
        			"----------------------", drawRect.getCanvas().render());
    }

    @Test
    public void drawRectangleCommand_ReverseCoordinate() throws DrawCanvasException{
        DrawRectangleCommand drawRect = new DrawRectangleCommand();
        drawRect.setCanvas(create.getCanvas());
        drawRect.execute(new String[]{"18", "3", "14", "1"});
        
        assertEquals("----------------------\n" + 
        			"|             xxxxx  |\n" + 
        			"|             x   x  |\n" + 
        			"|             xxxxx  |\n" + 
        			"|                    |\n" + 
        			"----------------------", drawRect.getCanvas().render());
    }
    
    @Test
    public void drawRectangleCommand_WholeArea() throws DrawCanvasException{
        DrawRectangleCommand drawRect = new DrawRectangleCommand();
        drawRect.setCanvas(create.getCanvas());
        drawRect.execute(new String[]{"1", "1", "20", "4"});
        
        assertEquals("----------------------\n" + 
        			"|xxxxxxxxxxxxxxxxxxxx|\n" + 
        			"|x                  x|\n" + 
        			"|x                  x|\n" + 
        			"|xxxxxxxxxxxxxxxxxxxx|\n" + 
        			"----------------------", drawRect.getCanvas().render());
    }

    @Test
    public void drawRectangleCommand_executeOutOfBoundary() throws DrawCanvasException{
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please specify correct x1 y1 x2 y2 that is within canvas boundary.");

        DrawRectangleCommand drawRect = new DrawRectangleCommand();
        drawRect.setCanvas(create.getCanvas());
        drawRect.execute(new String[]{"30", "1", "20", "4"});
    }

    @Test
    public void drawRectangleCommand_invalidParamsLength() throws DrawCanvasException{
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please enter 4 arguments to draw a rectangle, in the following format 'R x1 y1 x2 y2'.");

        DrawRectangleCommand drawRect = new DrawRectangleCommand();
        drawRect.setCanvas(create.getCanvas());
        drawRect.execute(new String[]{"18", "3", "14"});
    }

    @Test
    public void drawRectangleCommand_invalidNegativeParams() throws DrawCanvasException{
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input (x1,y1,x2,y2) is only positive numbers.");
        
        DrawRectangleCommand drawRect = new DrawRectangleCommand();
        drawRect.setCanvas(create.getCanvas());
        drawRect.execute(new String[]{"18", "-3", "14", "1"});
    }

    @Test
    public void drawRectangleCommand_invalidAlphabetParams() throws DrawCanvasException{
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input (x1,y1,x2,y2) is only positive numbers.");

        DrawRectangleCommand drawRect = new DrawRectangleCommand();
        drawRect.setCanvas(create.getCanvas());
        drawRect.execute(new String[]{"18", "3", "14", "a"});
    }

    @Test
    public void drawRectangleCommand_invalidEmptyParams() throws DrawCanvasException{
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input (x1,y1,x2,y2) is only positive numbers.");

        DrawRectangleCommand drawRect = new DrawRectangleCommand();
        drawRect.setCanvas(create.getCanvas());
        drawRect.execute(new String[]{" ", " ", "14", "3"});
    }
}