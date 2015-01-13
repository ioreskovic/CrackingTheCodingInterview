package com.lopina.exercises.chapter3.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lopina.exercises.chapter3.MyTwoStackQueue;

public class Question5 {

	@Test
	public void shouldBeEmptyWhenCreatedEmptyQueue() {
		MyTwoStackQueue<Integer> queue = new MyTwoStackQueue<Integer>();
		assertEquals(0, queue.size());
	}
	
	@Test
	public void queueSizeShouldCorrespondWithTheNumberOfElements() {
		MyTwoStackQueue<Integer> queue = new MyTwoStackQueue<Integer>();
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
		MyTwoStackQueue<Integer> queue = new MyTwoStackQueue<Integer>();
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
	}
	
	@Test
	public void queueIteratorShouldBeFromStartToFinishOrder() {
		MyTwoStackQueue<Integer> queue = new MyTwoStackQueue<Integer>();
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
	
	@Test
	public void elementsShouldBeEnqueuedAndDeqeuedInProperOrderWhenUsingTwoStacks() {
		MyTwoStackQueue<Integer> queue = new MyTwoStackQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		assertEquals(Integer.valueOf(1), queue.dequeue());
		assertEquals(Integer.valueOf(2), queue.dequeue());
		assertEquals(Integer.valueOf(3), queue.dequeue());
		
		queue.enqueue(6);
		queue.enqueue(7);
		
		assertEquals(Integer.valueOf(4), queue.dequeue());
		assertEquals(Integer.valueOf(5), queue.dequeue());
		assertEquals(Integer.valueOf(6), queue.dequeue());
		
		queue.enqueue(8);
		queue.enqueue(9);
		
		assertEquals(Integer.valueOf(7), queue.dequeue());
		assertEquals(Integer.valueOf(8), queue.dequeue());
		assertEquals(Integer.valueOf(9), queue.dequeue());
	}

}
