package com.lopina.exercises.chapter5.question4;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter5.BitUtils;

public class Chapter5Queston4 {

	@Test
	public void test() {
		int n = 31;
		int m = 14;
		
		int distance = BitUtils.distance(n, m);
		
		assertEquals(2, distance);
		
		n = Integer.parseInt("01010101", 2);
		m = Integer.parseInt("10101010", 2);
		
		distance = BitUtils.distance(n, m);
		assertEquals(8, distance);
		
		n = 45;
		m = 45;
		distance = BitUtils.distance(n, m);
		assertEquals(0, distance);
	}

}
