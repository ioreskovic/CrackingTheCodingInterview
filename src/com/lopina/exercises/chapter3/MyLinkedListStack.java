package com.lopina.exercises.chapter3;

import java.util.Iterator;

public class MyLinkedListStack<T> implements MyStack<T> {
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
	private int size = 0;
	
	@Override
	public void push(T item) {
		MyNode<T> node = new MyNode<T>(item);
		
		node.next = top;
		top = node;
		
		size ++;
	}
	
	@Override
	public T pop() {
		T item = null;
		
		if (top != null) {
			item = top.data;
			top = top.next;
			
			size --;
		}
		
		return item;
	}
	
	@Override
	public T peek() {
		if (top != null) {
			return top.data;
		}
		
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private MyNode<T> node = MyLinkedListStack.this.top;
			
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
