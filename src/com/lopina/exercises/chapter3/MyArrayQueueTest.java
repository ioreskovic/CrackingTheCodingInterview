package com.lopina.exercises.chapter3;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyArrayQueueTest {

	@Test
	public void shouldGetSizeZeroWhenEmptyQueue() {
		MyDequeue<Integer> queue = new MyArrayDequeue<Integer>();
		
		assertEquals(0, queue.size());
	}
	
	@Test
	public void shouldGetCorrectSizeWhenAddingAndRemovingFromQueue() {
		MyDequeue<Integer> queue = new MyArrayDequeue<Integer>(8);
		assertEquals(0, queue.size());
		
		queue.offerLast(1);
		assertEquals(1, queue.size());
		
		queue.offerLast(2);
		assertEquals(2, queue.size());
		
		queue.offerLast(3);
		assertEquals(3, queue.size());
		
		queue.offerLast(4);
		assertEquals(4, queue.size());
		
		queue.offerLast(5);
		assertEquals(5, queue.size());
		
		assertEquals(Integer.valueOf(1), queue.pollFirst());
		assertEquals(4, queue.size());
		
		assertEquals(Integer.valueOf(2), queue.pollFirst());
		assertEquals(3, queue.size());
		
		assertEquals(Integer.valueOf(3), queue.pollFirst());
		assertEquals(2, queue.size());
		
		queue.offerLast(6);
		assertEquals(3, queue.size());
		
		queue.offerLast(7);
		assertEquals(4, queue.size());
		
		queue.offerLast(8);
		assertEquals(5, queue.size());
		
		queue.offerLast(9);
		assertEquals(6, queue.size());
		
		assertEquals(Integer.valueOf(4), queue.pollFirst());
		assertEquals(5, queue.size());
		
		assertEquals(Integer.valueOf(5), queue.pollFirst());
		assertEquals(4, queue.size());
		
		assertEquals(Integer.valueOf(6), queue.pollFirst());
		assertEquals(3, queue.size());
		
		queue.offerLast(10);
		assertEquals(4, queue.size());
		
		queue.offerLast(11);
		assertEquals(5, queue.size());
		
		queue.offerLast(12);
		assertEquals(6, queue.size());
		
		queue.offerLast(13);
		assertEquals(7, queue.size());
		
		queue.offerLast(14);
		assertEquals(8, queue.size());
		
		assertEquals(Integer.valueOf(7), queue.pollFirst());
		assertEquals(7, queue.size());
		
		assertEquals(Integer.valueOf(8), queue.pollFirst());
		assertEquals(6, queue.size());
		
		assertEquals(Integer.valueOf(9), queue.pollFirst());
		assertEquals(5, queue.size());
		
		assertEquals(Integer.valueOf(10), queue.pollFirst());
		assertEquals(4, queue.size());
		
		assertEquals(Integer.valueOf(11), queue.pollFirst());
		assertEquals(3, queue.size());
		
		assertEquals(Integer.valueOf(12), queue.pollFirst());
		assertEquals(2, queue.size());
		
		assertEquals(Integer.valueOf(13), queue.pollFirst());
		assertEquals(1, queue.size());
		
		assertEquals(Integer.valueOf(14), queue.pollFirst());
		assertEquals(0, queue.size());
	}
	
	@Test
	public void dequeueOperationsShouldMakeDequeueConsistentWhenUsingThem() {
		MyDequeue<Integer> dequeue = new MyArrayDequeue<Integer>(8);
		assertEquals(0, dequeue.size());
		System.out.println(dequeue.toString());
		
		dequeue.offerFirst(3);
		assertEquals(1, dequeue.size());
		System.out.println(dequeue.toString());

		dequeue.offerLast(4);
		assertEquals(2, dequeue.size());
		System.out.println(dequeue.toString());
		
		dequeue.offerFirst(2);
		assertEquals(3, dequeue.size());
		System.out.println(dequeue.toString());

		dequeue.offerLast(5);
		assertEquals(4, dequeue.size());
		System.out.println(dequeue.toString());
		
		dequeue.offerFirst(1);
		assertEquals(5, dequeue.size());
		System.out.println(dequeue.toString());

		dequeue.offerLast(6);
		assertEquals(6, dequeue.size());
		System.out.println(dequeue.toString());
		
		dequeue.offerFirst(0);
		assertEquals(7, dequeue.size());
		System.out.println(dequeue.toString());

		dequeue.offerLast(7);
		assertEquals(8, dequeue.size());
		System.out.println(dequeue.toString());
	}

}
