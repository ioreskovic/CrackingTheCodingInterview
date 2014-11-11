package com.lopina.exercises.chapter2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter2.LinkedListUtils;
import com.lopina.exercises.chapter2.MyLinkedList;

public class LinkedListQuestion6 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionWhenNullList() {
		MyLinkedList<Integer> list = null;
		
		Integer loopStart = LinkedListUtils.findLoopStart(list);
	}
	
	@Test
	public void shouldReturnNullWhenProvidedNonCircularList() {
		MyLinkedList<Integer> list = LinkedListUtils.createCircularList(4, 0);
		
		Integer loopStart = LinkedListUtils.findLoopStart(list);
		
		assertNull(loopStart);
	}
	
	@Test
	public void shouldReturnFirstCircularElementWhenProvidedCircularOnlyList() {
		MyLinkedList<Integer> list = LinkedListUtils.createCircularList(0, 6);
		
		Integer loopStart = LinkedListUtils.findLoopStart(list);
		
		assertNotNull(loopStart);
		assertEquals(Integer.valueOf(0), loopStart);
	}
	
	@Test
	public void shouldReturnFirstCircularElementWhenProvidedMixedList() {
		MyLinkedList<Integer> list = LinkedListUtils.createCircularList(3, 8);
		
		Integer loopStart = LinkedListUtils.findLoopStart(list);
		
		assertNotNull(loopStart);
		assertEquals(Integer.valueOf(3), loopStart);
	}

}
