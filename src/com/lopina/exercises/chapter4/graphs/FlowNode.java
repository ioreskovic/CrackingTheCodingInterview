package com.lopina.exercises.chapter4.graphs;

import java.util.HashSet;
import java.util.Set;

public class FlowNode {
	private final int id;
	private final String description;
	private Set<FlowEdge> inEdges;
	private Set<FlowEdge> outEdges;
	
	public FlowNode(int id, String description) {
		super();
		this.id = id;
		this.description = description;
		
		this.inEdges = new HashSet<FlowEdge>();
		this.outEdges = new HashSet<FlowEdge>();
	}
	
	public FlowNode(FlowNode other) {
		this(other.id, other.description);
		
		for (FlowEdge inEdge : other.inEdges) {
			this.inEdges.add(new FlowEdge(inEdge));
		}
		
		for (FlowEdge outEdge : other.outEdges) {
			this.outEdges.add(new FlowEdge(outEdge));
		}
	}
	
	public void addInEdge(FlowEdge inEdge) {
		this.inEdges.add(inEdge);
	}
	
	public void addOutEdge(FlowEdge outEdge) {
		this.outEdges.add(outEdge);
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
