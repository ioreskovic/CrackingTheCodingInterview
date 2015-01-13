package com.lopina.exercises.chapter4.interview;

import java.util.Iterator;

import com.lopina.exercises.chapter4.graphs.Digraph;

public class VertexReachabilityDirectedAcyclicGraph {

	private Integer reachableVertex = null;
	
	public VertexReachabilityDirectedAcyclicGraph(Digraph digraph) {
		int vertices = digraph.V();
		
		for (int vertex = 0; vertex < vertices; vertex++) {
			Iterator<Integer> adj = digraph.adj(vertex).iterator();
			
			if (!adj.hasNext()) {
				if (reachableVertex == null) {
					reachableVertex = vertex;
				} else {
					reachableVertex = null;
					break;
				}
			}
		}
	}
	
	public boolean hasReachableVertex() {
		return reachableVertex != null;
	}

	public int getReachableVertex() {
		return reachableVertex;
	}
}
