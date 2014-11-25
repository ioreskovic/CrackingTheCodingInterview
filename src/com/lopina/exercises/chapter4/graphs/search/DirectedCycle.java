package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lopina.exercises.chapter4.graphs.Digraph;

public class DirectedCycle {
	private boolean[] marked;
	private boolean[] onStack;
	private int[] edgeTo;
	private Deque<Integer> cycle;
	
	public DirectedCycle(Digraph digraph) {
		int vertices = digraph.V();
		
		this.marked = new boolean[vertices];
		this.onStack = new boolean[vertices];
		this.edgeTo = new int[vertices];
		
		for (int v = 0; v < vertices; v++) {
			if (!marked[v]) {
				dfs(digraph, v);
			}
		}
	}

	private void dfs(Digraph digraph, int vertex) {
		onStack[vertex] = true;
		marked[vertex] = true;
		
		for (int w : digraph.adj(vertex)) {
			
			if (cycle != null) {
				return;
			} else if (!marked[w]) {
				edgeTo[w] = vertex;
				dfs(digraph, w);
			} else if (onStack[w]) {
				cycle = new ArrayDeque<Integer>();
				
				for (int x = vertex; x != w; x = edgeTo[x]) {
					cycle.offerFirst(x);
				}
				
				cycle.offerFirst(w);
				cycle.offerFirst(vertex);
			}
		}
		
		onStack[vertex] = false;
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}
	
	public Deque<Integer> cycle() {
		return cycle;
	}
}
