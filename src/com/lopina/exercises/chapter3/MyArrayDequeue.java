package com.lopina.exercises.chapter3;

import java.util.Iterator;

public class MyArrayDequeue<T> implements MyDequeue<T> {

	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	private T[] elements = null;
	
	private int head = 0;
	private int tail = 0;
	private int size = 0;
	
	public MyArrayDequeue() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayDequeue(int initialCapacity) {
		this.elements = (T[]) new Object[initialCapacity];
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int cursor = head;
			private int sizeTraversed = 0;
			private int size = size();
			
			@Override
			public boolean hasNext() {
				return (sizeTraversed < size);
			}

			@Override
			public T next() {
				T item = elements[((cursor + sizeTraversed) & (elements.length - 1))];
				sizeTraversed++;
				
				return item;
			}
		};
	}

	@SuppressWarnings("unchecked")
	private void checkForDoubleCapacity(boolean required) {
		if (!required) {
			return;
		}
		
		int newCapacity = elements.length << 1;
		T[] newElements = (T[]) new Object[newCapacity];
		
		int oldHead = head;
		int oldLength = elements.length;
		int elementsRightOfHead = oldLength - oldHead;
		
		System.arraycopy(elements, oldHead, newElements, 0, elementsRightOfHead);
		System.arraycopy(elements, 0, newElements, elementsRightOfHead, oldHead);
		
		elements = newElements;
		head = 0;
		tail = oldLength;
	}
	
	@SuppressWarnings("unchecked")
	private void checkForHalfCapacity(boolean required) {
		if (!required) {
			return;
		}
		
		int newCapacity = elements.length >> 1;
		T[] newElements = (T[]) new Object[newCapacity];
		
		int oldHead = head;
		int oldTail = tail;
		int oldLength = elements.length;
		int elementsRightOfHead = oldLength - oldHead;
		int oldSize = size();
		
		if (oldSize > 0) {
			if (oldHead < oldTail) {
				System.arraycopy(elements, oldHead, newElements, 0, oldTail - oldHead);
			} else {
				System.arraycopy(elements, oldHead, newElements, 0, elementsRightOfHead);
				System.arraycopy(elements, 0, newElements, elementsRightOfHead, oldHead);
			}
		}
		
		elements = newElements;
		head = 0;
		tail = oldSize;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("{ ");

		for (T element : elements) {
			if (element != null) {
				sb.append(element.toString());
			} else {
				sb.append("_");
			}
			
			sb.append(" ");
		}
		
		sb.append("}");
		
		return sb.toString();
	}

	@Override
	public void offerFirst(T item) {
		head = (head - 1) & (elements.length - 1);
		elements[head] = item;
		size ++;
		checkForDoubleCapacity(head == tail);
	}

	@Override
	public void offerLast(T item) {
		this.elements[tail] = item;
		tail = (tail + 1) & (elements.length - 1);
		size ++;
		checkForDoubleCapacity(head == tail);
	}

	@Override
	public T pollFirst() {
		int dequeueIndex = head;
		
		T item = this.elements[dequeueIndex];
		this.elements[dequeueIndex] = null;
		head = (dequeueIndex + 1) & (elements.length - 1);
		
		size --;
		
		checkForHalfCapacity(size < elements.length / 4);
		return item;
	}

	@Override
	public T pollLast() {
		int pollIndex = (tail - 1) & (elements.length - 1);
		T item = elements[pollIndex];
		elements[pollIndex] = null;
		tail = pollIndex;
		
		size --;
		
		checkForHalfCapacity(size < elements.length / 4);
		return item;
	}
}
