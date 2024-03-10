package com.drawcanvas.command;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.drawcanvas.exception.DrawCanvasException;


public class ClearCanvasCommandTest {
	
    @Rule
    public ExpectedException exception = ExpectedException.none();
	
    @Test
    public void clearCanvas() {
        new ClearCanvasCommand();
    }

    @Test
    public void clearCanvas_executeWithCanvas() throws DrawCanvasException {
    	CreateCanvasCommand create = new CreateCanvasCommand();
        create.execute(new String[]{"5","5"});
         
        ClearCanvasCommand clear = new ClearCanvasCommand();
        clear.setCanvas(create.getCanvas());
        clear.execute(null);
    }

    @Test
    public void clearCanvas_executeWithNoCanvas() throws DrawCanvasException {
        exception.expect(DrawCanvasException.class);
        exception.expectMessage("Please create a new canvas.");
        ClearCanvasCommand clear = new ClearCanvasCommand();			
        clear.execute(null);   
    }
}