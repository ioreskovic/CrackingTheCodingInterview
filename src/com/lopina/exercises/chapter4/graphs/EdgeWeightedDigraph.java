package com.lopina.exercises.chapter4.graphs;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.In;

public class EdgeWeightedDigraph {

	private int V;
	private int E;
	private final List<DirectedEdge>[] adj;
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(int V) {
		super();
		this.V = V;
		this.adj =(List<DirectedEdge>[]) new List[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<DirectedEdge>();
		}
	}
	
	public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            if (v < 0 || v >= V) throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
            if (w < 0 || w >= V) throw new IndexOutOfBoundsException("vertex " + w + " is not between 0 and " + (V-1));
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }
	
	public void addEdge(DirectedEdge e) {
		int from = e.from();
		adj[from].add(e);
		E++;
	}
	
	public Iterable<DirectedEdge> adj(int vertex) {
		return adj[vertex];
	}
	
	public int V() {
		return this.V;
	}
	
	public int E() {
		return this.E;
	}
	
	public Iterable<DirectedEdge> edges() {
		List<DirectedEdge> list = new ArrayList<DirectedEdge>();
		for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
	}
	
	public String toString() {
		String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
	}
	
	public int outdegree(int v) {
        return adj[v].size();
    }
}
