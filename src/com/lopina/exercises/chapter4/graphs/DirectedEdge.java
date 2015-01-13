package com.lopina.exercises.chapter4.graphs;

public class DirectedEdge {
	private int from;
	private int to;
	private double weight;
	
	public DirectedEdge(int from, int to, double weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public int from() {
		return this.from;
	}
	
	public int to() {
		return this.to;
	}
	
	public double weight() {
		return this.weight;
	}
	
	@Override
	public String toString() {
		return String.format("(%d)>-%.5f->(%d)", from, weight, to);
	}
}
