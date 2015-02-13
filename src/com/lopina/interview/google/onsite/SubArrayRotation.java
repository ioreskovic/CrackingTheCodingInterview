package com.lopina.interview.google.onsite;

import java.util.Arrays;

public class SubArrayRotation {
	public static <T> void reverse(T[] array, int startIndex, int endIndex) {
		while (startIndex < endIndex) {
			swap(array, startIndex++, endIndex--);
		}
	}
	
	public static <T> void rotate(T[] array, int startIndex, int endIndex, int step) {
		step = step % (endIndex - startIndex + 1);
		
		reverse(array, startIndex, endIndex);
		reverse(array, startIndex, startIndex + step - 1);
		reverse(array, startIndex + step, endIndex);
	}
	
	public static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		Integer[] array = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(Arrays.toString(array));
		rotate(array, 2, 5, 3);
		System.out.println(Arrays.toString(array));
	}
}
