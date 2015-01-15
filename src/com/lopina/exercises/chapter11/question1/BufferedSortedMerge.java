package com.lopina.exercises.chapter11.question1;

import java.util.Arrays;

public class BufferedSortedMerge {
	public static void sortedMerge(int[] a, int[] b, int lastAIndex, int lastBIndex) {
		int lastCIndex = lastAIndex + lastBIndex + 1;
		
		while (lastAIndex >= 0 && lastBIndex >= 0) {
			int aElement = a[lastAIndex];
			int bElement = b[lastBIndex];
			
			if (aElement > bElement) {
				a[lastCIndex] = a[lastAIndex];
				lastAIndex--;
			} else {
				a[lastCIndex] = b[lastBIndex];
				lastBIndex--;
			}
			
			lastCIndex--;
		}
		
		while (lastAIndex >=0) {
			a[lastCIndex] = a[lastAIndex];
			lastAIndex--;
			lastCIndex--;
		}
		
		while (lastBIndex >=0) {
			a[lastCIndex] = b[lastBIndex];
			lastBIndex--;
			lastCIndex--;
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 6, 7, 0, 0, 0, 0, 0, 0 };
		int[] b = new int[] { 3, 4, 5, 8, 9, 10 };
		sortedMerge(a, b, 3, 5);
		System.out.println(Arrays.toString(a));
	}
}
