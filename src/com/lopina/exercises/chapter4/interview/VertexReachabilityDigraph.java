package com.lopina.exercises.chapter4.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lopina.exercises.chapter4.graphs.Digraph;
import com.lopina.exercises.chapter4.graphs.search.StrongComponents;

public class VertexReachabilityDigraph {
	
	private Integer reachableVertex = null;
	
	public VertexReachabilityDigraph(Digraph digraph) {
		StrongComponents scc = new StrongComponents(digraph);
		List<Set<Integer>> strongComponents = new ArrayList<Set<Integer>>();
		
		Digraph kernelDAG = new Digraph(scc.count());
		
		for (int i = 0; i < scc.count(); i++) {
			strongComponents.add(new HashSet<Integer>());
		}
		
		for (int vertex = 0; vertex < digraph.V(); vertex++) {
			int id = scc.id(vertex);
			Set<Integer> strongComponent = strongComponents.get(id);
			strongComponent.add(vertex);
			
			for (int nextVertex : digraph.adj(vertex)) {
				int nextId = scc.id(nextVertex);
				
				if (id != nextId) {
					if (!kernelDAG.hasEdge(id, nextId)) {
						kernelDAG.addEdge(id, nextId);
					}
				}
			}
		}
		
		VertexReachabilityDirectedAcyclicGraph vrdag = new VertexReachabilityDirectedAcyclicGraph(kernelDAG);
		if (vrdag.hasReachableVertex()) {
			Set<Integer> reachableVertices = strongComponents.get(vrdag.getReachableVertex());
			
			if (reachableVertices.iterator().hasNext()) {
				reachableVertex = reachableVertices.iterator().next();
			}
		}
	}
	
	public boolean hasReachableVertex() {
		return reachableVertex != null;
	}
	
	public int getReachableVertex() {
		return reachableVertex;
	}
	
	public static void main(String[] args) {
		Digraph digraph = new Digraph(10);
		digraph.addEdge(1, 0);
		
		digraph.addEdge(1, 2);
		digraph.addEdge(2, 1);
		
		digraph.addEdge(3, 2);
		
		digraph.addEdge(3, 4);
		digraph.addEdge(4, 5);
		digraph.addEdge(5, 3);
		
		digraph.addEdge(7, 4);
		
		digraph.addEdge(7, 6);
		digraph.addEdge(6, 8);
		digraph.addEdge(8, 9);
		digraph.addEdge(9, 7);
		
		VertexReachabilityDigraph vrd = new VertexReachabilityDigraph(digraph);
		
		if (vrd.hasReachableVertex()) {
			System.out.println("Found reachable vertex: " + vrd.getReachableVertex());
		} else {
			System.out.println("No reachable vertex from all other vertices.");
		}
	}
}
