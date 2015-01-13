package com.lopina.exercises.dynamic.knapsack;

import java.util.Arrays;

public class KnapsackSolver {
	
	public static boolean[] solve(int[] weights, int[] values, int maxCapacity) {
		int nItems = weights.length;
		boolean[] solution = new boolean[nItems];
		
		int achievedCapacity = 0;
		
		int[][] value = new int[nItems + 1][maxCapacity + 1];
		
		for (int i = 1; i <= nItems; i++) {
			for (int c = 0; c <= maxCapacity; c++) {
				int itemExcludedValue = value[i - 1][c];
				
				int itemIncludedCapacity = c - weights[i - 1];
				int itemIncludedValue = Integer.MIN_VALUE;
				if (itemIncludedCapacity >= 0 && itemIncludedCapacity <= maxCapacity) {
					itemIncludedValue = value[i - 1][itemIncludedCapacity] + values[i - 1];
				}
				
				if (itemIncludedCapacity <= maxCapacity && itemIncludedValue > itemExcludedValue) {
					value[i][c] = itemIncludedValue;
					achievedCapacity = itemIncludedCapacity;
				} else {
					value[i][c] = itemExcludedValue;
					achievedCapacity = c;
				}
			}
		}
		
		int solutionValue = value[nItems][maxCapacity];
		
		System.out.println("Solution value: " + solutionValue);
		System.out.println("Solution capacity: " + achievedCapacity);
		
		for (int i = 0; i <= nItems; i++) {
			System.out.println(Arrays.toString(value[i]));
		}
		System.out.println();
		
		for (int i = nItems, c = maxCapacity; i > 0 && c > 0; i--) {
			int iThItemAddedValue = value[i - 1][c - weights[i - 1]] + values[i - 1];
			int iThItemInheritedValue = value[i - 1][c];
			
			if (iThItemAddedValue > iThItemInheritedValue) {
				solution[i - 1] = true;
				c = c - weights[i - 1];
			} else {
				solution[i - 1] = false;
			}
		}
		
		return solution;
	}
	
	public static void main(String[] args) {
		int nItems = 5;
		int[] weights = new int[] { 1, 2 , 5, 6, 4 };
		int[] values = new int[] { 1, 6, 18, 22, 28 };
		int maxCapacity = 11;
		
		System.out.println(Arrays.toString(KnapsackSolver.solve(weights, values, maxCapacity)));
	}
}
