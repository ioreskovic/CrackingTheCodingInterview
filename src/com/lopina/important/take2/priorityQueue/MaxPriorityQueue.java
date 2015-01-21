package com.lopina.important.take2.priorityQueue;

public class MaxPriorityQueue<T extends Comparable<T>> extends PriorityQueue<T> {

	public MaxPriorityQueue() {
		super();
	}

	public MaxPriorityQueue(int initialCapacity) {
		super(initialCapacity);
	}

	public MaxPriorityQueue(T[] elements) {
		super(elements);
	}

	@Override
	protected boolean violatesOrder(T firstFalue, T secondValue) {
		return firstFalue.compareTo(secondValue) < 0;
	}

	@Override
	protected PriorityQueue<T> create(int size) {
		return new MaxPriorityQueue<T>(size);
	}

}
