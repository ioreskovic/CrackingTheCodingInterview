package com.lopina.exercises.chapter3;

import java.util.Iterator;

public class MyLinkedListQueue<T> implements MyQueue<T> {

	public static class MyNode<T> {
		T data;
		MyNode<T> next;
		
		public MyNode(T data) {
			this.data = data;
		}
		
		public MyNode<T> getNext() {
			return next;
		}
	}
	
	private MyNode<T> first = null;
	private MyNode<T> last = null;
	private int size = 0;
	
	@Override
	public void enqueue(T item) {
		MyNode<T> newNode = new MyNode<T>(item);
		
		if (first == null) {
			last = newNode;
			first = last;
		} else {
			last.next = newNode;
			last = newNode;
		}
		
		size ++;
	}
	
	@Override
	public T dequeue() {
		T item = null;
		
		if (first != null) {
			item = first.data;
			first = first.next;
			
			size --;
		}
		
		return item;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private MyNode<T> node = MyLinkedListQueue.this.first;
			
			@Override
			public boolean hasNext() {
				return node != null;
			}

			@Override
			public T next() {
				T data = node.data;
				node = node.next;
				return data;
			}
		};
	}
	
	@Override
	public int size() {
		return size;
	}
}
