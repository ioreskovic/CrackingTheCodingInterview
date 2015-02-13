package com.lopina.interview.facebook.onsite;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class SubsetSum {
	public static boolean exists(int value, int[] nums) {
		List<Integer> result = compute(value, nums);
		
		return (result != null && !result.isEmpty());
	}

	private static List<Integer> compute(int value, int[] nums) {
		int n = nums.length;
		
		for (int i = 0; i < (1 << n); i++) {
			BitSet bitSet = BitSet.valueOf(new long[] { i });
			
			int sum = 0;
			
			for (int j = 0; j < n; j++) {
				if (bitSet.get(j)) {
					sum += nums[j];
				}
			}
			
			if (sum == value) {
				List<Integer> subset = new ArrayList<Integer>();
				
				for (int j = 0; j < n; j++) {
					if (bitSet.get(j)) {
						subset.add(nums[j]);
					}
				}
				
				return subset;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(compute(13, new int[] {1, 2, 3, 5, 7, 11}));
	}
}
