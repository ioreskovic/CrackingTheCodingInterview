package com.lopina.exercises.chapter1;

import java.awt.Point;

import com.lopina.exercises.chapter1.test.Coordinate;



public class MatrixUtils {
	
	/**
	 * Creates a new {@link Integer} square matrix and fills it with values from <code>0</code> to <code>n * n</code>
	 * @param n the dimension of the square matrix
	 * @return new Integer square matrix
	 */
	public static Integer[][] createIntegerMatrix(int n) {
		return createIntegerMatrix(n, n);
	}
	
	/**
	 * Creates a new {@link Integer} matrix and fills it with values from <code>0</code> to <code>m * n</code>
	 * @param m number of rows
	 * @param n number of columns
	 * @return new Integer matrix with <code>m</code> rows and <code>n</code> columns
	 */
	public static Integer[][] createIntegerMatrix(int m, int n) {
		Integer[][] matrix = new Integer[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.valueOf(i * n + j);
			}
		}
		
		return matrix;
	}
	
	/**
	 * Creates a string representation of the provided matrix.
	 * @param matrix the matrix
	 * @return a string representation of the provided matrix
	 */
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
	
	/**
	 * Replaces elements in rows and columns where mark element has been found with fill element
	 * Time complexity is O(m*n)
	 * Space complexity is O(m + n)
	 * @param matrix the provided matrix
	 * @param markElement the element which rows' and columns' elements will be replaced
	 * @param fillElement the replacing element
	 * @throws NullPointerException if the matrix is a null matrix
	 */
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
	
	public static <T> void traverseMatrixDiagonal1(T[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		int maxIndexSum = m + n - 1;
		
		for (int indexSum = 0; indexSum < maxIndexSum; indexSum++) {
			int topRightStartRow = indexSum < n ? 0 : indexSum - n + 1;
			int bottomLeftEndColumn = indexSum < m ? 0 : indexSum - m + 1;
			
			System.out.print(String.format("%3d: ", indexSum));
			for (int i = topRightStartRow; i <= (indexSum - bottomLeftEndColumn); i++) {
				System.out.print(String.format("[%4d]", matrix[i][indexSum - i]));
			}
			System.out.println();
		}
	}
	
	public static <T> void traverseMatrixDiagonal2(T[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		for (int slice = - (m - 1); slice <= (n - 1); slice++) {
			System.out.print(String.format("%3d: ", slice));
			
			int topLeftStartRow = slice < 0 ? -slice : 0;
			int topLeftStartColumn = slice < 0 ? 0 : slice;
			int bottomRightEndColumn = slice >= (n - m) ? n - 1 : m + slice - 1;
			
			int sliceLength = bottomRightEndColumn - topLeftStartColumn + 1;
			
			for (int i = 0; i < sliceLength; i++) {
				System.out.print(String.format("[%4d]", matrix[topLeftStartRow + i][topLeftStartColumn + i]));
			}
			System.out.println();
		}
	}
	
	public static <T> void traverseMatrixSpiral(T[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		int sh = 0;
		int sv = 0;
		int eh = m - 1;
		int ev = n - 1;
		
		while (sh < eh && sv < ev) {
//			System.out.println("h-range = [" + sh + ", " + eh + "]");
//			System.out.println("v-range = [" + sv + ", " + ev + "]");
			for (int i = sv; i <= ev - 1; i++) {
				System.out.print(String.format("%3s", matrix[sh][i]));
			}
			
			for (int i = sh; i <= eh - 1; i++) {
				System.out.print(String.format("%3s", matrix[i][ev]));
			}
			
			for (int i = ev; i >= sv + 1; i--) {
				System.out.print(String.format("%3s", matrix[eh][i]));
			}
			
			for (int i = eh; i >= sh + 1; i--) {
				System.out.print(String.format("%3s", matrix[i][sv]));
			}
			
			sh++;
			eh--;
			
			sv++;
			ev--;
		}
		
		if (sh == eh) {
			for (int i = sv; i <= ev; i++) {
				System.out.print(String.format("%3s", matrix[sh][i]));
			}
		} else if (sv == ev) {
			for (int i = sh; i <= eh; i++) {
				System.out.print(String.format("%3s", matrix[i][sv]));
			}
		}
	}
	
	public static <T extends Comparable<T>> Coordinate contains(T[][] matrix, T value) {
		return binaryMatrixSearch(matrix, value, new Coordinate(0, 0), new Coordinate(matrix.length - 1, matrix[0].length - 1));
	}
	
	public static <T extends Comparable<T>> Coordinate binaryMatrixSearch(T[][] matrix, T value, Coordinate upperLeft, Coordinate lowerRight) {
		System.out.println("Checking rectangle: " + upperLeft.toString() + " \\ " + lowerRight.toString());
		if (!upperLeft.inBounds(matrix) || !lowerRight.inBounds(matrix)) {
			return null;
		}
		
		if (value.equals(matrix[upperLeft.x][upperLeft.y])) {
			return upperLeft;
		} else if (!upperLeft.isBefore(lowerRight)) {
			return null;
		}
		
		
		int diagonalDistance = Math.min(
				lowerRight.x - upperLeft.x,
				lowerRight.y - upperLeft.y
		);
		
		Coordinate start = new Coordinate(upperLeft);
		Coordinate end = new Coordinate(start.x + diagonalDistance, start.y + diagonalDistance);
		Coordinate p = Coordinate.average(start, end);
		
		while (start.isBefore(end)) {
			Coordinate avg = Coordinate.average(start, end);
			p.x = avg.x;
			p.y = avg.y;
			if (value.compareTo(matrix[p.x][p.y]) == 0) {
				return p;
			} else if (value.compareTo(matrix[p.x][p.y]) > 0) {
				start.x = p.x + 1;
				start.y = p.y + 1;
			} else if (value.compareTo(matrix[p.x][p.y]) < 0) {
				end.x = p.x - 1;
				end.y = p.y - 1;
			}
		}
		
		System.out.println("Diagonal pivot: " + start);
		
		Coordinate upperRightStart = new Coordinate(upperLeft.x, start.y);
		Coordinate upperRightEnd = new Coordinate(start.x - 1, lowerRight.y);
		Coordinate lowerLeftStart = new Coordinate(start.x, upperLeft.y);
		Coordinate lowerLeftEnd = new Coordinate(lowerRight.x, start.y - 1);
		
		Coordinate result = binaryMatrixSearch(matrix, value, upperRightStart, upperRightEnd);
		if (result == null) {
			result = binaryMatrixSearch(matrix, value, lowerLeftStart, lowerLeftEnd);
		}
		
		return result;
	}
	
}
