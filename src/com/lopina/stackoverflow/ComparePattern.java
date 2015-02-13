package com.lopina.stackoverflow;

import java.util.HashMap;
import java.util.Map;

public class ComparePattern {
	public static boolean matches(String pattern, String text) {
		Map<Character, String> lookbackMap = new HashMap<Character, String>();
		
		StringBuilder regexBuilder = new StringBuilder();
		
		for (char c : pattern.toCharArray()) {
			if (!lookbackMap.containsKey(c)) {
				regexBuilder.append("(.+)");
				int lookbackIndex = lookbackMap.size() + 1;
				lookbackMap.put(c, "\\" + lookbackIndex);
			} else {
				regexBuilder.append(lookbackMap.get(c));
			}
		}
		
		return text.matches(regexBuilder.toString());
	}
	
	public static void main(String[] args) {
		System.out.println(matches("abba", "redbluebluered"));
		System.out.println(matches("aaaa", "asdasdasdasd"));
		System.out.println(matches("aabb", "xyzabcxzyabc"));
		System.out.println(matches("ababb", "thequickthequickquick"));
	}
}
