package com.lopina.important.quicksort;

public interface PivotSelectionStrategy {
	<T extends Comparable<T>> int selectPivot(T[] array, int from, int to);
}
