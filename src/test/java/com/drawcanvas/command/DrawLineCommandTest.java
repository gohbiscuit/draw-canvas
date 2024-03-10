package com.drawcanvas.command;

import com.drawcanvas.exception.DrawCanvasException;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DrawLineCommandTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    private CreateCanvasCommand create;
    
    @Before
    public void init() throws Exception {
        create = new CreateCanvasCommand();
        create.execute(new String[]{"20","4"});
    }
    
	@Test
    public void drawLineCommand_horizontalLine() throws DrawCanvasException {
        DrawLineCommand drawLine = new DrawLineCommand();
        drawLine.setCanvas(create.getCanvas());
        drawLine.execute(new String[]{"6", "2", "1", "2"});
        
        assertEquals("----------------------\n" + 
        			 "|                    |\n" + 
        			 "|xxxxxx              |\n" + 
        			 "|                    |\n" + 
        			 "|                    |\n" + 
        			 "----------------------", drawLine.getCanvas().render());
    }
	
	@Test
    public void drawLineCommand_vertical() throws DrawCanvasException {
        DrawLineCommand drawLine = new DrawLineCommand();
        drawLine.setCanvas(create.getCanvas());
        drawLine.execute(new String[]{"2", "1", "2", "4"});
        
        assertEquals("----------------------\n" + 
        			"| x                  |\n" + 
        			"| x                  |\n" + 
        			"| x                  |\n" + 
        			"| x                  |\n" + 
        			"----------------------", drawLine.getCanvas().render());
    }
	
	@Test
    public void drawLineCommand_diagonal() throws DrawCanvasException {
        DrawLineCommand drawLine = new DrawLineCommand();
        drawLine.setCanvas(create.getCanvas());
        drawLine.execute(new String[]{"1", "1", "4", "4"});
        
        assertEquals("----------------------\n" + 
        			"|x                   |\n" + 
        			"| x                  |\n" + 
        			"|  x                 |\n" + 
        			"|   x                |\n" + 
        			"----------------------", drawLine.getCanvas().render());
    }
	
	@Test
    public void drawLineCommand_diagonalAcrossCanvas() throws DrawCanvasException {
        DrawLineCommand drawLine = new DrawLineCommand();
        drawLine.setCanvas(create.getCanvas());
        drawLine.execute(new String[]{"1", "1", "20", "4"});
        
        assertEquals("----------------------\n" + 
        			"|xxxx                |\n" + 
        			"|    xxxxxx          |\n" + 
        			"|          xxxxxx    |\n" + 
        			"|                xxxx|\n" + 
        			"----------------------", drawLine.getCanvas().render());
    }
	
    @Test
    public void drawLineCommand_withoutCanvas() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please create a new canvas.");
        
        DrawLineCommand drawLine = new DrawLineCommand();
        drawLine.execute(new String[]{"1", "2", "6", "2", "10", "20"});
    }

    @Test
    public void drawLineCommand_executeOutOfBoundary() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please specify correct x1 y1 x2 y2 that is within canvas boundary.");
        
        CreateCanvasCommand create = new CreateCanvasCommand();
        create.execute(new String[]{"2","2"});
        
        DrawLineCommand drawLine = new DrawLineCommand();
        drawLine.setCanvas(create.getCanvas());
        drawLine.execute(new String[]{"30", "2", "1", "2"});
    }

    @Test
    public void drawLineCommand_invalidNegativeParams() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input (x1,y1,x2,y2) is only positive numbers.");
        
        DrawLineCommand drawLine = new DrawLineCommand();
        drawLine.setCanvas(create.getCanvas());
        drawLine.execute(new String[]{"6", "-2", "1", "2"});
    }

    @Test
    public void drawLineCommand_invalidAlphabetParams() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input (x1,y1,x2,y2) is only positive numbers.");
        
        DrawLineCommand drawLine = new DrawLineCommand();
        drawLine.setCanvas(create.getCanvas());
        drawLine.execute(new String[]{"a", "b", "1", "2"});
    }

    @Test
    public void drawLineCommand_invalidEmptyParams() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input (x1,y1,x2,y2) is only positive numbers.");

        DrawLineCommand drawLine = new DrawLineCommand();
        drawLine.setCanvas(create.getCanvas());
        drawLine.execute(new String[]{" ", " ", " ", " "});
    }

    @Test
    public void drawLineCommand_invalidParamsLength() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please enter 4 arguments to draw a line, in the following format 'L x1 y1 x2 y2'.");
        
        DrawLineCommand drawLine = new DrawLineCommand();
        drawLine.setCanvas(create.getCanvas());
        drawLine.execute(new String[]{"4", "2"});
    }


}