package com.drawcanvas.command;

import com.drawcanvas.exception.DrawCanvasException;
import com.drawcanvas.graphics.Canvas;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class CreateCanvasCommandTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void createCanvasCommand() throws Exception {
        CreateCanvasCommand create = new CreateCanvasCommand();
        create.execute(new String[]{"5","5"});

        assertEquals("-------\n" + 
        			"|     |\n" + 
        			"|     |\n" + 
        			"|     |\n" + 
        			"|     |\n" + 
        			"|     |\n" + 
        			"-------", create.getCanvas().render());
    }
    
    @Test
    public void createCanvasCommand_ExceedLimit() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Canvas width/height cannot be more than 80 units");
        
    	CreateCanvasCommand create = new CreateCanvasCommand();
        create.execute(new String[]{"200","200"});
    }	
    
    @Test
    public void createCanvasCommand_InvalidCommand() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please enter 2 arguments to create a canvas, in the following format 'C w h'.");
        
    	CreateCanvasCommand create = new CreateCanvasCommand();
        create.execute(new String[]{"5","5","10"});
    }	

    @Test
    public void createCanvasCommand_tooManyParameters() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please enter 2 arguments to create a canvas, in the following format 'C w h'.");
        
    	CreateCanvasCommand create = new CreateCanvasCommand();
        create.execute(new String[]{"5","5","10"});
    }	

    @Test
    public void createCanvasCommand_noParameters() throws DrawCanvasException{
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please enter 2 arguments to create a canvas, in the following format 'C w h'.");
    	CreateCanvasCommand create = new CreateCanvasCommand();
        create.execute(new String[]{});
    }

    @Test
    public void createCanvasCommand_invalidParametersLength() throws DrawCanvasException{
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please enter 2 arguments to create a canvas, in the following format 'C w h'.");
      	CreateCanvasCommand create = new CreateCanvasCommand();
        create.execute(new String[]{"10"});
    }


    @Test
    public void createCanvasCommand_negativeParameters() throws DrawCanvasException{
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input is only positive numbers.");
      	CreateCanvasCommand create = new CreateCanvasCommand();
        create.execute(new String[]{"-1","5"});
    }

    @Test
    public void createCanvasCommand_invalidParameters() throws DrawCanvasException{
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input is only positive numbers.");
      	CreateCanvasCommand create = new CreateCanvasCommand();
        create.execute(new String[]{"","1"});
    }

    @Test
    public void createCanvasCommand_alphabetParameters() throws DrawCanvasException{
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please ensure your input is only positive numbers.");
      	CreateCanvasCommand create = new CreateCanvasCommand();
        create.execute(new String[]{"a","b"});
    }
}