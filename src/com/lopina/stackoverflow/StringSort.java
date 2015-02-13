package com.lopina.stackoverflow;

public class StringSort {
	public static String insertionSort(String s) {
		return new String(insertionSort(s.toCharArray()));
	}

	private static String insertionSort(char[] array) {
		int len = array.length;
		
		for (int i = len - 1; i > 0; i--) {
			if (array[i] < array[i - 1]) {
				swap(array, i, i - 1);
			}
		}
		
		for (int i = 2; i < len; i++) {
			char temp = array[i];
			int j = i;
			while (temp < array[j - 1]) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
		}
		
		return new String(array);
	}
	
	private static  void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		String s = "alpha";
		String sSorted = insertionSort(s);
		System.out.println(sSorted);
	}
}
