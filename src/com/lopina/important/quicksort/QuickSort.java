package com.lopina.important.quicksort;

import com.lopina.important.insertionsort.InsertionSort;

public class QuickSort {
	private static final int CUTOFF = 7;
	
	public static <T extends Comparable<T>> void sort(T[] array) {
		quickSort(array, 0, array.length - 1, array.length);
	}
	
	public static <T extends Comparable<T>> void partialSort(T[] array, int k) {
		quickSort(array, 0, array.length - 1, k);
	}
	
	public static <T extends Comparable<T>> T select(T[] array, int k) {
		return kThOrderStatistic(array, k);
	}
	
	public static <T extends Comparable<T>> int kThOrderStatisticIndex(T[] array, int k, int from, int to) {
		while (to > from) {
			int pivotIndex = partition(array, from, to, k);
			
			if (k == pivotIndex) {
				return pivotIndex;
			} else if (k < pivotIndex) {
				to = pivotIndex - 1;
			} else {
				from = pivotIndex + 1;
			}
		}
		
		return from;
	} 
	
	public static <T extends Comparable<T>> T kThOrderStatistic(T[] array, int k, int from, int to) {
		while (to > from) {
			int pivotIndex = partition(array, from, to);
			
			if (k == pivotIndex) {
				return array[pivotIndex];
			} else if (k < pivotIndex) {
				to = pivotIndex - 1;
			} else {
				from = pivotIndex + 1;
			}
		}
		
		return array[from];
	}
	
	public static <T extends Comparable<T>> T kThOrderStatistic(T[] array, int k) {
		int from = 0;
		int to = array.length - 1;
		
		while (to > from) {
			int pivotIndex = partition(array, from, to);
			
			if (k == pivotIndex) {
				return array[pivotIndex];
			} else if (k < pivotIndex) {
				to = pivotIndex - 1;
			} else {
				from = pivotIndex + 1;
			}
		}
		
		return array[from];
	}
	
	private static <T extends Comparable<T>> void quickSort(T[] array, int from, int to, int k) {
		if (from >= to) {
			return;
		}
		
		if (to - from + 1 <= CUTOFF) {
			InsertionSort.sort(array, from, to);
		}
		
		int pivotIndex = partition(array, from, to);
		quickSort(array, from, pivotIndex - 1, k);
		if (pivotIndex < k - 1) {
			quickSort(array, pivotIndex + 1, to, k);
		}
		assert isSorted(array, from, k - 1);
	}
	
	private static <T extends Comparable<T>> int partition(T[] array, int from, int to) {
		int pivotIndex = PivotSelectionStrategyFactory.getMedianOfMediansPivotSelectionStrategy().selectPivot(array, from, to);
		System.out.println("Touch: Swap");
		swap(array, from, pivotIndex);
		
		int i = from;
		int j = to + 1;
		
		T pivot = array[from];
		
		while (true) {
			while (array[++i].compareTo(pivot) <= 0) {
				System.out.println("Touch: Iterate");
				System.out.println("Touch: Compare");
				if (i == to) {
					break;
				}
			}
			
			while (array[--j].compareTo(pivot) >= 0) {
				System.out.println("Touch: Iterate");
				System.out.println("Touch: Compare");
				if (j == from) {
					break;
				}
			}
			
			if (i >= j) {
				break;
			}
			
			System.out.println("Touch: Swap");
			swap(array, i, j);
		}
		
		System.out.println("Touch: Swap");
		swap(array, from, j);
		
		return j;
	}
	
	private static <T extends Comparable<T>> int partition(T[] array, int from, int to, int pivotIndex) {
		swap(array, from, pivotIndex);
		
		int i = from;
		int j = to + 1;
		
		T pivot = array[from];
		
		while (true) {
			while (array[++i].compareTo(pivot) <= 0) {
				if (i == to) {
					break;
				}
			}
			
			while (array[--j].compareTo(pivot) >= 0) {
				if (j == from) {
					break;
				}
			}
			
			if (i >= j) {
				break;
			}
			
			swap(array, i, j);
		}
		
		swap(array, from, j);
		
		return j;
	}
	
	private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static <T extends Comparable<T>> boolean isSorted(T[] array, int from, int to) {
		for (int i = from; i < to; i++) {
			if (array[i].compareTo(array[i + 1]) > 0) {
				return false;
			}
		}
		
		return true;
	}
	
}
