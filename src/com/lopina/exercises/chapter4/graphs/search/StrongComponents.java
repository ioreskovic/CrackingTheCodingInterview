package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lopina.exercises.chapter4.graphs.Digraph;

public class StrongComponents {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public StrongComponents(Digraph digraph) {
		DepthFirstOrder dfs = new DepthFirstOrder(digraph.reverse());
		
		marked = new boolean[digraph.V()];
		id = new int[digraph.V()];
		
		for (int v : dfs.getReversePostorder()) {
			if (!marked[v]) {
				dfs(digraph, v);
				count++;
			}
		}
	}

	private void dfs(Digraph digraph, int v) {
		marked[v] = true;
		id[v] = count;
		
		for (int w : digraph.adj(v)) {
			if (!marked[w]) {
				dfs(digraph, w);
			}
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}
	
	public int id(int v) {
		return id[v];
	}
	
	public static void main(String[] args) {
		Digraph digraph = new Digraph(10);
		digraph.addEdge(1, 0);
		digraph.addEdge(1, 2);
		digraph.addEdge(2, 1);
		digraph.addEdge(3, 2);
		digraph.addEdge(3, 4);
		digraph.addEdge(4, 5);
		digraph.addEdge(5, 3);
		digraph.addEdge(7, 4);
		digraph.addEdge(7, 6);
		digraph.addEdge(6, 8);
		digraph.addEdge(8, 9);
		digraph.addEdge(9, 7);
		
		StrongComponents sc = new StrongComponents(digraph);
		
		List<Set<Integer>> scc = new ArrayList<Set<Integer>>();
		
		for (int i = 0; i < sc.count(); i++) {
			scc.add(new HashSet<Integer>());
		}
		
		for (int v = 0; v < digraph.V(); v++) {
			scc.get(sc.id(v)).add(v);
		}
		
		System.out.println(scc);
	}
}
