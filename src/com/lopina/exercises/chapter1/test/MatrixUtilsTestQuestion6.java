package com.lopina.exercises.chapter1.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MatrixUtilsTestQuestion6 {

	@Test
	public void shouldCreateAMatrix() {
		Integer[][] matrix = MatrixUtils.createIntegerMatrix(5);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Integer expectedValue = i * 5 + j;
				Integer actualValue = matrix[i][j];
				
				assertEquals(expectedValue, actualValue);
			}
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnNullMatrix() {
		Integer[][] matrix = null;
		
		MatrixUtils.rotatePositive90Degrees(matrix);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentEceptionOnNonSquareMatrix() {
		Integer[][] matrix = new Integer[3][5];
		
		MatrixUtils.rotatePositive90Degrees(matrix);
	}
	
	@Test
	public void shouldReturnImmediatelyOnSingleElementMatrix() {
		Integer[][] matrix = MatrixUtils.createIntegerMatrix(1);
		
		MatrixUtils.rotatePositive90Degrees(matrix);
	}
	
	@Test
	public void shouldRotate2Matrix() {
		Integer[][] matrix = MatrixUtils.createIntegerMatrix(2);
		
		MatrixUtils.rotatePositive90Degrees(matrix);
		
		Integer[][] expectedMatrix = new Integer[][] {
				{1, 3},
				{0, 2}
		};
		
		System.out.println("Expected matrix:");
		System.out.println(MatrixUtils.toString(expectedMatrix));
		System.out.println();
		System.out.println("Actual matrix:");
		System.out.println(MatrixUtils.toString(matrix));
		System.out.println();
		
		for (int i = 0; i < 2; i++) {
			assertArrayEquals(expectedMatrix[i], matrix[i]);
		}
	}
	
	@Test
	public void shouldRotate4Matrix() {
		Integer[][] matrix = MatrixUtils.createIntegerMatrix(4);
		
		MatrixUtils.rotatePositive90Degrees(matrix);
		
		Integer[][] expectedMatrix = new Integer[][] {
				{3, 7, 11, 15},
				{2, 6, 10, 14},
				{1, 5, 9,  13},
				{0, 4, 8,  12}
		};
		
		System.out.println("Expected matrix:");
		System.out.println(MatrixUtils.toString(expectedMatrix));
		System.out.println();
		System.out.println("Actual matrix:");
		System.out.println(MatrixUtils.toString(matrix));
		System.out.println();
		
		for (int i = 0; i < 4; i++) {
			assertArrayEquals(expectedMatrix[i], matrix[i]);
		}
	}
	
	@Test
	public void shouldRotate7Matrix() {
		Integer[][] matrix = MatrixUtils.createIntegerMatrix(7);
		
		MatrixUtils.rotatePositive90Degrees(matrix);
		
		Integer[][] expectedMatrix = new Integer[][] {
				{6, 13, 20, 27, 34, 41, 48},
				{5, 12, 19, 26, 33, 40, 47},
				{4, 11, 18, 25, 32, 39, 46},
				{3, 10, 17, 24, 31, 38, 45},
				{2, 9,  16, 23, 30, 37, 44},
				{1, 8,  15, 22, 29, 36, 43},
				{0, 7,  14, 21, 28, 35, 42}
		};
		
		System.out.println("Expected matrix:");
		System.out.println(MatrixUtils.toString(expectedMatrix));
		System.out.println();
		System.out.println("Actual matrix:");
		System.out.println(MatrixUtils.toString(matrix));
		System.out.println();
		
		for (int i = 0; i < 4; i++) {
			assertArrayEquals(expectedMatrix[i], matrix[i]);
		}
	}

}
