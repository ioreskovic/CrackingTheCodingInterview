package com.lopina.exercises.chapter4.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.chapter4.graphs.Graph;
import com.lopina.exercises.chapter4.graphs.search.DFSPaths;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class DFSPathsTest {

	@Test
	public void test() {
		Graph graph = new Graph(new In(new File("tinyCG.txt")));
		
		DFSPaths paths = new DFSPaths(graph, 0);
		
		for (int v = 0; v < graph.V(); v++) {
			if (paths.hasPathTo(v)) {
				StdOut.printf("%d to %d: ", 0, v);
				
				for (int x : paths.pathTo(v)) {
					StdOut.print(x + "-");
				}
				StdOut.println();
			} else {
				StdOut.printf("%d to %d:  not connected\n", 0, v);
			}
		}
	}

}
