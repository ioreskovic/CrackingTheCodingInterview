package com.lopina.important.take2.priorityQueue;

public class IndexedMinPriorityQueue<T extends Comparable<T>> extends
		IndexedPriorityQueue<T> {

	protected IndexedMinPriorityQueue(int NMAX) {
		super(NMAX);
	}

	@Override
	protected boolean orderViolated(T first, T second) {
		return first.compareTo(second) > 0;
	}

}
