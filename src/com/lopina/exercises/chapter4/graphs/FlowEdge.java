package com.lopina.exercises.chapter4.graphs;

public class FlowEdge {
	private final FlowNode from;
	private final FlowNode to;
	private final double capacity;
	private double flow;
	
	public FlowEdge(FlowNode from, FlowNode to, double capacity, double flow) {
		super();
		this.from = from;
		this.to = to;
		this.capacity = capacity;
		this.flow = flow;
	}
	
	public FlowEdge(FlowNode from, FlowNode to, double capacity) {
		this(from, to, capacity, 0.0);
	}
	
	public FlowEdge(FlowEdge other) {
		this(new FlowNode(other.from), new FlowNode(other.to), other.capacity, other.flow);
	}
	
	public FlowNode from() {
		return this.from;
	}
	
	public FlowNode to() {
		return this.to;
	}
	
	public double capacity() {
		return this.capacity;
	}
	
	public double flow() {
		return this.flow;
	}
	
	public FlowNode other(FlowNode node) {
		if (node == this.from) {
			return this.to;
		} else if (node == this.to) {
			return this.from;
		} else {
			throw new IllegalArgumentException("Node " + node.toString() + " is not a node of this edge + " + this.toString());
		}
	}
	
	public int other(int v) {
		if (v == this.from.id()) {
			return this.to.id();
		} else if (v == this.to.id()) {
			return this.from.id();
		} else {
			throw new IllegalArgumentException("Node " + v + " is not a node of this edge + " + this.toString());
		}
	}
	
	public double residualCapacity(FlowNode node) {
		if (node == this.to) {
			return this.capacity - this.flow;
		} else if (node == this.from) {
			return this.flow;
		} else {
			throw new IllegalArgumentException("Node " + node.toString() + " is not a node of this edge + " + this.toString());
		}
	}
	
	public void addResidualFlowTo(FlowNode node, double delta) {
		if (node == this.to) {
			this.flow += delta;
		} else if (node == this.from) {
			this.flow -= delta;
		} else {
			throw new IllegalArgumentException("Node " + node.toString() + " is not a node of this edge + " + this.toString());
		}
	}
	
	@Override
	public String toString() {
		return String.format(">>==%s==(%.2f/%.2f)==%s==>>", this.from.toString(), this.flow, this.capacity, this.to.toString());
	}
	
	public static void main(String[] args) {
		FlowNode from = new FlowNode(1, "One");
		FlowNode to = new FlowNode(2, "Two");
		
		FlowEdge edge = new FlowEdge(from, to, 15.0);
		
		System.out.println(edge.toString());
	}

}
