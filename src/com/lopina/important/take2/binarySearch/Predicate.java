package com.lopina.important.take2.binarySearch;

public interface Predicate<T extends Comparable<T>> {
	public int test(T first, T second);
}
