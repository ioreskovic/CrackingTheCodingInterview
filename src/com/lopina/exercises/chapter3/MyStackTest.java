package com.lopina.exercises.chapter3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MyStackTest {

	@Test
	public void emptyStackShouldHaveSizeZero() {
		MyLinkedListStack<Integer> stack = new MyLinkedListStack<Integer>();
		
		assertEquals(0, stack.size());
	}
	
	@Test
	public void stackSizeShouldCorrespondWithTheNumberOfElements() {
		MyLinkedListStack<Integer> stack = new MyLinkedListStack<Integer>();
		assertEquals(0, stack.size());
		
		stack.push(1);
		assertEquals(1, stack.size());
		
		stack.push(2);
		assertEquals(2, stack.size());
		
		stack.pop();
		assertEquals(1, stack.size());
		
		stack.pop();
		assertEquals(0, stack.size());
	}
	
	@Test
	public void stackElementsShouldBeInLifoOrder() {
		MyLinkedListStack<Integer> stack = new MyLinkedListStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		assertEquals(Integer.valueOf(5), stack.pop());
		assertEquals(Integer.valueOf(4), stack.pop());
		assertEquals(Integer.valueOf(3), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
		
		assertNull(stack.pop());
	}
	
	@Test
	public void peekMethodShouldNotAffectStackStructure() {
		MyLinkedListStack<Integer> stack = new MyLinkedListStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		assertEquals(Integer.valueOf(5), stack.peek());
		assertEquals(Integer.valueOf(5), stack.peek());
		assertEquals(Integer.valueOf(5), stack.peek());
		assertEquals(Integer.valueOf(5), stack.peek());
		assertEquals(Integer.valueOf(5), stack.peek());
		
		assertNotNull(stack.pop());
	}
	
	@Test
	public void stackIteratorShouldBeFromTopToBottomOrder() {
		MyLinkedListStack<Integer> stack = new MyLinkedListStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		List<Integer> listIterated = new ArrayList<Integer>();
		
		for (Integer element : stack) {
			listIterated.add(element);
		}
		
		assertArrayEquals(new Integer[] { 5, 4, 3, 2, 1 }, listIterated.toArray(new Integer[listIterated.size()]));
		
	}

}
