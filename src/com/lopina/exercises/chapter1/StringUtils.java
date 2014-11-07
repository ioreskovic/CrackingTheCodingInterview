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
	
	public static void replaceSpaces(char[] s) {
		checkForNullString(s, "The provided string was null");
		
		if (s.length == 0) {
			return;
		}
		
		rotateCharsLeftForEmptySpaces(s);
		
		for (int i = 0; i < s.length; i++) {
			char c = s[i];
			
			if (c == ' ') {
				rotateCharsRightFrom(i + 1, 2, s);
				putEncodedSpace(i, s);
				i += 2;
			}
		}
	}
	
	public static void replaceSpacesFast(char[] s) {
		checkForNullString(s, "The provided string was null");
		
		if (s.length == 0) {
			return;
		}
		
		rotateCharsLeftForEmptySpaces(s);
		
		int trailingEmptySpaces = getTrailingEmptySpaces(s);
		
		int extendedLength = s.length;
		int originalLength = s.length - trailingEmptySpaces;
		
		for (int i = originalLength - 1, j = extendedLength - 1; i >= 0; i--) {
			if (s[i] == ' ') {
				s[j - 2] = '%';
				s[j - 1] = '2';
				s[j] = '0';
				j -= 3;
			} else {
				s[j] = s[i];
				j--;
			}
		}
	}
	
	public static String compressRepeatedCounts(String s) {
		checkForNullString(s, "The provided string was null");
		
		if (s.isEmpty()) {
			return new String(s);
		}
		
		StringBuilder sb = new StringBuilder();
		
		char[] array = s.toCharArray();
		
		int seenCount = 1;
		char lastChar = array[0];
		int i = 1;
		
		while (i < array.length) {
			if (array[i] == lastChar) {
				seenCount++;
			} else {
				sb.append(lastChar).append(seenCount);
				lastChar = array[i];
				seenCount = 1;
			}
			
			i++;
		}
		
		sb.append(lastChar).append(seenCount);
		
		return sb.toString();
	}
	
	private static int getTrailingEmptySpaces(char[] s) {
		int trailingEmptySpaces = 0;
		int i = s.length - 1;
		
		while (s[i] == ' ' && i >= 0) {
			trailingEmptySpaces++;
			i--;
		}
		
		return trailingEmptySpaces;
	}

	private static void rotateCharsLeftForEmptySpaces(char[] s) {
		int leadingEmptySpaces = 0;
		
		while (s[leadingEmptySpaces] == ' ') {
			leadingEmptySpaces++;
		}
		
		rotateCharsLeftFrom(leadingEmptySpaces, leadingEmptySpaces, s);
	}

	private static void putEncodedSpace(int i, char[] s) {
		s[i] = '%';
		s[i + 1] = '2';
		s[i + 2] = '0';
	}

	private static void rotateCharsLeftFrom(int start,
			int step, char[] array) {
		for (int i = 0; i < array.length - step; i++) {
			array[i] = array[i + step];
		}
	}
	
	private static void rotateCharsRightFrom(int start, int step, char[] array) {
		for (int i = array.length - 1; i >= start; i --) {
			array[i] = array[i - step];
		}
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

	private static void checkForNullString(char[] s, String message) {
		checkForNullString(new String(s), message);
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
