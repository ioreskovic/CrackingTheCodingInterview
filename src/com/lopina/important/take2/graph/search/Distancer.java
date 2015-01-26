package com.lopina.important.take2.graph.search;

import com.lopina.important.take2.graph.Edge;

public interface Distancer<T extends Edge> {
	int distanceTo(int vertexIndex);
}
