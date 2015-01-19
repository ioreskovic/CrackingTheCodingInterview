package com.lopina.exercises.practice.random;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NumbersGenerator {
	
	public static void main(String[] args) {
		runFor(10, 1);
		runFor(10, 2);
		runFor(10, 3);
		runFor(10, 8);
		runFor(10, 5);
		runFor(10, 10);
	}
	
	
	private static void runFor(int n, int radix) {
		List<String> results = generate(n, radix);
		
		System.out.println("Counting from 0 to " + n + " in base " + radix);
		for (int i = 0; i <= n; i++) {
			System.out.println(String.format("%3d: %10s", i, results.get(i)));
		}
		System.out.println();
	}


	public static List<String> generate(int n, int radix) {
		List<String> results = new ArrayList<String>();
		
		Deque<String> queue = new ArrayDeque<String>();
		if (radix == 1) {
			queue.offerLast(Integer.toString(0));
		} else {
			for (int i = 1; i < radix; i++) {
				queue.offerLast(Integer.toString(i));
			}
		}
		
		
		while (n >= 0) {
			String num = queue.pollFirst();
			results.add(num);
			
			for (int i = 0; i < radix; i++) {
				queue.offerLast(num + i);
			}
			
			n--;
		}
		
		return results;
	}
}
