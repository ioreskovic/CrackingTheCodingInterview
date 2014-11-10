package com.lopina.exercises.chapter2.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lopina.exercises.chapter2.LinkedListUtils;
import com.lopina.exercises.chapter2.MyLinkedList;

public class LinkedListQuestion1 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnNullList() {
		MyLinkedList<Character> list = null;
		
		LinkedListUtils.removeDuplicatesFromHead(list);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnNullListFast() {
		MyLinkedList<Character> list = null;
		
		LinkedListUtils.removeDuplicatesFast(list);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionOnNullListConstantSpace() {
		MyLinkedList<Character> list = null;
		
		LinkedListUtils.removeDuplicatesFast(list);
	}
	
	
	
	
	@Test
	public void shouldReturnImmediatellyWhenEmptyList() {
		MyLinkedList<Character> list = new MyLinkedList<Character>();
		
		LinkedListUtils.removeDuplicatesFromHead(list);
	}
	
	@Test
	public void shouldReturnImmediatellyWhenEmptyListFast() {
		MyLinkedList<Character> list = new MyLinkedList<Character>();
		
		LinkedListUtils.removeDuplicatesFast(list);
	}
	
	@Test
	public void shouldReturnImmediatellyWhenEmptyListConstantSpace() {
		MyLinkedList<Character> list = new MyLinkedList<Character>();
		
		LinkedListUtils.removeDuplicatesFast(list);
	}
	
	
	
	
	@Test
	public void shouldRemoveAllElementsButOneWhenListHasAllSameElements() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A");
		
		System.out.println("Before: " + list.toString());
		
		LinkedListUtils.removeDuplicatesFromHead(list);
		
		System.out.println("After: " + list.toString());
		
		String[] expecteds = new String[] { "A" };
		
		List<String> actuals = new ArrayList<String>();
		
		for (String s : list) {
			actuals.add(s);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new String[actuals.size()]));
	}
	
	@Test
	public void shouldRemoveAllElementsButOneWhenListHasAllSameElementsFast() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A");
		
		System.out.println("Before: " + list.toString());
		
		LinkedListUtils.removeDuplicatesFast(list);
		
		System.out.println("After: " + list.toString());
		
		String[] expecteds = new String[] { "A" };
		
		List<String> actuals = new ArrayList<String>();
		
		for (String s : list) {
			actuals.add(s);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new String[actuals.size()]));
	}
	
	@Test
	public void shouldRemoveAllElementsButOneWhenListHasAllSameElementsConstantSpace() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A")
			.appendToTail("A");
		
		System.out.println("Before: " + list.toString());
		
		LinkedListUtils.removeDuplicatesFast(list);
		
		System.out.println("After: " + list.toString());
		
		String[] expecteds = new String[] { "A" };
		
		List<String> actuals = new ArrayList<String>();
		
		for (String s : list) {
			actuals.add(s);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new String[actuals.size()]));
	}
	
	
	
	
	@Test
	public void shouldRemoveDuplicateElementsWhenListHasDuplicateElements() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.appendToTail("F")
			.appendToTail("O")
			.appendToTail("L")
			.appendToTail("L")
			.appendToTail("O")
			.appendToTail("W")
			.appendToTail(" ")
			.appendToTail("U")
			.appendToTail("P");
		
		System.out.println("Before: " + list.toString());
		
		LinkedListUtils.removeDuplicatesFromHead(list);
		
		System.out.println("After: " + list.toString());
		
		String[] expecteds = new String[] { "F", "L", "O", "W", " ", "U", "P" };
		
		List<String> actuals = new ArrayList<String>();
		
		for (String s : list) {
			actuals.add(s);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new String[actuals.size()]));
	}
	
	@Test
	public void shouldRemoveDuplicateElementsWhenListHasDuplicateElementsFast() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.appendToTail("F")
			.appendToTail("O")
			.appendToTail("L")
			.appendToTail("L")
			.appendToTail("O")
			.appendToTail("W")
			.appendToTail(" ")
			.appendToTail("U")
			.appendToTail("P");
		
		System.out.println("Before: " + list.toString());
		
		LinkedListUtils.removeDuplicatesFast(list);
		
		System.out.println("After: " + list.toString());
		
		String[] expecteds = new String[] { "F", "O", "L", "W", " ", "U", "P" };
		
		List<String> actuals = new ArrayList<String>();
		
		for (String s : list) {
			actuals.add(s);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new String[actuals.size()]));
	}
	
	@Test
	public void shouldRemoveDuplicateElementsWhenListHasDuplicateElementsConstantSpace() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.appendToTail("F")
			.appendToTail("O")
			.appendToTail("L")
			.appendToTail("L")
			.appendToTail("O")
			.appendToTail("W")
			.appendToTail(" ")
			.appendToTail("U")
			.appendToTail("P");
		
		System.out.println("Before: " + list.toString());
		
		LinkedListUtils.removeDuplicatesFast(list);
		
		System.out.println("After: " + list.toString());
		
		String[] expecteds = new String[] { "F", "O", "L", "W", " ", "U", "P" };
		
		List<String> actuals = new ArrayList<String>();
		
		for (String s : list) {
			actuals.add(s);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new String[actuals.size()]));
	}
	
	
	
	
	@Test
	public void shouldNotRemoveElementsWhenListHasNoDuplicateElements() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.appendToTail("A")
			.appendToTail("B")
			.appendToTail("C")
			.appendToTail("D")
			.appendToTail("E")
			.appendToTail("F")
			.appendToTail("G")
			.appendToTail("H")
			.appendToTail("I");
		
		System.out.println("Before: " + list.toString());
		
		LinkedListUtils.removeDuplicatesFromHead(list);
		
		System.out.println("After: " + list.toString());
		
		String[] expecteds = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
		
		List<String> actuals = new ArrayList<String>();
		
		for (String s : list) {
			actuals.add(s);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new String[actuals.size()]));
	}
	
	@Test
	public void shouldNotRemoveElementsWhenListHasNoDuplicateElementsFast() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.appendToTail("A")
			.appendToTail("B")
			.appendToTail("C")
			.appendToTail("D")
			.appendToTail("E")
			.appendToTail("F")
			.appendToTail("G")
			.appendToTail("H")
			.appendToTail("I");
		
		System.out.println("Before: " + list.toString());
		
		LinkedListUtils.removeDuplicatesFast(list);
		
		System.out.println("After: " + list.toString());
		
		String[] expecteds = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
		
		List<String> actuals = new ArrayList<String>();
		
		for (String s : list) {
			actuals.add(s);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new String[actuals.size()]));
	}
	
	@Test
	public void shouldNotRemoveElementsWhenListHasNoDuplicateElementsConstantSpace() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.appendToTail("A")
			.appendToTail("B")
			.appendToTail("C")
			.appendToTail("D")
			.appendToTail("E")
			.appendToTail("F")
			.appendToTail("G")
			.appendToTail("H")
			.appendToTail("I");
		
		System.out.println("Before: " + list.toString());
		
		LinkedListUtils.removeDuplicatesConstantSpace(list);
		
		System.out.println("After: " + list.toString());
		
		String[] expecteds = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
		
		List<String> actuals = new ArrayList<String>();
		
		for (String s : list) {
			actuals.add(s);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new String[actuals.size()]));
	}
	
	
	
	
	@Test
	public void shouldRemoveSingleAndMultipleDuplicateElementsWhenListNoDuplicateElements() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.appendToTail("A")
			.appendToTail("B")
			.appendToTail("B")
			.appendToTail("C")
			.appendToTail("C")
			.appendToTail("C")
			.appendToTail("B")
			.appendToTail("B")
			.appendToTail("A");
		
		System.out.println("Before: " + list.toString());
		
		LinkedListUtils.removeDuplicatesFromHead(list);
		
		System.out.println("After: " + list.toString());
		
		String[] expecteds = new String[] { "C", "B", "A" };
		
		List<String> actuals = new ArrayList<String>();
		
		for (String s : list) {
			actuals.add(s);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new String[actuals.size()]));
	}
	
	@Test
	public void shouldRemoveSingleAndMultipleDuplicateElementsWhenListNoDuplicateElementsFast() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.appendToTail("A")
			.appendToTail("B")
			.appendToTail("B")
			.appendToTail("C")
			.appendToTail("C")
			.appendToTail("C")
			.appendToTail("B")
			.appendToTail("B")
			.appendToTail("A");
		
		System.out.println("Before: " + list.toString());
		
		LinkedListUtils.removeDuplicatesFast(list);
		
		System.out.println("After: " + list.toString());
		
		String[] expecteds = new String[] { "A", "B", "C" };
		
		List<String> actuals = new ArrayList<String>();
		
		for (String s : list) {
			actuals.add(s);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new String[actuals.size()]));
	}
	
	@Test
	public void shouldRemoveSingleAndMultipleDuplicateElementsWhenListNoDuplicateElementsConstantSpace() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.appendToTail("A")
			.appendToTail("B")
			.appendToTail("B")
			.appendToTail("C")
			.appendToTail("C")
			.appendToTail("C")
			.appendToTail("B")
			.appendToTail("B")
			.appendToTail("A");
		
		System.out.println("Before: " + list.toString());
		
		LinkedListUtils.removeDuplicatesConstantSpace(list);
		
		System.out.println("After: " + list.toString());
		
		String[] expecteds = new String[] { "A", "B", "C" };
		
		List<String> actuals = new ArrayList<String>();
		
		for (String s : list) {
			actuals.add(s);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new String[actuals.size()]));
	}

}
