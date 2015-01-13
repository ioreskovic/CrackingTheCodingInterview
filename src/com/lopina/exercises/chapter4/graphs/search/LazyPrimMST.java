package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

import com.lopina.exercises.chapter4.graphs.Edge;
import com.lopina.exercises.chapter4.graphs.EdgeWeightedGraph;
import com.lopina.exercises.chapter4.graphs.MinimalSpanningTree;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class LazyPrimMST implements MinimalSpanningTree {

	private double weight;
	private Deque<Edge> mst;
	private boolean[] marked;
	private PriorityQueue<Edge> pq;
	
	public LazyPrimMST(EdgeWeightedGraph graph) {
		this.pq = new PriorityQueue<Edge>();
		
		lazyPrim(graph);
	}
	
	public LazyPrimMST(EdgeWeightedGraph graph, Comparator<Edge> edgeComparator) {
		this.pq = new PriorityQueue<Edge>(edgeComparator);
		
		lazyPrim(graph);
	}

	private void lazyPrim(EdgeWeightedGraph graph) {
		this.mst = new ArrayDeque<Edge>();
		this.marked = new boolean[graph.V()];
		
		for (int v = 0; v < graph.V(); v++) {
			if (!marked[v]) {
				primLazy(graph, v);
			}
		}
	}
	
	private void primLazy(EdgeWeightedGraph graph, int vertex) {
		scan(graph, vertex);
		
		while (!pq.isEmpty()) {
			Edge minEdge = pq.remove();
			int v = minEdge.either();
			int w = minEdge.other(v);
			
			if (marked[v] && marked[w]) {
				continue;
			}
			
			mst.offerLast(minEdge);
			this.weight += minEdge.getWeight();
			
			if (!marked[v]) {
				scan(graph, v);
			}
			
			if (!marked[w]) {
				scan(graph, w);
			}
		}
	}

	private void scan(EdgeWeightedGraph graph, int vertex) {
		marked[vertex] = true;
		for (Edge edge : graph.adj(vertex)) {
			if (!marked[edge.other(vertex)]) {
				pq.add(edge);
			}
		}
	}

	@Override
	public Iterable<Edge> edges() {
		return mst;
	}

	@Override
	public double weight() {
		return this.weight;
	}
	
	public static void main(String[] args) {
        In in = new In("tinyEWG.txt");
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        MinimalSpanningTree mst = new LazyPrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }

}
