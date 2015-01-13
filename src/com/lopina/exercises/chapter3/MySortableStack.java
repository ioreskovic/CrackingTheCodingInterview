package com.lopina.exercises.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MySortableStack<T extends Comparable<T>> implements MyStack<T> {

	private Deque<T> stack = null;
	
	public MySortableStack() {
		this.stack = new ArrayDeque<T>();
	}
	
	@Override
	public Iterator<T> iterator() {
		return this.stack.iterator();
	}

	@Override
	public void push(T item) {
		this.stack.push(item);
	}

	@Override
	public T pop() {
		return this.stack.pop();
	}

	@Override
	public T peek() {
		return this.stack.peek();
	}

	@Override
	public int size() {
		return this.stack.size();
	}
	
	public void sort() {
		Deque<T> auxStack = new ArrayDeque<T>();
		T tmp = null;
		
		while (!this.stack.isEmpty()) {
			tmp = this.stack.pop();
			
			if (shouldPushValue(tmp, auxStack)) {
				auxStack.push(tmp);
			} else {
				sift(auxStack, this.stack);
				auxStack.push(tmp);
			}
		}
		
		sift(auxStack, this.stack);
	}

	private void sift(Deque<T> source, Deque<T> destination) {
		while (!source.isEmpty()) {
			destination.push(source.pop());
		}
	}

	private boolean shouldPushValue(T value, Deque<T> orderedStack) {
		if (orderedStack.isEmpty()) {
			return true;
		}
		
		T peekValue = orderedStack.peek();
		
		return (value.compareTo(peekValue) < 0);
	}

	
}
