package com.lopina.exercises.dynamic.longest.common.substring.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.dynamic.longest.common.substring.LongestCommonSubstring;

public class LongestCommonSubstringTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String s1 = "X111X222X333X";
		String s2 = "Y000Y111Y222Y333Y444Y";
		
//		String s1 = "SICK";
//		String s2 = "BRICKS";
		
		LongestCommonSubstring lcs = new LongestCommonSubstring(s1, s2);
		Iterable<String> lcsSolutions = lcs.solve();
		
		System.out.println("Longest common substring(s) for strings '" + s1 + "' and '" + s2 + "':");
		for (String lcsSolution : lcsSolutions) {
			System.out.println("\t" + lcsSolution);
		}
	}

}
