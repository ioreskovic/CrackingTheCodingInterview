package com.lopina.exercises.chapter4.graphs.search;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import com.lopina.exercises.chapter4.graphs.FlowEdge;
import com.lopina.exercises.chapter4.graphs.FlowNetwork;
import com.lopina.exercises.chapter4.graphs.FlowNode;

import edu.princeton.cs.introcs.In;


public class FordFulkerson {

	private Set<FlowNode> marked;
	private FlowEdge[] edgeTo;
	private double value;
	
	private int sourceVertexIndex;
	private int sinkVertexIndex;
	
	private FlowNetwork graph;
	
	public FordFulkerson(FlowNetwork graph, int sourceVertexIndex, int sinkVertexIndex) {
		if (sourceVertexIndex == sinkVertexIndex) {
			throw new IllegalArgumentException("Source equals sink");
		}
		
		if (!isFeasible(graph, sourceVertexIndex, sinkVertexIndex)) {
			throw new IllegalArgumentException("Initial flow is infeasible");
		}
		
		this.graph = graph;
		this.sourceVertexIndex = sourceVertexIndex;
		this.sinkVertexIndex = sinkVertexIndex;
		
		compute(graph, graph.node(sourceVertexIndex), graph.node(sinkVertexIndex));
	}

	private void compute(FlowNetwork graph, FlowNode source, FlowNode sink) {
		value = excess(graph, sink);
		
		while (hasAugmentingPath(graph, source, sink)) {
			double bottle = Double.POSITIVE_INFINITY;
			
			for (int v = sink.id(); v != source.id(); v = edgeTo[v].other(v)) {
				bottle = Math.min(bottle, edgeTo[v].residualCapacity(graph.node(v)));
			}
			
			for (int v = sink.id(); v != source.id(); v = edgeTo[v].other(v)) {
				edgeTo[v].addResidualFlowTo(graph.node(v), bottle);
			}
			
			value += bottle;
			
			System.out.println(graph);
		}
	}

	private boolean hasAugmentingPath(FlowNetwork graph, FlowNode source, FlowNode sink) {
		edgeTo = new FlowEdge[graph.nodes()];
		marked = new HashSet<FlowNode>();
		
		Deque<FlowNode> queue = new ArrayDeque<FlowNode>();
		queue.offerLast(source);
		marked.add(source);
		
		System.out.println("Augmenting path: ");
		
		while (!queue.isEmpty() && !marked.contains(sink)) {
			FlowNode node = queue.pollFirst();
			
			for (FlowEdge e : graph.adjAll(node)) {
				FlowNode next = e.other(node);
				
				if (e.residualCapacity(next) > 0) {
					if (!marked.contains(next)) {
						System.out.println("\t" + e);
						edgeTo[next.id()] = e;
						marked.add(next);
						queue.offerLast(next);
					}
				}
			}
		}
		System.out.println();
		
		return marked.contains(sink);
	}

	private double excess(FlowNetwork graph, FlowNode node) {
		double excess = 0.0;
		
		for (FlowEdge e : graph.adjAll(node)) {
			if (node == e.from()) {
				excess -= e.flow();
			} else if (node == e.to()) {
				excess += e.flow();
			} else {
				throw new IllegalStateException("Node " + node + " is not a part of edge " + e);
			}
		}
		
		return excess;
	}

	private boolean isFeasible(FlowNetwork graph, int sourceVertexIndex, int sinkVertexIndex) {
		double EPSILON = 1E-11;
		
		for (int v = 0; v < graph.nodes(); v++) {
			for (FlowEdge e : graph.adjAll(graph.node(v))) {
				if (e.flow() < -EPSILON || e.flow() > e.capacity() + EPSILON) {
					System.err.println("Edge does not satisfy capacity constraints: " + e.toString());
					return false;
				}
			}
		}
		
		if (Math.abs(value + excess(graph, graph.node(sourceVertexIndex))) > EPSILON) {
			System.err.println("Excess at source = " + excess(graph, graph.node(sourceVertexIndex)));
			System.err.println("Max flow = " + value);
			return false;
		}
		
		if (Math.abs(value - excess(graph, graph.node(sinkVertexIndex))) > EPSILON) {
			System.err.println("Excess at sink = " + excess(graph, graph.node(sinkVertexIndex)));
			System.err.println("Max flow = " + value);
			return false;
		}
		
		for (int v = 0; v < graph.nodes(); v++) {
			if (v == sourceVertexIndex || v == sinkVertexIndex) {
				continue;
			} else if (Math.abs(excess(graph, graph.node(v))) > EPSILON) {
				System.err.println("Net flow out of " + graph.node(v) + " does not equal zero");
				return false;
			}
		}
		
		return true;
	}
	
	public double getValue() {
		return value;
	}
	
	public Set<FlowNode> minCut() {
		hasAugmentingPath(graph, graph.node(sourceVertexIndex), graph.node(sinkVertexIndex));
		return new HashSet<FlowNode>(marked);
	}
	
	public static void main(String[] args) {
		FlowNetwork flowNetwork = new FlowNetwork(new In(new File("tinyFN.txt")));
		System.out.println("Flow Network: ");
		System.out.println(flowNetwork);
		System.out.println();
		FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, 0, flowNetwork.nodes() - 1);
		System.out.println("Max Flow: ");
		System.out.println(flowNetwork);
		System.out.println("Max Flow value: " + fordFulkerson.getValue());
		System.out.println();
		System.out.println("Min Cut: ");
		for (FlowNode node : fordFulkerson.minCut()) {
			System.out.println(node);
		}
	}
}
