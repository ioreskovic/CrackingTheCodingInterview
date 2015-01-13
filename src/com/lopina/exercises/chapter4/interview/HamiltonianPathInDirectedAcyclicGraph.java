package com.lopina.exercises.chapter4.interview;

import java.util.Deque;
import java.util.Iterator;

import com.lopina.exercises.chapter4.graphs.Digraph;
import com.lopina.exercises.chapter4.graphs.search.Topological;

public class HamiltonianPathInDirectedAcyclicGraph {

	private boolean hamiltonianPath = true;
	
	public HamiltonianPathInDirectedAcyclicGraph(Digraph digraph) {
		Topological t = new Topological(digraph);
		Deque<Integer> topologicalSort = t.sort();
		
		Iterator<Integer> it = topologicalSort.iterator();
		
		Integer v = null;
		Integer w = null;
		
		if (it.hasNext()) {
			v = it.next();
		}
		
		while (it.hasNext()) {
			w = it.next();
			
			hamiltonianPath &= hasPath(digraph, v, w);
			
			v = w;
		}
	}

	private boolean hasPath(Digraph digraph, Integer v, Integer w) {
		return digraph.hasEdge(v, w);
	}
	
	public boolean hasHamiltonianPath() {
		return hamiltonianPath;
	}
}
