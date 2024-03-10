package com.drawcanvas.command;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HelpCommandTest {

    @Test
    public void helpCommand_execute() {
        HelpCommand h = new HelpCommand();
        Assert.assertEquals("\nWelcome to the DrawCanvas help menu.\n" +
                "\n" +
                "\n" +
                "1. C w h:          Should create a new canvas of width w and height h.\n" +
                "2. L x1 y1 x2 y2:  Should create a new line from (x1,y1) to (x2,y2). Currently only\n" +
                "                   horizontal or vertical lines are supported. Horizontal and vertical lines\n" +
                "                   will be drawn using the 'x' character.\n" +
                "3. R x1 y1 x2 y2:  Should create a new rectangle, whose upper left corner is (x1,y1) and\n" +
                "                   lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n" +
                "                   using the 'x' character.\n" +
                "4. B x y c:        Should fill the entire area connected to (x,y) with \"colour\" c. The\n" +
                "                   behaviour of this is the same as that of the \"bucket fill\" tool in paint\n" +
                "                   programs.\n" +
                "5. O:              Clear the canvas.\n" +
                "6. H:              Show the help menu.\n" +
                "7. Q               Should quit the program.\n", h.getBuilder().toString());
    }
}