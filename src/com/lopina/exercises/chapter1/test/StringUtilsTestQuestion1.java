package com.lopina.exercises.chapter1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter1.StringUtils;

public class StringUtilsTestQuestion1 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnNullString() {
		String s = null;
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharacters(s);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnNullStringSimpleBackingArray() {
		String s = null;
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharactersSimpleBackingArray(s);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnNullStringConstantSpace() {
		String s = null;
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharactersConstantSpace(s);
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void shoudThrowIllegalArgumentEceptionOnEmptyString() {
		String s = "";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharacters(s);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shoudThrowIllegalArgumentEceptionOnEmptyStringSimpleBackingArray() {
		String s = "";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharactersSimpleBackingArray(s);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shoudThrowIllegalArgumentEceptionOnEmptyStringConstantSpace() {
		String s = "";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharactersConstantSpace(s);
	}
	
	
	@Test
	public void shouldReturnFalseOnLongStringFilledWithSpacesOnly() {
		String s = "        ";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharacters(s);
		assertFalse(containsAllUniqueCharacters);
	}
	
	@Test
	public void shouldReturnFalseOnLongStringFilledWithSpacesOnlySimpleBackingArray() {
		String s = "        ";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharactersSimpleBackingArray(s);
		assertFalse(containsAllUniqueCharacters);
	}
	
	@Test
	public void shouldReturnFalseOnLongStringFilledWithSpacesOnlyConstantSpace() {
		String s = "        ";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharactersConstantSpace(s);
		assertFalse(containsAllUniqueCharacters);
	}
	
	
	@Test
	public void shouldReturnTrueOnSingleCharacterString() {
		String s = " ";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharacters(s);
		assertTrue(containsAllUniqueCharacters);
	}
	
	@Test
	public void shouldReturnTrueOnSingleCharacterStringSimpleBackingArray() {
		String s = " ";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharactersSimpleBackingArray(s);
		assertTrue(containsAllUniqueCharacters);
	}
	
	@Test
	public void shouldReturnTrueOnSingleCharacterStringConstantSpace() {
		String s = " ";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharactersConstantSpace(s);
		assertTrue(containsAllUniqueCharacters);
	}
	
	
	@Test
	public void shouldReturnTrueOnStringWithNonEnglishCharacters() {
		String s = "abcèæd\t";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharacters(s);
		assertTrue(containsAllUniqueCharacters);
	}
	
	@Test
	public void shouldReturnTrueOnStringWithNonEnglishCharactersSimpleBackingArray() {
		String s = "abcèæd\t";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharactersSimpleBackingArray(s);
		assertTrue(containsAllUniqueCharacters);
	}
	
	@Test
	public void shouldReturnTrueOnStringWithNonEnglishCharactersConstantSpace() {
		String s = "abcèæd\t";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharactersConstantSpace(s);
		assertTrue(containsAllUniqueCharacters);
	}
	
	
	@Test
	public void shouldReturnFalseOnStringWithNonEnglishCharacters() {
		String s = "abcèèææ\t\t";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharacters(s);
		assertFalse(containsAllUniqueCharacters);
	}
	
	@Test
	public void shouldReturnFalseOnStringWithNonEnglishCharactersSimpleBackingArray() {
		String s = "abcèèææ\t\t";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharactersSimpleBackingArray(s);
		assertFalse(containsAllUniqueCharacters);
	}
	
	@Test
	public void shouldReturnFalseOnStringWithNonEnglishCharactersConstantSpace() {
		String s = "abcèèææ\t\t";
		boolean containsAllUniqueCharacters = StringUtils.allUniqueCharactersConstantSpace(s);
		assertFalse(containsAllUniqueCharacters);
	}
}
