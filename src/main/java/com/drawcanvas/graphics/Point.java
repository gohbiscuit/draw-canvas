package com.drawcanvas.graphics;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Point {
    private int x;
	private int y;
	
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(x,y) : (" + x + ", " + y + ")";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
    
    
}
