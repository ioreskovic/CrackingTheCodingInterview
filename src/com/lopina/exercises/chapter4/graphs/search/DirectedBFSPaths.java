package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lopina.exercises.chapter4.graphs.Digraph;

public class DirectedBFSPaths {
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	
	public DirectedBFSPaths(Digraph digraph, int startingVertex) {
		int vertices = digraph.V();
		
		this.marked = new boolean[vertices];
		this.edgeTo = new int[vertices];
		this.distTo = new int[vertices];
		
		for (int v = 0; v < vertices; v++) {
			distTo[v] = INFINITY;
		}
		
		bfs(digraph, startingVertex);
	}

	private void bfs(Digraph digraph, int vertex) {
		Deque<Integer> queue = new ArrayDeque<Integer>();
		marked[vertex] = true;
		distTo[vertex] = 0;
		queue.offerLast(vertex);
		
		bfs(digraph, vertex, queue);
	}

	private void bfs(Digraph digraph, int vertex, Deque<Integer> queue) {
		while (!queue.isEmpty()) {
			int v = queue.pollFirst();
			
			for (int w : digraph.adj(v)) {
				if (!marked[vertex]) {
					edgeTo[w] = vertex;
					distTo[w] = distTo[vertex] + 1;
					marked[w] = true;
					
					queue.offerLast(w);
				}
			}
		}
	}
	
	private void bfs(Digraph digraph, Iterable<Integer> vertices) {
		Deque<Integer> queue = new ArrayDeque<Integer>();
		
		for (int vertex : vertices) {
			marked[vertex] = true;
			distTo[vertex] = 0;
			queue.offerLast(vertex);
			
			bfs(digraph, vertex, queue);
		}
		
	}
	
	public boolean hasPathTo(int vertex) {
		return marked[vertex];
	}
	
	public int distTo(int vertex) {
		return distTo[vertex];
	}
	
	public Iterable<Integer> pathTo(int vertex) {
		if (!hasPathTo(vertex)) {
			return null;
		}
		
		Deque<Integer> stack = new ArrayDeque<Integer>();
		
		int x;
		
		for (x = vertex; distTo[x] != 0; x = edgeTo[x]) {
			stack.offerFirst(x);
		}
		stack.offer(x);
		
		return stack;
	}
}
