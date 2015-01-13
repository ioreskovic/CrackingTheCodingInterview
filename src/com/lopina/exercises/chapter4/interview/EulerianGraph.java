package com.lopina.exercises.chapter4.interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.lopina.exercises.chapter4.graphs.Graph;

import edu.princeton.cs.introcs.In;

/**
 * Finds an Eulerian cycle in a graph.</br>
 * An Eulerian cycle is a sequence of visits to graph vertices in such a way that<br>
 * each edge is visited only once and that the start node is the end node aswell.</br>
 * 
 * @author eivaore
 *
 */
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

	/**
	 * Checks if the specidied graph meets the criteria of Eulerian cycle.<br>
	 * In order for a graph to have Eulerian cycle, all of its vertices need to</br>
	 * have even number of edges connected to them.</br>
	 * 
	 * @param graph the specified graph
	 * @return <code>true</code> if the graph has Eulerian cycle, <code>false</code> otherwise
	 */
	@SuppressWarnings("unchecked")
	private boolean hasEulerianCycle(Graph graph) {
		edgesMap = new HashMap<Edge, Integer>();
		adj = (Iterator<Integer>[]) new Iterator[graph.V()];
		
		// Collect data about vertices and corresponding edges
		// Runs in O(V + E) time 
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
	 * See: <a href="http://iampandiyan.blogspot.in/2013/10/c-program-to-find-euler-path-or-euler.html">http://iampandiyan.blogspot.in/2013/10/c-program-to-find-euler-path-or-euler.html</a></br>
	 * Constructs Eulerian cycle for the given graph</br>
	 * Time complexity is O(E + V)
	 * 
	 * @param graph the specified graph
	 */
	private void findEulerianCycle(Graph graph) {
		eulerianCycle = new ArrayDeque<Integer>();
		Deque<Integer> stack = new ArrayDeque<Integer>();
		
		// Push the initial vertex to the stack
		stack.offerFirst(0);

		// While there is something on the stack, we can try exploring further in a DFS manner
		while (!stack.isEmpty()) {
			// Check which vertex is the most recent one to explore
			int v = stack.peek();
			
			// For each of its neighboring vertices
			while (adj[v].hasNext()) {
				// Check if we have traversed that edge before
				int w = adj[v].next();
				Edge edge = new Edge(v, w);
				
				// If we can still use it it
				if (edgeAvailable(edge)) {
					// Push the other end of that edge onto the stack and mark that we've used it
					stack.offerFirst(w);
					decrementEdgeCount(edge);
					
					// set the current vertex to explore for children the other vertex of the edge
					v = w;
				}
			}
			
			// We've come to a place where our current node has no more available edges
			// So we need to backtrack to find possible loops we missed
			// While there is something on the stack
			while (!stack.isEmpty()) {
				
				// Take the latest vertex and push it on another stack to keep traversal order
				int x = stack.pop();
				eulerianCycle.push(x);

				// If we've come to the end of the stack, we've completed the search
				// and the traversal order is on the another stack
				if (stack.isEmpty()) {
					return;
				}
				
				// If there is something on the stack
				// Check what it is
				int k = stack.peek();
				
				// If that something still has unexplored edges
				// Set it as the node to be examined and force break the loop
				// And start outer one again from that point
				if (adj[k].hasNext()) {
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
		
		EulerianGraph egEnv = new EulerianGraph(new Graph(new In("eulerianEnvelope.txt")));
		System.out.println(egEnv.getEulerianCycle());
	}
	
}
