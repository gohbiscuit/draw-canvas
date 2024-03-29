package com.drawcanvas.command;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.drawcanvas.exception.DrawCanvasException;

public class UndoCanvasCommandTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    private CreateCanvasCommand create;
    
    @Before
    public void init() throws Exception {
    }
    
    @Test
    public void undoCommandTest() throws DrawCanvasException {
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
    }
    
    @Test
    public void undoCommandTest_MultipleShapes() throws DrawCanvasException {
        create = new CreateCanvasCommand();
        create.execute(new String[]{"20","4"});
        
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
        
         DrawLineCommand drawLine2 = new DrawLineCommand();
         drawLine2.setCanvas(fillArea.getCanvas());
         drawLine2.execute(new String[]{"1", "1", "20", "4"});
         
         assertEquals("----------------------\n" + 
         		"|xxxx                |\n" + 
         		"|ax  xxxxxx          |\n" + 
         		"|aax       xxxxxx    |\n" + 
         		"|aaax            xxxx|\n" + 
         		"----------------------", drawLine2.getCanvas().render());
    	
    	UndoCommand undoCommand = new UndoCommand();
        
    	undoCommand.setCanvas(drawLine2.getCanvas());
    	undoCommand.execute(new String[]{});
         
        assertEquals("----------------------\n" + 
    			"|x                   |\n" + 
    			"|ax                  |\n" + 
    			"|aax                 |\n" + 
    			"|aaax                |\n" + 
    			"----------------------", undoCommand.getCanvas().render());
    }
    
    @Test
    public void undoCommandTest_NoCanvasCreated() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please create a new canvas.");
    	
    	UndoCommand undoCommand = new UndoCommand();
    	undoCommand.setCanvas(undoCommand.getCanvas());
    	undoCommand.execute(new String[]{});
    }
    
    @Test
    public void undoCommandTest_NoShapesDrawn() throws DrawCanvasException {
    	exception.expect(DrawCanvasException.class);
    	exception.expectMessage("Nothing to undo.");
    	
    	create = new CreateCanvasCommand();
        create.execute(new String[]{"20","4"});
    	        
        UndoCommand undoCommand = new UndoCommand();
    	undoCommand.setCanvas(create.getCanvas());
    	undoCommand.execute(new String[]{});
    }
    
    @Test
    public void undoCommandTest_MultipleTimes() throws DrawCanvasException {
        create = new CreateCanvasCommand();
        create.execute(new String[]{"20","4"});
        
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
        
         DrawLineCommand drawLine2 = new DrawLineCommand();
         drawLine2.setCanvas(fillArea.getCanvas());
         drawLine2.execute(new String[]{"1", "1", "20", "4"});
         
         assertEquals("----------------------\n" + 
         		"|xxxx                |\n" + 
         		"|ax  xxxxxx          |\n" + 
         		"|aax       xxxxxx    |\n" + 
         		"|aaax            xxxx|\n" + 
         		"----------------------", drawLine2.getCanvas().render());
    	
    	UndoCommand undoCommand = new UndoCommand();
        
    	undoCommand.setCanvas(drawLine2.getCanvas());
    	undoCommand.execute(new String[]{});
         
        assertEquals("----------------------\n" + 
    			"|x                   |\n" + 
    			"|ax                  |\n" + 
    			"|aax                 |\n" + 
    			"|aaax                |\n" + 
    			"----------------------", undoCommand.getCanvas().render());
        
    	UndoCommand undoCommand2 = new UndoCommand();
        
    	undoCommand2.setCanvas(undoCommand.getCanvas());
    	undoCommand2.execute(new String[]{});
         
        assertEquals("----------------------\n" + 
    			"|x                   |\n" + 
    			"| x                  |\n" + 
    			"|  x                 |\n" + 
    			"|   x                |\n" + 
    			"----------------------", undoCommand.getCanvas().render());
    }
}
