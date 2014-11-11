package com.lopina.exercises.chapter2.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lopina.exercises.chapter2.LinkedListUtils;
import com.lopina.exercises.chapter2.MyLinkedList;

public class LinkedListQuestion5 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnEitherListsBeingNull() {
		MyLinkedList<Integer> a = null;
		MyLinkedList<Integer> b = null;
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
	}
	
	@Test
	public void shouldReturnEmptyListWhenBothListsAreBeingEmpty() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		assertNull(c.getHead());
	}
	
	@Test
	public void shouldCalculateCorrectlyWhenOneListIsShorterThanAnotherWithoutOverflow() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		a.appendToTail(0)
		 .appendToTail(1);
		
		b.appendToTail(1);
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		Integer[] expecteds = new Integer[]{ 1, 1 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : c) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	@Test
	public void shouldCalculateCorrectlyWhenOneListIsShorterThanAnotherWithOverflow() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		a.appendToTail(6)
		 .appendToTail(1);
		
		b.appendToTail(4);
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		Integer[] expecteds = new Integer[]{ 0, 2 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : c) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	@Test
	public void shouldCalculateCorrectlyWhenBothListsAreSameLengthAndWithoutOverflow() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		a.appendToTail(0)
		 .appendToTail(1);
		
		b.appendToTail(0)
		 .appendToTail(2);
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		Integer[] expecteds = new Integer[]{ 0, 3 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : c) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	@Test
	public void shouldCalculateCorrectlyWhenBothListsAreSameLengthAndWithOverflow() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		a.appendToTail(5)
		 .appendToTail(1);
		
		b.appendToTail(5)
		 .appendToTail(1);
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		Integer[] expecteds = new Integer[]{ 0, 3 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : c) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	@Test
	public void shouldReturnCopyOfTheNonEmptyListWhenOneListIsEmpty() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		a.appendToTail(9)
		 .appendToTail(9);
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		Integer[] expecteds = new Integer[]{ 9, 9 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : c) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}

}
