package com.lopina.exercises.chapter4.graphs;

public class Edge implements Comparable<Edge> {

	private final int v;
	private final int w;
	private double weight;
	
	public Edge(int from, int to, double weight) {
		if (from < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (to < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
		
		this.v = from;
		this.w = to;
		this.weight = weight;
	}
	
	public int either() {
		return v;
	}
	
	public int other(int vertex) {
		if (vertex == v) {
			return w;
		} else {
			return v;
		}
	}
	
	public double getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return String.format("(%d)--%.5f--(%d)", v, weight, w);
	}
	
	@Override
	public int compareTo(Edge that) {
		if (this.weight < that.weight) {
			return -1;
		} else if (this.weight > that.weight) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + v;
		result = prime * result + w;
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Edge)) {
			return false;
		}
		Edge other = (Edge) obj;
		if (v != other.v) {
			return false;
		}
		if (w != other.w) {
			return false;
		}
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight)) {
			return false;
		}
		return true;
	}
}
