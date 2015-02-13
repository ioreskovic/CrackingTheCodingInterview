package com.lopina.stackoverflow;

import java.util.Random;

public class EuropeanRoulette {
	private static Random random = new Random(System.currentTimeMillis());
	
	public static int getRandom(int[] numbers) {
		int selectedIndex = random.nextInt(numbers.length);
		return numbers[selectedIndex];
	}
	
	public static void main(String[] args) {
		int[] numbers = { 0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26 };
		
		System.out.println(EuropeanRoulette.getRandom(numbers));
	}
}
