package com.lopina.exercises.chapter2;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
	public static class MyNode<T> {
		MyNode<T> next = null;
		T data;
		
		public MyNode(T data) {
			this.data = data;
		}
		
		public MyNode<T> getNext() {
			return next;
		}
	}
	
	private MyNode<T> head;
	private MyNode<T> tail;
	
	public MyLinkedList<T> appendToFront(T data) {
		MyNode<T> start = new MyNode<T>(data);
		
		if (head == null) {
			tail = start;
		} else {
			start.next = head;
		}
		
		head = start;
		
		return this;
	}
	
	public MyLinkedList<T> appendToBack(T data) {
		MyNode<T> end = new MyNode<T>(data);
		
		MyNode<T> n = head;
		
		if (head == null) {
			head = end;
		} else {
			tail.next = end;
		}
		
		tail = end;
		
		return this;
	}
	
	public MyLinkedList<T> delete(T data) {
		deleteNode(data);
		
		return this;
	}
	
	private void deleteNode(T data) {
		MyNode<T> n = head;
		
		if (n.data.equals(data)) {
			if (tail == head) {
				tail = null;
			}
			
			head = head.next;
		} else {
			while (n.next != null) {
				if (n.next.data.equals(data)) {
					n.next = n.next.next;
					
					tail = n;
					return;
				}
				
				n = n.next;
			}
		}
	}

	public MyNode<T> getHead() {
		return head;
	}
	
	public void setHead(MyNode<T> head) {
		this.head = head;
	}
	
	public MyNode<T> getTail() {
		return tail;
	}
	
	public void setTail(MyNode<T> tail) {
		this.tail = tail;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private MyNode<T> node = MyLinkedList.this.head;
			
			
			@Override
			public boolean hasNext() {
				return (node != null);
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("{").append(" ");
		
		for (T element : this) {
			sb.append(element.toString()).append(" ");
		}
		
		sb.append("}");
		
		return sb.toString();
	}
	
}
