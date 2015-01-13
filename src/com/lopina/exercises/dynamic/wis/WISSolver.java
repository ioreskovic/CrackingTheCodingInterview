package com.lopina.exercises.dynamic.wis;

import java.util.Arrays;

public class WISSolver {
	public static int solve(int[] lineVertices) {
		int n = lineVertices.length;
		
		boolean[] inSolution = new boolean[n];
		inSolution[0] = true;
		
		int[] pathTo = new int[n + 1];
		pathTo[0] = -1;
		
		int[] best = new int[n + 1];
		best[0] = 0;
		best[1] = lineVertices[0];
		
		for (int i = 2; i <= n; i++) {
			int gPrimeValue = best[i - 1];
			int gDoublePrimeValue = best[i - 2] + lineVertices[i - 1];
			
			if (gDoublePrimeValue > gPrimeValue) {
				best[i] = gDoublePrimeValue;
				pathTo[i] = i - 2;
				pathTo[i - 1] = -1;
				inSolution[i - 1] = true;
				inSolution[i - 2] = false;
			} else {
				best[i] = gPrimeValue;
				pathTo[i] = -1;
				inSolution[i - 1] = false;
			}
		}
		
		System.out.println("Best: " + Arrays.toString(best));
		System.out.println("Path: " + Arrays.toString(pathTo));
		System.out.println("InSolution: " + Arrays.toString(inSolution));

		int i = pathTo.length - 1;
		int k = pathTo[i];
		
		while (i > 0) {
			k = pathTo[i];
			if (k != -1) {
				System.out.println("A[" + (i - 1) + "] = " + lineVertices[(i - 1)]);
				i = k;
			} else {
				i--;
			}
		}

		return best[best.length - 1];
	}
	
	public static void main(String[] args) {
		int[] vertices = new int[] { 1, 6, 1, 1, 6 };
		System.out.println("Solving: " + Arrays.toString(vertices) + " = " + solve(vertices));
	}
}
