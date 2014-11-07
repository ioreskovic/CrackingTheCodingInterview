package com.lopina.exercises.chapter1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter1.StringUtils;

public class StringUtilsTestQuestion4 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnNullString() {
		StringUtils.replaceSpaces(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnNullStringFast() {
		StringUtils.replaceSpacesFast(null);
	}
	
	
	
	
	@Test
	public void shouldReturnImmediatelyOnEmptyString() {
		char[] expectedS = "".toCharArray();
		char[] actualS = "".toCharArray();
		StringUtils.replaceSpaces(actualS);
		
		assertArrayEquals(expectedS, actualS);
	}
	
	@Test
	public void shouldReturnImmediatelyOnEmptyStringFast() {
		char[] expectedS = "".toCharArray();
		char[] actualS = "".toCharArray();
		StringUtils.replaceSpacesFast(actualS);
		
		assertArrayEquals(expectedS, actualS);
	}
	
	
	
	
	@Test
	public void shouldReplaceSpacesWithHTMLEncoding() {
		char[] expectedS = "Mr%20John%20Smith".toCharArray();
		char[] actualS   = "Mr John Smith    ".toCharArray();
		StringUtils.replaceSpaces(actualS);
		
		assertArrayEquals(expectedS, actualS);
	}
	
	@Test
	public void shouldReplaceSpacesWithHTMLEncodingFast() {
		char[] expectedS = "Mr%20John%20Smith".toCharArray();
		char[] actualS   = "Mr John Smith    ".toCharArray();
		StringUtils.replaceSpacesFast(actualS);
		
		assertArrayEquals(expectedS, actualS);
	}
	
	
	
	
	@Test
	public void shouldReplaceSpacesWithHTMLEncodingIfStringStartsWithExtraSpaces() {
		char[] expectedS = "Mr%20John%20Smith".toCharArray();
		char[] actualS   = "  Mr John Smith  ".toCharArray();
		StringUtils.replaceSpaces(actualS);
		
		assertArrayEquals(expectedS, actualS);
	}
	
	@Test
	public void shouldReplaceSpacesWithHTMLEncodingIfStringStartsWithExtraSpacesFast() {
		char[] expectedS = "Mr%20John%20Smith".toCharArray();
		char[] actualS   = "  Mr John Smith  ".toCharArray();
		StringUtils.replaceSpacesFast(actualS);
		
		assertArrayEquals(expectedS, actualS);
	}

}
