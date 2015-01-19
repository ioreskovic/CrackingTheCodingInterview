package com.lopina.exercises.practice.palantir;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();
		
		System.out.println(getOutput(areAnagrams(s1, s2)));
	}

	private static String getOutput(boolean areAnagrams) {
		if (areAnagrams) {
			return "Anagrams!";
		} else {
			return "Not anagrams!";
		}
	}

	private static boolean areAnagrams(String s1, String s2) {
		Map<Character, Integer> letters = new HashMap<Character, Integer>();
		
		for (char c : s1.toCharArray()) {
			int countSoFar = letters.getOrDefault(c, 0);
			countSoFar++;
			letters.put(c, countSoFar);
		}
		
		for (char c : s2.toCharArray()) {
			int countSoFar = letters.getOrDefault(c, 0);
			if (countSoFar == 0) {
				return false;
			} else {
				countSoFar--;
				letters.put(c, countSoFar);
			}
		}
		
		return true;
	}
	
	private static <K, V> V getOrDefault(Map<K, V> map, K key, V defaultValue) {
		if (map.containsKey(key)) {
			return map.get(key);
		}
		
		return defaultValue;
	}
}
