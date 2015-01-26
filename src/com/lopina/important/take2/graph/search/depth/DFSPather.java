package com.lopina.important.take2.graph.search.depth;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import com.lopina.important.take2.graph.Edge;
import com.lopina.important.take2.graph.Graph;
import com.lopina.important.take2.graph.search.Distancer;
import com.lopina.important.take2.graph.search.Pather;

public class DFSPather<T extends Edge> implements Pather<T> {

	private boolean[] marked;
	private int[] edgeTo;
	private Graph<T> graph;
	private int sourceVertexIndex;
	
	public DFSPather(Graph<T> graph, int sourceVertexIndex) {
		this.graph = graph;
		this.sourceVertexIndex = sourceVertexIndex;
		
		int vertices = graph.vertices();
		
		this.marked = new boolean[vertices];
		this.edgeTo = new int[vertices];
		
		dfs();
	}
	
	private void dfs() {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		
		stack.offerFirst(sourceVertexIndex);
		
		while (!stack.isEmpty()) {
			int v = stack.pollFirst();
			marked[v] = true;
			
			Deque<Integer> adj = new ArrayDeque<Integer>();
			for (Iterator<Integer> ascIt = graph.adj(v).iterator(); ascIt.hasNext(); ) {
				adj.offerFirst(ascIt.next());
			}
			
			for (Iterator<Integer> descIt = adj.descendingIterator(); descIt.hasNext(); ) {
				int w = descIt.next();
				
				if (!marked[w]) {
					stack.offerFirst(w);
					edgeTo[w] = v;
				}
			}
		}
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
