package com.lopina.important.take2.graph.search;

import com.lopina.important.take2.graph.Edge;

public interface Pather<T extends Edge> {
	public boolean hasPathTo(int vertexIndex);
	public Iterable<Integer> pathTo(int vertexIndex);
	public Iterable<T> pathToAsEdges(int vertexIndex);
}
