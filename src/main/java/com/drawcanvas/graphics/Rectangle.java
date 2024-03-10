package com.drawcanvas.graphics;

public class Rectangle implements IShape {
	private Point p1;
	private Point p2;

	public Rectangle(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public char[][] draw(char[][] shape) {
		int startY = Math.min(p1.getY(), p2.getY());
		int endY = Math.max(p1.getY(), p2.getY());
		int startX = Math.min(p1.getX(), p2.getX());
		int endX = Math.max(p1.getX(), p2.getX());

		for (int row = startY; row <= endY; row++) {
			for (int col = startX; col <= endX; col++) {
				if ((row == p1.getY() || row == p2.getY()) || (col == p1.getX() || col == p2.getX())) {
					shape[row][col] = 'x';
				}
			}
		}
		return shape;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
		result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		return true;
	}
	
	
}
