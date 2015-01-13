package com.lopina.exercises.chapter4.interview;

import com.lopina.exercises.chapter4.graphs.Graph;
import com.lopina.exercises.chapter4.graphs.search.BFSPaths;

import edu.princeton.cs.introcs.In;

public class LongestSimplePath {

	private Graph graph;
	private Iterable<Integer> longestSimplePath;

	public LongestSimplePath(Graph graph) {
		super();
		this.graph = graph;
		
		process();
	}

	private void process() {
		lsp(graph);
	}

	/**
	 * This is a 2-step algorithm:</br>
	 * </br>
	 * Step 0: Select random node as initial node</br>
	 * Step 1: Finds longest simple path to most distant node from initial node</br>
	 * Step 2: Finds longest simple path from 1st most distant node</br>
	 * </br>
	 * Explanation:</br>
	 * If the initial node is the edge node of the longest path then the longest path is calculated in 1st pass</br>
	 * If it is not, then there exists a node that is further from initial node than the 1st node and BFS will get it.</br>
	 * @param graph the tree graph to find longest simple path in
	 */
	private void lsp(Graph graph) {
		BFSPaths bfsPaths1 = new BFSPaths(graph, 0);
		int pass1Vertex = bfsPaths1.getMaxDistanceVertex();
		
		BFSPaths bfsPaths2 = new BFSPaths(graph, pass1Vertex);
		int pass2Vertex = bfsPaths2.getMaxDistanceVertex();
		
		this.longestSimplePath = bfsPaths2.pathTo(pass2Vertex);
	}
	
	public Iterable<Integer> getLongestSimplePath() {
		return longestSimplePath;
	}
	
	public static void main(String[] args) {
		LongestSimplePath lspSmall = new LongestSimplePath(new Graph(new In("smallTree.txt")));
		System.out.println(lspSmall.getLongestSimplePath());
		
		LongestSimplePath lspBig = new LongestSimplePath(new Graph(new In("bigTree.txt")));
		System.out.println(lspBig.getLongestSimplePath());
	}
}
