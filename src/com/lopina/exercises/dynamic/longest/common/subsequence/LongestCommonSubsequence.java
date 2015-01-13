package com.lopina.exercises.dynamic.longest.common.subsequence;

public class LongestCommonSubsequence {
	private String firstString;
	private String secondString;
	
	private boolean solved;
	private String solution;
	
	private int[][] lcs;
	
	public LongestCommonSubsequence(String firstString, String secondString) {
		this.firstString = firstString;
		this.secondString = secondString;
		
		init();
		
		this.solved = false;
	}
	
	private void init() {
		int n = this.firstString.length();
		int m = this.secondString.length();
		
		this.lcs = new int[n + 1][m + 1];
		
		for (int i = 0; i <= n; i++) {
			this.lcs[i][0] = 0;
		}
		
		for (int j = 0; j <= m; j++) {
			this.lcs[0][j] = 0;
		}
	}
	
	public void solve() {
		if (!solved) {
			int n = this.firstString.length();
			int m = this.secondString.length();
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					char firstStringChar = firstString.charAt(i - 1);
					char secondStringChar = secondString.charAt(j - 1);
					
					int case1Value = Integer.MIN_VALUE;
					int case2Value = Integer.MIN_VALUE;
					int case3Value = Integer.MIN_VALUE;
					
					if (firstStringChar == secondStringChar) {
						case1Value = lcs[i - 1][j - 1] + 1;
					} else {
						case2Value = lcs[i - 1][j];
						case3Value = lcs[i][j - 1];
					}
					
					int maxValue = max(case1Value, case2Value, case3Value);
					
					lcs[i][j] = maxValue;
				}
			}
			
			this.solution = reconstructSolution();
			
			this.solved = true;
		}
	}
	
	private String reconstructSolution() {
		int n = this.firstString.length();
		int m = this.secondString.length();
		
		StringBuilder sb = new StringBuilder();
		
		int i, j;
		
		for (i = n, j = m; i > 0 && j > 0; ) {
			char firstStringChar = firstString.charAt(i - 1);
			char secondStringChar = secondString.charAt(j - 1);
			
			int case1Value = Integer.MIN_VALUE;
			int case2Value = Integer.MIN_VALUE;
			int case3Value = Integer.MIN_VALUE;
			
			if (firstStringChar == secondStringChar) {
				case1Value = lcs[i - 1][j - 1] + 1;
			} else {
				case2Value = lcs[i - 1][j];
				case3Value = lcs[i][j - 1];
			}
			
			int maxValue = max(case1Value, case2Value, case3Value);
			
			if (maxValue == case1Value) {
				sb.append(firstStringChar);
				i--;
				j--;
			} else if (maxValue == case2Value) {
				i--;
			} else if (maxValue == case3Value) {
				j--;
			} else {
				throw new IllegalStateException("Should not happen");
			}
		}
		
		return sb.reverse().toString();
	}
	
	public String getSolution() {
		if (!solved) {
			throw new IllegalStateException("Solution not reached");
		}
		return solution;
	}

	private int max(int ... values) {
		int max = values[0];
		for (int i = 1; i < values.length; i++) {
			max = Math.max(max, values[i]);
		}
		
		return max;
	}
}
