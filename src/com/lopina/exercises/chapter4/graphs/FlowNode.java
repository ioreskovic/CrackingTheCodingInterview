package com.lopina.exercises.chapter4.graphs;

import java.util.HashMap;
import java.util.Map;

public class FlowNode {
	private final int id;
	private final String description;
	private Map<FlowNode, FlowEdge> inEdges;
	private Map<FlowNode, FlowEdge> outEdges;
	
	public FlowNode(int id, String description) {
		super();
		this.id = id;
		this.description = description;
		
		this.inEdges = new HashMap<FlowNode, FlowEdge>();
		this.outEdges = new HashMap<FlowNode, FlowEdge>();
	}
	
	public FlowNode(FlowNode other) {
		this(other.id, other.description);
		
		for (FlowEdge inEdge : other.inEdges.values()) {
			FlowEdge copyInEdge = new FlowEdge(inEdge);
			this.inEdges.put(copyInEdge.from(), copyInEdge);
		}
		
		for (FlowEdge outEdge : other.outEdges.values()) {
			FlowEdge copyOutEdge = new FlowEdge(outEdge);
			this.outEdges.put(copyOutEdge.to(), copyOutEdge);
		}
	}
	
	public void addInEdge(FlowEdge inEdge) {
		this.inEdges.put(inEdge.from(), inEdge);
	}
	
	public void addOutEdge(FlowEdge outEdge) {
		this.outEdges.put(outEdge.to(), outEdge);
	}
	
	public int id() {
		return id;
	}
	
	public String desctiption() {
		return description;
	}
	
	@Override
	public String toString() {
		return "FlowNode[" + id + "|" + description + "]";
	}
}
