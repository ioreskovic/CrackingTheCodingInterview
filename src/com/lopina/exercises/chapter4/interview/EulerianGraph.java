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
	private Map<Edge, Integer> edgesMap;
	private Deque<Edge> cycle = new ArrayDeque<Edge>();
	private Iterator<Integer>[] adj;
	
	
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

	@SuppressWarnings("unchecked")
	private boolean hasEulerianCycle(Graph graph) {
		edgesMap = new HashMap<Edge, Integer>();
		adj = (Iterator<Integer>[]) new Iterator[graph.V()];
		
		for (int v = 0; v < graph.V(); v++) {
			adj[v] = graph.adj(v).iterator();
			if (graph.adj(v).size() % 2 == 1) {
				eulerianCycle = null;
				return false;
			}
			
			for (int w : graph.adj(v)) {
				addEdgeCount(new Edge(v, w));
			}
			
		}
		
		for (Edge e : edgesMap.keySet()) {
			int currentEdgeCount = this.edgesMap.get(e);
			edgesMap.put(e, currentEdgeCount / 2);
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
		eulerianCycle = new ArrayDeque<Integer>();
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.offerFirst(0);

		while (!stack.isEmpty()) {
			int v = stack.peek();
			System.out.println("Examining top of temp stack: " + v);
			
			while (adj[v].hasNext()) {
				int w = adj[v].next();
				System.out.println("\tNext possible vertex is: " + w);
				
				Edge edge = new Edge(v, w);
				
				if (edgeAvailable(edge)) {
					System.out.println("\t\tEdge from " + v + " to " + w + " is free");
					stack.offerFirst(w);
					decrementEdgeCount(edge);
					v = w;
					continue;
				} else {
					System.out.println("\t\tEdge from " + v + " to " + w + " is not free");
//					break;
				}
			}
			
			System.out.println();
			System.out.println("Trying to find the place to re-loop");
			
			while (!stack.isEmpty()) {
				int x = stack.pop();
				eulerianCycle.push(x);
				System.out.println("\tMoving " + x + " to cycle stack");
				
				if (stack.isEmpty()) {
					System.out.println("\tCycle done");
					return;
				}
				
				int k = stack.peek();
				System.out.println("\tBacktracking from " + k);
				
				if (adj[k].hasNext()) {
					v = k;
					break;
				}
			}
		}
	}
	
	private boolean edgeAvailable(Edge edge) {
		int edgeCount = edgesMap.getOrDefault(edge, 0);
		
		return edgeCount > 0;
	}

	private void decrementEdgeCount(Edge edge) {
		int countSoFar = edgesMap.getOrDefault(edge, 0);
		setEdgeCount(edge, countSoFar -1);
	}

	public Deque<Integer> getEulerianCycle() {
		return eulerianCycle;
	}
	
	public static void main(String[] args) {
		EulerianGraph egSmall = new EulerianGraph(new Graph(new In("eulerianSmall.txt")));
		System.out.println(egSmall.getEulerianCycle());
		
		EulerianGraph egBig = new EulerianGraph(new Graph(new In("eulerianBig.txt")));
		System.out.println(egBig.getEulerianCycle());
	}
	
}
