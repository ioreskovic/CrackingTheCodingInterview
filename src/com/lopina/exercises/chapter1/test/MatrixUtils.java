package com.lopina.exercises.chapter1.test;



public class MatrixUtils {
	
	public static Integer[][] createIntegerMatrix(int n) {
		Integer[][] matrix = new Integer[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.valueOf(i * n + j);
			}
		}
		
		return matrix;
	}
	
	public static <T> String toString(T[][] matrix) {
		StringBuilder sb = new StringBuilder();
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(matrix[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public static <T> void rotatePositive90Degrees(T[][] matrix) {
		checkForNullMatrix(matrix, "The matrix was null.");
		checkForNonSquareMatrix(matrix, "The matrix was not square.");
		
		int n = matrix.length;
		
		if (n == 1) {
			return;
		}
		
		int topLeft = 0;
		int bottomRight = n - 1;
		
		while (topLeft < bottomRight) {
			rotateOuterMatrixRing(matrix, topLeft, bottomRight);
			topLeft++;
			bottomRight--;
		}
		
		return;
	}
	
	private static <T> void rotateOuterMatrixRing(T[][] matrix, int topLeft, int bottomRight) {
		int spliceLength = bottomRight - topLeft;
		
		//TODO
		// swap left and top splice
		for (int s = 0; s < spliceLength; s++) {
			int ai = topLeft + spliceLength - s;
			int aj = topLeft;
			
			int bi = topLeft;
			int bj = topLeft + s;
			
			swap(matrix, ai, aj, bi, bj);
		}
		
		// swap top and right splice
		for (int s = 0; s < spliceLength; s++) {
			int ai = topLeft;
			int aj = topLeft + s;
			
			int bi = topLeft + s;
			int bj = bottomRight;
			
			swap(matrix, ai, aj, bi, bj);
		}
		
		// swap right and bottom splice
		for (int s = 0; s < spliceLength; s++) {
			int ai = topLeft + s;
			int aj = bottomRight;
			
			int bi = bottomRight;
			int bj = bottomRight - s;
			
			swap(matrix, ai, aj, bi, bj);
		}
	}
	
	private static <T> void swap(T[][] matrix, int ai, int aj, int bi, int bj) {
		T temp = matrix[ai][aj];
		matrix[ai][aj] = matrix[bi][bj];
		matrix[bi][bj] = temp;
	}
	
	private static <T> void checkForNullMatrix(T[][] matrix, String message) {
		if (matrix == null) {
			throw new NullPointerException(message);
		}
	}
	
	private static <T> void checkForNonSquareMatrix(T[][] matrix, String message) {
		if (matrix.length != matrix[0].length) {
			throw new IllegalArgumentException(message);
		}
	}
}
