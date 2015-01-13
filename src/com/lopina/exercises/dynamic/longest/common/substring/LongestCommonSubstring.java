package com.lopina.exercises.dynamic.longest.common.substring;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestCommonSubstring {
	private String firstString;
	private String secondString;
	
	private boolean solved;
	private Iterable<String> solution;
	
	private int[][] lcs;
	
	public LongestCommonSubstring(String firstString, String secondString) {
		this.firstString = firstString;
		this.secondString = secondString;
		
		this.solved = false;
		
		init();
	}

	private void init() {
		int n = this.firstString.length();
		int m = this.secondString.length();
		
		this.lcs = new int[n + 1][m + 1];
	}

	public Iterable<String> solve() {
		int n = this.firstString.length();
		int m = this.secondString.length();
		
		int maxLengthSoFar = 0;
		Deque<String> solutions = new ArrayDeque<String>();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				char firstStringChar = firstString.charAt(i - 1);
				char secondStringChar = secondString.charAt(j - 1);
				
				if (firstStringChar == secondStringChar) {
//					if (i == 1 || j == 1) {
//						lcs[i][j] = 1;
//					} else {
						lcs[i][j] = 1 + lcs[i - 1][j - 1];
//					}
					
					if (lcs[i][j] > maxLengthSoFar) {
						maxLengthSoFar = lcs[i][j];
						int startIndex = (i - 1) - maxLengthSoFar + 1;
						int endIndex = (i - 1);
						
						solutions = new ArrayDeque<String>();
						solutions.offer(firstString.substring(startIndex, endIndex + 1));
					} else if (lcs[i][j] == maxLengthSoFar) {
						int startIndex = (i - 1) - maxLengthSoFar + 1;
						int endIndex = (i - 1);
						
						if (lcs[i][j] > maxLengthSoFar) {
							solutions = new ArrayDeque<String>();
						}
						
						solutions.offer(firstString.substring(startIndex, endIndex + 1));
					}
				} else {
					lcs[i][j] = 0;
				}
			}
		}
		
		this.solved = true;
		this.solution = solutions;
		
		return solutions;
	}
	
	public Iterable<String> getSolutions() {
		if (!solved) {
			throw new IllegalStateException("Solution not computed");
		}
		
		return this.solution;
	}

}
