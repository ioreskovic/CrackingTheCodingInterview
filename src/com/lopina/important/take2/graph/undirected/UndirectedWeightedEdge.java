package com.lopina.important.take2.graph.undirected;

import com.lopina.important.take2.graph.Weightable;

public class UndirectedWeightedEdge extends UndirectedEdge implements
		Weightable, Comparable<UndirectedWeightedEdge> {

	private double weight;
	
	public UndirectedWeightedEdge(int v, int w, double weight) {
		super(v, w);
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
	public int compareTo(UndirectedWeightedEdge other) {
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
		return String.format("(%d)<--[%.3f]-->(%d)", Math.min(v, w), weight, Math.max(v, w));
	}

}
