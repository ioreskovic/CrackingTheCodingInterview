package com.lopina.important.take2.graph.directed;

import com.lopina.important.take2.graph.AbstractGraph;

public abstract class AbstractDirectedGraph<T extends DirectedEdge> extends AbstractGraph<T> {

	protected AbstractDirectedGraph(int vertices) {
		super(vertices);
	}

	@Override
	public void addEdge(T edge) {
		int from = edge.from();
		int to = edge.to();
		
		this.adj[from].add(to);
		this.outEdges[from].add(edge);
		this.inEdges[to].add(edge);
		
		this.edgeList.add(edge);
		
		this.edges++;
	}

}
