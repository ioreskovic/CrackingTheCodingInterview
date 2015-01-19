package com.lopina.important.mergesort;

public class MergeSort {
	public static <T extends Comparable<T>> void mergesort(T[] array) {
		sort(array, 0, array.length - 1);
	}
	
	public static <T extends Comparable<T>> void sort(T[] array, int from, int to) {
		if (from >= to) {
			return;
		}
		
		sort(array, from, (from + to) / 2);
		sort(array, (from + to) / 2 + 1, to);
		merge(array, from, (from + to) / 2, (from + to) / 2 + 1, to);
		assert isSorted(array, from, to);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void merge(T[] array, int fromFirst, int toFirst, int fromSecond, int toSecond) {
		int tempLen = toFirst - fromFirst + 1 + toSecond - fromSecond + 1;
		T[] temp = (T[]) new Comparable[tempLen];
		int tempIndex = 0;
		
		int firstIndex = fromFirst;
		int secondIndex = fromSecond;
		
		while (firstIndex <= toFirst && secondIndex <= toSecond) {
			T firstElement = array[firstIndex];
			T secondElement = array[secondIndex];
			
			if (firstElement.compareTo(secondElement) < 0) {
				temp[tempIndex++] = firstElement;
				firstIndex++;
			} else {
				temp[tempIndex++] = secondElement;
				secondIndex++;
			}
		}
		
		while (firstIndex <= toFirst) {
			temp[tempIndex++] = array[firstIndex++];
		}
		
		while (secondIndex <= toSecond) {
			temp[tempIndex++] = array[secondIndex++];
		}
		
		for (int i = 0; i < temp.length; i++) {
			array[fromFirst + i] = temp[i];
		}
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
