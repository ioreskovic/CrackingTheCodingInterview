package com.lopina.exercises.chapter4.interview;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lopina.exercises.chapter4.graphs.Digraph;
import com.lopina.exercises.chapter4.graphs.search.DirectedBFSPaths;

public class ShortestDirectCycle {
	private Deque<Integer> cycle = new ArrayDeque<Integer>();
	private int length;
	
	public ShortestDirectCycle(Digraph digraph) {
		Digraph reverse = digraph.reverse();
		length = digraph.V() + 1;
		
		
		// Run BFS for every vertex on REVERSED graph. Why?
		// On original graph, G, if there is a cycle of x -> y -> z -> w
		// There is a cycle x -> w > z -> y
		// Meaning that the second to last vertex in a cycle in original graph
		// Is second vertex from x in reversed graph
		// So we check if the second to last vertex has a link to original vertex
		// If so, the cycle is complete
		// Then all that is left is to compare cycle lengths to find the shortest/longest
		for (int v = 0; v < digraph.V(); v++) {
			DirectedBFSPaths bfspaths = new DirectedBFSPaths(reverse, v);
			
			for (int w : digraph.adj(v)) {
				if (bfspaths.hasPathTo(w) && (bfspaths.distTo(w) + 1) < length) {
					length = bfspaths.distTo(w) + 1;
					cycle = new ArrayDeque<Integer>();
					
					for (int x : bfspaths.pathTo(w)) {
						cycle.offerFirst((x));
					}
					
					cycle.offerFirst(v);
				}
			}
		}
	}
	
	public boolean hasCycle() {
		return cycle != null;
	}
	
	public Deque<Integer> cycle() {
		return cycle;
	}
	
	public int cycleLength() {
		return length;
	}
}
