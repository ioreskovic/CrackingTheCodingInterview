package com.lopina.exercises.chapter1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter1.StringUtils;

public class StringUtilsTestQuestion5 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnNullString() {
		StringUtils.compressRepeatedCounts(null);
	}
	
	@Test
	public void shouldReturnNewInstanceOfEmptyStringOnEmptyStringArgument() {
		String a = "";
		String b = StringUtils.compressRepeatedCounts(a);
		
		assertFalse(a == b);
		assertEquals(a, b);
	}
	
	@Test
	public void shouldCompressProperlyOneCharacterString() {
		String a = " ";
		String b = StringUtils.compressRepeatedCounts(a);
		
		assertFalse(a == b);
		assertEquals(" 1", b);
	}
	
	@Test
	public void shouldCompressProperlyMultipleOneCharacterString() {
		String a = "   ";
		String b = StringUtils.compressRepeatedCounts(a);
		
		assertFalse(a == b);
		assertEquals(" 3", b);
	}
	
	@Test
	public void shouldCompressProperlyMultipleCharactersString() {
		String a = "aabcccccaaa";
		String b = StringUtils.compressRepeatedCounts(a);
		
		assertFalse(a == b);
		assertEquals("a2b1c5a3", b);
	}

}
