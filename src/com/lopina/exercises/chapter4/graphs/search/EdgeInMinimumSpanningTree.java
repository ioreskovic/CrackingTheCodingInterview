package com.lopina.exercises.chapter4.graphs.search;

import com.lopina.exercises.chapter4.graphs.Edge;
import com.lopina.exercises.chapter4.graphs.EdgeWeightedGraph;
import com.lopina.exercises.chapter4.graphs.MinimalSpanningTree;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * We will solve this using MST cycle property, which says that, "For any cycle C in the graph, if the weight of an edge e of C is larger than the weights of all other edges of C, then this edge cannot belong to an MST."</br>
 * Now, run the following O(E+V) algorithm to test if the edge E connecting vertices u and v will be a part of some MST or not.</br>
 * Step 1</br>
 * Run dfs from one of the end-points(either u or v) of the edge E considering only those edges that have weight less than that of E.</br>
 * Step 2</br>
 * Case 1 If at the end of this dfs, the vertices u and v get connected, then edge E cannot be a part of some MST. This is because in this case there definitely exists a cycle in the graph with the edge E having the maximum weight and it cannot be a part of the MST(from the cycle property).</br>
 * Case 2 But if at the end of the dfs u and v stay disconnected, then edge E must be the part of some MST as in this case E is not always the maximum weight edge of all the cycles that it is a part of</br>
 * 
 * @author eivaore
 *
 */
public class EdgeInMinimumSpanningTree {
	private boolean[] marked;
	private boolean inMst;
	
	public EdgeInMinimumSpanningTree(EdgeWeightedGraph graph, int firstVertex, int secondVertex) {
		Edge graphEdge = null;
		
		for (Edge edge : graph.adj(firstVertex)) {
			if (edge.other(firstVertex) == secondVertex) {
				graphEdge = edge;
				break;
			}
		}
		
		if (graphEdge == null) {
			inMst = false;
			return;
		} 
		
		this.marked = new boolean[graph.V()];
		
		dfs(graph, firstVertex, graphEdge);
		
		inMst = !marked[secondVertex];
	}

	private void dfs(EdgeWeightedGraph graph, int vertex, Edge graphEdge) {
		marked[vertex] = true;
		
		for (Edge e : graph.adj(vertex)) {
			int other = e.other(vertex);
			
			if (e.getWeight() < graphEdge.getWeight() && !marked[other]) {
				dfs(graph, other, graphEdge);
			}
		}
	}
	
	public boolean isInMst() {
		return inMst;
	}
	
	public static void main(String[] args) {
		In in = new In("tinyEWG.txt");
		EdgeWeightedGraph graph = new EdgeWeightedGraph(in);
		
		EdgeInMinimumSpanningTree x = null;
		MinimalSpanningTree mst = new KruskalMST(graph);
		System.out.println("MST:");
		System.out.println("____");
		for (Edge edge : mst.edges()) {
			 StdOut.println(edge);
		}
		System.out.println();
		
		x = new EdgeInMinimumSpanningTree(graph, 0, 2);
		System.out.println("Edge (0, 2) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 0, 4);
		System.out.println("Edge (0, 4) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 0, 6);
		System.out.println("Edge (0, 6) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 0, 7);
		System.out.println("Edge (0, 7) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 1, 2);
		System.out.println("Edge (1, 2) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 1, 3);
		System.out.println("Edge (1, 3) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 1, 5);
		System.out.println("Edge (1, 5) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 1, 7);
		System.out.println("Edge (1, 7) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 2, 3);
		System.out.println("Edge (2, 3) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 2, 6);
		System.out.println("Edge (2, 6) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 2, 7);
		System.out.println("Edge (2, 7) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 3, 6);
		System.out.println("Edge (3, 6) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 4, 5);
		System.out.println("Edge (4, 5) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 4, 6);
		System.out.println("Edge (4, 6) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 4, 7);
		System.out.println("Edge (4, 7) in MST: " + x.isInMst());
		
		x = new EdgeInMinimumSpanningTree(graph, 5, 7);
		System.out.println("Edge (5, 7) in MST: " + x.isInMst());
	}
}
