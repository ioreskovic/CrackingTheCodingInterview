package com.lopina.exercises.chapter4.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.princeton.cs.introcs.In;

public class Graph {
	private final int V;
	private int E;
	private List<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		if (V < 0) {
			throw new IllegalArgumentException("Number of vertices must be nonnegative");
		}
		
		this.V = V;
		this.E = 0;
		this.adj = (ArrayList<Integer>[])new ArrayList[V];
		
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
		}
	}
	
	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();
		if (E < 0) {
			throw new IllegalArgumentException("Number of edges must be nonnegative");
		}
		
		for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
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
	
	public static int degree(Graph G, int v) {
		int degree = 0;
		
		for (int w : G.adj(v)) {
			degree++;
		}
		
		return degree;
	}
	
	public int degree(int v) {
		return degree(this, v);
	}
	
	public static int maxDegree(Graph G) {
		int max = 0;
		
		for (int v = 0; v < G.V(); v++) {
			if (degree(G, v) > max) {
				max = degree(G, v);
			}
		}
		
		return max;
	}
	
	public int maxDegree() {
		return maxDegree(this);
	}
	
	public static double averageDegree(Graph G) {
		return 2.0 * G.E() / G.V();
	}
	
	public double averageDegree() {
		return averageDegree(this);
	}
	
	public static int numberOfSelfLoops(Graph G) {
		int count = 0;
		
		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				if (v == w) {
					count++;
				}
			}
		}
		
		return count / 2;
	}
}
