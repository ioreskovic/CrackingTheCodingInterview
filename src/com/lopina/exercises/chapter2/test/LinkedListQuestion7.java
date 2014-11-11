package com.lopina.exercises.chapter2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter2.LinkedListUtils;
import com.lopina.exercises.chapter2.MyLinkedList;

public class LinkedListQuestion7 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionWhenProvidedNullList() {
		MyLinkedList<Integer> list = null;
		
		boolean isPalindrome = LinkedListUtils.isPalindrome(list);
	}
	
	@Test
	public void shouldReturnTrueOnEmptyList() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		boolean isPalindrome = LinkedListUtils.isPalindrome(list);
		
		assertTrue(isPalindrome);
	}
	
	@Test
	public void shouldReturnTrueOnOneElementList() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToFront(0);
		
		boolean isPalindrome = LinkedListUtils.isPalindrome(list);
		
		assertTrue(isPalindrome);
	}
	
	@Test
	public void shouldReturnTrueOnTwoElementListThatIsPalindrome() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToFront(0)
			.appendToBack(0);
		
		boolean isPalindrome = LinkedListUtils.isPalindrome(list);
		
		assertTrue(isPalindrome);
	}
	
	@Test
	public void shouldReturnFalseOnTwoElementListThatIsNotPalindrome() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToFront(0)
			.appendToBack(1);
		
		boolean isPalindrome = LinkedListUtils.isPalindrome(list);
		
		assertFalse(isPalindrome);
	}
	
	@Test
	public void shouldReturnFalseOnEvenCountElementListThatIsNotPalindrome() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(0)
			.appendToBack(1)
			.appendToBack(0)
			.appendToBack(0);
		
		boolean isPalindrome = LinkedListUtils.isPalindrome(list);
		
		assertFalse(isPalindrome);
	}
	
	@Test
	public void shouldReturnTrueOnEvenCountElementListThatIsPalindrome() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(0)
			.appendToBack(1)
			.appendToBack(1)
			.appendToBack(0);
		
		boolean isPalindrome = LinkedListUtils.isPalindrome(list);
		
		assertTrue(isPalindrome);
	}
	
	@Test
	public void shouldReturnFalseOnOddCountElementListThatIsNotPalindrome() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(0)
			.appendToBack(1)
			.appendToBack(2)
			.appendToBack(3)
			.appendToBack(0);
		
		boolean isPalindrome = LinkedListUtils.isPalindrome(list);
		
		assertFalse(isPalindrome);
	}
	
	@Test
	public void shouldReturnTrueOnOddCountElementListThatIsPalindrome() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(0)
			.appendToBack(1)
			.appendToBack(2)
			.appendToBack(1)
			.appendToBack(0);
		
		boolean isPalindrome = LinkedListUtils.isPalindrome(list);
		
		assertTrue(isPalindrome);
	}

}
