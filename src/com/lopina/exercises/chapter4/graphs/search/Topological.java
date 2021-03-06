package com.lopina.exercises.chapter4.graphs.search;

import java.util.Deque;

import com.lopina.exercises.chapter4.graphs.Digraph;
import com.lopina.exercises.chapter4.graphs.EdgeWeightedDigraph;

public class Topological {

	private Deque<Integer> order;
	
	public Topological(Digraph digraph) {
		DirectedCycle cycleFinder = new DirectedCycle(digraph);
		
		if (!cycleFinder.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(digraph);
			order = dfs.getReversePostorder();
		}
	}
	
	public Topological(EdgeWeightedDigraph graph) {
		DepthFirstOrder dfs = new DepthFirstOrder(graph);
		order = dfs.getReversePostorder();
	}
	
	public Deque<Integer> sort() {
		return order;
	}
	
	public boolean haasOrder() {
		return order != null;
	}
}
