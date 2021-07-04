package com.drawcanvas;


import com.drawcanvas.command.AbstractCommand;
import com.drawcanvas.command.CommandType;
import com.drawcanvas.exception.DrawCanvasErrorCodes;
import com.drawcanvas.exception.DrawCanvasException;
import com.drawcanvas.factory.CommandFactory;
import com.drawcanvas.graphics.Canvas;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

/**
* A draw canvas console application which takes in user input and draw shapes on the canvas by issuing different commands.
*
* @author  Edwin Goh
* @version 1.0
* @since   2020-01-22
*/
public class App 
{
	private CommandFactory commandFactory = new CommandFactory();
	private Canvas canvas = null;
    private AbstractCommand command;
	
    public static void main( String[] args ) 
    {
		App app = new App();
		try {
			app.printHelpMenu();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			while (true) {
				try {
					System.out.print("Enter command: ");
					app.executeCommand(scanner.nextLine().trim());
				} catch (DrawCanvasException de) {
		            System.err.println(de.getErrorCodes().getTitle() + ": " + de.getErrorCodes().getDescription());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void executeCommand(String input) throws DrawCanvasException{
        String[] commandArray = input.split(" ");
        String commandString = commandArray[0].toUpperCase();
        String[] parameters = Arrays.copyOfRange(commandArray, 1, commandArray.length);
        CommandType selectedCommand = CommandType.get(commandString);
        this.validateCommand(selectedCommand);
    	switch (selectedCommand){
            case CREATE_CANVAS:
                command = commandFactory.getCommand(selectedCommand);
                command.execute(parameters);
                canvas = command.getCanvas();
                break;
            case DRAW_LINE:
            case DRAW_RECT:
            case FILL_AREA:
            case UNDO:
            case REDO:
                command = commandFactory.getCommand(selectedCommand);
                command.setCanvas(canvas);
                command.execute(parameters);
                break;
            case QUIT:
                AbstractCommand quit = commandFactory.getCommand(selectedCommand);
            	quit.execute(parameters);
                break;
            /* Additional Commands (clear canvas,undo and help) */
            case CLEAR_CANVAS:
                command = commandFactory.getCommand(selectedCommand);
                command.setCanvas(canvas);
            	command.execute(parameters);
            	canvas = command.getCanvas();
                break;
            case HELP:
            	command = commandFactory.getCommand(selectedCommand);
            	command.execute(parameters);
                break;       
            default:
            	throw new DrawCanvasException(DrawCanvasErrorCodes.INVALID_COMMAND_ERROR, DrawCanvasErrorCodes.INVALID_COMMAND_ERROR.getDescription());
        }
    }
    
    /* Check if the command is valid */
    private void validateCommand(CommandType command) throws DrawCanvasException{
    	if(!Optional.ofNullable(command).isPresent()) {
    		throw new DrawCanvasException(DrawCanvasErrorCodes.INVALID_COMMAND_ERROR, DrawCanvasErrorCodes.INVALID_COMMAND_ERROR.getDescription());
    	}
    }
    
    private void printHelpMenu() throws DrawCanvasException  {
    	AbstractCommand command = commandFactory.getCommand(CommandType.HELP);
		command.execute(null);
    }
}
