package com.lopina.interview.google;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class GoogleInterview {
	public static int indexOfFirstNonAsc(int[] numbers) {
		if (numbers == null) {
			throw new IllegalArgumentException("Null array");
		}

		int len = numbers.length;

		for (int i = 0; i < len - 1; i++) {
			int a = numbers[i];
			int b = numbers[i + 1];

			if (b <= a) {
				return (i + 1);
			}
		}

		return -1;
	}

	public static String canonize(String path) {
		if (path == null) {
			throw new IllegalArgumentException("Null path provided");
		}

		if (path.isEmpty() || !path.startsWith("/")) {
			throw new IllegalArgumentException("Not an absolute path");
		}

		Deque<String> canonQueue = new ArrayDeque<String>();
		String[] parts = path.split("/");

		for (String pathPart : parts) {
			if ("..".equals(pathPart)) {
				if (canonQueue.isEmpty()) {
					throw new IllegalArgumentException("Invalid path");
				}

				canonQueue.pollLast();
			} else if (".".equals(pathPart) || "".equals(pathPart)) {
				// do nothing
			} else {
				canonQueue.offerLast(pathPart);
			}
		}

		StringBuilder pathBuilder = new StringBuilder();

		for (String pathPartCanon : canonQueue) {
			pathBuilder.append("/").append(pathPartCanon);
		}

		return pathBuilder.toString();
	}
	
	public static void main(String[] args) {
		int[] a_1 = null;
		int[] a0 = new int[] {};
		int[] a1 = new int[] { 1 };
		int[] a2 = new int[] { 1, 2 };
		int[] a3 = new int[] { 1, 1, 1 };
		int[] a4 = new int[] { 1, 2, 3, 4, 5 };
		int[] a5 = new int[] { 1, 2, 3, 2, 4, 5 };
		int[] a6 = new int[] { 1, 2, 3, 4, 5, 6, 7};
		int[] a7 = new int[] { 7, 6, 5, 4, 3, 2, 1, 0};
//		printIndexOfFirstNonAsc(a_1);
		printIndexOfFirstNonAsc(a0);
		printIndexOfFirstNonAsc(a1);
		printIndexOfFirstNonAsc(a2);
		printIndexOfFirstNonAsc(a3);
		printIndexOfFirstNonAsc(a4);
		printIndexOfFirstNonAsc(a5);
		printIndexOfFirstNonAsc(a6);
		printIndexOfFirstNonAsc(a7);
		
		String path = "/a/b/.././///c/d/file.txt";
		System.out.println(path + " -> " + canonize(path));
	}

	private static void printIndexOfFirstNonAsc(int[] a) {
		System.out.print(Arrays.toString(a) + " : " + indexOfFirstNonAsc(a));
		System.out.println();
	}
}
