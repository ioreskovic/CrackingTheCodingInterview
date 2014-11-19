package com.lopina.exercises.chapter4.interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.lopina.exercises.chapter4.graphs.Graph;

import edu.princeton.cs.introcs.In;

public class EulerianGraph {

	private class Edge {
		int vertexA;
		int vertexB;
		
		public Edge(int vertexA, int vertexB) {
			super();
			this.vertexA = Math.min(vertexA, vertexB);
			this.vertexB = Math.max(vertexA, vertexB);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + vertexA;
			result = prime * result + vertexB;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof Edge)) {
				return false;
			}
			Edge other = (Edge) obj;
			if (!getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if (vertexA != other.vertexA) {
				return false;
			}
			if (vertexB != other.vertexB) {
				return false;
			}
			return true;
		}

		private EulerianGraph getOuterType() {
			return EulerianGraph.this;
		}
		
		@Override
		public String toString() {
			return " (" + vertexA + ") --- (" + vertexB + ") ";
		}
	}
	
	private Graph graph;
	private Deque<Integer> eulerianCycle;
	private int[] edges;
	private Map<Edge, Integer> edgesMap;
	private Deque<Edge> cycle = new ArrayDeque<EulerianGraph.Edge>();
	
	
	public EulerianGraph(Graph graph) {
		super();
		this.graph = graph;
		
		process();
	}

	private void process() {
		if (hasEulerianCycle(graph)) {
			findEulerianCycle(graph);
		}
	}

	private boolean hasEulerianCycle(Graph graph) {
		edges = new int[graph.V()];
		edgesMap = new HashMap<EulerianGraph.Edge, Integer>();
		
		for (int v = 0; v < graph.V(); v++) {
			if (graph.adj(v).size() % 2 == 1) {
				eulerianCycle = null;
				return false;
			}
			
			for (int w : graph.adj(v)) {
				setEdgeCount(new Edge(v, w), 1);
			}
			
		}
		
		return true;
	}

	private void addEdgeCount(Edge edge) {
		int countSoFar = edgesMap.getOrDefault(edge, 0);
		setEdgeCount(edge, countSoFar + 1);
	}
	
	private void setEdgeCount(Edge edge, int count) {
		edgesMap.put(edge, count);
	}

	/**
	 * See: <a href="http://iampandiyan.blogspot.in/2013/10/c-program-to-find-euler-path-or-euler.html">http://iampandiyan.blogspot.in/2013/10/c-program-to-find-euler-path-or-euler.html</a>
	 * @param graph
	 */
	private void findEulerianCycle(Graph graph) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.offerFirst(0);

		int x = -1;
		
		while (!stack.isEmpty()) {
			int v = stack.pollFirst();
			cycle.offerFirst(new Edge(x, v));
			
			x = v;
			
			Edge edge = null;
			for (int w : graph.adj(v)) {
				edge = new Edge(v, w);
				
				if (edgesMap.getOrDefault(edge, 0) > 0) {
					stack.offerFirst(w);
					setEdgeCount(edge, edgesMap.get(edge) - 1);
				}
			}
		}
	}
	
	public Deque<Edge> getEulerianCycle() {
		return cycle;
	}
	
	public static void main(String[] args) {
		EulerianGraph egSmall = new EulerianGraph(new Graph(new In("eulerianSmall.txt")));
		System.out.println(egSmall.getEulerianCycle());
		
		EulerianGraph egBig = new EulerianGraph(new Graph(new In("eulerianBig.txt")));
		System.out.println(egBig.getEulerianCycle());
	}
	
}
