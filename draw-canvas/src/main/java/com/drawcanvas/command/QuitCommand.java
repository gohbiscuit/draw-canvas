package com.drawcanvas.command;

public class QuitCommand extends AbstractCommand {

    public QuitCommand() {}

    @Override
    public void execute(String[] params)  {
        System.out.println("Thanks for using DrawCanvas. Have a great day!");
        System.exit(0);
    }
}
