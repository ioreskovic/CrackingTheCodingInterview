package com.lopina.exercises.chapter4.graphs.search;

import com.lopina.exercises.chapter4.graphs.DirectedEdge;
import com.lopina.exercises.chapter4.graphs.EdgeWeightedDigraph;

public abstract class ShortestPathTree implements
		Pathable {

	protected final EdgeWeightedDigraph graph;
	protected final int sourceVertex;
	
	public ShortestPathTree(EdgeWeightedDigraph graph, int sourceVertex) {
		super();
		this.graph = graph;
		this.sourceVertex = sourceVertex;
	}
	
	@Override
	public double distance(int sourceVertex, int sinkVertex) {
		if (this.sourceVertex != sourceVertex) {
			throw new IllegalStateException("The provided source vertex (" + sourceVertex + ") was not the same as predefined source vertex (" + this.sourceVertex + ")");
		}
		
		return distance(sinkVertex);
	}

	protected abstract double distance(int sinkVertex);

	@Override
	public Iterable<DirectedEdge> path(int sourceVertex, int sinkVertex) {
		if (this.sourceVertex != sourceVertex) {
			throw new IllegalStateException("The provided source vertex (" + sourceVertex + ") was not the same as predefined source vertex (" + this.sourceVertex + ")");
		}
		
		return path(sinkVertex);
	}

	protected abstract Iterable<DirectedEdge> path(int sinkVertex);

}
