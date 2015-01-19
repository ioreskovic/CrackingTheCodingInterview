package com.lopina.important.take2.bucketSort;

import java.util.Arrays;
import java.util.Random;

public class BucketSort {
	private static final Random random = new Random(System.currentTimeMillis());
	
	public static void sort(int[] array) {
		int min = array[0];
		int max = min;
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
			
			if (array[i] > max) {
				max = array[i];
			}
		}
		
		int[] aux = new int[max - min + 1];
		for (int i = 0; i < array.length; i++) {
			aux[array[i] - min]++;
		}
		
		int k = 0;
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux[i]; j++) {
				array[k++] = i + min;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] randomArray;
		
		randomArray = new int[15];
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = random.nextInt(5) + random.nextInt(5) + 1;
		}
		
		System.out.println(Arrays.toString(randomArray));
		BucketSort.sort(randomArray);
		System.out.println(Arrays.toString(randomArray));
		Arrays.sort(randomArray);
		System.out.println(Arrays.toString(randomArray));
	}
}
