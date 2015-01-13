package com.lopina.exercises.dynamic.coins;

public class CoinExchangeProblem {
	private int[] coinValues;
	private int sum;
	
	private int[] numCoins;
	
	private boolean solved;
	
	private int[] solution;
	private int coinsUsed;
	
	public CoinExchangeProblem(int[] coinValues, int sum) {
		this.coinValues = coinValues;
		this.sum = sum;
		this.solved = false;
		
		init();
	}
	
	public void solve() {
		if (!solved) {
			for (int i = 1; i <= sum; i++) {
				int[] previousNumCoins = new int[coinValues.length];
				
				for (int s = 0; s < coinValues.length; s++) {
					previousNumCoins[s] = max(0, i - s);
				}
				
				this.numCoins[i] = min(previousNumCoins) + 1;
			}
			
			this.solution = reconstrucSolution();
			this.coinsUsed = countCoinsUsed(this.solution);
			this.solved = true;
		}
	}
	
	public int getCoinsUsed() {
		return coinsUsed;
	}
	
	private int countCoinsUsed(int[] solution) {
		return sum(solution);
	}

	private int sum(int[] values) {
		int sum = 0;
		
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		
		return sum;
	}

	private int[] reconstrucSolution() {
		int[] solution = new int[coinValues.length];
		
		for (int i = sum; i > 0; ) {
			int[] previousNumCoins = new int[coinValues.length];
			
			for (int s = 0; s < coinValues.length; s++) {
				previousNumCoins[s] = max(0, i - coinValues[s]);
			}
			
			int coinIndexUsed = minIndex(previousNumCoins);
			
			solution[coinIndexUsed]++;
			
			i -= coinValues[coinIndexUsed];
		}
		
		return solution;
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

	public int[] getSolution() {
		return solution;
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
	
	private void init() {
		this.numCoins = new int[sum + 1];
		this.numCoins[0] = 0;
	}
}
