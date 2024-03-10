package com.drawcanvas.graphics;

import java.util.Arrays;

public class Line implements IShape {
	private Point p1;
	private Point p2;

	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public char[][] draw(char[][] canvas) {
		drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY(), canvas, 'x');
		return canvas;
	}

	private void drawLine(int x1, int y1, int x2, int y2, char[][] canvas, char lineChar) {
		if (x1 == x2) {
			int startY = Math.min(y1, y2);
			int endY = Math.max(y1, y2);
			
			// vertical line
			for (int i = startY; i <= endY; i++) {
				canvas[i][x1] = lineChar;
			}

		} else if (y1 == y2) {
			int startX = Math.min(x1, x2);
			int endX = Math.max(x1, x2);
			
			// horizontal line
			Arrays.fill(canvas[y1], startX, endX + 1, lineChar);
		} else {
			// diagonal line using Bresenhams Line Algorithm
			int dx = Math.abs(x2 - x1);
			int dy = Math.abs(y2 - y1);

			int sx = x1 < x2 ? 1 : -1;
			int sy = y1 < y2 ? 1 : -1;

			int err = dx - dy;
			int e2;

			while(true) {
				canvas[y1][x1] = lineChar;
				if (x1 == x2 && y1 == y2)
					break;
				e2 = 2 * err;
				if (e2 > -dy) {
					err = err - dy;
					x1 = x1 + sx;
				}

				if (e2 < dx) {
					err = err + dx;
					y1 = y1 + sy;
				}
			}
		}
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
		Line other = (Line) obj;
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
