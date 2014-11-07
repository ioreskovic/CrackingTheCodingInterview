package com.lopina.exercises.chapter1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter1.StringUtils;

public class StringUtilsTestQuestion3 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionIfEitherOfTheStringsIsNull() {
		String a = null;
		String b = "string";
		
		boolean result = StringUtils.arePermutations(a, b);
	}
	
	 @Test
	 public void shouldReturnFalseIfStringLengthsDoNotMatch() {
		 String a = "";
		 String b = "string";
		 
		 boolean result = StringUtils.arePermutations(a, b);
		 assertFalse(result);
	 }
	 
	 @Test
	 public void shouldReturnFalseIfTwoStringsAreNotPermutations() {
		 String a = "aaa";
		 String b = "bbb";
		 
		 boolean result = StringUtils.arePermutations(a, b);
		 assertFalse(result);
	 }
	 
	 @Test
	 public void shouldReturnTrueIfTwoStringsArePermutations() {
		 String a = "abcdefghijklmnopqrstuvwxyz";
		 String b = "zyxwvutsrqponmlkjihgfedbca";
		 
		 boolean result = StringUtils.arePermutations(a, b);
		 assertTrue(result);
	 }

}
