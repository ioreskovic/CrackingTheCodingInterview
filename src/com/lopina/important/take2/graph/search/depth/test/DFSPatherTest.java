package com.lopina.important.take2.graph.search.depth.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lopina.important.take2.graph.Edge;
import com.lopina.important.take2.graph.directed.DirectedEdge;
import com.lopina.important.take2.graph.directed.DirectedGraph;
import com.lopina.important.take2.graph.directed.DirectedWeightedEdge;
import com.lopina.important.take2.graph.directed.DirectedWeightedGraph;
import com.lopina.important.take2.graph.search.depth.DFSPather;
import com.lopina.important.take2.graph.undirected.UndirectedEdge;
import com.lopina.important.take2.graph.undirected.UndirectedGraph;
import com.lopina.important.take2.graph.undirected.UndirectedWeightedEdge;
import com.lopina.important.take2.graph.undirected.UndirectedWeightedGraph;

public class DFSPatherTest {

	private static UndirectedGraph undirectedGraph;
	private static UndirectedWeightedGraph undirectedWeightedGraph;
	private static DirectedGraph directedGraph;
	private static DirectedWeightedGraph directedWeightedGraph;
	private static final int vertices = 10;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		undirectedGraph = new UndirectedGraph(vertices);
		undirectedWeightedGraph = new UndirectedWeightedGraph(vertices);
		directedGraph = new DirectedGraph(vertices);
		directedWeightedGraph = new DirectedWeightedGraph(vertices);
		
		addEdge(9, 8, 1.0);
		
		addEdge(8, 7, 2.0);
		addEdge(8, 5, 2.0);
		
		addEdge(7, 6, 1.0);
		addEdge(7, 4, 3.0);
		
		addEdge(6, 3, 2.0);
		
		addEdge(5, 4, 3.0);
		addEdge(5, 2, 1.0);
		
		addEdge(4, 3, 2.0);
		addEdge(4, 1, 2.0);
		
		addEdge(3, 0, 1.0);
		
		addEdge(2, 1, 2.0);
		
		addEdge(1, 0, 1.0);
	}

	private static void addEdge(int from, int to, double weight) {
		undirectedGraph.addEdge(new UndirectedEdge(from, to));
		undirectedWeightedGraph.addEdge(new UndirectedWeightedEdge(from, to, weight));
		directedGraph.addEdge(new DirectedEdge(from, to));
		directedWeightedGraph.addEdge(new DirectedWeightedEdge(from, to, weight));
	}

	@Test
	public void testUndirectedGraph() {
		DFSPather<UndirectedEdge> pather = new DFSPather<UndirectedEdge>(undirectedGraph, 9);
		System.out.println(pather.pathTo(4));
		System.out.println(pather.pathToAsEdges(4));
	}
	
	@Test
	public void testUndirectedWeighedGraph() {
		DFSPather<UndirectedWeightedEdge> pather = new DFSPather<UndirectedWeightedEdge>(undirectedWeightedGraph, 9);
		System.out.println(pather.pathTo(4));
		System.out.println(pather.pathToAsEdges(4));
	}
	
	@Test
	public void testDirectedGraph() {
		DFSPather<DirectedEdge> pather = new DFSPather<DirectedEdge>(directedGraph, 9);
		System.out.println(pather.pathTo(4));
		System.out.println(pather.pathToAsEdges(4));
	}
	
	@Test
	public void testDirectedWeighedGraph() {
		DFSPather<DirectedWeightedEdge> pather = new DFSPather<DirectedWeightedEdge>(directedWeightedGraph, 9);
		System.out.println(pather.pathTo(4));
		System.out.println(pather.pathToAsEdges(4));
	}
	
	@After
	public void tearDown() {
		System.out.println();
	}
	
}
