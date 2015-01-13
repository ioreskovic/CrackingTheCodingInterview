package com.lopina.exercises.chapter7;

public class Point implements Comparable<Point> {
	private final double x;
	private final double y;
	
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	@Override
	public int compareTo(Point other) {
		if (other == null) {
			throw new IllegalArgumentException("Cannot compare to null");
		}
		if (other == this) {
			return 0;
		}
		
		int compareResult = 0;
		
		if (this.x < other.x) {
			compareResult = -1;
		} else if (this.x > other.x) {
			compareResult = 1;
		}
		
		if (compareResult == 0) {
			if (this.y < other.y) {
				compareResult = -1;
			} else if (this.y > other.y) {
				compareResult = 1;
			}
		}
		
		return compareResult;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}
