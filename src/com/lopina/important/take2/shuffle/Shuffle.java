package com.lopina.important.take2.shuffle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.lopina.exercises.chapter1.MatrixUtils;

public class Shuffle {
	public static <T> void knuthShuffle(T[] array) {
		Random random = new Random(System.currentTimeMillis());
		
		for (int i = 0; i < array.length; i++) {
			int j = i + random.nextInt(array.length - i);
			swap(array, i, j);
		}
	}
	
	public static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		Integer[] array = new Integer[] { 0, 1, 2, 3, 4 };
		Integer[][] counter = new Integer[array.length][array.length];
		
		Map<String, Integer> counts = new HashMap<String, Integer>();
		
		System.out.println(Arrays.toString(array));
		
		for (int k = 0; k < 14400; k++) {
			Shuffle.knuthShuffle(array);
			String key = Arrays.toString(array);
			int count = counts.getOrDefault(key, 0);
			count++;
			counts.put(key, count);
		}
		
		double expected = 120.0 / 14400.0;
		
		for (String key : counts.keySet()) {
			System.out.println(key + ": " + ((counts.get(key) / 14400.0 - expected)*100));
		}
		
	}
}
