package com.lopina.important.take2.graph.directed;

import com.lopina.important.take2.graph.Edge;

public class DirectedEdge implements Edge {

	protected int from;
	protected int to;
	
	public DirectedEdge(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public int either() {
		return from;
	}

	@Override
	public int other(int x) {
		if (from == x) {
			return to;
		} else if (to == x) {
			return from;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public String toString() {
		return "(" + from + ")------------>(" + to + ")";
	}
	
	public int from() {
		return from;
	}
	
	public int to() {
		return to;
	}

}
