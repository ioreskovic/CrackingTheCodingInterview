package com.lopina.exercises.chapter3;

public interface MyStack<T> extends Iterable<T> {
	public void push(T item);
	public T pop();
	public T peek();
	public int size();
}
