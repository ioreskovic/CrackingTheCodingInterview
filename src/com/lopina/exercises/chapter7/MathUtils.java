package com.lopina.exercises.chapter7;

import javafx.scene.shape.LineTo;

public class MathUtils {	
	public static boolean isPrime(int n) {
		return SieveOfEratosthenes.isPrime(n);
	}
	
	public static int greatesCommonDivisor(int a, int b) {
		if (b > a) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		int greatestCommonDivisor = 1;
		
		while (b != 0) {
			greatestCommonDivisor = b;
			b = a % b;
			a = greatestCommonDivisor;
		}
		
		return greatestCommonDivisor;
	}
	
	public static int leastCommonMultiple(int a, int b) {
		return a * (b / greatesCommonDivisor(a, b));
	}
	
	public static int simpleNegate(int a) {
		int negatedA = 0;
		int negativeSignum = a < 0 ? 1 : -1;
		
		while (a != 0) {
			negatedA += negativeSignum;
			a += negativeSignum;
		}
		
		return negatedA;
	}
	
	public static int simpleAbs(int a) {
		if (a < 0) {
			return simpleNegate(a);
		} else {
			return a;
		}
	}
	
	public static int simpleAdd(int a, int b) {
		return a + b;
	}
	
	public static int simpleSubtract(int a, int b) {
		return a + simpleNegate(b);
	}
	
	public static int simpleMultiply(int a, int b) {
		if (a < b) {
			return simpleMultiply(b, a);
		}
		
		int multiplicationSum = 0;
		
		for (int i = simpleAbs(b); i > 0; i--) {
			multiplicationSum += a;
		}
		
		if (b < 0) {
			multiplicationSum = simpleNegate(multiplicationSum);
		}
		
		return multiplicationSum;
	}
	
