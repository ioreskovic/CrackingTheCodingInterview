package com.lopina.interview.google.onsite;

import java.util.HashMap;
import java.util.Map;

public class PositiveSubsetSum {
	public static boolean exists(int value, int[] nums) {
		Map<String, Boolean> dp = new HashMap<String, Boolean>();
		
		boolean result = positiveSubsetSumExistsTopDown(value, nums, 0, dp);
		
		System.out.println(dp);
		
		return result;
	}
	
	private static boolean positiveSubsetSumExistsTopDown(int value, int[] nums, int i, Map<String, Boolean> dp) {
		if (i >= nums.length) {
			return false;
		}
		
		int num = nums[i];
		
		boolean partial1 = (value == num);
		boolean partial2 = (dp.getOrDefault((value - num) + "x" + (i + 1), positiveSubsetSumExistsTopDown(value - num, nums, i + 1, dp)));
		boolean partial3 = (dp.getOrDefault((value) + "x" + (i + 1), positiveSubsetSumExistsTopDown(value, nums, i + 1, dp)));
		
		boolean partial = partial1 || partial2 || partial3;
		
		dp.put((value) + "x" + (i), partial);
		
		return partial;
	}
	
	public static void main(String[] args) {
		int value = 15;
		int[] nums = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(exists(value, nums));
	}
}
