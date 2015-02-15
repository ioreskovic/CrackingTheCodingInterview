package com.lopina.important.take2.strings.worder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringToWords {
	public static List<String> splitToWords(Set<String> dictionary, String document) {
		int len = document.length();
		int[] dp = new int[len + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		String[] words = new String[len + 1];
		Arrays.fill(words, "");
		
		List<String>[] text = (List<String>[]) (new List[len + 1]);
		Arrays.fill(text, new ArrayList<String>());
		
		List<Integer>[] splits = (List<Integer>[]) (new List[len + 1]);
		Arrays.fill(splits, new ArrayList<Integer>());
		
		for (int i = 0; i < len; i++) {
			if (dp[i] == -1) {
				continue;
			}
			
			for (int j = i + 1; j <= len; j++) {
				int wordLen = j - i;
				String word = document.substring(i, j);
				
				if (dictionary.contains(word)) {
					String glue = (i > 0) ? " " : "";
					words[i + wordLen] = words[i] + glue + word;
					dp[i + wordLen] = dp[i] + 1;
					
					text[i + wordLen] = new ArrayList<String>(text[i]);
					text[i + wordLen].add(word);
					
					splits[i + wordLen] = new ArrayList<Integer>(splits[i]);
					splits[i + wordLen].add(j);
				}
			}
		}
		
		if (dp[dp.length - 1] != -1) {
			List<String> wordList = Arrays.asList(words[words.length - 1].split(" "));
			
			System.out.println(text[text.length - 1]);
			
			System.out.println(splits[splits.length - 1]);
			
			List<Integer> splitPositions = splits[splits.length - 1];
			int i = 0;
			for (int j : splitPositions) {
				System.out.println(document.substring(i, j));
				i = j;
			}
			
			return wordList;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		
		dictionary.add("i");
		dictionary.add("it");
		dictionary.add("was");
		dictionary.add("the");
		dictionary.add("he");
		dictionary.add("worst");
		dictionary.add("or");
		dictionary.add("to");
		dictionary.add("of");
		dictionary.add("time");
		dictionary.add("times");
		dictionary.add("sit");
		dictionary.add("be");
		dictionary.add("best");
		
		String document = "itwastheworstoftimesitwasthebestoftimes";
		
		System.out.println(splitToWords(dictionary, document));
	}
}
