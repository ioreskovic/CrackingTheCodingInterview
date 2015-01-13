package com.lopina.exercises.dynamic.stringalignment;

public class DNANucleobaseStringAlignmentProblem implements
		StringAlignmentProblem {

	private static final char GAP = ' ';
	private DNANucleobaseAlignmentPenalty penaltyStrategy;
	private String originalFirstString;
	private String originalSecondString;
	
	private String alignedFirstString;
	private String alignedSecondString;
	
	private boolean solved = false;
	
	private double[][] penaltyValueMatrix;
	
	public DNANucleobaseStringAlignmentProblem(DNANucleobaseAlignmentPenalty penaltyStrategy, String a, String b) {
		this.penaltyStrategy = penaltyStrategy;
		this.originalFirstString = a;
		this.originalSecondString = b;
		
		init();
	}

	private void init() {
		this.penaltyValueMatrix = new double[originalFirstString.length() + 1][originalSecondString.length() + 1];
		
		for (int i = 1; i < originalFirstString.length() + 1; i++) {
			this.penaltyValueMatrix[i][0] = i * this.penaltyStrategy.getPenaltyFor(GAP, originalFirstString.charAt(i - 1));
		}
		
		for (int j = 1; j < originalSecondString.length() + 1; j++) {
			this.penaltyValueMatrix[0][j] = j * this.penaltyStrategy.getPenaltyFor(GAP, originalSecondString.charAt(j - 1));
		}
	}

	@Override
	public void solve() {
		if (!solved) {
			int m = originalFirstString.length();
			int n = originalSecondString.length();
			
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					char firstStringChar = originalFirstString.charAt(i - 1);
					char secondStringChar = originalSecondString.charAt(j - 1);
					
					double penaltyXPrimeYPrime = penaltyValueMatrix[i - 1][j - 1];
					double penaltyXY = this.penaltyStrategy.getPenaltyFor(firstStringChar, secondStringChar);
					
					double penaltyXPrimeY = penaltyValueMatrix[i - 1][j];
					double penaltyXGap = this.penaltyStrategy.getPenaltyFor(firstStringChar, GAP);
					
					double penaltyXYPrime = penaltyValueMatrix[i][j - 1];
					double penaltyGapY = this.penaltyStrategy.getPenaltyFor(GAP, secondStringChar);

					this.penaltyValueMatrix[i][j] = min(
							penaltyXPrimeYPrime + penaltyXY,
							penaltyXPrimeY + penaltyXGap,
							penaltyXYPrime + penaltyGapY
					);
				}
			}
		}
		
		reconstructSolution();
	}

	private void reconstructSolution() {
		int m = originalFirstString.length();
		int n = originalSecondString.length();
		
		StringBuilder sbFirst = new StringBuilder();
		StringBuilder sbSecond = new StringBuilder();
		
		int i = m;
		int j = n;
		
		for (i = m, j = n; i > 0 && j > 0; ) {
			char firstStringChar = originalFirstString.charAt(i - 1);
			char secondStringChar = originalSecondString.charAt(j - 1);
			
			double[] totalPositionPenalties = new double[3];
			
			double penaltyXPrimeYPrime = penaltyValueMatrix[i - 1][j - 1];
			double penaltyXY = this.penaltyStrategy.getPenaltyFor(firstStringChar, secondStringChar);
			totalPositionPenalties[0] = penaltyXPrimeYPrime + penaltyXY;
			
			double penaltyXPrimeY = penaltyValueMatrix[i - 1][j];
			double penaltyXGap = this.penaltyStrategy.getPenaltyFor(firstStringChar, GAP);
			totalPositionPenalties[1] = penaltyXPrimeY + penaltyXGap;
			
			double penaltyXYPrime = penaltyValueMatrix[i][j - 1];
			double penaltyGapY = this.penaltyStrategy.getPenaltyFor(GAP, secondStringChar);
			totalPositionPenalties[2] = penaltyXYPrime + penaltyGapY;

			double totalPositionPenalty = min(totalPositionPenalties);
			
			if (totalPositionPenalty == totalPositionPenalties[1]) {
				sbFirst.append(firstStringChar);
				sbSecond.append(GAP);
				i--;
			} else if (totalPositionPenalty == totalPositionPenalties[2]) {
				sbFirst.append(GAP);
				sbSecond.append(secondStringChar);
				j--;
			} else {
				sbFirst.append(firstStringChar);
				sbSecond.append(secondStringChar);
				i--;
				j--;
			}
		}
		
		while (i > 0) {
			sbFirst.append(originalFirstString.charAt(i - 1));
			sbSecond.append(GAP);
			i--;
		}
		
		while (j > 0) {
			sbFirst.append(GAP);
			sbSecond.append(originalFirstString.charAt(j - 1));
			j--;
		}
		
		this.alignedFirstString = sbFirst.reverse().toString();
		this.alignedSecondString = sbSecond.reverse().toString();
		
		this.solved = true;
	}

	private double min(double ... values) {
		double min = values[0];
		for (int i = 1; i < values.length; i++) {
			min = Math.min(min, values[i]);
		}
		
		return min;
	}

	@Override
	public String getFirstString() {
		if (solved) {
			return this.alignedFirstString;
		} else {
			throw new IllegalStateException("Problem not solved");
		}
	}

	@Override
	public String getSecondString() {
		if (solved) {
			return this.alignedSecondString;
		} else {
			throw new IllegalStateException("Problem not solved");
		}
	}

}
