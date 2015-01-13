package com.lopina.exercises.chapter3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter3.MySortableStack;

public class Question6 {

	@Test
	public void shouldDoNothingWhenEmptyStack() {
		MySortableStack<Integer> stack = new MySortableStack<Integer>();
		
		stack.sort();
		
		assertEquals(0, stack.size());
	}
	
	@Test
	public void shouldSortWhenStackHasOnlyOneElement() {
		MySortableStack<Integer> stack = new MySortableStack<Integer>();
		
		stack.push(1);
		
		stack.sort();
		
		assertEquals(1, stack.size());
		assertEquals(Integer.valueOf(1), stack.peek());
	}
	
	@Test
	public void shouldSortWhenElementsAlreadyInOrder() {
		MySortableStack<Integer> stack = new MySortableStack<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		stack.sort();
		
		assertEquals(6, stack.size());
		
		assertEquals(Integer.valueOf(6), stack.pop());
		assertEquals(Integer.valueOf(5), stack.pop());
		assertEquals(Integer.valueOf(4), stack.pop());
		assertEquals(Integer.valueOf(3), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
	}
	
	@Test
	public void shouldSortWhenElementsInReverseOrder() {
		MySortableStack<Integer> stack = new MySortableStack<Integer>();
		
		stack.push(6);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		stack.sort();
		
		assertEquals(6, stack.size());
		
		assertEquals(Integer.valueOf(6), stack.pop());
		assertEquals(Integer.valueOf(5), stack.pop());
		assertEquals(Integer.valueOf(4), stack.pop());
		assertEquals(Integer.valueOf(3), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
	}
	
	@Test
	public void shouldSortWhenElementsInMixedOrder() {
		MySortableStack<Integer> stack = new MySortableStack<Integer>();
		
		stack.push(6);
		stack.push(1);
		stack.push(5);
		stack.push(2);
		stack.push(4);
		stack.push(3);
		
		stack.sort();
		
		assertEquals(6, stack.size());
		
		assertEquals(Integer.valueOf(6), stack.pop());
		assertEquals(Integer.valueOf(5), stack.pop());
		assertEquals(Integer.valueOf(4), stack.pop());
		assertEquals(Integer.valueOf(3), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
	}
	
	@Test
	public void shouldSortWhenElementsInMixedOrderAndAddedAgainInMixedOrder() {
		MySortableStack<Integer> stack = new MySortableStack<Integer>();
		
		stack.push(6);
		stack.push(1);
		stack.push(5);
		stack.push(2);
		stack.push(4);
		stack.push(3);
		
		stack.sort();
		
		stack.push(10);
		stack.push(7);
		stack.push(9);
		stack.push(8);
		
		stack.sort();
		
		assertEquals(10, stack.size());
		
		assertEquals(Integer.valueOf(10), stack.pop());
		assertEquals(Integer.valueOf(9), stack.pop());
		assertEquals(Integer.valueOf(8), stack.pop());
		assertEquals(Integer.valueOf(7), stack.pop());
		assertEquals(Integer.valueOf(6), stack.pop());
		assertEquals(Integer.valueOf(5), stack.pop());
		assertEquals(Integer.valueOf(4), stack.pop());
		assertEquals(Integer.valueOf(3), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
	}

}
