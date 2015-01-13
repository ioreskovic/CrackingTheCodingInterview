package com.lopina.exercises.chapter5.question3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter5.BitUtils;

public class Chapter5Question3 {

	@Test
	public void test() {
		int num = 13948; //11011001111100
		int next = BitUtils.nextSmallestIntWithSameNumberOfOnes(num);
		int prev = BitUtils.previousBiggestIntWithSameNumberOfOnes(num);
		
		assertEquals(13967, next);
		assertEquals(13946, prev);
	}

}
