package com.lopina.exercises.chapter3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter3.MyStack;
import com.lopina.exercises.chapter3.SetOfStacks;

public class Question3 {

	@Test
	public void shouldReturnNullOnPeekWhenEmptySetOfStacks() {
		MyStack<Integer> sos = new SetOfStacks<Integer>(6);
		System.out.println(sos.toString());
		assertEquals(0, sos.size());
		assertNull(sos.peek());
	}
	
	@Test
	public void shouldCreateNewStacksWhenPreviousStackIsFullOnPushOnFullStack() {
		MyStack<Integer> sos = new SetOfStacks<Integer>(6);
		System.out.println(sos.toString());
		assertEquals(0, sos.size());
		assertNull(sos.peek());
		
		sos.push(1);
		assertEquals(1, sos.size());
		assertEquals(Integer.valueOf(1), sos.peek());
		System.out.println(sos.toString());
		
		sos.push(2);
		assertEquals(2, sos.size());
		assertEquals(Integer.valueOf(2), sos.peek());
		System.out.println(sos.toString());
		
		sos.push(3);
		assertEquals(3, sos.size());
		assertEquals(Integer.valueOf(3), sos.peek());
		System.out.println(sos.toString());
		
		sos.push(4);
		assertEquals(4, sos.size());
		assertEquals(Integer.valueOf(4), sos.peek());
		System.out.println(sos.toString());
		
		sos.push(5);
		assertEquals(5, sos.size());
		assertEquals(Integer.valueOf(5), sos.peek());
		System.out.println(sos.toString());
		
		sos.push(6);
		assertEquals(6, sos.size());
		assertEquals(Integer.valueOf(6), sos.peek());
		System.out.println(sos.toString());
		
		
		sos.push(1);
		assertEquals(7, sos.size());
		assertEquals(Integer.valueOf(1), sos.peek());
		System.out.println(sos.toString());
		
		sos.push(2);
		assertEquals(8, sos.size());
		assertEquals(Integer.valueOf(2), sos.peek());
		System.out.println(sos.toString());
		
		sos.push(3);
		assertEquals(9, sos.size());
		assertEquals(Integer.valueOf(3), sos.peek());
		System.out.println(sos.toString());
		
		sos.push(4);
		assertEquals(10, sos.size());
		assertEquals(Integer.valueOf(4), sos.peek());
		System.out.println(sos.toString());
		
		sos.push(5);
		assertEquals(11, sos.size());
		assertEquals(Integer.valueOf(5), sos.peek());
		System.out.println(sos.toString());
		
		sos.push(6);
		assertEquals(12, sos.size());
		assertEquals(Integer.valueOf(6), sos.peek());
		System.out.println(sos.toString());
		
		
		
		assertEquals(Integer.valueOf(6), sos.pop());
		assertEquals(11, sos.size());
		System.out.println(sos.toString());
		
		assertEquals(Integer.valueOf(5), sos.pop());
		assertEquals(10, sos.size());
		System.out.println(sos.toString());
		
		assertEquals(Integer.valueOf(4), sos.pop());
		assertEquals(9, sos.size());
		System.out.println(sos.toString());
		
		assertEquals(Integer.valueOf(3), sos.pop());
		assertEquals(8, sos.size());
		System.out.println(sos.toString());
		
		assertEquals(Integer.valueOf(2), sos.pop());
		assertEquals(7, sos.size());
		System.out.println(sos.toString());
		
		assertEquals(Integer.valueOf(1), sos.pop());
		assertEquals(6, sos.size());
		System.out.println(sos.toString());
		
		assertEquals(Integer.valueOf(6), sos.pop());
		assertEquals(5, sos.size());
		System.out.println(sos.toString());
		
		assertEquals(Integer.valueOf(5), sos.pop());
		assertEquals(4, sos.size());
		System.out.println(sos.toString());
		
		assertEquals(Integer.valueOf(4), sos.pop());
		assertEquals(3, sos.size());
		System.out.println(sos.toString());
		
		assertEquals(Integer.valueOf(3), sos.pop());
		assertEquals(2, sos.size());
		System.out.println(sos.toString());
		
		assertEquals(Integer.valueOf(2), sos.pop());
		assertEquals(1, sos.size());
		System.out.println(sos.toString());
		
		assertEquals(Integer.valueOf(1), sos.pop());
		assertEquals(0, sos.size());
		System.out.println(sos.toString());
	}

}
