package com.lopina.exercises.chapter5.question2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter5.BitUtils;

public class Chapter5Question2 {

	@Test
	public void test() {
		double d1 = 0.72;
		double d2 = 0;
		
		for (int i = 0; i < 32; i++) {
			d2 += (1 / Math.pow(2, i + 1));
		}
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		
		String s1 = "ERROR";
		String s2 = "11111111111111111111111111111111";
		
		assertEquals(s1, BitUtils.smallDoubleToBinary(d1));
		assertEquals(s2, BitUtils.smallDoubleToBinary(d2));
	}

}
