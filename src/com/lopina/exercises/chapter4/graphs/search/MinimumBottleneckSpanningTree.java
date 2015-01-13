package com.lopina.exercises.chapter4.graphs.search;

import com.lopina.exercises.chapter4.graphs.Edge;
import com.lopina.exercises.chapter4.graphs.EdgeWeightedGraph;
import com.lopina.exercises.chapter4.graphs.MinimalSpanningTree;

/**
 * Every MST is a MBST.<br/>
 * Proof by contradiction:</br>
 * There exists MST that is not MBST.</br>
 * Therefore, we can substitute edge <i>e</i> of weight <i>w<sub>i</sub></i> with edge <i>e'</i> of weight <i>w'<sub>i</sub></i> that still forms ST such that the max weight edge oft the new ST is lower.</br>
 * In essence, that means that <i>w<sub>i</sub></i> > <i>w'<sub>i</sub></i></br>
 * The total weight of the new ST is SUM(j, <i>w'<sub>j</sub></i>) = (SUM(, <i>w<sub>j</sub></i>) + (-<i>w<sub>i</sub></i> + <i>w'<sub>i</sub></i>))</br>
 * Since <i>w<sub>i</sub></i> > <i>w'<sub>i</sub></i></br>, then (-<i>w<sub>i</sub></i> + <i>w'<sub>i</sub></i>) < 0 and SUM(j, <i>w'<sub>j</sub></i>) < SUM(j, <i>w<sub>j</sub></i>)</br>
 * Which means that old ST was MST, therefore the initial hypothesis is false and EVERY MST is MBST.
 * @author eivaore
 *
 */
public class MinimumBottleneckSpanningTree {

	Iterable<Edge> edges;
	
	public MinimumBottleneckSpanningTree(EdgeWeightedGraph graph) {
		MinimalSpanningTree mst = new KruskalMST(graph);
		edges = mst.edges();
	}
	
	public Iterable<Edge> edges() {
		return edges;
	}
}
