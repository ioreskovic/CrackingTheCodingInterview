package com.lopina.exercises.chapter3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MyQueueTest {

	@Test
	public void test() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		
		assertEquals(0, queue.size());
	}
	
	@Test
	public void queueSizeShouldCorrespondWithTheNumberOfElements() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		assertEquals(0, queue.size());
		
		queue.enqueue(1);
		assertEquals(1, queue.size());
		
		queue.enqueue(2);
		assertEquals(2, queue.size());
		
		queue.dequeue();
		assertEquals(1, queue.size());
		
		queue.dequeue();
		assertEquals(0, queue.size());
	}
	
	@Test
	public void queueElementsShouldBeInFifoOrder() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		assertEquals(Integer.valueOf(1), queue.dequeue());
		assertEquals(Integer.valueOf(2), queue.dequeue());
		assertEquals(Integer.valueOf(3), queue.dequeue());
		assertEquals(Integer.valueOf(4), queue.dequeue());
		assertEquals(Integer.valueOf(5), queue.dequeue());
		
		assertNull(queue.dequeue());
	}
	
	@Test
	public void queueIteratorShouldBeFromStartToFinishOrder() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		List<Integer> listIterated = new ArrayList<Integer>();
		
		for (Integer element : queue) {
			listIterated.add(element);
		}
		
		assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, listIterated.toArray(new Integer[listIterated.size()]));
	}

}
