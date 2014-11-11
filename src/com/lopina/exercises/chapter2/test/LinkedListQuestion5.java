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
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnEitherListsBeingNullAlternate() {
		MyLinkedList<Integer> a = null;
		MyLinkedList<Integer> b = null;
		
		MyLinkedList<Integer> c = LinkedListUtils.addAlternate(a, b);
	}
	
	
	
	
	@Test
	public void shouldReturnEmptyListWhenBothListsAreBeingEmpty() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		assertNull(c.getHead());
	}
	
	@Test
	public void shouldReturnEmptyListWhenBothListsAreBeingEmptyAlternate() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		MyLinkedList<Integer> c = LinkedListUtils.addAlternate(a, b);
		
		assertNull(c.getHead());
	}
	
	
	
	
	@Test
	public void shouldCalculateCorrectlyWhenOneListIsShorterThanAnotherWithoutOverflow() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		a.appendToBack(0)
		 .appendToBack(1);
		
		b.appendToBack(1);
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		Integer[] expecteds = new Integer[]{ 1, 1 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : c) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	@Test
	public void shouldCalculateCorrectlyWhenOneListIsShorterThanAnotherWithoutOverflowAlternate() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		a.appendToBack(1)
		 .appendToBack(0);
		
		b.appendToBack(1);
		
		MyLinkedList<Integer> c = LinkedListUtils.addAlternate(a, b);
		
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
		
		a.appendToBack(6)
		 .appendToBack(1);
		
		b.appendToBack(4);
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		Integer[] expecteds = new Integer[]{ 0, 2 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : c) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	@Test
	public void shouldCalculateCorrectlyWhenOneListIsShorterThanAnotherWithOverflowAlternate() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		a.appendToBack(1)
		 .appendToBack(6);
		
		b.appendToBack(4);
		
		MyLinkedList<Integer> c = LinkedListUtils.addAlternate(a, b);
		
		Integer[] expecteds = new Integer[]{ 2, 0 };
		
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
		
		a.appendToBack(0)
		 .appendToBack(1);
		
		b.appendToBack(0)
		 .appendToBack(2);
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		Integer[] expecteds = new Integer[]{ 0, 3 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : c) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	@Test
	public void shouldCalculateCorrectlyWhenBothListsAreSameLengthAndWithoutOverflowAlternate() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		a.appendToBack(1)
		 .appendToBack(0);
		
		b.appendToBack(2)
		 .appendToBack(0);
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		Integer[] expecteds = new Integer[]{ 3, 0 };
		
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
		
		a.appendToBack(5)
		 .appendToBack(1);
		
		b.appendToBack(5)
		 .appendToBack(1);
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		Integer[] expecteds = new Integer[]{ 0, 3 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : c) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	@Test
	public void shouldCalculateCorrectlyWhenBothListsAreSameLengthAndWithOverflowAlternate() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		a.appendToBack(1)
		 .appendToBack(5);
		
		b.appendToBack(1)
		 .appendToBack(5);
		
		MyLinkedList<Integer> c = LinkedListUtils.addAlternate(a, b);
		
		Integer[] expecteds = new Integer[]{ 3, 0 };
		
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
		
		a.appendToBack(9)
		 .appendToBack(9);
		
		MyLinkedList<Integer> c = LinkedListUtils.add(a, b);
		
		Integer[] expecteds = new Integer[]{ 9, 9 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : c) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	@Test
	public void shouldReturnCopyOfTheNonEmptyListWhenOneListIsEmptyAlternate() {
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		MyLinkedList<Integer> b = new MyLinkedList<Integer>();
		
		a.appendToBack(9)
		 .appendToBack(9);
		
		MyLinkedList<Integer> c = LinkedListUtils.addAlternate(a, b);
		
		Integer[] expecteds = new Integer[]{ 9, 9 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : c) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}

}
