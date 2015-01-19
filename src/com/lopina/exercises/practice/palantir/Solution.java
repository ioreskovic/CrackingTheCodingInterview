package com.lopina.exercises.practice.palantir;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String paramLine = scanner.nextLine();
		String[] params = paramLine.split("\\s+");
		int m = Integer.parseInt(params[0]);
		int n = Integer.parseInt(params[1]);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < m; i++) {
			String line = scanner.nextLine();
			String key = getKey(line);
			int countSoFar = map.getOrDefault(key, 0);
			countSoFar++;
			map.put(key, countSoFar);
		}
		
		System.out.println(max(map.values()));
	}
	
	private static String getKey(String cs) {
		if (cs.charAt(0) == 'T') {
			return cs;
		}
		
		return inverse(cs);
	}

	private static int max(Collection<Integer> values) {
		int max = Integer.MIN_VALUE;
		
		for (Integer i : values) {
			if (i > max) {
				max = i;
			}
		}
		
		return max;
	}

	private static String inverse(String c) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < c.length(); i++) {
			sb.append(inverse(c.charAt(i)));
		}
		
		return sb.toString();
	}

	private static char inverse(char c) {
		if (c == 'P') {
			return 'T';
		} else if (c == 'T') {
			return 'P';
		}
		
		return c;
	}
}
