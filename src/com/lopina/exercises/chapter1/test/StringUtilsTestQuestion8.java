package com.lopina.exercises.chapter1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter1.StringUtils;

public class StringUtilsTestQuestion8 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnAnyStringBeingNull() {
		String a = null;
		String b = null;
		
		boolean isRotation = StringUtils.isRotation(a, b);
	}
	
	@Test
	public void shouldReturnFalseIfTheStringsAreNotOfSameLength() {
		String a = "aaa";
		String b = "aa";
		
		boolean isRotation = StringUtils.isRotation(a, b);
		
		assertFalse(isRotation);
	}
	
	@Test
	public void shouldReturnTrueIfTheStringsAreRotationsOfEachOther() {
		String a = "waterbottle";
		String b = "erbottlewat";
		
		boolean isRotation = StringUtils.isRotation(a, b);
		
		assertTrue(isRotation);
	}
	
	@Test
	public void shouldReturnTrueIfTheStringsAreRotationsOfEachOtherReflexive() {
		String a = "waterbottle";
		String b = "waterbottle";
		boolean isRotation1 = StringUtils.isRotation(a, b);
		assertTrue(isRotation1);
		
		boolean isRotation2 = StringUtils.isRotation(b, a);
		assertTrue(isRotation2);
	}
	
	@Test
	public void shouldReturnTrueIfTheStringsAreRotationsOfEachOtherSymmetric() {
		String a = "waterbottle";
		String b = "erbottlewat";
		boolean isRotation1 = StringUtils.isRotation(a, b);
		assertTrue(isRotation1);
		
		boolean isRotation2 = StringUtils.isRotation(b, a);
		assertTrue(isRotation2);
	}
	
	@Test
	public void shouldReturnTrueIfTheStringsAreRotationsOfEachOtherTransitive() {
		String a = "waterbottle";
		String b = "erbottlewat";
		String c = "bottlewater";
		boolean isRotation1 = StringUtils.isRotation(a, b);
		assertTrue(isRotation1);
		
		boolean isRotation2 = StringUtils.isRotation(b, c);
		assertTrue(isRotation2);
		
		boolean isRotation3 = StringUtils.isRotation(a, c);
		assertTrue(isRotation3);
		
		boolean isRotation4 = StringUtils.isRotation(c, a);
		assertTrue(isRotation4);
	}

}
