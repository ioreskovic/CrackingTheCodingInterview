package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lopina.exercises.chapter4.graphs.Digraph;

public class DirectedDFSPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private final int startingVertex;
	
	public DirectedDFSPaths(Digraph digraph, int startingVertex) {
		int vertices = digraph.V();
		
		this.marked = new boolean[vertices];
		this.edgeTo = new int[vertices];
		this.startingVertex = startingVertex;
		
		dfs(digraph, startingVertex);
	}

	private void dfs(Digraph digraph, int vertex) {
		marked[vertex] = true;
		
		for (int w : digraph.adj(vertex)) {
			if (!marked[w]) {
				edgeTo[w] = vertex;
				dfs(digraph, w);
			}
		}
	}
	
	public boolean hasPathTo(int vertex) {
		return marked[vertex];
	}
	
	public Deque<Integer> pathTo(int vertex) {
		if (!hasPathTo(vertex)) {
			return null;
		}
		
		Deque<Integer> path = new ArrayDeque<Integer>();
		
		for (int x = vertex; x != startingVertex; x = edgeTo[x]) {
			path.offerFirst(x);
		}
		
		path.offerFirst(startingVertex);
		
		return path;
	}
}
