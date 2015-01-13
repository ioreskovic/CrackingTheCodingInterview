package com.lopina.exercises.dynamic.maxtrix;

import com.lopina.exercises.chapter1.MatrixUtils;

public class MaximumSumSubmatrix {
	private Integer[][] matrix;
	private int k;
	private int m;
	private int n;
	
	private boolean solved;
	
	private Integer rSum[][];
	private Integer kSum[][];
	
	private Integer[][] solution;
	
	public MaximumSumSubmatrix(Integer[][] matrix, int k) {
		this.matrix = matrix;
		this.m = this.matrix.length;
		this.n = this.matrix[0].length;
		this.k = k;
		this.solved = false;
		
		init();
	}

	private void init() {
		int kRows = this.m - this.k + 1;
		int kCols = this.n - this.k + 1;
		this.kSum = new Integer[kRows + 1][kCols + 1];
	}
	
	public void solve() {
		if (!solved) {
			solveRMatrix();
			solveKMatrix();
			
			printMatrix(rSum);
			printMatrix(kSum);
		}
	}

	private void printMatrix(Integer[][] matrix) {
		System.out.println(MatrixUtils.toString(matrix));
		System.out.println();
	}

	private void solveRMatrix() {
		int rRows = this.m;
		int rCols = this.n - this.k + 1;
		this.rSum = new Integer[rRows][rCols];
		
		for (int i = 0; i < rRows; i++) {
			for (int j = 0; j < rCols; j++) {
				if (j == 0) {
					rSum[i][j] = sumH(matrix, i, j, k);
				} else {
					rSum[i][j] = rSum[i][j - 1] - matrix[i][j - 1] + matrix[i][j + k - 1];
				}
			}
		}
	}

	private void solveKMatrix() {
		int kRows = this.m - this.k + 1;
		int kCols = this.n - this.k + 1;
		this.kSum = new Integer[kRows][kCols];
		
		int iMax = 0;
		int jMax = 0;
		int sumMax = Integer.MIN_VALUE;
		
		for (int i = 0; i < kRows; i++) {
			for (int j = 0; j < kCols; j++) {
				if (i == 0) {
					kSum[i][j] = sumV(rSum, i, i + k, j);
				} else {
					kSum[i][j] = kSum[i - 1][j] - rSum[i - 1][j] + rSum[i + k - 1][j];
				}
				
				if (kSum[i][j] > sumMax) {
					sumMax = kSum[i][j];
					iMax = i;
					jMax = j;
				}
			}
		}
		
		this.solution = submatrix(matrix, iMax, jMax, k);
		
		this.solved = true;
	}
	
	private Integer[][] submatrix(Integer[][] original, int x, int y, int size) {
		Integer[][] submatrix = new Integer[k][k];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				submatrix[i][j] = original[x + i][y + j];
			}
		}
		
		return submatrix;
	}
	
	public Integer[][] getSolution() {
		if (!solved) {
			throw new IllegalStateException("Solution not reached");
		}
		return solution;
	}

	private int sumH(Integer[][] matrix, int row, int start, int end) {
		int sum = 0;
		
		for (int col = start; col < end; col++) {
			sum += matrix[row][col];
		}
		
		return sum;
	}
	
	private int sumV(Integer[][] matrix, int start, int end, int col) {
		int sum = 0;
		
		for (int row = start; row < end; row++) {
			sum += matrix[row][col];
		}
		
		return sum;
	}
}
