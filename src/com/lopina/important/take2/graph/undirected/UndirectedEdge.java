package com.lopina.important.take2.graph.undirected;

import com.lopina.important.take2.graph.Edge;

public class UndirectedEdge implements Edge {

	protected int v;
	protected int w;
	
	public UndirectedEdge(int v, int w) {
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int either() {
		return this.v;
	}

	@Override
	public int other(int x) {
		if (v == x) {
			return w;
		} else if (w == x) {
			return v;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public String toString() {
		return "(" + Math.min(v, w) + ")<----------->(" + Math.max(v, w) + ")";
	}
	
}
