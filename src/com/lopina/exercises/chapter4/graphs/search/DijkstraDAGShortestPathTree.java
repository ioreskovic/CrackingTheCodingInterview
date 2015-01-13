package com.lopina.exercises.chapter4.graphs.search;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

import com.lopina.exercises.chapter4.graphs.DirectedEdge;
import com.lopina.exercises.chapter4.graphs.EdgeWeightedDigraph;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class DijkstraDAGShortestPathTree extends ShortestPathTree {

	private DirectedEdge[] edgeTo;
	private double[] distanceTo;
	
	public DijkstraDAGShortestPathTree(EdgeWeightedDigraph graph, int sourceVertex) {
		super(graph, sourceVertex);
		
		dagDijkstra(graph, sourceVertex);
	}

	private void dagDijkstra(EdgeWeightedDigraph graph, int sourceVertex) {
		edgeTo = new DirectedEdge[graph.V()];
		distanceTo = new double[graph.V()];
		
		for (int v = 0; v < graph.V(); v++) {
			distanceTo[v] = Double.POSITIVE_INFINITY;
		}
		
		distanceTo[sourceVertex] = 0.0;
		
		Topological topological = new Topological(graph);
		
		for (int v : topological.sort()) {
			for (DirectedEdge e : graph.adj(v)) {
				relax(e);
			}
		}
	}
	
	private void relax(DirectedEdge e) {
		int fromVertex = e.from();
		int toVertex = e.to();
		
		if (distanceTo[toVertex] > distanceTo[fromVertex] + e.weight()) {
			distanceTo[toVertex] = distanceTo[fromVertex] + e.weight();
			edgeTo[toVertex] = e;
		}
	}

	@Override
	protected double distance(int sinkVertex) {
		return distanceTo[sinkVertex];
	}

	@Override
	protected Iterable<DirectedEdge> path(int sinkVertex) {
		Deque<DirectedEdge> path = new ArrayDeque<DirectedEdge>();
		
		for (DirectedEdge e = edgeTo[sinkVertex]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}
		
		return path;
	}
	
	public boolean hasPath(int vertex) {
        return distanceTo[vertex] < Double.POSITIVE_INFINITY;
    }
	
	public static void main(String[] args) {
		In in = new In(new File("tinyEWDAG.txt"));
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        int s = 5;
        
        // compute shortest paths
        DijkstraDAGShortestPathTree sp = new DijkstraDAGShortestPathTree(G, s);


        // print shortest path
        for (int t = 0; t < G.V(); t++) {
            if (sp.hasPath(t)) {
                StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distance(t));
                if (sp.hasPath(t)) {
                    for (DirectedEdge e : sp.path(t)) {
                        StdOut.print(e + "   ");
                    }
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, t);
            }
        }
	}

}
