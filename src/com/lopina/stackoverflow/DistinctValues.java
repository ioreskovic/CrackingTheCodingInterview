package com.lopina.stackoverflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctValues {
	public static List<Integer> distinctIndexes(String[] strings) {
		Map<String, Integer> firstOccurenceMap = new HashMap<String, Integer>();
		
		for (int i = 0; i < strings.length; i++) {
			firstOccurenceMap.putIfAbsent(strings[i], i);
		}
		
		return new ArrayList<Integer>(firstOccurenceMap.values());
	}
	
	public static void main(String[] args) {
		String[] strings = new String[] { "1", "1", "3", "3", "3", "3", "3", "3" };
		
		System.out.println(distinctIndexes(strings));
	}
}
