package com.lopina.interview.palantir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.lopina.exercises.chapter1.test.Coordinate;
import com.lopina.exercises.chapter4.graphs.DirectedEdge;
import com.lopina.exercises.chapter4.graphs.EdgeWeightedDigraph;
import com.lopina.exercises.chapter4.graphs.search.DijkstraDAGShortestPathTree;

public class SolutionWork {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int[][] waitTimes = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				waitTimes[i][j] = scanner.nextInt();
			}
		}

		
		// O(M * N)
		int[] distanceToWork = dijkstra(waitTimes);
		
//		System.out.println(Arrays.toString(distanceToWork));
		
		List<Coordinate> employees = new ArrayList<Coordinate>();
		int e = scanner.nextInt();
		int[] vi = new int[e];
		for (int k = 0; k < e; k++) {
			int vertexIndex = scanner.nextInt() * n + scanner.nextInt();
			vi[k] = distanceToWork[vertexIndex];
		}
		
		for (int vix : vi) {
			System.out.println(vix);
		}
	}

	private static int[] dijkstra(int[][] waitTimes) {
		int m = waitTimes.length;
		int n = waitTimes[0].length;
		
		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(m * n + 1);
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i < m - 1) {
					graph.addEdge(new DirectedEdge((i + 1) * n + j, i * n + j, waitTimes[i][j]));
				}
				
				if (j < n - 1) {
					graph.addEdge(new DirectedEdge((i) * n + j + 1, i * n + j, waitTimes[i][j]));
				}
			}
		}
		
		graph.addEdge(new DirectedEdge(m * n, m * n - 1, waitTimes[m - 1][n - 1]));
		
		DijkstraDAGShortestPathTree d = new DijkstraDAGShortestPathTree(graph, m * n);
		
		int[] distances = new int[m * n];
		
		for (int i = 0; i < m * n; i++) {
			distances[i] = (int) d.distance(m * n, i);
		}
		
		return distances;
	}
}
