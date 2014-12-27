package com.lopina.exercises.chapter5.question8;

import static org.junit.Assert.*;

import org.junit.Test;

public class Chapter5Question8 {

	@Test
	public void test() {
		ScreenCanvas canvas = new ScreenCanvas(32, 12);
		System.out.println(canvas);
		canvas.drawLine(15, 24, 3);
		System.out.println();
		System.out.println(canvas);
	}

}
