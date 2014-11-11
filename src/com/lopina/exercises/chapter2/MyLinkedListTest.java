package com.lopina.exercises.chapter2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lopina.exercises.chapter2.MyLinkedList.MyNode;

public class MyLinkedListTest {

	@Test
	public void shouldHaveHeadAsNullWhenLinkedListIsEmpty() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		MyNode<Integer> head = list.getHead();
		
		assertNull(head);
	}
	
	@Test
	public void shouldNotHaveHeadAsNullWhenLinkedListIsNotEmpty() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(0);
		MyNode<Integer> head = list.getHead();
		
		assertNotNull(head);
	}
	
	@Test
	public void shouldRetainConstatnNonNullHeadWhenLinkedListIsNotEmptyAndOnlyAddingElements() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(0);
		MyNode<Integer> head1 = list.getHead();
		
		assertNotNull(head1);
		
		list.appendToBack(1);
		MyNode<Integer> head2 = list.getHead();
		
		assertNotNull(head2);
		
		assertSame(head1, head2);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionWhenDeletingFromEmptyList() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.delete(0);
	}
	
	@Test
	public void shouldResetHeadToNullAfterDeletingSingleElementFromSingleElementList() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(0);
		MyNode<Integer> head1 = list.getHead();
		assertNotNull(head1);
		
		list.delete(0);
		MyNode<Integer> head2 = list.getHead();
		assertNull(head2);
	}
	
	@Test
	public void shouldHaveElementsListedInAddingOrderWhenNotEmpty() {
		MyLinkedList<Character> list = new MyLinkedList<Character>();
		
		list.appendToBack('F')
			.appendToBack('O')
			.appendToBack('L')
			.appendToBack('L')
			.appendToBack('O')
			.appendToBack('W')
			.appendToBack(' ')
			.appendToBack('U')
			.appendToBack('P');
		
		Character[] expected = new Character[] { 'F', 'O','L', 'L', 'O', 'W', ' ', 'U', 'P' };
		
		List<Character> listElements = new ArrayList<Character>();
		
		for (Character c : list) {
			listElements.add(c);
		}
		
		assertArrayEquals(expected, listElements.toArray(new Character[listElements.size()]));
	}
	
	@Test
	public void shouldAppendToFrontOfTheListInConstantTime() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToFront(9)
			.appendToFront(8)
			.appendToFront(7)
			.appendToFront(6)
			.appendToFront(5)
			.appendToFront(4)
			.appendToFront(3)
			.appendToFront(2)
			.appendToFront(1)
			.appendToFront(0);
		
		Integer[] expected = new Integer[] { 0, 1, 2, 3, 4, 5, 6,7 , 8, 9 };
		
		List<Integer> listElements = new ArrayList<Integer>();
		
		for (Integer i : list) {
			listElements.add(i);
		}
		
		assertArrayEquals(expected, listElements.toArray(new Integer[listElements.size()]));
	}
	
	@Test
	public void shouldAppendToEndOfTheListInConstantTime() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(0)
			.appendToBack(1)
			.appendToBack(2)
			.appendToBack(3)
			.appendToBack(4)
			.appendToBack(5)
			.appendToBack(6)
			.appendToBack(7)
			.appendToBack(8)
			.appendToBack(9);
		
		Integer[] expected = new Integer[] { 0, 1, 2, 3, 4, 5, 6,7 , 8, 9 };
		
		List<Integer> listElements = new ArrayList<Integer>();
		
		for (Integer i : list) {
			listElements.add(i);
		}
		
		assertArrayEquals(expected, listElements.toArray(new Integer[listElements.size()]));
	}

}
