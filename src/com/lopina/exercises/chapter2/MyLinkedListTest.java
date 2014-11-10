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
		
		list.appendToTail(0);
		MyNode<Integer> head = list.getHead();
		
		assertNotNull(head);
	}
	
	@Test
	public void shouldRetainConstatnNonNullHeadWhenLinkedListIsNotEmptyAndOnlyAddingElements() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToTail(0);
		MyNode<Integer> head1 = list.getHead();
		
		assertNotNull(head1);
		
		list.appendToTail(1);
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
		
		list.appendToTail(0);
		MyNode<Integer> head1 = list.getHead();
		assertNotNull(head1);
		
		list.delete(0);
		MyNode<Integer> head2 = list.getHead();
		assertNull(head2);
	}
	
	@Test
	public void shouldHaveElementsListedInAddingOrderWhenNotEmpty() {
		MyLinkedList<Character> list = new MyLinkedList<Character>();
		
		list.appendToTail('F')
			.appendToTail('O')
			.appendToTail('L')
			.appendToTail('L')
			.appendToTail('O')
			.appendToTail('W')
			.appendToTail(' ')
			.appendToTail('U')
			.appendToTail('P');
		
		Character[] expected = new Character[] { 'F', 'O','L', 'L', 'O', 'W', ' ', 'U', 'P' };
		
		List<Character> listElements = new ArrayList<Character>();
		
		for (Character c : list) {
			listElements.add(c);
		}
		
		assertArrayEquals(expected, listElements.toArray(new Character[listElements.size()]));
	}

}
