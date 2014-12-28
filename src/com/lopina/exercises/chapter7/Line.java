package com.lopina.exercises.chapter7;

public class Line {
	private Point start;
	private Point end;
	
	
	public Line(Point p1, Point p2) {
		if (p1.compareTo(p2) <= 0) {
			this.start = p1;
			this.end = p2;
		} else {
			this.start = p2;
			this.end = p1;
		}
	}

	public Line(double x1, double y1, double x2, double y2) {
		this(new Point(x1, y1), new Point(x2, y2));
	}
	
	public Point getStart() {
		return start;
	}
	
	public Point getEnd() {
		return end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "{" + start + ", " + end + "}";
	}
	
	
}