	public static int simpleDivide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Division by zero");
		}
		
		int absA = simpleAbs(a);
		int absB = simpleAbs(b);
		
		int cummulativeProduct = 0;
		int divisionResult = 0;
		
		while (cummulativeProduct + absB <= absA) {
			cummulativeProduct += absB;
			divisionResult++;
		}
		
		if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
			return divisionResult;
		} else {
			return simpleNegate(divisionResult);
		}
	}
	
	public static Line findDividingLine(Square s1, Square s2) {
		Point middle1 = s1.getMiddle();
		Point middle2 = s2.getMiddle();
		
		Line midLine = new Line(middle1, middle2);
		
		
		if (isDegenerative(midLine)) {
			return nonVerticalCrossingLine(new Line(midLine.getStart().getX() - 1, midLine.getStart().getY(), midLine.getEnd().getX() + 1, midLine.getEnd().getY()), s1, s2);
		} else if (middle1.getX() == middle2.getX()) {
			return getVerticalCrossingLine(midLine, s1, s2);
		} else {
			return nonVerticalCrossingLine(midLine, s1, s2);
		}
	}

	private static Line getVerticalCrossingLine(Line midLine, Square s1, Square s2) {
		Square sTop = getMostTopSquare(s1, s2);
		Square sBottom = getMostBottomSquare(s1, s2);
		
		Line lineTop = new Line(sTop.getTopLeft(), sTop.getTopRight());
		Line lineBottom = new Line(sBottom.getBottomLeft(), sBottom.getBottomRight());
		
		Point topIntersection = intersect(lineTop, midLine);
		Point bottomIntersection = intersect(lineBottom, midLine);
		
		return new Line(topIntersection, bottomIntersection);
	}

	private static Line nonVerticalCrossingLine(Line midLine, Square s1, Square s2) {
		Square sLeft = getMostLeftSquare(s1, s2);
		Square sRight = getMostRightSquare(s1, s2);
		
		Line lineLeft = new Line(sLeft.getTopLeft(), sLeft.getBottomLeft());
		Line lineRight = new Line(sRight.getTopRight(), sRight.getBottomRight());
		
		Point leftIntersection = intersect(lineLeft, midLine);
		Point rightIntersection = intersect(lineRight, midLine);
		
		return new Line(leftIntersection, rightIntersection);
	}

	private static Square getMostTopSquare(Square s1, Square s2) {
		if (s1.getTopLeft().getY() < s2.getTopLeft().getY()) {
			return s1;
		} else if (s1.getTopLeft().getY() > s2.getTopLeft().getY()) {
			return s2;
		} else {
			if (s1.getTopLeft().getX() < s2.getTopLeft().getX()) {
				return s1;
			} else if (s1.getTopLeft().getX() > s2.getTopLeft().getX()) {
				return s2;
			} else {
				if (s1.getWidth() >= s2.getWidth()) {
					return s1;
				} else {
					return s2;
				}
			}
		}
	}

	private static Square getMostBottomSquare(Square s1, Square s2) {
		if (s1.getBottomRight().getY() > s2.getBottomRight().getY()) {
			return s1;
		} else if (s1.getBottomRight().getY() < s2.getBottomRight().getY()) {
			return s2;
		} else {
			if (s1.getBottomRight().getX() > s2.getBottomRight().getX()) {
				return s1;
			} else if (s1.getBottomRight().getX() < s2.getBottomRight().getX()) {
				return s2;
			} else {
				if (s1.getWidth() >= s2.getWidth()) {
					return s1;
				} else {
					return s2;
				}
			}
		}
	}
	
	private static Square getMostLeftSquare(Square s1, Square s2) {
		if (s1.getTopLeft().getX() < s2.getTopLeft().getX()) {
			return s1;
		} else if (s1.getTopLeft().getX() > s2.getTopLeft().getX()) {
			return s2;
		} else {
			if (s1.getTopLeft().getY() < s2.getTopLeft().getY()) {
				return s1;
			} else if (s1.getTopLeft().getY() > s2.getTopLeft().getY()) {
				return s2;
			} else {
				if (s1.getWidth() >= s2.getWidth()) {
					return s1;
				} else {
					return s2;
				}
			}
		}
	}

	private static Square getMostRightSquare(Square s1, Square s2) {
		if (s1.getBottomRight().getX() > s2.getBottomRight().getX()) {
			return s1;
		} else if (s1.getBottomRight().getX() < s2.getBottomRight().getX()) {
			return s2;
		} else {
			if (s1.getBottomRight().getY() > s2.getBottomRight().getY()) {
				return s1;
			} else if (s1.getBottomRight().getY() < s2.getBottomRight().getY()) {
				return s2;
			} else {
				if (s1.getWidth() >= s2.getWidth()) {
					return s1;
				} else {
					return s2;
				}
			}
		}
	}

	private static Point intersect(Line line1, Line line2) {
		if (isDegenerative(line1) || isDegenerative(line2)) {
			return null;
		}
		
		if (areParallel(line1, line2)) {
			return null;
		}
		
		
		double x1 = line1.getStart().getX();	
		double y1 = line1.getStart().getY();
		double x2 = line1.getEnd().getX();
		double y2 = line1.getEnd().getY();
		double x3 = line2.getStart().getX();
		double y3 = line2.getStart().getY();
		double x4 = line2.getEnd().getX();
		double y4 = line2.getEnd().getY();
		
		double intersectionXNumerator = ((x1*y2 - y1*x2) * (x3 - x4)) - ((x1 - x2) * (x3*y4 - y3*x4));
		double intersectionYNumerator = ((x1*y2 - y1*x2) * (y3 - y4)) - ((y1 - y2) * (x3*y4 - y3*x4));
		double intersectionDenominator = ((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4));
		
		double intersectionX = intersectionXNumerator / intersectionDenominator;
		double intersectionY = intersectionYNumerator / intersectionDenominator;
		
		return new Point(intersectionX, intersectionY);
	}

	private static boolean areParallel(Line line1, Line line2) {
		double x1 = line1.getStart().getX();	
		double y1 = line1.getStart().getY();
		double x2 = line1.getEnd().getX();
		double y2 = line1.getEnd().getY();
		double x3 = line2.getStart().getX();
		double y3 = line2.getStart().getY();
		double x4 = line2.getEnd().getX();
		double y4 = line2.getEnd().getY();
		
		double intersectionDenominator = ((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4));
		
		return Math.abs(intersectionDenominator) <= 1E-8;
	}

	private static boolean isDegenerative(Line line) {
		return line.getStart().compareTo(line.getEnd()) == 0;
	}
	
}
