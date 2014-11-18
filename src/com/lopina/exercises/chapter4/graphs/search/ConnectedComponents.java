package com.lopina.exercises.chapter4.graphs.search;

import com.lopina.exercises.chapter4.graphs.Graph;

public class ConnectedComponents {
	
	private Graph graph;
	
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public ConnectedComponents(Graph graph) {
		this.graph = graph;
		
		this.marked = new boolean[graph.V()];
		this.id = new int[graph.V()];
		this.count = 0;
		
		process(this.graph);
	}

	private void process(Graph graph) {
		discoverConnectedComponents(graph);
	}

	private void discoverConnectedComponents(Graph graph) {
		
		for (int v = 0; v < graph.V(); v++) {
			if (!marked[v]) {
				dfs(graph, v);
				count++;
			}
		}
	}
	
	public int count() {
		return count;
	}
	
	public int id(int v) {
		return id[v];
	}
	
	private void dfs(Graph graph, int v) {
		marked[v] = true;
		id[v] = count;
		
		for (int w : graph.adj(v)) {
			if (!marked[w]) {
				dfs(graph, w);
			}
		}
	}
	
	
}
