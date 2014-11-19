package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lopina.exercises.chapter4.graphs.Graph;

public class BFSPaths extends Paths {

	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	
	public BFSPaths(Graph graph, int sourceVertexIndex) {
		super(graph, sourceVertexIndex);
		
		this.marked = new boolean[graph.V()];
		this.distTo = new int[graph.V()];
		this.edgeTo = new int[graph.V()];
		
		findPaths(graph, sourceVertexIndex);
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
		
		for (int vertex = vertexIndex; distTo[vertex] != 0; vertex = edgeTo[vertex]) {
			path.offerFirst(vertex);
		}
		
		path.offerFirst(this.sourceVertexIndex);
		
		return path;
	}

	@Override
	protected void findPaths(Graph graph, int sourceVertexIndex) {
		bfs(graph, sourceVertexIndex);
	}

	private void bfs(Graph graph, int sourceVertexIndex) {
		Deque<Integer> queue = new ArrayDeque<Integer>();
		
		for (int v = 0; v < graph.V(); v++) {
			distTo[v] = INFINITY;
		}
		
		distTo[sourceVertexIndex] = 0;
		marked[sourceVertexIndex] = true;
		
		queue.offerLast(sourceVertexIndex);
		
		while (!queue.isEmpty()) {
			int v = queue.pollFirst();
			
			for (int w : graph.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					
					queue.offerLast(w);
				}
			}
		}
	}
	
	public int getMaxDistanceVertex() {
		int maxDistance = Integer.MIN_VALUE;
		int maxDistanceVertexIndex = -1;
		
		for (int i = 0; i < distTo.length; i++) {
			if (distTo[i] > maxDistance) {
				maxDistance = distTo[i];
				maxDistanceVertexIndex = i;
			}
		}
		
		return maxDistanceVertexIndex;
	}
	
}
