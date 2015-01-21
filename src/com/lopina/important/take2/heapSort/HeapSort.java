package com.lopina.important.take2.heapSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HeapSort {
	private static final Random random = new Random(System.currentTimeMillis());
	
	public static <T extends Comparable<T>> void sort(T[] array) {
		heapsort(array);
	}
	
	public static <T extends Comparable<T>> void heapsort(T[] array) {
		int len = array.length;
		
		for (int k = len / 2; k >= 1; k--) {
			sink(array, k, len);
		}
		
		while (len > 0) {
			swap(array, 1, len--);
			sink(array, 1, len);
		}
		
	}
	
	private static <T extends Comparable<T>> boolean less(T[] array, int firstIndex, int secondIndex) {
		return less(array[firstIndex - 1], array[secondIndex - 1]);
	}
	
	private static <T extends Comparable<T>> boolean less(T first, T second) {
		return first.compareTo(second) < 0;
	}
	
	private static <T extends Comparable<T>> void swap(T[] array, int firstIndex, int secondIndex) {
		T temp = array[firstIndex - 1];
		array[firstIndex - 1] = array[secondIndex - 1];
		array[secondIndex - 1] = temp;
	}
	
	private static <T extends Comparable<T>> void sink(T[] array, int parentIndex, int len) {
		// while there exists at least one child
		while(2 * parentIndex <= len) {
			int childIndex = 2 * parentIndex;
			// select bigger child
			if (childIndex < len && less(array, childIndex, childIndex + 1)) {
				childIndex++;
			}
			
			if (!less(array, parentIndex, childIndex)) {
				break;
			}
			
			// if the parent is smaller than the bigger child, swap them
			swap(array, parentIndex, childIndex);
			
			// move down
			parentIndex = childIndex;
		}
	}
	
	public static void main(String[] args) {
		Integer[] randomArray;
		
		randomArray = new Integer[15];
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = random.nextInt(6) + i*6;
		}
		List<Integer> list = Arrays.asList(randomArray);
		Collections.shuffle(list, random);
		randomArray = list.toArray(randomArray);
		
		System.out.println(Arrays.toString(randomArray));
		HeapSort.sort(randomArray);
		System.out.println(Arrays.toString(randomArray));
		Arrays.sort(randomArray);
		System.out.println(Arrays.toString(randomArray));
	}
	
}
