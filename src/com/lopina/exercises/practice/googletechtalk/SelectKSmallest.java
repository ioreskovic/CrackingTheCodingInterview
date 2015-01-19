package com.lopina.exercises.practice.googletechtalk;

import java.util.Arrays;
import java.util.Random;

public class SelectKSmallest {
	public static int[] selectKSmallest(int[] array, int k) {
		partialQuickSort(array, 0, array.length - 1, k);
		return Arrays.copyOfRange(array, 0, k);
	}

	private static void partialQuickSort(int[] array, int from, int to, int k) {
		if (to <= from) {
			return;
		}
		
		int pivotIndex = partition(array, from, to);
		
		partialQuickSort(array, from, pivotIndex - 1, k);
		if (pivotIndex < k - 1) {
			partialQuickSort(array, pivotIndex + 1, to, k);
		}
	}

	private static int partition(int[] array, int from, int to) {
		int i = from;
		int j = to + 1;
		
		int pivot = array[from];
		while (true) {
			while (array[++i] < pivot) {
				if (i == to) {
					break;
				}
			}

            while (pivot < array[--j]) {
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

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = new int[20];
		Random random = new Random();
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
		
		System.out.println(Arrays.toString(array));
		int[] kSmallest = selectKSmallest(array, 5);
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		Arrays.sort(kSmallest);
		System.out.println(Arrays.toString(kSmallest));
	}
}
