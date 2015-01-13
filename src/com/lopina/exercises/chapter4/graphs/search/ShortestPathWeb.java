package com.lopina.exercises.chapter4.graphs.search;

import com.lopina.exercises.chapter4.graphs.DirectedEdge;
import com.lopina.exercises.chapter4.graphs.EdgeWeightedDigraph;

public abstract class ShortestPathWeb implements Pathable {

	protected final EdgeWeightedDigraph graph;
	
	public ShortestPathWeb(EdgeWeightedDigraph graph) {
		super();
		this.graph = graph;
	}

	@Override
	public abstract double distance(int sourceVertex, int sinkVertex);

	@Override
	public abstract Iterable<DirectedEdge> path(int sourceVertex, int sinkVertex);

}
