package com.lopina.important.take2.tree;

public interface Tree<T> {
	void add(T item);
	void remove(T item);
	T get(T item);
	boolean contains(T item);
}
