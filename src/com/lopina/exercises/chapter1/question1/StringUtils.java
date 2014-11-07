package com.lopina.exercises.chapter1.question1;

import java.util.HashMap;
import java.util.Map;

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
		if (s == null) {
			throw new NullPointerException("The provided string was null");
		}
		
		if (s.isEmpty()) {
			throw new IllegalArgumentException("The provided string was empty");
		}
		
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
		if (s == null) {
			throw new NullPointerException("The provided string was null");
		}
		
		if (s.isEmpty()) {
			throw new IllegalArgumentException("The provided string was empty");
		}
		
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
		if (s == null) {
			throw new NullPointerException("The provided string was null");
		}
		
		if (s.isEmpty()) {
			throw new IllegalArgumentException("The provided string was empty");
		}
		
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
}
