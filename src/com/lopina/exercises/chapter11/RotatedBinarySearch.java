package com.lopina.exercises.chapter11;

public class RotatedBinarySearch {
	public static int find(int[] array, int from, int to, int x) {
		if (from > to) {
			return -1;
		}
		int mid = (from + to) / 2;
		
		int curr = array[mid];
		int prev = array[from];
		int next = array[to];
		
		if (x == next) {
			return to;
		}
		
		if (x == curr) {
			return mid;
		} 
		
		if (x == prev) {
			return from;
		}
		
		if (prev < curr) {
			if (prev <= x && x <= curr) {
				return find(array, from, mid - 1, x);
			} else {
				return find(array, mid + 1, to, x);
			}
		} else if (prev > curr) {
			if (curr <= x && x <= next) {
				return find(array, mid + 1, to, x);
			} else {
				return find(array, from, mid - 1, x);
			}
		} else if (prev == curr) {
			if (curr != next) {
				return find(array, mid + 1, to, x);
			} else {
				int leftResult = find(array, from, mid - 1, x);
				if (leftResult > 0) {
					return leftResult;
				}
				
				return find(array, mid + 1, to, x);
			}
		}
		
		return -1;
	}
	
	public static int rotationIndex(int[] array, int from, int to) {
		if (from > to) {
			return -1;
		}
		int mid = (from + to) / 2;
		
		int curr = array[mid];
		int prev = array[Math.max(0, mid - 1)];
		int next = array[Math.min(mid + 1, array.length - 1)];
		
		if (prev > curr && curr <= next) {
			return mid;
		} else if (prev <= curr && curr > next) {
			return Math.min(mid + 1, array.length - 1);
		} else {
			int possibleLeftRotationIndex = rotationIndex(array, from, mid - 1);
			if (possibleLeftRotationIndex != -1) {
				return possibleLeftRotationIndex;
			} else {
				return rotationIndex(array, mid + 1, to);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
		int[] b = new int[] { 1, 2, 3, 4, 5, 6, 7, 0 };
		int[] c = new int[] { 7, 0, 1, 2, 3, 4, 5, 6 };
		int[] d = new int[] { 0, 0, 1, 2, 3, 4, 5, 0 };
		
		System.out.println(rotationIndex(a, 0, a.length - 1));
		System.out.println(rotationIndex(b, 0, b.length - 1));
		System.out.println(rotationIndex(c, 0, c.length - 1));
		System.out.println(rotationIndex(d, 0, d.length - 1));
		System.out.println();
		
		System.out.println(find(a, 0, a.length - 1, 1));
		System.out.println(find(a, 0, a.length - 1, 7));
		System.out.println(find(a, 0, a.length - 1, 9));
		System.out.println();
		
		System.out.println(find(b, 0, b.length - 1, 1));
		System.out.println(find(b, 0, b.length - 1, 7));
		System.out.println(find(b, 0, b.length - 1, 9));
		System.out.println();
		
		System.out.println(find(c, 0, c.length - 1, 1));
		System.out.println(find(c, 0, c.length - 1, 7));
		System.out.println(find(c, 0, c.length - 1, 9));
		System.out.println();
		
		System.out.println(find(d, 0, d.length - 1, 1));
		System.out.println(find(d, 0, d.length - 1, 0));
		System.out.println(find(d, 0, d.length - 1, 9));
		System.out.println();
		
	}
}
