
package com.lopina.important.take2.priorityQueue;

public class IndexedMaxPriorityQueue<T extends Comparable<T>> extends
		IndexedPriorityQueue<T> {

	protected IndexedMaxPriorityQueue(int NMAX) {
		super(NMAX);
	}

	@Override
	protected boolean orderViolated(T first, T second) {
		return first.compareTo(second) < 0;
	}

}
