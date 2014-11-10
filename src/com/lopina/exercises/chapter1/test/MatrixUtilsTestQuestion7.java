package com.lopina.exercises.chapter1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter1.MatrixUtils;

public class MatrixUtilsTestQuestion7 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionWhenGivenNullMatrix() {
		Integer[][] matrix = null;
		MatrixUtils.fillMarkedRowsAndColumns(matrix, 5, 5);
	}
	
	@Test
	public void shouldReplaceOnlyCenterRowAndColumnWhenGivenCenterMarkArgument() {
		Integer[][] matrix = MatrixUtils.createIntegerMatrix(3, 5);
		
		System.out.println("Starting matrix:");
		System.out.println(MatrixUtils.toString(matrix));
		
		MatrixUtils.fillMarkedRowsAndColumns(matrix, 7, 7);
		
		Integer[][] expectedMatrix = new Integer[][] {
				{0,  1,  7, 3,  4},
				{7,  7,  7, 7,  7},
				{10, 11, 7, 13, 14}
		};
		
		System.out.println("Expected matrix:");
		System.out.println(MatrixUtils.toString(expectedMatrix));
		System.out.println();
		System.out.println("Actual matrix:");
		System.out.println(MatrixUtils.toString(matrix));
		System.out.println();
		
		for (int i = 0; i < 3; i++) {
			assertArrayEquals(expectedMatrix[i], matrix[i]);
		}
	}
	
	@Test
	public void shouldReplaceOnlyTopRowAndLeftColumnWhenGivenUpperLeftMarkArgument() {
		Integer[][] matrix = MatrixUtils.createIntegerMatrix(3, 5);
		
		System.out.println("Starting matrix:");
		System.out.println(MatrixUtils.toString(matrix));
		
		MatrixUtils.fillMarkedRowsAndColumns(matrix, 0, 0);
		
		Integer[][] expectedMatrix = new Integer[][] {
				{0,  0,  0,  0,  0},
				{0,  6,  7,  8,  9},
				{0,  11, 12, 13, 14}
		};
		
		System.out.println("Expected matrix:");
		System.out.println(MatrixUtils.toString(expectedMatrix));
		System.out.println();
		System.out.println("Actual matrix:");
		System.out.println(MatrixUtils.toString(matrix));
		System.out.println();
		
		for (int i = 0; i < 3; i++) {
			assertArrayEquals(expectedMatrix[i], matrix[i]);
		}
	}
	
	@Test
	public void shouldReplaceOnlyBottomRowAndRightColumnWhenGivenLowerRightMarkArgument() {
		Integer[][] matrix = MatrixUtils.createIntegerMatrix(3, 5);
		
		System.out.println("Starting matrix:");
		System.out.println(MatrixUtils.toString(matrix));
		
		MatrixUtils.fillMarkedRowsAndColumns(matrix, 14, 14);
		
		Integer[][] expectedMatrix = new Integer[][] {
				{0,   1,  2,  3,  14},
				{5,   6,  7,  8,  14},
				{14,  14, 14, 14, 14}
		};
		
		System.out.println("Expected matrix:");
		System.out.println(MatrixUtils.toString(expectedMatrix));
		System.out.println();
		System.out.println("Actual matrix:");
		System.out.println(MatrixUtils.toString(matrix));
		System.out.println();
		
		for (int i = 0; i < 3; i++) {
			assertArrayEquals(expectedMatrix[i], matrix[i]);
		}
	}
	
	@Test
	public void shouldNotReplaceAnythingWhenGivenNonExistantMarkElement() {
		Integer[][] matrix = MatrixUtils.createIntegerMatrix(3, 5);
		
		System.out.println("Starting matrix:");
		System.out.println(MatrixUtils.toString(matrix));
		
		MatrixUtils.fillMarkedRowsAndColumns(matrix, 15, 15);
		
		Integer[][] expectedMatrix = new Integer[][] {
				{0,   1,  2,  3,  4},
				{5,   6,  7,  8,  9},
				{10,  11, 12, 13, 14}
		};
		
		System.out.println("Expected matrix:");
		System.out.println(MatrixUtils.toString(expectedMatrix));
		System.out.println();
		System.out.println("Actual matrix:");
		System.out.println(MatrixUtils.toString(matrix));
		System.out.println();
		
		for (int i = 0; i < 3; i++) {
			assertArrayEquals(expectedMatrix[i], matrix[i]);
		}
	}

}
