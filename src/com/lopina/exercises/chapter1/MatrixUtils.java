package com.lopina.exercises.chapter1;



public class MatrixUtils {
	
	public static Integer[][] createIntegerMatrix(int n) {
		return createIntegerMatrix(n, n);
	}
	
	public static Integer[][] createIntegerMatrix(int m, int n) {
		Integer[][] matrix = new Integer[m][n];
		
		for (int i = 0; i < m; i++) {
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
	
	public static <T> void fillMarkedRowsAndColumns(T[][] matrix, T markElement, T fillElement) {
		checkForNullMatrix(matrix, "The matrix was null");
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		boolean[] markedRows = new boolean[rows];
		boolean[] markedCols = new boolean[cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j].equals(markElement)) {
					markedRows[i] = true;
					markedCols[j] = true;
				}
			}
		}
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (isInMarkedRow(i, markedRows) || isInMarkedColumn(j, markedCols)) {
					setMatrixElement(matrix, markElement, i, j);
				}
			}
		}
	}
	
	private static boolean isInMarkedRow(int i, boolean[] markedRows) {
		return isMarked(i, markedRows);
	}

	private static boolean isInMarkedColumn(int j, boolean[] markedCols) {
		return isMarked(j, markedCols);
	}
	
	private static boolean isMarked(int i, boolean[] array) {
		return array[i];
	}
	
	private static <T> void setMatrixElement(T[][] matrix, T markElement, int row, int col) {
		matrix[row][col] = markElement;
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
