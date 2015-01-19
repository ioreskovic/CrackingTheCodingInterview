package com.lopina.important.quicksort;

import java.util.Arrays;

import com.lopina.important.insertionsort.InsertionSort;
import com.lopina.important.mergesort.MergeSort;

public class MedianOfMediansPivotSelectionStrategy implements PivotSelectionStrategy {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Comparable<T>> int selectPivot(T[] array, int from, int to) {
		T pivot = select(array, from, to, (to - from) / 2);
		
		for (int i = from; i <= to; i++) {
			System.out.println("Touch: Iterate");
			System.out.println("Touch: Compare");
			if (array[i].equals(pivot)) {
				return i;
			}
		}
		
		return from;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> T select(T[] array, int from, int to, int k) {
		if (to - from <= 10) {
			InsertionSort.sort(array, from, to);
			return array[from + k];
		}
		
		int nPartitions = (int) Math.ceil((to - from + 1) / 5.0);
		T[] medians = (T[]) new Comparable[nPartitions];
		
		for (int i = 0; i < nPartitions; i++) {
			int fromIndex = from + i * 5;
			int toIndex = Math.min(from + i * 5 + 5 - 1, to);
			medians[i] = select(array, fromIndex, toIndex, (toIndex - fromIndex) / 2);
		}
		T median = select(medians, 0, nPartitions - 1, (nPartitions) / 2);
		
		return median;
	}

}
