package com.drawcanvas.command;

import com.drawcanvas.exception.DrawCanvasException;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FillAreaCommandTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    private CreateCanvasCommand create;
    
    @Before
    public void init() throws Exception {
        create = new CreateCanvasCommand();
        create.execute(new String[]{"20","4"});
    }

    @Test
    public void fillAreaCommand_FullArea() throws DrawCanvasException {
        FillAreaCommand fillArea = new FillAreaCommand();
        fillArea.setCanvas(create.getCanvas());
        fillArea.execute(new String[]{"10", "3", "o"});
        
        assertEquals("----------------------\n" + 
        			"|oooooooooooooooooooo|\n" + 
        			"|oooooooooooooooooooo|\n" + 
        			"|oooooooooooooooooooo|\n" + 
        			"|oooooooooooooooooooo|\n" + 
        			"----------------------", fillArea.getCanvas().render());
    }
    
    @Test
    public void fillAreaCommand_EnclosedArea() throws DrawCanvasException {
        DrawLineCommand drawLine = new DrawLineCommand();
        drawLine.setCanvas(create.getCanvas());
        drawLine.execute(new String[]{"1", "1", "4", "4"});
    	
        FillAreaCommand fillArea = new FillAreaCommand();
        fillArea.setCanvas(create.getCanvas());
        fillArea.execute(new String[]{"1", "2", "a"});
        
        assertEquals("----------------------\n" + 
        			"|x                   |\n" + 
        			"|ax                  |\n" + 
        			"|aax                 |\n" + 
        			"|aaax                |\n" + 
        			"----------------------", fillArea.getCanvas().render());
    }

    @Test
    public void fillAreaCommand_OpenArea() throws DrawCanvasException {
    	DrawRectangleCommand drawRect = new DrawRectangleCommand();
        drawRect.setCanvas(create.getCanvas());
        drawRect.execute(new String[]{"4", "4", "2", "2"});
    	
        FillAreaCommand fillArea = new FillAreaCommand();
        fillArea.setCanvas(create.getCanvas());
        fillArea.execute(new String[]{"1", "2", "p"});
        
        assertEquals("----------------------\n" + 
        			"|pppppppppppppppppppp|\n" + 
        			"|pxxxpppppppppppppppp|\n" + 
        			"|px xpppppppppppppppp|\n" + 
        			"|pxxxpppppppppppppppp|\n" + 
        		"----------------------", fillArea.getCanvas().render());
    }
    
    @Test
    public void fillAreaCommand_OnEdge() throws DrawCanvasException {
    	DrawRectangleCommand drawRect = new DrawRectangleCommand();
        drawRect.setCanvas(create.getCanvas());
        drawRect.execute(new String[]{"14", "1", "18", "3"});
    	
        FillAreaCommand fillArea = new FillAreaCommand();
        fillArea.setCanvas(create.getCanvas());
        fillArea.execute(new String[]{"14", "1", "c"});
        
        assertEquals("----------------------\n" + 
        			"|             ccccc  |\n" + 
        			"|             c   c  |\n" + 
        			"|             ccccc  |\n" + 
        			"|                    |\n" + 
        			"----------------------", fillArea.getCanvas().render());
    }
    
    @Test
    public void fillAreaCommand_invalidColorType() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input (x1,y1) is only positive numbers, and color c is a single digit");

        FillAreaCommand fillArea = new FillAreaCommand();
        fillArea.setCanvas(create.getCanvas());
        fillArea.execute(new String[]{"10", "3", "@"});
    }

    @Test
    public void fillAreaCommand_executeOutOfCanvasBoundary() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please specify point (x1,y1) is within canvas boundary.");

        FillAreaCommand fillArea = new FillAreaCommand();
        fillArea.setCanvas(create.getCanvas());
        fillArea.execute(new String[]{"14", "20", "c"});
    }

    @Test
    public void fillAreaCommand_invalidParamsLength() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please enter 3 arguments to fill an area at a point (x,y) with color c, in the following format 'B x y c'.");
        
        FillAreaCommand fillArea = new FillAreaCommand();
        fillArea.setCanvas(create.getCanvas());
        fillArea.execute(new String[]{"14", "20"});
    }

    @Test
    public void fillAreaCommand_invalidNegativeParamsType() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input (x1,y1) is only positive numbers, and color c is a single digit");

        FillAreaCommand fillArea = new FillAreaCommand();
        fillArea.setCanvas(create.getCanvas());
        fillArea.execute(new String[]{"10", "-1", "o"});
    }

    @Test
    public void fillAreaCommand_invalidParamsType() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input (x1,y1) is only positive numbers, and color c is a single digit");

        FillAreaCommand fillArea = new FillAreaCommand();
        fillArea.setCanvas(create.getCanvas());
        fillArea.execute(new String[]{"a", "3", "o"});
    }

    @Test
    public void fillAreaCommand_emptyParamsType() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input (x1,y1) is only positive numbers, and color c is a single digit");
        FillAreaCommand fillArea = new FillAreaCommand();
        fillArea.setCanvas(create.getCanvas());
        fillArea.execute(new String[]{" ", " ", "o"});
    }
}