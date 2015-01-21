package com.lopina.important.take2.priorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public abstract class PriorityQueue<T extends Comparable<T>> implements Iterable<T> {
	private static final Random random = new Random(System.currentTimeMillis());
	
	private T[] heap;
	private int size;
	
	protected PriorityQueue() {
		this(1);
	}
	
	@SuppressWarnings("unchecked")
	protected PriorityQueue(int initialCapacity) {
		this.heap = (T[]) (new Comparable[initialCapacity + 1]);
		this.size = 0;
	}
	
	@SuppressWarnings("unchecked")
	protected PriorityQueue(T[] elements) {
		this.size = elements.length;
		this.heap = (T[]) (new Comparable[elements.length + 1]);
		System.out.println("Copying:");
		for (int i = 0; i < size; i++) {
			this.heap[i + 1] = elements[i];
		}
		System.out.println(Arrays.toString(this.heap));
		
		System.out.println("Sinking:");
		for (int k = size/2; k >= 1; k--) {
			sink(this.heap, k);
			System.out.println("Sank " + k);
			System.out.println(Arrays.toString(this.heap));
		}
	}
	
	public T priorityElement() {
		return this.heap[1];
	}
	
	public void insert(T element) {
		if (this.size == this.heap.length - 1) {
			resize(2 * this.heap.length);
		}
		
		this.heap[++this.size] = element;
		swim(this.heap, this.size);
	}
	
	public T removePriorityElement() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		swap(this.heap, 1, this.size);
		T priorityElement = this.heap[this.size--];
		sink(this.heap, 1);
		this.heap[this.size + 1] = null;
		
		if ((this.size > 0) && (this.size == (this.heap.length - 1) / 4)) {
			resize(this.heap.length / 2);;
		}
		
		return priorityElement;
	}
	
	private void swim(T[] heap, int elementIndex) {
		while (elementIndex > 1 && violatesOrder(elementIndex / 2, elementIndex)) {
			swap(heap, elementIndex, elementIndex / 2);
		}
	}
	
	private void sink(T[] heap, int elementIndex) {
		while (2 * elementIndex <= this.size) {
			int leftChildIndex = 2 * elementIndex;
			if (leftChildIndex < this.size && violatesOrder(leftChildIndex, leftChildIndex + 1)) {
				leftChildIndex++;
			}
			
			if (!violatesOrder(elementIndex, leftChildIndex)) {
				break;
			}
			
			swap(heap, elementIndex, leftChildIndex);
			elementIndex = leftChildIndex;
		}
	}

	protected boolean violatesOrder(int firstIndex, int secondIndex) {
		return violatesOrder(this.heap[firstIndex], this.heap[secondIndex]);
	}
	
	protected abstract boolean violatesOrder(T firstFalue, T secondValue);
	protected abstract PriorityQueue<T> create(int size);

	@SuppressWarnings("unchecked")
	private void resize(int newCapacity) {
		T[] temp = (T[]) (new Object[newCapacity]);
		for (int i = 1; i <= this.size; i++) {
			temp[i] = this.heap[i];
		}
		
		this.heap = temp;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	private void swap(T[] array, int firstIndex, int secondIndex) {
		T temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new HeapIterator();
	}
	
	@Override
	public String toString() {
		return Arrays.toString(heap);
	}
	
	private class HeapIterator implements Iterator<T> {

		private PriorityQueue<T> copy;
		
		public HeapIterator() {
			copy = create(size());
			for (int i = 1; i < size; i++) {
				copy.insert(heap[i]);
			}
		}
		
		@Override
		public boolean hasNext() {
			return !copy.isEmpty();
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			return copy.removePriorityElement();
		}
	}
	
	public static void main(String[] args) {
		Integer[] randomArray;
		
		randomArray = new Integer[15];
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = random.nextInt(6) + i*6;
		}
		List<Integer> list = Arrays.asList(randomArray);
		Collections.shuffle(list, random);
		randomArray = list.toArray(randomArray);
		
		
		System.out.println("Input:");
		System.out.println(Arrays.toString(randomArray));
		System.out.println();
		
		
		System.out.println("MinPQ:");
		PriorityQueue<Integer> minPQ = new MinPriorityQueue<Integer>(randomArray);
		System.out.println(minPQ);
		System.out.println();
		
		System.out.println("MaxPQ:");
		PriorityQueue<Integer> maxPQ = new MaxPriorityQueue<Integer>(randomArray);
		System.out.println(maxPQ);
		System.out.println();
	}
}
