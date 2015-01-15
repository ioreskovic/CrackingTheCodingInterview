package com.lopina.exercises.practice.q8;

import java.util.HashSet;
import java.util.Set;

public class CentsExchange {
	
	/**
	 * Time complexity seems exponential
	 * product of 1 + n/denomx, where x = denomination value
	 * This case  (1 + 6/1) * (1 + 6/2) * (1 + 6/3) = 7 * 4 * 3 = 84
	 * Case with n = 100 and denoms are 25, 10, 5, and 1: 5 * 11 * 21 * 101 = 116655
	 * @return
	 */
	private static Set<String> makeExchangeNaiveOneTwoThreeToSix() {
		Set<String> solutions = new HashSet<String>();
		
		for (int ones = 0; ones <= 6; ones++) {
			for (int twos = 0; twos <= 3; twos++) {
				for (int threes = 0; threes <= 2; threes++) {
					int sum = 1*ones + 2*twos + 3*threes;
					if (sum == 5) {
						StringBuilder sb = new StringBuilder();
						sb.append(ones).append("x1").append(",").append(twos).append("x2").append(",").append(threes).append("x3");
						solutions.add(sb.toString());
					}
				}
			}
		}
		
		return solutions;
	}
	
	private static int makeExchangeRecursive(int[] denom, int n) {
		int[][] solution = new int[denom.length + 1][n + 1];
		for (int i = 0; i <= denom.length; i++) {
			for (int j = 0; j <= n; j++) {
				solution[i][j] = Integer.MIN_VALUE;
			}
		}
		
		return makeEchange(n, denom, 0, solution);
	}
	
	private static int makeEchange(int n, int[] denom, int i, int[][] solution) {
		if (i == denom.length) {
			if (n == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		
		int ways = 0;
		int currDenom = denom[i];
		
		if (solution[i][n] != Integer.MIN_VALUE) {
			return solution[i][n]; 
		}
		
		
		for (int j = 0; j * currDenom <= n; j++) {
			int currentWays = makeEchange(n - j * currDenom, denom, i + 1, solution);

			if (currentWays > 0) {
				ways += currentWays;
			}
		}
		
		solution[i][n] = ways;
		
		return ways;
	}

	public static void main(String[] args) {
		Set<String> makeExchangeNaiveOneTwoThreeToSixSolution = makeExchangeNaiveOneTwoThreeToSix();
		System.out.println(makeExchangeNaiveOneTwoThreeToSixSolution.size() + " ways to exchange 6");
		for (String s : makeExchangeNaiveOneTwoThreeToSixSolution) {
			System.out.println("\t" + s);
		}
		
		int[] denom = new int[] { 2, 3, 5 };
		int n = 13;

		int ways = makeExchangeRecursive(denom, n);
		System.out.println(ways);
	}
}
