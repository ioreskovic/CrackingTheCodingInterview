package com.lopina.exercises.chapter2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter2.LinkedListUtils;
import com.lopina.exercises.chapter2.MyLinkedList;

public class LinkedListQuestion2 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnNullList() {
		MyLinkedList<Integer> list = null;
		
		Integer i = LinkedListUtils.getKthToTheEndElement(5, list);
	}
	
	@Test
	public void shouldReturnNullImmediatelyWhenTheListIsEmpty() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		Integer i = LinkedListUtils.getKthToTheEndElement(5, list);

		assertNull(i);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenNegativeK() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToTail(10)
			.appendToTail(9)
			.appendToTail(8)
			.appendToTail(7)
			.appendToTail(6)
			.appendToTail(5)
			.appendToTail(4)
			.appendToTail(3)
			.appendToTail(2)
			.appendToTail(1)
			.appendToTail(0);
		
		assertEquals(null, LinkedListUtils.getKthToTheEndElement(-1, list));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenListIsTooShortForK() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToTail(10)
			.appendToTail(9)
			.appendToTail(8)
			.appendToTail(7)
			.appendToTail(6)
			.appendToTail(5)
			.appendToTail(4)
			.appendToTail(3)
			.appendToTail(2)
			.appendToTail(1)
			.appendToTail(0);
		
		assertEquals(Integer.valueOf(0), LinkedListUtils.getKthToTheEndElement(11, list));
	}
	
	@Test
	public void shouldReturnProperElementWhenTheIndexIsSet() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToTail(10)
			.appendToTail(9)
			.appendToTail(8)
			.appendToTail(7)
			.appendToTail(6)
			.appendToTail(5)
			.appendToTail(4)
			.appendToTail(3)
			.appendToTail(2)
			.appendToTail(1)
			.appendToTail(0);
		
		assertEquals(Integer.valueOf(0), LinkedListUtils.getKthToTheEndElement(0, list));
		assertEquals(Integer.valueOf(1), LinkedListUtils.getKthToTheEndElement(1, list));
		assertEquals(Integer.valueOf(2), LinkedListUtils.getKthToTheEndElement(2, list));
		assertEquals(Integer.valueOf(3), LinkedListUtils.getKthToTheEndElement(3, list));
		assertEquals(Integer.valueOf(4), LinkedListUtils.getKthToTheEndElement(4, list));
		assertEquals(Integer.valueOf(5), LinkedListUtils.getKthToTheEndElement(5, list));
		assertEquals(Integer.valueOf(6), LinkedListUtils.getKthToTheEndElement(6, list));
		assertEquals(Integer.valueOf(7), LinkedListUtils.getKthToTheEndElement(7, list));
		assertEquals(Integer.valueOf(8), LinkedListUtils.getKthToTheEndElement(8, list));
		assertEquals(Integer.valueOf(9), LinkedListUtils.getKthToTheEndElement(9, list));
		assertEquals(Integer.valueOf(10), LinkedListUtils.getKthToTheEndElement(10, list));
	}

}
