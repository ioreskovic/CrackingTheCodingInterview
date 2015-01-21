package com.lopina.important.take2.priorityQueue;

public class MinPriorityQueue<T extends Comparable<T>> extends PriorityQueue<T> {

	public MinPriorityQueue() {
		super();
	}

	public MinPriorityQueue(int initialCapacity) {
		super(initialCapacity);
	}

	public MinPriorityQueue(T[] elements) {
		super(elements);
	}

	@Override
	protected boolean violatesOrder(T firstFalue, T secondValue) {
		return firstFalue.compareTo(secondValue) > 0;
	}

	@Override
	protected PriorityQueue<T> create(int size) {
		return new MinPriorityQueue<T>(size);
	}

}
