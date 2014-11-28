package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.lopina.exercises.chapter4.graphs.Edge;
import com.lopina.exercises.chapter4.graphs.EdgeWeightedGraph;
import com.lopina.exercises.chapter4.graphs.MinimalSpanningTree;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * Step 1: Compute MaxumumWeightSpanningForest O(E log E)
 *   Explanation: Perform Kruskal's algorithm with Negated natural comparator
 * Step 2: Remove forest edges from the graph O(E)
 * @author eivaore
 *
 */
public class MinimumWeightFeedbackEdgeSet {

	private List<Edge> minimumFeedbackEdgeSet;
	
	public MinimumWeightFeedbackEdgeSet(EdgeWeightedGraph graph) {
		computeMWFES(graph);
	}

	private void computeMWFES(EdgeWeightedGraph graph) {
		this.minimumFeedbackEdgeSet = new ArrayList<Edge>();
		
		MinimalSpanningTree mst = new KruskalMST(graph, new Comparator<Edge>() {
			
			@Override
			public int compare(Edge o1, Edge o2) {
				return -o1.compareTo(o2);
			}
		});
		
		Map<Edge, Integer> minimumWeightFeedbackSet = new HashMap<Edge, Integer>();
		
		for (Edge edge : graph.edges()) {
			int count = minimumWeightFeedbackSet.getOrDefault(edge, 0);
			minimumWeightFeedbackSet.put(edge, count + 1);
		}
		
		for (Edge edge : mst.edges()) {
			int count = minimumWeightFeedbackSet.getOrDefault(edge, 0);
			
			if (count > 0) {
				minimumWeightFeedbackSet.put(edge, count - 1);
			}
		}
		
		for (Entry<Edge, Integer> entry : minimumWeightFeedbackSet.entrySet()) {
			Edge edge = entry.getKey();
			int count = entry.getValue();
			
			for (int i = 0; i < count; i++) {
				this.minimumFeedbackEdgeSet.add(edge);
			}
		}
	}
	
	public List<Edge> getMinimumFeedbackEdgeSet() {
		return this.minimumFeedbackEdgeSet;
	}
	
	public static void main(String[] args) {
		In in = new In("tinyEWG.txt");
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		
		System.out.println("GRAPH:");
		System.out.println("------");
		System.out.println(G.toString());
		System.out.println();
		
		MinimalSpanningTree mst = new KruskalMST(G);
		System.out.println("MST:");
		System.out.println("____");
		for (Edge edge : mst.edges()) {
			 StdOut.println(edge);
		}
		System.out.println();
		
		MinimumWeightFeedbackEdgeSet mwfes = new MinimumWeightFeedbackEdgeSet(G);
		System.out.println("MWFES:");
		System.out.println("______");
		for (Edge edge : mwfes.getMinimumFeedbackEdgeSet()) {
			StdOut.println(edge);
		}
		System.out.println();
		
	}

}
