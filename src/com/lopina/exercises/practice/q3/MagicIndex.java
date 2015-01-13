package com.lopina.exercises.practice.q3;

public class MagicIndex {
	
	/*
	 * O(n)
	 */
	public static int magicIndexBruteForce(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (i == numbers[i]) {
				return i;
			}
		}
		
		return -1;
	}
	
	/*
	 * O(logn)
	 */
	public static int magicIndexBinarySearch(int[] sortedNumbers, int from, int to) {
		if (from > to) {
			return -1;
		}
		
		int midIndex = (from + to) / 2;
		
		// If the value is lesser than the index, the previous (distinct) value is also lesser than its index
		// Induction: the left part cannot contain the magic index, so we need so search right
		
		// If the value is greater than the index, then next (distinct) value is also greater than its index
		// Induction: the right part cannot contain the magic index, so we need to search left
		if (midIndex == sortedNumbers[midIndex]) {
			return midIndex;
		} else if (midIndex > sortedNumbers[midIndex]) {
			return magicIndexBinarySearch(sortedNumbers, midIndex + 1, to);
		} else {
			return magicIndexBinarySearch(sortedNumbers, from, midIndex - 1);
		}
	}
	
	public static int magicIndexSublinearNonDistinct(int[] numbers, int from, int to) {
		if (from > to) {
			return -1;
		}
		
		int midIndex = (from + to) / 2;
		
		if (midIndex == numbers[midIndex]) {
			return midIndex;
		}
		
		int leftUpperBound = Math.min(midIndex - 1, numbers[midIndex]);
		int result = magicIndexSublinearNonDistinct(numbers, from, leftUpperBound);
		if (result >= 0) {
			return result;
		}
		
		int rightLowerBound = Math.max(midIndex + 1, numbers[midIndex]);
		return magicIndexSublinearNonDistinct(numbers, rightLowerBound, to);
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { -40, -20, -1, 1, 2, 3, 5, 6, 7, 8, 10 };
		int[] b = new int[] { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
		System.out.println("Magic naive: " + magicIndexBruteForce(a));
		System.out.println("Magic binary: " + magicIndexBinarySearch(a, 0, a.length));
		System.out.println("Magic sublinear: " + magicIndexSublinearNonDistinct(b, 0, b.length));
	}
}
