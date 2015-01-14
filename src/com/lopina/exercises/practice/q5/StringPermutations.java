package com.lopina.exercises.practice.q5;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
	public static List<String> permutations(String s) {
		List<String> perms = new ArrayList<String>();
		
		if (s.length() == 0) {
			perms.add("");
		} else {
			char lead = s.charAt(0);
			String rest = s.substring(1);
			List<String> permsSoFar = permutations(rest);
			
			for (String permSoFar : permsSoFar) {
				for (int i = 0; i <= permSoFar.length(); i++) {
					perms.add(insertChar(lead, permSoFar, i));
				}
			}
		}
		
		return perms;
	}

	private static String insertChar(char lead, String s, int i) {
		String start = s.substring(0, i);
		String end = s.substring(i);
		return start + lead + end;
	}
	
	public static void main(String[] args) {
		String s = "1234";
		
		int index = 1;
		for (String perm : permutations(s)) {
			System.out.println(String.format("%02d: %s", index, perm));
			index++;
		}
	}
}
