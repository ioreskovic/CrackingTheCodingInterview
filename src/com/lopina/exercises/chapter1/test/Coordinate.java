package com.lopina.exercises.chapter1.test;

public class Coordinate {
	public int x;
	public int y;
	
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Coordinate(Coordinate other) {
		this(other.x, other.y);
	}

	public boolean inBounds(Object[][] matrix) {
		if (x < 0) {
			return false;
		}
		
		if (x >= matrix.length) {
			return false;
		}
		
		if (y < 0) {
			return false;
		}
		
		if (y >= matrix[0].length) {
			return false;
		}
		
		return true;
	}
	
	public boolean isBefore(Coordinate other) {
		return this.x <= other.x && this.y <= other.y;
	}
	
	public static Coordinate average(Coordinate a, Coordinate b) {
		return new Coordinate((a.x + b.x) / 2, (a.y + b.y) / 2);
	}
	
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}
