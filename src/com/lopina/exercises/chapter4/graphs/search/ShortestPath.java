package com.lopina.exercises.chapter4.graphs.search;

import com.lopina.exercises.chapter4.graphs.DirectedEdge;
import com.lopina.exercises.chapter4.graphs.EdgeWeightedDigraph;

public abstract class ShortestPath implements Pathable {

	protected final EdgeWeightedDigraph graph;
	protected final int sourceVertex;
	protected final int sinkVertex;
	

	public ShortestPath(EdgeWeightedDigraph graph, int sourceVertex, int sinkVertex) {
		super();
		this.graph = graph;
		this.sourceVertex = sourceVertex;
		this.sinkVertex = sinkVertex;
	}

	@Override
	public double distance(int sourceVertex, int sinkVertex) {
		if (this.sinkVertex != sinkVertex) {
			throw new IllegalStateException("The provided source vertex (" + sourceVertex + ") was not the same as predefined source vertex (" + this.sourceVertex + ")");
		}
		
		if (this.sinkVertex != sinkVertex) {
			throw new IllegalStateException("The provided sink vertex (" + sinkVertex + ") was not the same as predefined sink vertex (" + this.sinkVertex + ")");
		}
		
		return getDistance();
	}

	protected abstract double getDistance();

	@Override
	public Iterable<DirectedEdge> path(int sourceVertex, int sinkVertex) {
		if (this.sinkVertex != sinkVertex) {
			throw new IllegalStateException("The provided source vertex (" + sourceVertex + ") was not the same as predefined source vertex (" + this.sourceVertex + ")");
		}
		
		if (this.sinkVertex != sinkVertex) {
			throw new IllegalStateException("The provided sink vertex (" + sinkVertex + ") was not the same as predefined sink vertex (" + this.sinkVertex + ")");
		}
		
		return getPath();
	}

	protected abstract Iterable<DirectedEdge> getPath();

}
