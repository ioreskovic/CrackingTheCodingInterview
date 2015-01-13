package com.lopina.exercises.chapter4.graphs.search;

import com.lopina.exercises.chapter4.graphs.Digraph;

public class TransitiveClosure {

	private DigraphDFS[] tc;
	
	public TransitiveClosure(Digraph digraph) {
		int vertices = digraph.V();
		
		tc = new DigraphDFS[vertices];
		
		for (int v = 0; v < vertices; v++) {
			tc[v] = new DigraphDFS(digraph, v);
		}
	}
	
	public boolean reachable(int v, int w) {
		return tc[v].marked(w);
	}
}
