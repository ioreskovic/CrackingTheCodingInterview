package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

import com.lopina.exercises.chapter4.UnionFind;
import com.lopina.exercises.chapter4.graphs.Edge;
import com.lopina.exercises.chapter4.graphs.EdgeWeightedGraph;
import com.lopina.exercises.chapter4.graphs.MinimalSpanningTree;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class KruskalMST implements MinimalSpanningTree {

	private double weight;
	private Deque<Edge> mst = new ArrayDeque<Edge>();
	
	public KruskalMST(EdgeWeightedGraph graph) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		for (Edge edge : graph.edges()) {
			pq.add(edge);
		}
		
		UnionFind uf = new UnionFind(graph.V());
		
		while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
			Edge edge = pq.remove();
			int v = edge.either();
			int w = edge.other(v);
			
			if (!uf.connected(v, w)) {
				uf.union(v, w);
				mst.offerLast(edge);
				weight += edge.getWeight();
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
        MinimalSpanningTree mst = new KruskalMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }

}
