package com.lopina.exercises.chapter4.graphs;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.princeton.cs.introcs.In;

public class FlowNetwork {
	private int edges;
	
	private Map<FlowNode, List<FlowEdge>> adj;
	private Map<Integer, FlowNode> nodes;

	public FlowNetwork() {
		super();
		this.adj = new HashMap<FlowNode, List<FlowEdge>>();
		this.nodes = new HashMap<Integer, FlowNode>();
	}
	
	public FlowNetwork(In in) {
		this();
		int V = in.readInt();
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double capacity = in.readDouble();

            FlowNode from = this.nodes.getOrDefault(v, new FlowNode(v, Integer.toString(v)));
            FlowNode to = this.nodes.getOrDefault(w, new FlowNode(w, Integer.toString(w)));
            
            FlowEdge edge = new FlowEdge(from, to, capacity);
            
            addFlowEdge(edge);
        }
    }
	
	public int edges() {
		return this.edges;
	}
	
	public int nodes() {
		return this.nodes.size();
	}
	
	public FlowNode node(int flowNodeId) {
		return this.nodes.get(flowNodeId);
	}
	
	public void addFlowEdge(FlowEdge edge) {
		FlowNode from = edge.from();
		FlowNode to = edge.to();
		
		registerNode(from);
		registerNode(to);
		
		registerEdge(from, edge);
		registerEdge(to, edge);
		
		edges++;
	}

	private void registerNode(FlowNode node) {
		FlowNode existingNode = this.nodes.get(node.id());
		
		if (existingNode == null) {
			this.nodes.put(node.id(), node);
		} else if(existingNode != node) {
			throw new IllegalStateException("Node mismatch. Existing + " + existingNode + " vs new " + node);
		}

	}

	private void registerEdge(FlowNode node, FlowEdge edge) {
		List<FlowEdge> edgeList = adj.getOrDefault(node, new ArrayList<FlowEdge>());
		edgeList.add(edge);
		adj.put(node, edgeList);
	}
	
	public Iterable<FlowEdge> adjForwardEdges(FlowNode node) {
		List<FlowEdge> allAdjEdges = this.adj.getOrDefault(node, new ArrayList<FlowEdge>());
		
		List<FlowEdge> forwardAdjEdges = new ArrayList<FlowEdge>();
		
		for (FlowEdge edge : allAdjEdges) {
			if (edge.to() != node) {
				forwardAdjEdges.add(edge);
			}
		}
		
		return forwardAdjEdges;
	}
	
	public Iterable<FlowEdge> adjAll(FlowNode node) {
		return this.adj.getOrDefault(node, new ArrayList<FlowEdge>());
	}
	
	@Override
	public String toString() {
		String NEWLINE = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		
		sb.append("Flow Network - ").append(edges()).append(" edges, ").append(nodes()).append(" nodes").append(NEWLINE);
		for (FlowNode node : this.nodes.values()) {
			for (FlowEdge edge : adjForwardEdges(node)) {
				sb.append("\t").append(edge).append(NEWLINE);
			}
		}
		sb.append(NEWLINE);
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		FlowNetwork flowNetwork = new FlowNetwork(new In(new File("tinyFN.txt")));
		System.out.println(flowNetwork.toString());
	}
}
