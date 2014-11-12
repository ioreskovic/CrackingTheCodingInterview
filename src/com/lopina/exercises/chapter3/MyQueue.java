package com.lopina.exercises.chapter3;

public interface MyQueue<T> extends Iterable<T> {
	public void enqueue(T item);
	public T dequeue();
	public int size();
}
