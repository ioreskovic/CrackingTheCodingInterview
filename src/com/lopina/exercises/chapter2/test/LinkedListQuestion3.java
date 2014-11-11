package com.lopina.exercises.chapter2.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lopina.exercises.chapter2.LinkedListUtils;
import com.lopina.exercises.chapter2.MyLinkedList;
import com.lopina.exercises.chapter2.MyLinkedList.MyNode;

public class LinkedListQuestion3 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExpcetionWhenNullList() {
		MyLinkedList<Integer> list = null;
		
		LinkedListUtils.deleteNodeAccessOnly(list, new MyNode<Integer>(0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenNodeIsNull() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		LinkedListUtils.deleteNodeAccessOnly(list, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenNodeIsNotInTheMiddleOfTheList() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(10)
			.appendToBack(9)
			.appendToBack(8)
			.appendToBack(7)
			.appendToBack(6)
			.appendToBack(5)
			.appendToBack(4)
			.appendToBack(3)
			.appendToBack(2)
			.appendToBack(1)
			.appendToBack(0);
		
		LinkedListUtils.deleteNodeAccessOnly(list, new MyNode<Integer>(15));
	}
	
	@Test
	public void shouldRemoveNodeWhenNodeIsInTheMiddleOfTheList() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(10)
			.appendToBack(9)
			.appendToBack(8)
			.appendToBack(7)
			.appendToBack(6)
			.appendToBack(5)
			.appendToBack(4)
			.appendToBack(3)
			.appendToBack(2)
			.appendToBack(1)
			.appendToBack(0);
		
		MyNode<Integer> node = list.getHead();
		node = node.getNext();
		node = node.getNext();
		node = node.getNext();
		node = node.getNext();
		node = node.getNext();
		
		LinkedListUtils.deleteNodeAccessOnly(list, node);
		
		Integer[] expecteds = new Integer[]{ 10, 9, 8, 7, 6, 4, 3, 2, 1, 0 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : list) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	@Test
	public void shouldRemoveHeadWhenNodeIsInHeadfTheList() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(10)
			.appendToBack(9)
			.appendToBack(8)
			.appendToBack(7)
			.appendToBack(6)
			.appendToBack(5)
			.appendToBack(4)
			.appendToBack(3)
			.appendToBack(2)
			.appendToBack(1)
			.appendToBack(0);
		
		MyNode<Integer> node = list.getHead();
		
		LinkedListUtils.deleteNodeAccessOnly(list, node);
		
		Integer[] expecteds = new Integer[]{ 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : list) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}

}
