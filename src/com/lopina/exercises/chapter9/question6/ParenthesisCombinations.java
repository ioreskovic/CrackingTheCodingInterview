package com.lopina.exercises.chapter9.question6;

import java.util.HashSet;
import java.util.Set;

public class ParenthesisCombinations {
	
	public static void main(String[] args) {
		Set<String> s = validParenthesesPairsBruteForce(4);
		printSet(s);
		
		Set<String> p = validParenthesesPairsFast(4);
		printSet(p);
	}
	
	private static void printSet(Set<String> s) {
		int index = 1;
		for (String x : s) {
			System.out.println(String.format("\t%2d: '%s'", index, x));
			index++;
		}
		System.out.println();
	}
	
	public static Set<String> validParenthesesPairsFast(int nPairs) {
		Set<String> pairs = new HashSet<String>();
		
		char[] str = new char[nPairs * 2];
		
		compute(pairs, nPairs, nPairs, str, 0);
		
		return pairs;
	}

	private static void compute(Set<String> pairs, int leftRemaining, int rightRemaining, char[] str, int index) {
		if (leftRemaining < 0 || leftRemaining > rightRemaining) {
			return;
		}
		
		if (leftRemaining == 0 && rightRemaining == 0) {
			String combination = new String(str);
			pairs.add(combination);
		}
		
		if (leftRemaining > 0) {
			str[index] = '(';
			compute(pairs, leftRemaining - 1, rightRemaining, str, index + 1);
		}
		
		if (rightRemaining > leftRemaining) {
			str[index] = ')';
			compute(pairs, leftRemaining, rightRemaining - 1, str, index + 1);
		}
	}

	public static Set<String> validParenthesesPairsBruteForce(int nPairs) {
		Set<String> s = new HashSet<String>();
		if (nPairs < 1) {
			s.add("");
		} else if (nPairs == 1) {
			s.add("()");
		} else {
			Set<String> previousPairs = validParenthesesPairsBruteForce(nPairs - 1);
			
			for (String previousPair : previousPairs) {
				for (int i = 0; i < previousPair.length(); i++) {
					for (int j = i; j <= previousPair.length(); j++) {
						s.add(envelop(previousPair, i, j));
					}
				}
			}
		}
		
		return s;
	}

	private static String envelop(String s, int i, int j) {
		String start = s.substring(0, i);
		String mid = s.substring(i, j);
		String end = s.substring(j);
		
		return start + "(" + mid + ")" + end;
	}
}
