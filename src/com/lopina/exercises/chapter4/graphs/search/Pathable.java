package com.lopina.exercises.chapter4.graphs.search;

import com.lopina.exercises.chapter4.graphs.DirectedEdge;

public interface Pathable {
	double distance(int sourceVertex, int sinkVertex);
	Iterable<DirectedEdge> path(int sourceVertex, int sinkVertex);
}
