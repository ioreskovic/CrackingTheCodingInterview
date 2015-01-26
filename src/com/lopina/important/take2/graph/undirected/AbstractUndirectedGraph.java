package com.lopina.important.take2.graph.undirected;

import com.lopina.important.take2.graph.AbstractGraph;

public abstract class AbstractUndirectedGraph<T extends UndirectedEdge> extends AbstractGraph<T> {

	protected AbstractUndirectedGraph(int vertices) {
		super(vertices);
	}
	
	@Override
	public void addEdge(T edge) {
		int v = edge.either();
		int w = edge.other(v);
		
		this.adj[v].add(w);
		this.outEdges[v].add(edge);
		this.inEdges[v].add(edge);
		
		this.adj[w].add(v);
		this.outEdges[w].add(edge);
		this.inEdges[w].add(edge);
		
		this.edgeList.add(edge);
		
		this.edges++;
	}

}
