package com.lopina.important.take2.mergeSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MergeSort {
	private static final Random random = new Random(System.currentTimeMillis());
	
	public static <T> void sort(T[] array, Comparator<T> comparator) {
		mergeSort(array, comparator, 0, array.length - 1);
	}
	
	public static <T> void mergeSort(T[] array, Comparator<T> comparator, int fromIndex, int toIndex) {
		if (fromIndex >= toIndex) {
			return;
		}
		
		int breakingPoint = (fromIndex + toIndex) / 2;
		mergeSort(array, comparator, fromIndex, breakingPoint);
		mergeSort(array, comparator, breakingPoint + 1, toIndex);
		merge(array, comparator, fromIndex, breakingPoint, breakingPoint + 1, toIndex);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void merge(T[] array, Comparator<T> comparator, int firstFromIndex, int firstToIndex, int secondFromIndex, int secondToIndex) {
		int i = firstFromIndex;
		int j = secondFromIndex;
		int k = 0;
		
		T[] temp = (T[]) new Object[secondToIndex - firstFromIndex + 1];
		
		while (i <= firstToIndex && j <= secondToIndex) {
			if (comparator.compare(array[i], array[j]) < 0) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}
		
		while (i <= firstToIndex) {
			temp[k++] = array[i++];
		}
		
		while (j <= secondToIndex) {
			temp[k++] = array[j++];
		}
		
		for (k = 0; k < temp.length; k++) {
			array[firstFromIndex + k] = temp[k];
		}
	}
	
	public static void main(String[] args) {
		Comparator<Integer> naturalComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		
		Integer[] randomArray;
		
		randomArray = new Integer[15];
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = random.nextInt(6) + i*6;
		}
		List<Integer> list = Arrays.asList(randomArray);
		Collections.shuffle(list, random);
		randomArray = list.toArray(randomArray);
		
		System.out.println(Arrays.toString(randomArray));
		MergeSort.sort(randomArray, naturalComparator);
		System.out.println(Arrays.toString(randomArray));
	}
}
