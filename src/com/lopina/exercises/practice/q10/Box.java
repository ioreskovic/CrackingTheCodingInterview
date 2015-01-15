package com.lopina.exercises.practice.q10;

public class Box {
	public int w;
	public int h;
	public int d;
	
	public Box(int w, int h, int d) {
		this.w = w;
		this.h = h;
		this.d = d;
	}

	@Override
	public String toString() {
		return "Box [w=" + w + ", h=" + h + ", d=" + d + "]";
	}

	public boolean canBeAbove(Box other) {
		if (other == null) {
			return true;
		}
		return (this.w < other.w && this.h < other.h && this.d < other.d);
	}
	
	
}
