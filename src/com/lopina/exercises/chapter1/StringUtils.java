package com.lopina.exercises.chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StringUtils {
	/**
	 * Checks whether the given string is comprised of all unique characters
	 * 
	 * Uses {@link HashMap} as backing data structure that keeps information about seen characters.
	 * Time complexity is O(n)
	 * Space complexity is at worst (all unique characters in string) O(n)
	 * 
	 * @param s The string to examine
	 * @return <code>true</code> if the string is comprised of all unique characters, <code>false</code> otherwise
	 * @throws NullPointerException if the passed string is <code>null</code>
	 * @throws IllegalArgumentException if the passed string is empty
	 */
	public static boolean allUniqueCharacters(String s) {
		checkForNullString(s, "The provided string was null");
		checkForEmptyString(s, "The provided string was empty");
		
		Map<Character, Boolean> seenCharacterMap = new HashMap<Character, Boolean>();
		
		for (char c : s.toCharArray()) {
			boolean seenAlready = seenCharacterMap.getOrDefault(c, false);
			
			if (seenAlready) {
				return false;
			} else {
				seenCharacterMap.put(c, true);
			}
		}
		
		return true;
	}
	
	/**
	 * Checks whether the given string is comprised of all unique characters
	 * 
	 * Uses a simple array as backing data structure that keeps information about seen characters.
	 * Time complexity is O(n)
	 * Space complexity is O(n) because of preallocated space for all possible characters
	 * 
	 * @param s The string to examine
	 * @return <code>true</code> if the string is comprised of all unique characters, <code>false</code> otherwise
	 * @throws NullPointerException if the passed string is <code>null</code>
	 * @throws IllegalArgumentException if the passed string is empty
	 */
	public static boolean allUniqueCharactersSimpleBackingArray(String s) {
		checkForNullString(s, "The provided string was null");
		checkForEmptyString(s, "The provided string was empty");

		
		boolean[] seenArray = new boolean[Character.MAX_VALUE];
		
		for (char c : s.toCharArray()) {
			boolean seenAlready = seenArray[c];
			
			if (seenAlready) {
				return false;
			} else {
				seenArray[c] = true;
			}
		}
		
		return true;
	}
	
	/**
	 * Checks whether the given string is comprised of all unique characters
	 * 
	 * Uses a single variable as backing data structure that keeps information about seen characters.
	 * Time complexity is O(n<sup>2</sup>)
	 * Space complexity is O(1)
	 * 
	 * @param s The string to examine
	 * @return <code>true</code> if the string is comprised of all unique characters, <code>false</code> otherwise
	 * @throws NullPointerException if the passed string is <code>null</code>
	 * @throws IllegalArgumentException if the passed string is empty
	 */
	public static boolean allUniqueCharactersConstantSpace(String s) {
		checkForNullString(s, "The provided string was null");
		checkForEmptyString(s, "The provided string was empty");

		
		char[] stringAsCharArray = s.toCharArray();
		
		for (int i = 0; i < stringAsCharArray.length - 1; i++) {
			char currentChar = stringAsCharArray[i];
			
			for (int j = i + 1; j < stringAsCharArray.length; j++) {
				char examiningChar = stringAsCharArray[j];
				
				if (examiningChar == currentChar) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Checks if the two provided strings are permutations of each other.
	 * Time complexity is 0(n)
	 * Space comlexity is at most O(n)
	 * 
	 * @param a the first string
	 * @param b the second string
	 * @return <code>true</code> if the provided strings are permutations of each other, <code>false</code> otherwise
	 * @throws NullPointerException if either of the provided strings is a null string
	 */
	public static boolean arePermutations(String a, String b) {
		checkForNullString(a, "String a should not be null");
		checkForNullString(b, "String b should not be null");
		
		if (a.length() != b.length()) {
			return false;
		}
		
		Map<Character, Integer> usedCharacterMap = new HashMap<Character, Integer>();
		int length = a.length();
		
		for (int i = 0; i < length; i++) {
			char ca = a.charAt(i);
			char cb = b.charAt(i);
			
			incrementCharacterCount(ca, usedCharacterMap);
			decrementCharacterCount(cb, usedCharacterMap);
		}
		
		for (Entry<Character, Integer> e : usedCharacterMap.entrySet()) {
			if (e.getValue() != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	private static void incrementCharacterCount(char ca,
			Map<Character, Integer> usedCharacterMap) {
		changeCharacterCount(ca, usedCharacterMap, 1);
	}

	private static void decrementCharacterCount(char cb,
			Map<Character, Integer> usedCharacterMap) {
		changeCharacterCount(cb, usedCharacterMap, -1);
	}

	private static void changeCharacterCount(char c,
			Map<Character, Integer> usedCharacterMap, int step) {
		int usedTimes = usedCharacterMap.getOrDefault(c, 0);
		usedCharacterMap.put(c, usedTimes + step);
	}

	private static void checkForNullString(String s, String message) {
		if (s == null) {
			throw new NullPointerException(message);
		}
	}
	
	private static void checkForEmptyString(String s, String message) {
		if (s == null) {
			throw new IllegalArgumentException(message);
		}
	}
}
