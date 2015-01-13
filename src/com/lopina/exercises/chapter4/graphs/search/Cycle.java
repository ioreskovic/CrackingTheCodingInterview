package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lopina.exercises.chapter4.graphs.Graph;

public class Cycle {
	
	private Graph graph;
	
	private boolean[] marked;
	private int[] edgeTo;
	private Deque<Integer> cycle;
	
	public Cycle(Graph graph) {
		this.graph = graph;
		
		if (hasSelfLoop(graph)) {
			return;
		}
		
		if (hasParallelEdges(graph)) {
			return;
		}
		
		int vertices = graph.V();
		
		this.marked = new boolean[vertices];
		this.edgeTo = new int[vertices];
		
		process();
	}

	private void process() {
		for (int v = 0; v < graph.V(); v++) {
			if (!marked[v]) {
				dfs(graph, -1, v);
			}
		}
	}

	private boolean hasSelfLoop(Graph graph) {
		for (int v = 0; v < graph.V(); v++) {
			for (int w : graph.adj(v)) {
				if (v == w) {
					cycle = new ArrayDeque<Integer>();
					cycle.offerFirst(v);
					cycle.offerFirst(v);
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean hasParallelEdges(Graph graph) {
		marked = new boolean[graph.V()];
		
		for (int v = 0; v < graph.V(); v++) {
			for (int w : graph.adj(v)) {
				if (marked[w]) {
					cycle = new ArrayDeque<Integer>();
					
					cycle.offerFirst(v);
					cycle.offerFirst(w);
					cycle.offerFirst(v);
					
					return true;
				}
				
				marked[w] = true;
 			}
			
			for (int w : graph.adj(v)) {
				marked[w] = false;
			}
		}
		
		return false;
	}
	
	private void dfs(Graph graph, int u, int v) {
		marked[v] = true;
		
		for (int w : graph.adj(v)) {
			if (cycle != null) {
				return;
			}
			
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(graph, v, w);
			} else if (w != u) {
				cycle = new ArrayDeque<Integer>();
				
				for (int x = v; x != w; x = edgeTo[x]) {
					cycle.offerFirst(x);
				}
				
				cycle.offerFirst(w);
				cycle.offerFirst(v);
			}
		}
	}
	
	
}
