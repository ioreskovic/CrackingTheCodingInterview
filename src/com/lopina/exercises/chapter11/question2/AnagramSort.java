package com.lopina.exercises.chapter11.question2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramSort {
	private static String sortChars(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	public static List<String> sort(List<String> strings) {
		Comparator<String> anagramComparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return sortChars(o1).compareTo(sortChars(o2));
			}
		};
		
		Collections.sort(strings, anagramComparator);
		
		return strings;
	}
	
	private static List<String> group(List<String> strings) {
		Map<String, List<String>> groups = new HashMap<String, List<String>>();
		
		for (String s : strings) {
			String key = sortChars(s);
			List<String> group = groups.getOrDefault(key, new ArrayList<String>());
			group.add(s);
			groups.put(key, group);
		}
		
		List<String> grouped = new ArrayList<String>();
		
		for (String key : groups.keySet()) {
			List<String> group = groups.getOrDefault(key, new ArrayList<String>());
			grouped.addAll(group);
		}
		
		return grouped;
	}
	
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("111223");
		strings.add("112213");
		strings.add("122113");
		strings.add("221113");
		strings.add("111223");
		strings.add("113221");
		strings.add("122131");
		strings.add("322111");
		strings.add("112223");
		strings.add("122213");
		strings.add("122123");
		strings.add("221213");
		strings.add("111233");
		strings.add("112313");
		strings.add("123113");
		strings.add("231113");
		
		System.out.println(group(strings));
		System.out.println(sort(strings));
	}
}
