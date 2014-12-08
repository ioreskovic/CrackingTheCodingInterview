package com.lopina.exercises.chapter4.graphs.search;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

import com.lopina.exercises.chapter4.graphs.DirectedEdge;
import com.lopina.exercises.chapter4.graphs.EdgeWeightedDigraph;
import com.lopina.exercises.chapter4.graphs.search.IndexedPriorityQueue.Priority;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class DijkstraShortestPathTree extends ShortestPathTree {

	private DirectedEdge[] edgeTo;
	private double[] distanceTo;
	private IndexedPriorityQueue<Double, DirectedEdge> pq;
	
	public DijkstraShortestPathTree(EdgeWeightedDigraph graph, int sourceVertex) {
		super(graph, sourceVertex);
		
		dijkstra(graph, sourceVertex);
	}

	private void dijkstra(EdgeWeightedDigraph graph, int sourceVertex) {
		edgeTo = new DirectedEdge[graph.V()];
		distanceTo = new double[graph.V()];
		pq = new IndexedPriorityQueue<Double, DirectedEdge>(
				new Comparator<Double>() {

					@Override
					public int compare(Double o1, Double o2) {
						return o1.compareTo(o2);
					}
				}, 
				graph.V(),
				Priority.MIN
		);
		
		for (int v = 0; v < graph.V(); v++) {
			distanceTo[v] = Double.POSITIVE_INFINITY;
		}
		distanceTo[sourceVertex] = 0.0;
		
		pq.insert(sourceVertex, 0.0);
		
		while (!pq.isEmpty()) {
			int v = pq.delPriority();
			
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
			
			if (pq.contains(toVertex)) {
				pq.decreaseKey(toVertex, distanceTo[toVertex]);
			} else {
				pq.insert(toVertex, distanceTo[toVertex]);
			}
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
		In in = new In(new File("tinyEWD.txt"));
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        int s = 0;
        
        // compute shortest paths
        DijkstraShortestPathTree sp = new DijkstraShortestPathTree(G, s);


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
