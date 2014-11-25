package com.lopina.exercises.chapter4.graphs.search;

import com.lopina.exercises.chapter4.graphs.Digraph;

public class DigraphDFS {

	private boolean[] marked;
	private int count;
	
	public DigraphDFS(Digraph digraph, int startVertex) {
		marked = new boolean[digraph.V()];
		dfs(digraph, startVertex);
	}

	private void dfs(Digraph digraph, int vertex) {
		count ++;
		marked[vertex] = true;
		
		for (int w : digraph.adj(vertex)) {
			if (!marked[w]) {
				dfs(digraph, w);
			}
		}
	}
	
	public boolean marked(int vertex) {
		return marked[vertex];
	}
	
	public int count() {
		return count;
	}
}
