package com.lopina.important.take2.graph.search.mst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

import com.lopina.important.take2.graph.Edge;
import com.lopina.important.take2.graph.Graph;
import com.lopina.important.take2.graph.Weightable;
import com.lopina.important.take2.graph.search.MST;

public class LazyPrim<T extends Edge & Weightable & Comparable<T>> implements MST<T> {

	private Graph<T> graph;
	private int vertices;
	private PriorityQueue<T> pq;
	private boolean[] marked;
	private Deque<T> mst;
	private double weight;
	
	public LazyPrim(Graph<T> graph) {
		this.graph = graph;
		this.vertices = graph.vertices();
		this.pq = new PriorityQueue<T>();
		this.marked = new boolean[vertices];
		this.mst = new ArrayDeque<T>();
		this.weight = 0.0;
		
		process();
	}
	
	private void process() {
		for (int v = 0; v < vertices; v++) {
			if (!marked[v]) {
				prim(v);
			}
		}
	}

	private void prim(int x) {
		scan(x);
		
		while (!pq.isEmpty()) {
			T edge = pq.remove();
			int v = edge.either();
			int w = edge.other(v);
			
			if (marked[v] && marked[w]) {
				continue;
			}
			
			mst.offerLast(edge);
			weight += edge.getWeight();
			
			if (!marked[v]) {
				scan(v);
			}
			
			if (!marked[w]) {
				scan(w);
			}
			
		}
	}

	private void scan(int v) {
		marked[v] = true;
		
		for (T edge : graph.outEdges(v)) {
			int w = edge.other(v);
			if (!marked[w]) {
				this.pq.add(edge);
			}
		}
		
		for (T edge : graph.inEdges(v)) {
			int w = edge.other(v);
			if (!marked[w]) {
				this.pq.add(edge);
			}
		}
	}

	@Override
	public Iterable<T> edges() {
		return this.mst;
	}

	@Override
	public double weight() {
		return this.weight;
	}

}
