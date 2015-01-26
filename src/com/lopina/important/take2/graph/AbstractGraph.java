package com.lopina.important.take2.graph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGraph<T extends Edge> implements Graph<T> {

	protected final int vertices;
	protected int edges;
	protected List<Integer>[] adj;
	protected List<T>[] outEdges;
	protected List<T>[] inEdges;
	protected List<T> edgeList;
	
	@SuppressWarnings("unchecked")
	protected AbstractGraph(int vertices) {
		this.vertices = vertices;
		this.adj = (ArrayList<Integer>[]) (new ArrayList[vertices]);
		this.outEdges = (ArrayList<T>[]) (new ArrayList[vertices]);
		this.inEdges = (ArrayList<T>[]) (new ArrayList[vertices]);
		this.edgeList = new ArrayList<T>();
		
		for (int v = 0; v < vertices; v++) {
			this.adj[v] = new ArrayList<Integer>();
			this.outEdges[v] = new ArrayList<T>();
			this.inEdges[v] = new ArrayList<T>();
		}
	}
	
	@Override
	public int vertices() {
		return this.vertices;
	}

	@Override
	public int edges() {
		return this.edges;
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	@Override
	public Iterable<T> outEdges(int v) {
		return outEdges[v];
	}

	@Override
	public Iterable<T> inEdges(int v) {
		return inEdges[v];
	}

	@Override
	public String toString() {
		String NEWLINE = System.lineSeparator();
		StringBuilder sb = new StringBuilder();
		
		sb.append("Graph: ").append(vertices).append(" vertices; ").append(edges).append(" edges").append(NEWLINE);
		for (int v = 0; v < vertices; v++) {
			sb.append("\t").append("Vertex: ").append(v).append(NEWLINE);
			for (T e : outEdges(v)) {
				sb.append("\t\t").append(e);
			}
			sb.append(NEWLINE);
		}
		sb.append(NEWLINE);
		
		return sb.toString();
	}

}
