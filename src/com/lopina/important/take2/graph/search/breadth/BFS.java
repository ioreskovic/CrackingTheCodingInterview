package com.lopina.important.take2.graph.search.breadth;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import com.lopina.important.take2.graph.Edge;
import com.lopina.important.take2.graph.Graph;
import com.lopina.important.take2.graph.Weightable;
import com.lopina.important.take2.graph.search.Distancer;
import com.lopina.important.take2.graph.search.Pather;

public class BFS<T extends Edge> implements Pather<T>, Distancer<T> {

	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private Graph<T> graph;
	private int sourceVertexIndex;
	private int vertices;
	
	public BFS(Graph<T> graph, int sourcVertexIndex) {
		this.graph = graph;
		this.sourceVertexIndex = sourcVertexIndex;
		
		this.vertices = this.graph.vertices();
		
		this.marked = new boolean[vertices];
		this.edgeTo = new int[vertices];
		this.distTo = new int[vertices];
		
		bfs();
	}
	
	private void bfs() {
		Deque<Integer> queue = new ArrayDeque<Integer>();
		
		for (int v = 0; v < vertices; v++) {
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
					distTo[w] = distTo[v] + getDistance(v, w);
					marked[w] = true;
					
					queue.offerLast(w);
				}
			}
		}
	}

	private int getDistance(int v, int w) {
		T edge = null;
		for (T e : graph.outEdges(v)) {
			if (e.other(v) == w) {
				edge = e;
				break;
			}
		}
		
		if (edge == null) {
			return INFINITY;
		}
		
		if (edge instanceof Weightable) {
			return (int) ((Weightable) edge).getWeight();
		} else {
			return 1;
		}
	}

	@Override
	public int distanceTo(int vertexIndex) {
		return distTo[vertexIndex];
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
		
		path.offerFirst(sourceVertexIndex);
		
		return path;
	}

	@Override
	public Iterable<T> pathToAsEdges(int vertexIndex) {
		if (!hasPathTo(vertexIndex)) {
			return null;
		}
		
		Deque<T> edgePath = new ArrayDeque<T>();
		Iterable<Integer> vertexPath = pathTo(vertexIndex);
		
		Iterator<Integer> it = vertexPath.iterator();
		int v = it.next();
		
		while (it.hasNext()) {
			int w = it.next();
			
			for (T edge : graph.outEdges(v)) {
				if (edge.other(v) == w) {
					edgePath.offerLast(edge);
					break;
				}
			}
			
			v = w;
		}
		
		return edgePath;
	}

}
