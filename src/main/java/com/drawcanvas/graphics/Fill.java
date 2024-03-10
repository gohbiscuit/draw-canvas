package com.drawcanvas.graphics;

public class Fill implements IShape {
	private Point p;
	private char color;
	private int width;
	private int height;

	public Fill(Point p, char color, int width, int height) {
		this.p = p;
		this.color = color;
		this.width = width;
		this.height = height;
	}

	public char[][] draw(char[][] canvas) {
		floodFill(canvas, this.p.getX(), this.p.getY(), this.color);
		return canvas;
	}
	/**
	 * FloodFill Method, Fill empty spaces to the edge of other shapes Recursive
	 * Function
	 * 
	 * @param canvas char[][]
	 * @param x int
	 * @param y int
	 * @param colorToPaint char
	 */
	private void floodFill(char[][] canvas, int x, int y,char colorToPaint) {
		char previousColor = canvas[y][x]; 
		if(previousColor == colorToPaint)
			return;
		
        floodFillUtil(canvas, x, y, previousColor, colorToPaint); 
	}

	/**
	 * FloodFillUtil. A recursive function to replace previous color 'previousColor' at '(x, y)' 
	 * and all surrounding pixels of (x, y) with new color 'colorToPaint' 
	 * @param canvas char[][]
	 * @param x int
	 * @param y int
	 * @param previousColor char
	 * @param colorToPaint char
	 */
	private void floodFillUtil(char[][] canvas, int x, int y, char previousColor, char colorToPaint) {
		if(x < 0 || x > this.width || y < 0 || y  > this.height) 
			return;
		if(canvas[y][x] != previousColor)
			return;

		canvas[y][x] = colorToPaint;
		floodFillUtil(canvas, x+1, y, previousColor, colorToPaint);
		floodFillUtil(canvas, x-1, y, previousColor, colorToPaint);
		floodFillUtil(canvas, x, y+1, previousColor, colorToPaint);
		floodFillUtil(canvas, x, y-1, previousColor, colorToPaint);
	}
}
