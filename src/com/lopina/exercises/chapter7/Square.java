package com.lopina.exercises.chapter7;

public class Square {
	private final Point topLeft;
	private final Point topRight;
	private final Point bottomRight;
	private final Point bottomLeft;
	
	private final double width;
	private final Point middle;
	
	public Square(double x, double y, double width) {
		this.width = width;
		this.topLeft = new Point(x, y);
		this.topRight = new Point(x + width, y);
		this.bottomRight = new Point(x + width, y + width);
		this.bottomLeft = new Point(x, y + width);
		this.middle = new Point(
				(this.topLeft.getX() + this.bottomRight.getX()) / 2.0, 
				(this.topLeft.getY() + this.bottomRight.getY()) / 2.0
		);
	}
	
	public Point getMiddle() {
		return this.middle;
	}
	
	public Point getTopLeft() {
		return topLeft;
	}
	
	public Point getTopRight() {
		return topRight;
	}
	
	public Point getBottomLeft() {
		return bottomLeft;
	}
	
	public Point getBottomRight() {
		return bottomRight;
	}
	
	public double getWidth() {
		return width;
	}
}
