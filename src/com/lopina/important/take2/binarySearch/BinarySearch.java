package com.lopina.important.take2.binarySearch;


public class BinarySearch {
	public static <T extends Comparable<T>> int indexOf(T[] array, T element, Predicate<T> predicate) {
		return binarySearch(array, element, predicate, 0, array.length - 1);
	}
	
	public static <T extends Comparable<T>> int binarySearch(T[] array, T element, Predicate<T> predicate, int fromIndex, int toIndex) {
		while (fromIndex <= toIndex) {
			int pivotIndex = (fromIndex + toIndex) / 2;
			T pivot = array[pivotIndex];
			
			int testResult = predicate.test(element, pivot);
			
			if (testResult == 0) {
				return pivotIndex;
			} else if (testResult < 0) {
				toIndex = pivotIndex - 1;
			} else {
				fromIndex = pivotIndex + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Predicate<Integer> compareTo = new Predicate<Integer>() {
			
			@Override
			public int test(Integer first, Integer second) {
				return first.compareTo(second);
			}
		};
		
		Integer[] numbers = new Integer[] { -11, -9, -7, -5, -3, -2, -1, 0, 1, 2, 4, 6, 7, 11 };
		System.out.println("Index of -12: " + BinarySearch.indexOf(numbers, -12, compareTo));
		System.out.println("Index of -11: " + BinarySearch.indexOf(numbers, -11, compareTo));
		System.out.println("Index of -3: " + BinarySearch.indexOf(numbers, -3, compareTo));
		System.out.println("Index of 0: " + BinarySearch.indexOf(numbers, 0, compareTo));
		System.out.println("Index of 2: " + BinarySearch.indexOf(numbers, 2, compareTo));
		System.out.println("Index of 8: " + BinarySearch.indexOf(numbers, 8, compareTo));
		System.out.println("Index of 11: " + BinarySearch.indexOf(numbers, 11, compareTo));
		System.out.println("Index of 14: " + BinarySearch.indexOf(numbers, 14, compareTo));
	}
}
