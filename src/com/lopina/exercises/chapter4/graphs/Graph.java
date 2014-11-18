package com.lopina.exercises.chapter4.graphs;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	private final int V;
	private int E;
	private Set<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		if (V < 0) {
			throw new IllegalArgumentException("Number of vertices must be nonnegative");
		}
		
		this.V = V;
		this.E = 0;
		this.adj = (HashSet<Integer>[])new HashSet[V];
		
		for (int v = 0; v < V; v++) {
			adj[v] = new HashSet<Integer>();
		}
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	private void validateVertex(int v) {
		if (v < 0 || v >= V) {
			throw new IndexOutOfBoundsException("Vertex " + v + " is not between 0 and " + (V - 1));
		}
	}
	
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		sb.append(V).append(" vertices, ").append(E).append(" edges ").append(NEWLINE).append(NEWLINE);
		
		for (int v = 0; v < V; v++) {
			sb.append(v).append(": ");
			for (int w : adj[v]) {
				sb.append(w).append(" ");
			}
			sb.append(NEWLINE);
		}
		
		return sb.toString();
	}
	
}
