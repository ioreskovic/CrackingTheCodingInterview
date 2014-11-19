package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;

import com.lopina.exercises.chapter4.graphs.Graph;


public class DFSPaths extends Paths {

	private boolean[] marked;
	private int[] edgeTo;
	
	public DFSPaths(Graph graph, int sourceVertexIndex) {
		super(graph, sourceVertexIndex);
		
		int vertices = graph.V();
		
		this.marked = new boolean[vertices];
		this.edgeTo = new int[vertices];
		
		findPaths(this.graph, this.sourceVertexIndex);
	}

	@Override
	public boolean hasPathTo(int vertexIndex) {
		return marked[vertexIndex];
	}

	@Override
	public Iterable<Integer> pathTo(int vertexIndex) {
		if (!hasPathTo(vertexIndex)) {
			return null;
		}
		
		Deque<Integer> path = new ArrayDeque<Integer>();
		
		for (int vertex = vertexIndex; vertex != sourceVertexIndex; vertex = edgeTo[vertex]) {
			path.offerFirst(vertex);
		}
		
		path.offerFirst(this.sourceVertexIndex);
		
		return path;
	}

	@Override
	protected void findPaths(Graph graph, int sourceVertexIndex) {
		dfsIterative(graph, sourceVertexIndex);
	}

	private void dfs(Graph graph, int sourceVertexIndex) {
		marked[sourceVertexIndex] = true;
		
		for (int w : graph.adj(sourceVertexIndex)) {
			if (!marked[w]) {
				dfs(graph, w);
				edgeTo[w] = sourceVertexIndex;
			}
		}
	}
	
	private void dfsIterative(Graph graph, int sourceVertexIndex) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		
		stack.offerFirst(sourceVertexIndex);
		
		while (!stack.isEmpty()) {
			int v = stack.pollFirst();
			System.out.println("Marked " + v);
			marked[v] = true;
			
			Deque<Integer> adj = new ArrayDeque<Integer>();
			for (Iterator<Integer> it = graph.adj(v).iterator(); it.hasNext();) {
				adj.offerLast(it.next());
			}
			
			for (Iterator<Integer> descIt = adj.descendingIterator(); descIt.hasNext(); ) {
				int w = descIt.next();
				
				if (!marked[w]) {
					System.out.println("\tAdded unexplored child " + w);
					stack.offerFirst(w);
					edgeTo[w] = v;
				} else {
					System.out.println("\tSkipped explored child " + w);
				}
			}
		}
	}
}
