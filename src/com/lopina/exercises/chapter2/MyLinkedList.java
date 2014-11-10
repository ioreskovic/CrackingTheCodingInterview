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
	
	public MyLinkedList<T> appendToTail(T data) {
		MyNode<T> end = new MyNode<T>(data);
		MyNode<T> n = head;
		
		// If the list is empty
		// just set the new node as head
		//
		// Otherwise, find tail, and append
		// the new node as new tail
		if (head == null) {
			head = end;
		} else {
			while (n.next != null) {
				n = n.next;
			}
			
			n.next = end;
		}
		
		return this;
	}
	
	public MyLinkedList<T> delete(T data) {
		deleteNode(data);
		
		return this;
	}
	
	private void deleteNode(T data) {
		MyNode<T> n = head;
		
		if (n.data.equals(data)) {
			head = head.next;
		} else {
			while (n.next != null) {
				if (n.next.data.equals(data)) {
					n.next = n.next.next;
					return;
				}
				
				n = n.next;
			}
		}
	}

	public MyNode<T> getHead() {
		return head;
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
