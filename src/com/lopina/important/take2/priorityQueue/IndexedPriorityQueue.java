package com.lopina.important.take2.priorityQueue;

import java.util.NoSuchElementException;

public abstract class IndexedPriorityQueue<T extends Comparable<T>> {
	private int NMAX;
	private int N;
	private int[] pq;
	private int[] qp;
	private T[] elements;
	
	@SuppressWarnings("unchecked")
	protected IndexedPriorityQueue(int NMAX) {
		if (NMAX < 0) {
			throw new IllegalArgumentException();
		}
		
		this.NMAX = NMAX;
		this.elements = (T[]) (new Comparable[NMAX + 1]);
		this.pq = new int[NMAX + 1];
		this.qp = new int[NMAX + 1];
		
		for (int i = 0; i <= NMAX; i++) {
			qp[i] = -1;
		}
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public boolean contains(int i) {
		if (i < 0 || i >= NMAX) {
			throw new IndexOutOfBoundsException();
		}
		return qp[i] != -1;
	}
	
	public void insert(int i, T element) {
		if (i < 0 || i >= NMAX) {
			throw new IndexOutOfBoundsException();
		}
		
		if (contains(i)) {
			throw new IllegalArgumentException();
		}
		
		N++;
		qp[i] = N;
		pq[N] = i;
		elements[i] = element;
		swim(N);
	}
	
	public int priorityIndex() {
		if (N == 0) {
			throw new NoSuchElementException();
		}
		
		return pq[1];
	}
	
	public T priorityElement() {
		if (N == 0) {
			throw new NoSuchElementException();
		}
		
		return elements[pq[1]];
	}
	
	public int removePriority() {
		if (N == 0) {
			throw new NoSuchElementException();
		}
		
		int priorityElementIndex = pq[1];
		swap(1, N--);
		sink(1);
		qp[priorityElementIndex] = -1;
		elements[pq[N+1]] = null;
		pq[N+1] = -1;
		
		return priorityElementIndex;
	}
	
	public T elementOf(int i) {
		if (i < 0 || i >= NMAX) {
			throw new IndexOutOfBoundsException();
		}
		
		if (!contains(i)) {
			throw new NoSuchElementException();
		}
		
		return elements[i];
	}
	
	public void changeElement(int i, T element) {
		if (i < 0 || i >= NMAX) {
			throw new IndexOutOfBoundsException();
		}
		
		if (!contains(i)) {
			throw new NoSuchElementException();
		}
		
		elements[i] = element;
		swim(qp[i]);
		sink(qp[i]);
	}
	
	public void decreaseElement(int i, T element) {
		if (i < 0 || i >= NMAX) {
			throw new IndexOutOfBoundsException();
		}
		
		if (!contains(i)) {
			throw new NoSuchElementException();
		}
		
		if (elements[i].compareTo(element) <= 0) {
			throw new IllegalArgumentException("Calling decreaseElement() with given argument would not strictly decrease the key");
		}
		
		elements[i] = element;
		swim(qp[i]);
	}
	
	public void increaseElement(int i, T element) {
		if (i < 0 || i >= NMAX) {
			throw new IndexOutOfBoundsException();
		}
		
		if (!contains(i)) {
			throw new NoSuchElementException();
		}
		
		if (elements[i].compareTo(element) >= 0) {
			throw new IllegalArgumentException("Calling increaseElement() with given argument would not strictly decrease the key");
		}
		
		elements[i] = element;
		sink(qp[i]);
	}
	
	public void remove(int i) {
		if (i < 0 || i >= NMAX) {
			throw new IndexOutOfBoundsException();
		}
		
		if (!contains(i)) {
			throw new NoSuchElementException();
		}
		
		int index = qp[i];
		swap(index, N--);
		swim(index);
		sink(index);
		elements[i] = null;
		qp[i] = -1;
	}

	
	
	private void swim(int k) {
		while (k > 1 && orderViolated(k/2, k)) {
			swap(k, k/2);
			k = k/2;
		}
	}

	private void sink(int k) {
		while (2*k <= N) {
			int j = 2*k;
			if (j < N && orderViolated(j, j + 1)) {
				j++;
			}
			if (!orderViolated(k, j)) {
				break;
			}
			swap(k, j);
			k = j;
		}
	}
	
	private boolean orderViolated(int i, int j) {
		return orderViolated(elements[pq[i]], elements[pq[j]]);
	}

	protected abstract boolean orderViolated(T t, T t2);

	private void swap(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}
	
	
}
