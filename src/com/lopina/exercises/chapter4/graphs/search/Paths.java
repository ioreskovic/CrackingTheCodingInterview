package com.lopina.exercises.chapter4.graphs.search;

import com.lopina.exercises.chapter4.graphs.Graph;

public abstract class Paths {
	protected Graph graph;
	protected int sourceVertexIndex;
	
	public Paths(Graph graph, int sourceVertexIndex) {
		this.graph = graph;
		this.sourceVertexIndex = sourceVertexIndex;
	}
	
	public abstract boolean hasPathTo(int vertexIndex);
	public abstract Iterable<Integer> pathTo(int vertexIndex);
	protected abstract void findPaths(Graph graph, int sourceVertexIndex);
}
