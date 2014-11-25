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
}
