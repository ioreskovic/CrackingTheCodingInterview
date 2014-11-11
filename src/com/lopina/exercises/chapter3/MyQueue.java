package com.lopina.exercises.chapter3;

import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {

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
	
	public void enqueue(T item) {
		MyNode<T> newNode = new MyNode<T>(item);
		
		if (first == null) {
			last = newNode;
			first = last;
		} else {
			last.next = newNode;
			last = newNode;
		}
	}
	
	public T dequeue() {
		T item = null;
		
		if (first != null) {
			item = first.data;
			first = first.next;
			
			return item;
		}
		
		return item;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private MyNode<T> node = MyQueue.this.first;
			
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
}
