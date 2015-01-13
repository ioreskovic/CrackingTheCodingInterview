package com.lopina.exercises.dynamic.longest.common.subsequence.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.dynamic.longest.common.subsequence.LongestCommonSubsequence;

public class LongestCommonSubsequenceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String s1 = "BANANA";
		String s2 = "ANANAS";
		
		LongestCommonSubsequence lcs = new LongestCommonSubsequence(s1, s2);
		lcs.solve();
		
		System.out.println(lcs.getSolution());
		System.out.println(lcs.getSolution().length());
	}

}
