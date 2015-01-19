package com.lopina.important.quicksort.test;

import java.util.Arrays;

import com.lopina.important.quicksort.PivotSelectionStrategy;
import com.lopina.important.quicksort.QuickSort;

public class MedianPivotSelectionStrategy implements PivotSelectionStrategy {

	@Override
	public <T extends Comparable<T>> int selectPivot(T[] array, int from, int to) {
		T[] temp = Arrays.copyOf(array, to - from + 1);
		int halfLen = (to - from + 1) / 2;
//		return QuickSort.kThOrderStatisticIndex(temp, halfLen, 0, to - from) + from;
		return QuickSort.kThOrderStatisticIndex(array, halfLen, 0, to - from) + from;
	}

}
