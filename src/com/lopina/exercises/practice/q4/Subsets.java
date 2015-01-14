package com.lopina.exercises.practice.q4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Subsets {
	
	public static List<List<Integer>> allSubsets(Set<Integer> set) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		
		int n = set.size();
		Integer[] setElements = set.toArray(new Integer[n]);
		
		int none = 0;
		int all = 1 << n;
		
		for (int i = none; i < all; i++) {
			results.add(decodeSetAndSave(i, setElements));
		}
		
		return results;
	}

	private static List<Integer> decodeSetAndSave(int combination, Integer[] setElements) {
		int n = setElements.length;
		int mask = 1;
		List<Integer> subset = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			if ((combination & mask) > 0) {
				subset.add(setElements[i]);
			}
			combination = combination >> 1;
		}
		
		return subset;
	}
	
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		List<List<Integer>> allSubsets = allSubsets(set);
		
		Collections.sort(allSubsets, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return Integer.compare(o1.size(), o2.size());
			}
		});
		
		int index = 1;
		for (List<Integer> subset : allSubsets) {
			System.out.println(index + ": '" + subset.toString() + "'");
			index++;
		}
	}
}
