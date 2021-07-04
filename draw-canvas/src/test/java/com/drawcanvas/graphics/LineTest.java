package com.drawcanvas.graphics;

import org.junit.Assert;
import org.junit.Test;

public class LineTest {

    @Test
    public void create() {
        new Line(new Point(1, 4), new Point(4, 4));
    }

    @Test
    public void checkSameLine() {
        Line lineOne = new Line(new Point(1, 4), new Point(4, 4));
        Line lineTwo = new Line(new Point(1, 4), new Point(4, 4));

        Assert.assertEquals(lineOne,lineTwo);
    }

    @Test
    public void checkDistinctLines() {
        Line lineOne = new Line(new Point(1, 4), new Point(4, 4));
        Line lineTwo = new Line(new Point(1, 1), new Point(2, 1));

        Assert.assertNotEquals(lineOne,lineTwo);
    }
}