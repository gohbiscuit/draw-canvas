package com.drawcanvas.command;

import lombok.Getter;

public class HelpCommand extends AbstractCommand {

	@Getter
    private StringBuilder builder;
    private String paddedSpace;

    public HelpCommand() {
        builder = new StringBuilder();
        
        paddedSpace = new String(new char[19]).replace("\0", " ");   	// pad string for 19 
        builder.append("\nWelcome to the DrawCanvas help menu.\n\n");

        builder.append(String.format("%1$-20s", "\n1. C w h: "));       // pad with space
        builder.append("Should create a new canvas of width w and height h.");

        builder.append(String.format("%1$-20s", "\n2. L x1 y1 x2 y2: "));
        builder.append("Should create a new line from (x1,y1) to (x2,y2). Currently only");
        builder.append("\n");
        builder.append(paddedSpace);
        builder.append("horizontal or vertical lines are supported. Horizontal and vertical lines\n");
        builder.append(paddedSpace);
        builder.append("will be drawn using the 'x' character.");

        builder.append(String.format("%1$-20s", "\n3. R x1 y1 x2 y2: "));
        builder.append("Should create a new rectangle, whose upper left corner is (x1,y1) and\n");
        builder.append(paddedSpace);
        builder.append("lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n");
        builder.append(paddedSpace);
        builder.append("using the 'x' character.");

        builder.append(String.format("%1$-20s", "\n4. B x y c: "));
        builder.append("Should fill the entire area connected to (x,y) with \"colour\" c. The\n");
        builder.append(paddedSpace);
        builder.append("behaviour of this is the same as that of the \"bucket fill\" tool in paint\n");
        builder.append(paddedSpace);
        builder.append("programs.");

        builder.append(String.format("%1$-20s", "\n5. O: "));
        builder.append("Clear the canvas.");
        
        builder.append(String.format("%1$-20s", "\n6. U: "));
        builder.append("Undo the canvas.");

        builder.append(String.format("%1$-20s", "\n7. H: "));
        builder.append("Show the help menu.");

        builder.append(String.format("%1$-20s", "\n8. Q "));
        builder.append("Should quit the program.\n");
    }

    @Override
    public void execute(String[] params)  {
        System.out.println(builder.toString());
    }
}
