package com.lopina.exercises.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MyTwoStackQueue<T> implements MyQueue<T> {

	private Deque<T> pushStack = null;
	private Deque<T> popStack = null;
	
	public MyTwoStackQueue() {
		super();
		
		this.pushStack = new ArrayDeque<T>();
		this.popStack = new ArrayDeque<T>();
	}

	@Override
	public Iterator<T> iterator() {
		if (this.popStack.isEmpty()) {
			moveItems(this.pushStack, this.popStack);
		}
		
		return this.popStack.iterator();
	}

	@Override
	public void enqueue(T item) {
//		moveItems(this.popStack, this.pushStack);
		this.pushStack.push(item);
	}

	@Override
	public T dequeue() {
		moveItems(this.pushStack, this.popStack);
		return this.popStack.pop();
	}

	private void moveItems(Deque<T> source, Deque<T> destination) {
		if (destination.isEmpty()) {
			while (!source.isEmpty()) {
				destination.push(source.pop());
			}
		}
	}

	@Override
	public int size() {
		return this.pushStack.size() + this.popStack.size();
	}

}
