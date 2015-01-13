package com.lopina.exercises.dynamic.stringalignment;

import java.util.HashMap;
import java.util.Map;

public class DNANucleobaseAlignmentPenalty implements AlignmentPenalty {

	private DNANucleobaseAlphabet alphabet;
	private Map<AlphabetElementPair, Double> penaltyMatrix;
	
	private class AlphabetElementPair {
		final Character a;
		final Character b;
		
		public AlphabetElementPair(Character a, Character b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((a == null) ? 0 : a.hashCode());
			result = prime * result + ((b == null) ? 0 : b.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AlphabetElementPair other = (AlphabetElementPair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (a == null) {
				if (other.a != null)
					return false;
			} else if (!a.equals(other.a))
				return false;
			if (b == null) {
				if (other.b != null)
					return false;
			} else if (!b.equals(other.b))
				return false;
			return true;
		}

		private DNANucleobaseAlignmentPenalty getOuterType() {
			return DNANucleobaseAlignmentPenalty.this;
		}
		
		
	}

	public DNANucleobaseAlignmentPenalty(DNANucleobaseAlphabet alphabet) {
		this.alphabet = alphabet;
		this.penaltyMatrix = new HashMap<DNANucleobaseAlignmentPenalty.AlphabetElementPair, Double>();
		
		fillPenaltyMatrix();
	}
	
	private void fillPenaltyMatrix() {
		penaltyMatrix.put(new AlphabetElementPair('A', 'A'), 0.0);
		penaltyMatrix.put(new AlphabetElementPair('A', 'C'), 1.0);
		penaltyMatrix.put(new AlphabetElementPair('A', 'G'), 1.0);
		penaltyMatrix.put(new AlphabetElementPair('A', 'T'), 0.5);
		penaltyMatrix.put(new AlphabetElementPair('A', ' '), 0.625);
		
		penaltyMatrix.put(new AlphabetElementPair('C', 'A'), 1.0);
		penaltyMatrix.put(new AlphabetElementPair('C', 'C'), 0.0);
		penaltyMatrix.put(new AlphabetElementPair('C', 'G'), 0.5);
		penaltyMatrix.put(new AlphabetElementPair('C', 'T'), 1.0);
		penaltyMatrix.put(new AlphabetElementPair('C', ' '), 0.625);
		
		penaltyMatrix.put(new AlphabetElementPair('G', 'A'), 1.0);
		penaltyMatrix.put(new AlphabetElementPair('G', 'C'), 0.5);
		penaltyMatrix.put(new AlphabetElementPair('G', 'G'), 0.0);
		penaltyMatrix.put(new AlphabetElementPair('G', 'T'), 1.0);
		penaltyMatrix.put(new AlphabetElementPair('G', ' '), 0.625);

		penaltyMatrix.put(new AlphabetElementPair('T', 'A'), 0.5);
		penaltyMatrix.put(new AlphabetElementPair('T', 'C'), 1.0);
		penaltyMatrix.put(new AlphabetElementPair('T', 'G'), 1.0);
		penaltyMatrix.put(new AlphabetElementPair('T', 'T'), 0.0);
		penaltyMatrix.put(new AlphabetElementPair('T', ' '), 0.625);

		penaltyMatrix.put(new AlphabetElementPair(' ', 'A'), 0.625);
		penaltyMatrix.put(new AlphabetElementPair(' ', 'C'), 0.625);
		penaltyMatrix.put(new AlphabetElementPair(' ', 'G'), 0.625);
		penaltyMatrix.put(new AlphabetElementPair(' ', 'T'), 0.625);
		penaltyMatrix.put(new AlphabetElementPair(' ', ' '), 0.0);

	}

	@Override
	public double getPenaltyFor(Character a, Character b) {
		return penaltyMatrix.get(new AlphabetElementPair(a, b));
	}
	
}
