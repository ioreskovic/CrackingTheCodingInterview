package com.lopina.exercises.chapter4.graphs.search;

import java.io.File;
import java.util.Iterator;

import com.lopina.exercises.chapter4.graphs.Graph;

import edu.princeton.cs.introcs.In;

public class DegreesOfSeparation {
	
	private Graph graph;
	
	private Integer[][] degrees;

	public DegreesOfSeparation(Graph graph) {
		super();
		this.graph = graph;
		
		int vertices = graph.V();
		
		this.degrees = new Integer[vertices][vertices];
	}
	
	public int getDegrees(int v, int w) {
		if (degrees[v][w] == null) {
			
			BFSPaths bfs = new BFSPaths(graph, v);
			
			for (int x = 0; x < graph.V(); x++) {
				if (bfs.hasPathTo(x)) {
					this.degrees[v][x] = getSteps(bfs.pathTo(x));
				} else {
					this.degrees[v][x] = -1;
				}
				this.degrees[x][v] = this.degrees[v][x];
			}
		}
		
		return degrees[v][w]; 
	}

	private Integer getSteps(Iterable<Integer> path) {
		int steps = -1;
		
		for (Iterator<Integer> it = path.iterator(); it.hasNext(); it.next()) {
			steps++;
		}
		
		return steps;
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(new In(new File("tinyCG.txt")));
		DegreesOfSeparation dos = new DegreesOfSeparation(graph);
		
		for (int i = 0; i < graph.V(); i++) {
			for (int j = 0; j < graph.V(); j++) {
				System.out.println("DOS[" + i + "," + j + "]=" + dos.getDegrees(i, j));
			}
		}
		
		for (int i = 0; i < graph.V(); i++) {
			for (int j = 0; j < graph.V(); j++) {
				System.out.println("XXX[" + i + "," + j + "]=" + dos.getDegrees(i, j));
			}
		}
	}
}
