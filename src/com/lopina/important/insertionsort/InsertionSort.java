package com.lopina.important.insertionsort;

public class InsertionSort {
	public static <T extends Comparable<T>> void sort(T[] array) {
		int len = array.length;
		
		for (int i = len - 1; i > 0; i--) {
			if (array[i].compareTo(array[i - 1]) < 0) {
				swap(array, i, i - 1);
			}
		}
		
		for (int i = 2; i < len; i++) {
			T temp = array[i];
			int j = i;
			while (temp.compareTo(array[j - 1]) < 0) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
		}
		
		assert isSorted(array, 0, array.length);
	}
	
	public static <T extends Comparable<T>> void sort(T[] array, int from, int to) {
		for (int i = to; i > from; i--) {
			System.out.println("Touch: Iterate");
			System.out.println("Touch: Compare");
			if (array[i].compareTo(array[i - 1]) < 0) {
				System.out.println("Touch: Swap");
				swap(array, i, i - 1);
			}
		}
		
		for (int i = from + 2; i <= to; i++) {
			T temp = array[i];
			int j = i;
			while (temp.compareTo(array[j - 1]) < 0) {
				System.out.println("Touch: Compare");
				array[j] = array[j - 1];
				System.out.println("Touch: Swap");
				j--;
			}
			System.out.println("Touch: Swap");
			array[j] = temp;
		}
		
		assert isSorted(array, 0, array.length);
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
