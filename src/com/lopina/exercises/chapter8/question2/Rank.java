package com.lopina.exercises.chapter8.question2;

public enum Rank {
	RESPONDENT(16, 0.1, 0.3),
	MANAGER(8, 0.2, 0.6),
	DIRECTOR(4, 0.4, 1.0);
	
	private int numberOf;
	private double lb;
	private double ub;

	private Rank(int numberOf, double lb, double ub) {
		this.numberOf = numberOf;
		this.lb = lb;
		this.ub = ub;
	}
	
	public int getNumberOf() {
		return numberOf;
	}
	
	public double getLb() {
		return lb;
	}
	
	public double getUb() {
		return ub;
	}
}
