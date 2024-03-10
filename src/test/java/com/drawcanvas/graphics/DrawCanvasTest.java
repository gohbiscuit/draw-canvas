package com.drawcanvas.graphics;

import org.junit.Assert;
import org.junit.Test;

public class DrawCanvasTest {

    @Test
    public void createCanvas() {
    	Canvas canvas = new Canvas(5,5);
        Assert.assertEquals("-------\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "-------", canvas.render());
    }

    @Test
    public void addLine() {
    	Canvas canvas = new Canvas(5,5);
    	IShape line = new Line(new Point(1,3), new Point(5,3));
    	IShape line2 = new Line(new Point(3,1), new Point(3,5));
    	canvas.addShape(line);
    	canvas.addShape(line2);
    	
        Assert.assertEquals("-------\n" +
                "|  x  |\n" +
                "|  x  |\n" +
                "|xxxxx|\n" +
                "|  x  |\n" +
                "|  x  |\n" +
                "-------", canvas.render());
    }

    @Test
    public void addLineExample() {
    	Canvas canvas = new Canvas(20,4);
    	IShape line = new Line(new Point(1,2), new Point(6,2));
    	IShape line2 = new Line(new Point(6,3), new Point(6,4));
    	canvas.addShape(line);
    	canvas.addShape(line2);

        Assert.assertEquals("----------------------\n" +
                "|                    |\n" +
                "|xxxxxx              |\n" +
                "|     x              |\n" +
                "|     x              |\n" +
                "----------------------", canvas.render());
    }
    
    @Test
    public void addLineFullWidth() {
    	Canvas canvas = new Canvas(20,4);
    	IShape line = new Line(new Point(1,2), new Point(20,2));
    	canvas.addShape(line);

        Assert.assertEquals("----------------------\n" + 
        					"|                    |\n" + 
							"|xxxxxxxxxxxxxxxxxxxx|\n" + 
							"|                    |\n" + 
							"|                    |\n" + 
							"----------------------", canvas.render());
    }

    @Test
    public void addDiagonalLine() {
    	Canvas canvas = new Canvas(5,5);
    	IShape line = new Line(new Point(1,1), new Point(5,5));
    	canvas.addShape(line);

        Assert.assertEquals("-------\n" + 
        					"|x    |\n" + 
							"| x   |\n" + 
							"|  x  |\n" + 
							"|   x |\n" + 
							"|    x|\n" + 
							"-------", canvas.render());
    }

    @Test
    public void addRectangle() {
    	Canvas canvas = new Canvas(20,4);
    	IShape rect = new Rectangle(new Point(14,1), new Point(18,3));
    	canvas.addShape(rect);

        Assert.assertEquals("----------------------\n" +
                "|             xxxxx  |\n" +
                "|             x   x  |\n" +
                "|             xxxxx  |\n" +
                "|                    |\n" +
                "----------------------", canvas.render());
    }

    @Test
    public void addTwoRectangle() {
    	Canvas canvas = new Canvas(20,4);
    	IShape rect = new Rectangle(new Point(14,1), new Point(18,3));
    	IShape rect2 = new Rectangle(new Point(16,3), new Point(10,1));
    	canvas.addShape(rect);
    	canvas.addShape(rect2);
    	
        Assert.assertEquals("----------------------\n" +
                "|         xxxxxxxxx  |\n" +
                "|         x   x x x  |\n" +
                "|         xxxxxxxxx  |\n" +
                "|                    |\n" +
                "----------------------", canvas.render());
    }

    
    @Test
    public void fillArea() {
    	Canvas canvas = new Canvas(20,4);
    	
		IShape fill = new Fill(new Point(14,1), 'c', canvas.getDrawableWidth(), canvas.getDrawableHeight());
		canvas.addShape(fill);

        Assert.assertEquals("----------------------\n" +
                "|cccccccccccccccccccc|\n" +
                "|cccccccccccccccccccc|\n" +
                "|cccccccccccccccccccc|\n" +
                "|cccccccccccccccccccc|\n" +
                "----------------------", canvas.render());
    }

    @Test
    public void fillAreaInEnclosedArea() {
    	Canvas canvas = new Canvas(20,4);
    	
    	IShape rect = new Rectangle(new Point(14,1), new Point(18,3));
		IShape fill = new Fill(new Point(15,2), 'o', canvas.getDrawableWidth(), canvas.getDrawableHeight());
		canvas.addShape(rect);
		canvas.addShape(fill);

        Assert.assertEquals("----------------------\n" +
                "|             xxxxx  |\n" +
                "|             xooox  |\n" +
                "|             xxxxx  |\n" +
                "|                    |\n" +
                "----------------------", canvas.render());
    }

    @Test
    public void fillAreaInEdge() {
    	Canvas canvas = new Canvas(20,4);
    	IShape line = new Line(new Point(1,4), new Point(5,4));
		IShape fill = new Fill(new Point(2,4), 'o', canvas.getDrawableWidth(), canvas.getDrawableHeight());
		canvas.addShape(line);
		canvas.addShape(fill);
		
        Assert.assertEquals("----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|ooooo               |\n" +
                "----------------------", canvas.render());
    }

    @Test
    public void drawCanvasTest() {
    	Canvas canvas = new Canvas(20,4);
     	IShape line = new Line(new Point(1,2), new Point(6,2));
    	canvas.addShape(line);
        Assert.assertEquals("----------------------\n" + 
				"|                    |\n" + 
				"|xxxxxx              |\n" + 
				"|                    |\n" + 
				"|                    |\n" + 
				"----------------------", canvas.render());
    	
    	
    	IShape line2 = new Line(new Point(6,3), new Point(6,4));
    	canvas.addShape(line2);
        Assert.assertEquals("----------------------\n" + 
				"|                    |\n" + 
				"|xxxxxx              |\n" + 
				"|     x              |\n" + 
				"|     x              |\n" + 
				"----------------------", canvas.render());
    	

    	IShape rect = new Rectangle(new Point(14,1), new Point(18,3));
    	canvas.addShape(rect);
        Assert.assertEquals("----------------------\n" +
                "|             xxxxx  |\n" +
                "|xxxxxx       x   x  |\n" +
                "|     x       xxxxx  |\n" +
                "|     x              |\n" +
                "----------------------", canvas.render());
        
        IShape fill = new Fill(new Point(20,4), 'o', canvas.getDrawableWidth(), canvas.getDrawableHeight());
        canvas.addShape(fill);
        Assert.assertEquals("----------------------\n" + 
        		"|oooooooooooooxxxxxoo|\n" + 
        		"|xxxxxxooooooox   xoo|\n" + 
        		"|     xoooooooxxxxxoo|\n" + 
        		"|     xoooooooooooooo|\n" + 
        		"----------------------", canvas.render());
    }

}