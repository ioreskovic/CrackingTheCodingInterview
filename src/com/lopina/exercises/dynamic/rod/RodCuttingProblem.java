package com.lopina.exercises.dynamic.rod;

import java.util.Arrays;

public class RodCuttingProblem {
	private int[] cutLengths;
	private int[] cutValues;
	private int rodLength;
	
	private boolean solved;
	
	private int[] bestPrice;
	
	private int[] solution;
	private int profit;
	
	public RodCuttingProblem(int[] cutLengths, int[] cutValues, int rodLength) {
		this.cutLengths = cutLengths;
		this.cutValues = cutValues;
		this.rodLength = rodLength;
		
		this.solved = false;
		
		init();
	}

	private void init() {
		this.bestPrice = new int[rodLength + 1];
		this.bestPrice[0] = 0;
	}
	
	public void solve() {
		if (!solved) {
			int noCutOptions = cutValues.length;
			
			for (int i = 1; i <= rodLength; i++) {
				int[] possibleCutValues = new int[noCutOptions];
				
				for (int j = 0; j < i; j++) {
					possibleCutValues[j] = bestPrice[max(0, i - cutLengths[j])] + cutValues[j];
				}
				
				bestPrice[i] = max(possibleCutValues);
			}
			
			System.out.println(Arrays.toString(bestPrice));
			
			this.profit = bestPrice[rodLength];
			this.solution = reconstructSolution();
			this.solved = true;
		}
		
	}
	
	private int[] reconstructSolution() {
		int noCutOptions = cutValues.length;
		
		int[] solution = new int[noCutOptions];
		
		for (int i = rodLength; i > 0; ) {
			int[] possibleCutValues = new int[noCutOptions];
			
			for (int j = 0; j < i; j++) {
				possibleCutValues[j] = bestPrice[max(0, i - cutLengths[j])] + cutValues[j];
			}
			
			int cutIndex = maxIndex(possibleCutValues);
			solution[cutIndex]++;
			
			i -= cutLengths[cutIndex];
		}
		
		return solution;
	}

	public int[] getSolution() {
		return solution;
	}
	
	public int getProfit() {
		return profit;
	}
	
	private int max(int ... values) {
		int max = values[0];
		for (int i = 1; i < values.length; i++) {
			max = Math.max(max, values[i]);
		}
		
		return max;
	}
	
	private int min(int ... values) {
		int min = values[0];
		for (int i = 1; i < values.length; i++) {
			min = Math.min(min, values[i]);
		}
		
		return min;
	}
	
	private int minIndex(int[] values) {
		int minIndex = 0;
		int minValue = values[0];
		
		for (int i = 1; i < values.length; i++) {
			if (values[i] < minValue) {
				minValue = values[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	private int maxIndex(int[] values) {
		int maxIndex = 0;
		int maxValue = values[0];
		
		for (int i = 1; i < values.length; i++) {
			if (values[i] > maxValue) {
				maxValue = values[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
}
