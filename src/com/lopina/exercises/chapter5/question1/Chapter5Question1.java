package com.lopina.exercises.chapter5.question1;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter5.BitUtils;

public class Chapter5Question1 {

	@Test
	public void test() {
		int n = 1024;
		int m = 19;
		int r = 1100;
		
		int x = BitUtils.updateBitsFromLeastSignificant(n, m, 2, 6);
		
		assertEquals(r, x);
	}

}
