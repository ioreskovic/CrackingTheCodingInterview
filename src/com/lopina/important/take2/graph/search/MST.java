package com.lopina.important.take2.graph.search;

import com.lopina.important.take2.graph.Edge;
import com.lopina.important.take2.graph.Weightable;

public interface MST<T extends Edge & Weightable & Comparable<T>> {
	public Iterable<T> edges();
	public double weight();
}
