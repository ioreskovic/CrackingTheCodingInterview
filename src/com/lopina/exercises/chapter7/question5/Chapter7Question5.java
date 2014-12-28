package com.lopina.exercises.chapter7.question5;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter7.Line;
import com.lopina.exercises.chapter7.MathUtils;
import com.lopina.exercises.chapter7.Square;

public class Chapter7Question5 {

	@Test
	public void test01() {
		Square bigSquare = new Square(10, 10, 3);
		Square smallSquare1 = new Square(8, 11, 1);
		Square smallSquare2 = new Square(14, 11, 1);
		Square smallSquare3 = new Square(11, 8, 1);
		Square smallSquare4 = new Square(11, 14, 1);
		
		Line line1 = MathUtils.findDividingLine(smallSquare1, bigSquare);
		Line line2 = MathUtils.findDividingLine(smallSquare2, bigSquare);
		Line line3 = MathUtils.findDividingLine(smallSquare3, bigSquare);
		Line line4 = MathUtils.findDividingLine(smallSquare4, bigSquare);
		
		Line line1Expected = new Line(8, 11.5, 13, 11.5);
		Line line2Expected = new Line(10, 11.5, 15, 11.5);
		Line line3Expected = new Line(11.5, 8, 11.5, 13);
		Line line4Expected = new Line(11.5, 10, 11.5, 15);
		
		assertEquals(line1Expected, line1);
		assertEquals(line2Expected, line2);
		assertEquals(line3Expected, line3);
		assertEquals(line4Expected, line4);
		
	}
	
	@Test
	public void test02() {
		Square bigSquare = new Square(10, 10, 3);
		Square smallSquare1 = new Square(10, 10, 1);
		Square smallSquare2 = new Square(12, 10, 1);
		Square smallSquare3 = new Square(12, 12, 1);
		Square smallSquare4 = new Square(10, 12, 1);
		
		Line line1 = MathUtils.findDividingLine(smallSquare1, bigSquare);
		Line line2 = MathUtils.findDividingLine(smallSquare2, bigSquare);
		Line line3 = MathUtils.findDividingLine(smallSquare3, bigSquare);
		Line line4 = MathUtils.findDividingLine(smallSquare4, bigSquare);
		
		Line line1Expected = new Line(10, 10, 13, 13);
		Line line2Expected = new Line(10, 13, 13, 10);
		Line line3Expected = new Line(10, 10, 13, 13);
		Line line4Expected = new Line(10, 13, 13, 10);
		
		assertEquals(line1Expected, line1);
		assertEquals(line2Expected, line2);
		assertEquals(line3Expected, line3);
		assertEquals(line4Expected, line4);
		
	}
	
	@Test
	public void test03() {
		Square bigSquare = new Square(10, 10, 3);
		Square smallSquare1 = new Square(11, 11, 1);
		Square smallSquare2 = new Square(10, 10, 3);
		
		Line line1 = MathUtils.findDividingLine(smallSquare1, bigSquare);
		Line line2 = MathUtils.findDividingLine(smallSquare2, bigSquare);

		
		Line line1Expected = new Line(10, 11.5, 13, 11.5);
		Line line2Expected = new Line(10, 11.5, 13, 11.5);

		
		assertEquals(line1Expected, line1);
		assertEquals(line2Expected, line2);

		
	}

}
