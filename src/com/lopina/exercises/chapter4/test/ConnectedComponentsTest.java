package com.lopina.exercises.chapter4.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

import org.junit.Test;

import com.lopina.exercises.chapter4.graphs.Graph;
import com.lopina.exercises.chapter4.graphs.search.ConnectedComponents;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class ConnectedComponentsTest {

	@Test
	public void test() {
		Graph graph = new Graph(new In(new File("tinyCG.txt")));
		
		ConnectedComponents cc = new ConnectedComponents(graph);
		
		int M = cc.count();
        StdOut.println(M + " components");

        // compute list of vertices in each connected component
        Deque<Integer>[] components = (Deque<Integer>[]) new Deque[M];
        for (int i = 0; i < M; i++) {
            components[i] = new ArrayDeque<Integer>();
        }
        for (int v = 0; v < graph.V(); v++) {
            components[cc.id(v)].offerLast(v);
        }

        // print results
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
	}

}
