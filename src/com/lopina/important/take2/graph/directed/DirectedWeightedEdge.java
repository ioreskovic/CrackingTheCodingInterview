package com.lopina.important.take2.graph.directed;

import com.lopina.important.take2.graph.Weightable;

public class DirectedWeightedEdge extends DirectedEdge implements Weightable, Comparable<DirectedWeightedEdge> {

	private double weight;
	
	public DirectedWeightedEdge(int from, int to, double weight) {
		super(from, to);
		this.weight = weight;
	}

	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public int compareTo(DirectedWeightedEdge other) {
		if (this.weight < other.weight) {
			return -1;
		} else if (this.weight > other.weight) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return String.format("(%d)---[%.3f]-->(%d)", from, weight, to);
	}

}
