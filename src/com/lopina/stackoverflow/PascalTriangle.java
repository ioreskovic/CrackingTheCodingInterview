package com.lopina.stackoverflow;

import java.util.Arrays;

public class PascalTriangle {
	public static void printPascalTriangle(int n) {
		pascalTriangle(n);
	}

	private static int[] pascalTriangle(int n) {
		if (n <= 0) {
			int[] pascalLine = new int[] { 1 };
			System.out.println(n + ": " + Arrays.toString(pascalLine));
			return pascalLine;
		}
		
		int[] pascalLine = new int[n + 1];
		int firstIndex = 0;
		int lastIndex = n;
		
		pascalLine[firstIndex] = 1;
		pascalLine[lastIndex] = 1;
		
		int[] previousLine = pascalTriangle(n - 1);
		
		for (int i = 1; i < lastIndex; i++) {
			pascalLine[i] = previousLine[i - 1] + previousLine[i];
		}
		
		System.out.println(n + ": " + Arrays.toString(pascalLine));
		return pascalLine;
	}
	
	public static void main(String[] args) {
		printPascalTriangle(5);
	}
}
