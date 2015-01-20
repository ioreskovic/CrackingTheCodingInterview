package com.lopina.important.take2.insertionSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class InsertionSort {
	private static final Random random = new Random(System.currentTimeMillis());
	
	public static <T> void sort(T[] array, Comparator<T> comparator) {
		for (int i = array.length - 1; i > 0; i--) {
			if (comparator.compare(array[i], array[i - 1]) < 0) {
				swap(array, i, i - 1);
			}
		}
		
		for (int i = 2; i < array.length; i++) {
			int j = i;
			T temp = array[i];
			
			while (comparator.compare(temp, array[j - 1]) < 0) {
				array[j] = array[j - 1];
				j--;
			}
			
			array[j] = temp;
		}
	}
	
	private static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
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
		InsertionSort.sort(randomArray, naturalComparator);
		System.out.println(Arrays.toString(randomArray));
		Arrays.sort(randomArray, naturalComparator);
		System.out.println(Arrays.toString(randomArray));
	}
}
