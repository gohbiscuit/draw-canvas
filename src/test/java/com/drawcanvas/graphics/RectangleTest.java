package com.drawcanvas.graphics;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RectangleTest {

    @Test
    public void create() {
        Point topLeft = new Point(1, 1);
        Point bottomRight = new Point(4, 4);

        new Rectangle(topLeft, bottomRight);
    }

    @Test
    public void checkSameRectangle() {
        Point topLeft = new Point(1, 1);
        Point bottomRight = new Point(4, 4);

        Rectangle rect1 = new Rectangle(topLeft, bottomRight);
        Rectangle rect2 = new Rectangle(topLeft, bottomRight);

        Assert.assertEquals(rect1, rect2);
    }

    @Test
    public void checkDistinctRectangle() {
        Point topLeft = new Point(1, 1);
        Point bottomRight = new Point(4, 4);

        Rectangle rect1 = new Rectangle(topLeft, bottomRight);
        Rectangle rect2 = new Rectangle(bottomRight, topLeft);

        Assert.assertNotEquals(rect1, rect2);
    }


}