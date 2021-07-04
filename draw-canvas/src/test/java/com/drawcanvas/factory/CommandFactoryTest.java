package com.drawcanvas.factory;

import static org.junit.Assert.*;


import org.junit.Test;

import com.drawcanvas.command.AbstractCommand;
import com.drawcanvas.command.ClearCanvasCommand;
import com.drawcanvas.command.CommandType;
import com.drawcanvas.command.CreateCanvasCommand;
import com.drawcanvas.command.DrawLineCommand;
import com.drawcanvas.command.DrawRectangleCommand;
import com.drawcanvas.command.FillAreaCommand;
import com.drawcanvas.command.HelpCommand;
import com.drawcanvas.command.QuitCommand;


public class CommandFactoryTest {


	@Test
    public void createCommand() {
		CommandFactory commandFactory = new CommandFactory();
        AbstractCommand command = commandFactory.getCommand(CommandType.CREATE_CANVAS);
        
        assertTrue(command instanceof CreateCanvasCommand);
    }
	
	@Test
    public void drawLineCommand() {
		CommandFactory commandFactory = new CommandFactory();
        AbstractCommand command = commandFactory.getCommand(CommandType.DRAW_LINE);
        
        assertTrue(command instanceof DrawLineCommand);
    }
	
	@Test
    public void drawRectCommand() {
		CommandFactory commandFactory = new CommandFactory();
        AbstractCommand command = commandFactory.getCommand(CommandType.DRAW_RECT);
        
        assertTrue(command instanceof DrawRectangleCommand);
    }
	
	@Test
    public void fillAreaCommand() {
		CommandFactory commandFactory = new CommandFactory();
        AbstractCommand command = commandFactory.getCommand(CommandType.FILL_AREA);
        
        assertTrue(command instanceof FillAreaCommand);
    }
	
	@Test
    public void helpCommand() {
		CommandFactory commandFactory = new CommandFactory();
        AbstractCommand command = commandFactory.getCommand(CommandType.HELP);
        
        assertTrue(command instanceof HelpCommand);
    }
	
	@Test
    public void clearCanvasCommand() {
		CommandFactory commandFactory = new CommandFactory();
        AbstractCommand command = commandFactory.getCommand(CommandType.CLEAR_CANVAS);
        
        assertTrue(command instanceof ClearCanvasCommand);
    }
	
	@Test
    public void quitCommand() {
		CommandFactory commandFactory = new CommandFactory();
        AbstractCommand command = commandFactory.getCommand(CommandType.QUIT);
        
        assertTrue(command instanceof QuitCommand);
    }

}
