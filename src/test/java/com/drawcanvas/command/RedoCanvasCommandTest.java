package com.drawcanvas.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.drawcanvas.exception.DrawCanvasException;

public class RedoCanvasCommandTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    private CreateCanvasCommand create;

    
//    @Test
    public void redoCommandTest() throws DrawCanvasException {
        create = new CreateCanvasCommand();
        create.execute(new String[]{"20","4"});
        
    	FillAreaCommand fillArea = new FillAreaCommand();
        fillArea.setCanvas(create.getCanvas());
        fillArea.execute(new String[]{"10", "3", "o"});
        
        assertEquals("----------------------\n" + 
        			"|oooooooooooooooooooo|\n" + 
        			"|oooooooooooooooooooo|\n" + 
        			"|oooooooooooooooooooo|\n" + 
        			"|oooooooooooooooooooo|\n" + 
        			"----------------------", fillArea.getCanvas().render());
    	
    	UndoCommand undoCommand = new UndoCommand();
        
    	undoCommand.setCanvas(create.getCanvas());
    	undoCommand.execute(new String[]{});
         
         assertEquals("----------------------\n" + 
         		"|                    |\n" + 
         		"|                    |\n" + 
         		"|                    |\n" + 
         		"|                    |\n" + 
         		"----------------------", undoCommand.getCanvas().render());
         
         RedoCommand redoCommand = new RedoCommand();
         
         redoCommand.setCanvas(undoCommand.getCanvas());
         redoCommand.execute(new String[]{});
          
         assertEquals("----------------------\n" + 
     			"|oooooooooooooooooooo|\n" + 
     			"|oooooooooooooooooooo|\n" + 
     			"|oooooooooooooooooooo|\n" + 
     			"|oooooooooooooooooooo|\n" + 
     			"----------------------", redoCommand.getCanvas().render());
    }
    
    // Test Cases
    // Assumptions - Redo will only redo the shapes in the current canvas
    // 1 - Redo with No Canvas
    // 2 - Redo with No Shapes
    // 3 - Redo with No Undo being executed -> Redo should throw and error 

    @Test
    public void redoCommandTest_WithNoCanvas() throws DrawCanvasException {
    	exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please create a new canvas.");
     	
     	RedoCommand redoCommand = new RedoCommand();
     	redoCommand.setCanvas(redoCommand.getCanvas());
     	redoCommand.execute(new String[]{});
    }
    
    @Test
    public void redoCommandTest_ForDrawLine() throws DrawCanvasException {
        create = new CreateCanvasCommand();
        create.execute(new String[]{"20","4"});
        
        DrawLineCommand drawLine = new DrawLineCommand();
        drawLine.setCanvas(create.getCanvas());
        drawLine.execute(new String[]{"6", "2", "1", "2"});
        
        assertEquals("----------------------\n" + 
        			 "|                    |\n" + 
        			 "|xxxxxx              |\n" + 
        			 "|                    |\n" + 
        			 "|                    |\n" + 
        			 "----------------------", drawLine.getCanvas().render());
    	
    	UndoCommand undoCommand = new UndoCommand();
        
    	undoCommand.setCanvas(drawLine.getCanvas());
    	undoCommand.execute(new String[]{});
         
        assertEquals("----------------------\n" + 
         		"|                    |\n" + 
         		"|                    |\n" + 
         		"|                    |\n" + 
         		"|                    |\n" + 
         		"----------------------", undoCommand.getCanvas().render());
         
         DrawLineCommand verticalLine = new DrawLineCommand();
         verticalLine.setCanvas(undoCommand.getCanvas());
         verticalLine.execute(new String[]{"2", "1", "2", "4"});
         
         assertEquals("----------------------\n" + 
         			"| x                  |\n" + 
         			"| x                  |\n" + 
         			"| x                  |\n" + 
         			"| x                  |\n" + 
         			"----------------------", verticalLine.getCanvas().render());
         
         RedoCommand redoCommand = new RedoCommand();
         
         redoCommand.setCanvas(verticalLine.getCanvas());
         redoCommand.execute(new String[]{});
          
         assertEquals("----------------------\n" + 
      			"| x                  |\n" + 
      			"| x                  |\n" + 
      			"| x                  |\n" + 
      			"| x                  |\n" + 
      			"----------------------", redoCommand.getCanvas().render());
    }
}
