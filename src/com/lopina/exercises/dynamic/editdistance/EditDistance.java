package com.lopina.exercises.dynamic.editdistance;

import java.util.ArrayDeque;
import java.util.Deque;


public class EditDistance {
	private EditDistancePenaltyStrategy editDistancePenaltyStrategy = new DefaultEditDistancePenaltyStrategy();
	
	private String firstString;
	private String secondString;
	
	private boolean solved;
	private int editDistanceValue;
	private Iterable<String> steps;
	
	private int[][] editDistance;
	
	public EditDistance(String firstString, String secondString) {
		this.firstString = firstString;
		this.secondString = secondString;
		
		this.solved = false;
		this.editDistanceValue = -1;
		
		initDPMatrix();
	}
	
	private void initDPMatrix() {
		int n = firstString.length();
		int m = secondString.length();
		
		this.editDistance = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			editDistance[i][0] = i;
		}
		
		for (int j = 1; j <= m; j++) {
			editDistance[0][j] = j;
		}
	}

	public void solve() {
		if (!solved) {
			int n = firstString.length();
			int m = secondString.length();
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					char firstStringChar = firstString.charAt(i - 1);
					char secondStringChar = secondString.charAt(j - 1);
					
					/* Cases */
					int case1Value = Integer.MAX_VALUE;
					int case2Value = Integer.MAX_VALUE;
					int case3Value = Integer.MAX_VALUE;
					int case4Value = Integer.MAX_VALUE;
					
					// Case 1: Elements are the same
					//     Inherit solution from the subproblem because no edits are needed
					if (firstStringChar == secondStringChar) {
						case1Value = editDistance[i - 1][j - 1];
					}
					
					// Case 2: Elements differ
					//    Do 1 change and inherit the solution from subproblem
					if (firstStringChar != secondStringChar) {
						case2Value = editDistance[i - 1][j - 1] + editDistancePenaltyStrategy.getPenaltyForReplace();
					}
					
					// Case 3: Try deleting an element from original string
					case3Value = editDistance[i - 1][j] + editDistancePenaltyStrategy.getPenaltyForDelete();
					
					// Case 4: Try inserting an element to original string
					case4Value = editDistance[i][j - 1] + editDistancePenaltyStrategy.getPenaltyForInsert();
					
					int minValue = min(case1Value, case2Value, case3Value, case4Value);
					
					editDistance[i][j] = minValue;
				}
			}
			
			this.editDistanceValue = editDistance[n][m];
			
			this.steps = reconstructSolutuon();
			
			this.solved = true;
		}
	}
	
	private Iterable<String> reconstructSolutuon() {
		Deque<String> steps = new ArrayDeque<String>();
		
		int n = firstString.length();
		int m = secondString.length();
		
		int i, j;
		
		for (i = n, j = m; i > 0 && j > 0; ) {
			char firstStringChar = firstString.charAt(i - 1);
			char secondStringChar = secondString.charAt(j - 1);
			
			/* Cases */
			int case1Value = Integer.MAX_VALUE;
			int case2Value = Integer.MAX_VALUE;
			int case3Value = Integer.MAX_VALUE;
			int case4Value = Integer.MAX_VALUE;
			
			// Case 1: Elements are the same
			//     Inherit solution from the subproblem because no edits are needed
			if (firstStringChar == secondStringChar) {
				case1Value = editDistance[i - 1][j - 1];
			}
			
			// Case 2: Elements differ
			//    Do 1 change and inherit the solution from subproblem
			if (firstStringChar != secondStringChar) {
				case2Value = editDistance[i - 1][j - 1] + editDistancePenaltyStrategy.getPenaltyForReplace();
			}
			
			// Case 3: Try deleting an element from original string
			case3Value = editDistance[i - 1][j] + editDistancePenaltyStrategy.getPenaltyForDelete();
			
			// Case 4: Try inserting an element to original string
			case4Value = editDistance[i][j - 1] + editDistancePenaltyStrategy.getPenaltyForInsert();
			
			int minValue = min(case1Value, case2Value, case3Value, case4Value);
			
			if (minValue == case1Value) {
				steps.push("KEEP '" + firstStringChar + "' and '" + secondStringChar + "'");
				--i;
				--j;
			} else if (minValue == case2Value) {
				steps.push("REPLACE '" + firstStringChar + "' with '" + secondStringChar + "'");
				--i;
				--j;
			} else if (minValue == case3Value) {
				steps.push("DELETE '" + firstStringChar + "' from '" + firstString + "'");
				--i;
			} else if (minValue == case4Value) {
				steps.push("INSERT '" + secondStringChar + "' to '" + firstString + "'");
				--j;
			} else {
				throw new IllegalStateException("This should not happen");
			}
		}
		
		while (i > 0) {
			char firstStringChar = firstString.charAt(i - 1);
			steps.push("DELETE '" + firstStringChar + "' from '" + firstString + "'");
			i--;
		}
		
		while (j > 0) {
			char secondStringChar = secondString.charAt(j - 1);
			steps.push("INSERT '" + secondStringChar + "' to '" + firstString + "'");
			j--;
		}
		
		return steps;
	}

	public int getEditDistanceValue() {
		if (!solved) {
			throw new IllegalStateException("Solution not reached (yet)");
		}
		return editDistanceValue;
	}
	
	public Iterable<String> getSteps() {
		if (!solved) {
			throw new IllegalStateException("Solution not reached (yet)");
		}
		return this.steps;
	}
	
	private int min(int ... values) {
		int min = values[0];
		for (int i = 1; i < values.length; i++) {
			min = Math.min(min, values[i]);
		}
		
		return min;
	}
}
