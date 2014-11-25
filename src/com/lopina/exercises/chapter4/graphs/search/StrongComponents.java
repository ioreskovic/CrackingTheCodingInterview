package com.lopina.exercises.chapter4.graphs.search;

import com.lopina.exercises.chapter4.graphs.Digraph;

public class StrongComponents {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public StrongComponents(Digraph digraph) {
		DepthFirstOrder dfs = new DepthFirstOrder(digraph.reverse());
		
		marked = new boolean[digraph.V()];
		id = new int[digraph.V()];
		
		for (int v : dfs.getReversePostorder()) {
			if (!marked[v]) {
				dfs(digraph, v);
				count++;
			}
		}
	}

	private void dfs(Digraph digraph, int v) {
		marked[v] = true;
		id[v] = count;
		
		for (int w : digraph.adj(v)) {
			if (!marked[w]) {
				dfs(digraph, w);
			}
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}
	
	public int id(int v) {
		return id[v];
	}
}
