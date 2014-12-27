package com.lopina.exercises.chapter5.question6;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter5.BitUtils;

public class Chapter5Question6 {

	@Test
	public void test() {
		int n = Integer.parseInt("110010100100", 2);
		int m = Integer.parseInt("110001011000", 2);
		
		assertEquals(m, BitUtils.swapOddEvenBits(n));
	}

}
