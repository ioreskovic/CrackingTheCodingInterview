package com.lopina.exercises.chapter4.interview;

import java.util.ArrayList;
import java.util.List;

import com.lopina.exercises.chapter4.graphs.Graph;

import edu.princeton.cs.introcs.In;

public class TreeGraphCenter {
	
	private Graph graph;
	private int centerVertex;

	public TreeGraphCenter(Graph graph) {
		super();
		this.graph = graph;
		
		process();
	}

	private void process() {
		findCenter(graph);
	}

	private void findCenter(Graph graph) {
		LongestSimplePath lsp = new LongestSimplePath(graph);
		Iterable<Integer> longestSimplePath = lsp.getLongestSimplePath();
		
		List<Integer> listPath = new ArrayList<Integer>();
		
		for (Integer v : longestSimplePath) {
			listPath.add(v);
		}
		
		centerVertex = listPath.get(listPath.size() / 2);
	}
	
	public int getCenterVertex() {
		return centerVertex;
	}
	
	public static void main(String[] args) {
		TreeGraphCenter tgcSmall = new TreeGraphCenter(new Graph(new In("smallTree.txt")));
		System.out.println(tgcSmall.getCenterVertex());
		
		TreeGraphCenter tgcBig = new TreeGraphCenter(new Graph(new In("bigTree.txt")));
		System.out.println(tgcBig.getCenterVertex());
	}
	
}
