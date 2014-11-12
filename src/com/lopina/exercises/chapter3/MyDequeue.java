package com.lopina.exercises.chapter3;

public interface MyDequeue<T> extends Iterable<T> {
	public void offerFirst(T item);
	public void offerLast(T item);
	public T pollFirst();
	public T pollLast();
	public int size();
}
