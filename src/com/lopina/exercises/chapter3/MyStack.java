package com.lopina.exercises.chapter3;

import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {
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
	
	private MyNode<T> top = null;
	
	public void push(T item) {
		MyNode<T> node = new MyNode<T>(item);
		
		node.next = top;
		top = node;
	}
	
	public T pop() {
		T item = null;
		
		if (top != null) {
			item = top.data;
			top = top.next;
		}
		
		return item;
	}
	
	public T peek() {
		if (top != null) {
			return top.data;
		}
		
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private MyNode<T> node = MyStack.this.top;
			
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
