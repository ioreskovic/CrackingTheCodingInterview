package com.lopina.exercises.chapter3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter3.MyStack;

public class Question2 {

	@Test
	public void shouldReturnNullAsMinimumWhenEmptyStack() {
		MyLinkedListStackWithMin<Integer> stack = new MyLinkedListStackWithMin<Integer>();
		
		Integer min = stack.peekMin();
		
		assertNull(min);
	}
	
	@Test
	public void shouldReturnOnlyElementAsMinimumWhenSingleElementInStack() {
		MyLinkedListStackWithMin<Integer> stack = new MyLinkedListStackWithMin<Integer>();
		
		stack.push(0);
		Integer min = stack.peekMin();
		assertEquals(Integer.valueOf(0), min);
	}
	
	@Test
	public void shouldReturnSameElementAsMinimumWhenMultipleSingleElementInStack() {
		MyLinkedListStackWithMin<Integer> stack = new MyLinkedListStackWithMin<Integer>();
		
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.peekMin());
		
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.peekMin());
		
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.peekMin());
		
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.peekMin());
		
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.peekMin());
		
		stack.pop();
		assertEquals(Integer.valueOf(0), stack.peekMin());
		
		stack.pop();
		assertEquals(Integer.valueOf(0), stack.peekMin());
		
		stack.pop();
		assertEquals(Integer.valueOf(0), stack.peekMin());
		
		stack.pop();
		assertEquals(Integer.valueOf(0), stack.peekMin());
		
		stack.pop();
		assertNull(stack.peekMin());
	}
	
	@Test
	public void shouldReturnMinimumWhenMultipleElementInStack() {
		MyLinkedListStackWithMin<Integer> stack = new MyLinkedListStackWithMin<Integer>();
		
		stack.push(9);
		assertEquals(Integer.valueOf(9), stack.peekMin());
		
		stack.push(8);
		assertEquals(Integer.valueOf(8), stack.peekMin());
		
		stack.push(7);
		assertEquals(Integer.valueOf(7), stack.peekMin());
		
		stack.push(6);
		assertEquals(Integer.valueOf(6), stack.peekMin());
		
		stack.push(5);
		assertEquals(Integer.valueOf(5), stack.peekMin());
		
		stack.push(4);
		assertEquals(Integer.valueOf(4), stack.peekMin());
		
		stack.push(3);
		assertEquals(Integer.valueOf(3), stack.peekMin());
		
		stack.push(2);
		assertEquals(Integer.valueOf(2), stack.peekMin());
		
		stack.push(1);
		assertEquals(Integer.valueOf(1), stack.peekMin());
		
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.peekMin());
		
		
		stack.pop();
		assertEquals(Integer.valueOf(1), stack.peekMin());
		
		stack.pop();
		assertEquals(Integer.valueOf(2), stack.peekMin());
		
		stack.pop();
		assertEquals(Integer.valueOf(3), stack.peekMin());
		
		stack.pop();
		assertEquals(Integer.valueOf(4), stack.peekMin());
		
		stack.pop();
		assertEquals(Integer.valueOf(5), stack.peekMin());
		
		stack.pop();
		assertEquals(Integer.valueOf(6), stack.peekMin());
		
		stack.pop();
		assertEquals(Integer.valueOf(7), stack.peekMin());
		
		stack.pop();
		assertEquals(Integer.valueOf(8), stack.peekMin());
		
		stack.pop();
		assertEquals(Integer.valueOf(9), stack.peekMin());
		
		stack.pop();
		assertNull(stack.peekMin());
	}

}
