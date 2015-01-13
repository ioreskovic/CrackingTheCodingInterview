package com.lopina.exercises.chapter4.graphs.search;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMaxPriorityQueue<Key, Value> implements Iterable<Integer> {

	private Comparator<Key> comparator;
	private int NMAX;
	private int N;
	private int[] pq;
	private int[] qp;
	private Key[] keys;
	
	@SuppressWarnings("unchecked")
	public IndexMaxPriorityQueue(Comparator<Key> comparator, int NMAX) {
		super();
		this.comparator = comparator;
		
		if (NMAX < 0) {
			throw new IllegalArgumentException();
		}
		
        this.NMAX = NMAX;
        keys = (Key[]) new Object[NMAX + 1];
        pq   = new int[NMAX + 1];
        qp   = new int[NMAX + 1];
        
        for (int i = 0; i <= NMAX; i++) {
        	qp[i] = -1;
        }
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public boolean contains(int i) {
        if (i < 0 || i >= NMAX) {
        	throw new IndexOutOfBoundsException();
        }
        
        return qp[i] != -1;
    }
	
	public int size() {
        return N;
    }
	
	public void insert(int i, Key key) {
        if (i < 0 || i >= NMAX) throw new IndexOutOfBoundsException();
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        N++;
        qp[i] = N;
        pq[N] = i;
        keys[i] = key;
        swim(N);
    }
	
	public int maxIndex() { 
        if (N == 0) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];        
    }
	
	public Key maxKey() { 
        if (N == 0) throw new NoSuchElementException("Priority queue underflow");
        return keys[pq[1]];        
    }
	
	public int delMax() { 
        if (N == 0) throw new NoSuchElementException("Priority queue underflow");
        int max = pq[1];        
        exch(1, N--); 
        sink(1);
        qp[max] = -1;            // delete
        keys[pq[N+1]] = null;    // to help with garbage collection
        pq[N+1] = -1;            // not needed
        return max; 
    }
	
	public Key keyOf(int i) {
        if (i < 0 || i >= NMAX) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        else return keys[i];
    }
	
	public void changeKey(int i, Key key) {
        if (i < 0 || i >= NMAX) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }
	
	public void decreaseKey(int i, Key key) {
        if (i < 0 || i >= NMAX) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (compare(keys[i], key) <= 0) throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
        keys[i] = key;
        swim(qp[i]);
    }
	
	public void increaseKey(int i, Key key) {
        if (i < 0 || i >= NMAX) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (compare(keys[i], key) >= 0) throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
        keys[i] = key;
        sink(qp[i]);
    }
	
	public void delete(int i) {
        if (i < 0 || i >= NMAX) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        int index = qp[i];
        exch(index, N--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }
	
	private boolean less(int i, int j) {
		return compare(keys[pq[i]], keys[pq[j]]) < 0;
    }

	private int compare(Key key1, Key key2) {
		return comparator.compare(key1, key2);
	}
	
    private void exch(int i, int j) {
        int swap = pq[i]; pq[i] = pq[j]; pq[j] = swap;
        qp[pq[i]] = i; qp[pq[j]] = j;
    }
	
	private void swim(int k)  {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    
    public Iterator<Integer> iterator() { 
    	return new HeapIterator(); 
    }
    
    private class HeapIterator implements Iterator<Integer> {
        // create a new pq
        private IndexMinPriorityQueue<Key, Value> copy;

        // add all elements to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new IndexMinPriorityQueue<Key, Value>(comparator, pq.length - 1);
            for (int i = 1; i <= N; i++)
                copy.insert(pq[i], keys[pq[i]]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
}
