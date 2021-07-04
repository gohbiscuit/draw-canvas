package com.drawcanvas.graphics;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PointTest {

    @Test
    public void create() {
        new Point(1, 4);
    }
    
    @Test
    public void checkSamePoint() {
    	Point p1 = new Point(1, 4);
    	Point p2 = new Point(1,4);

        Assert.assertEquals(p1,p2);
    }
    
    @Test
    public void checkDistinctPoint() {
    	Point p1 = new Point(1,4);
    	Point p2 = new Point(4,1);

        Assert.assertNotEquals(p1,p2);
    }
}