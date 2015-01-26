package com.lopina.important.take2.graph;

public interface Graph<T extends Edge> {
	public int vertices();
	public int edges();
	public Iterable<Integer> adj(int v);
	public Iterable<T> outEdges(int v);
	public Iterable<T> inEdges(int v);
	public void addEdge(T edge);
}
