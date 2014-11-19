package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lopina.exercises.chapter4.graphs.Graph;

public class Bipartite {

	private Graph graph;
	private boolean isBipartite;
	private boolean[] color;
	private boolean[] marked;
	private int[] edgeTo;
	
	private Deque<Integer> cycle;
	
	public Bipartite(Graph graph) {
		this.graph = graph;
		int v = graph.V();
		
		isBipartite = true;
		color = new boolean[v];
		marked = new boolean[v];
		edgeTo = new int[v];
		
		process();
	}

	private void process() {
		for (int v = 0; v < graph.V(); v++) {
			if (!marked[v]) {
				dfs(graph, v);
			}
		}
	}

	private void dfs(Graph graph, int v) {
		marked[v] = true;
		
		for (int w : graph.adj(v)) {
			if (cycle != null) {
				return;
			}
			
			if (!marked[w]) {
				edgeTo[w] = v;
				color[w] = !color[v];
				dfs(graph, w);
			} else if (color[w] == color[v]) {
				isBipartite = false;
				
				cycle = new ArrayDeque<Integer>();
				cycle.offerFirst(w);
				
				for (int x = v; x != w; x = edgeTo[x]) {
					cycle.offerFirst(x);
				}
				
				cycle.offerFirst(w);
			}
		}
	}
	
	public boolean isBipartite() {
		return isBipartite;
	}
	
	public boolean color(int v) {
		if (!isBipartite()) {
			throw new UnsupportedOperationException("Graph is not bipartite.");
		}
		
		return color[v];
	}
	
	public Iterable<Integer> oddCycle() {
		return cycle;
	}

	
	
}
