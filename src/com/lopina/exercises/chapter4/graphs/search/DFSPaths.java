package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayDeque;
import java.util.Deque;

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
			path.offerLast(vertex);
		}
		
		path.offerLast(this.sourceVertexIndex);
		
		return path;
	}

	@Override
	protected void findPaths(Graph graph, int sourceVertexIndex) {
		dfs(graph, sourceVertexIndex);
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
}
