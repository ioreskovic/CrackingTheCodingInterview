package com.lopina.important.take2.tree.binary.search;

import java.util.Arrays;

public class ArrayBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
	private T[] treeArray;

	@SuppressWarnings("unchecked")
	public ArrayBinarySearchTree() {
		this.treeArray = (T[]) new Comparable[1];
	}
	
	@Override
	public void add(T item) {
		int nodeIndex = 0;
		
		while(exists(nodeIndex)) {
			T subRoot = get(nodeIndex);
			int cmp = item.compareTo(subRoot);
			if (cmp == 0) {
				return;
			} else if (cmp < 0) {
				nodeIndex = 2 * nodeIndex + 1;
			} else if (cmp > 0) {
				nodeIndex = 2 * nodeIndex + 2;
			}
		}
		
		ensureCapacity(nodeIndex * 2 + 2);
		set(nodeIndex, item);
	}
	
	@Override
	public void remove(T item) {
		int toBeDeletedIndex = get(0, item);
		
		if (!exists(toBeDeletedIndex)) {
			return;
		}
		
		int successorIndex = min(2 * toBeDeletedIndex + 2);
		treeArray[toBeDeletedIndex] = treeArray[successorIndex];
		
		// TODO
		pullUpRight(successorIndex);
	}

	private void pullUpRight(int nodeIndex) {
		// TODO Auto-generated method stub
		
	}

	private int get(int i, T item) {
		int nodeIndex = i;
		
		while(exists(nodeIndex)) {
			T subRoot = get(nodeIndex);
			int cmp = item.compareTo(subRoot);
			if (cmp == 0) {
				return nodeIndex;
			} else if (cmp < 0) {
				nodeIndex = 2 * nodeIndex + 1;
			} else if (cmp > 0) {
				nodeIndex = 2 * nodeIndex + 2;
			}
		}
		
		if (!exists(nodeIndex)) {
			return -1;
		}
		
		return nodeIndex;
	}

	@Override
	public T get(T item) {
		int nodeIndex = 0;
		
		while(exists(nodeIndex)) {
			T subRoot = get(nodeIndex);
			int cmp = item.compareTo(subRoot);
			if (cmp == 0) {
				return subRoot;
			} else if (cmp < 0) {
				nodeIndex = 2 * nodeIndex + 1;
			} else if (cmp > 0) {
				nodeIndex = 2 * nodeIndex + 2;
			}
		}
		
		return null;
	}

	@Override
	public boolean contains(T item) {
		return get(item) != null;
	}
	
	@Override
	public T min() {
		return treeArray[min(0)];
	}

	private int min(int nodeIndex) {
		while (exists(nodeIndex)) {
			int leftIndex = 2 * nodeIndex + 1;
			if (!exists(leftIndex)) {
				break;
			}
			nodeIndex = leftIndex;
		}
		
		return nodeIndex;
	}

	@Override
	public T max() {
		return treeArray[max(0)];
	}
	
	private int max(int nodeIndex) {
		while (exists(nodeIndex)) {
			int rightIndex = 2 * nodeIndex + 2;
			if (!exists(rightIndex)) {
				break;
			}
			nodeIndex = rightIndex;
		}
		
		return nodeIndex;
	}

	private boolean exists(int nodeIndex) {
		if (nodeIndex < 0 || nodeIndex >= treeArray.length) {
			return false;
		}
		
		return treeArray[nodeIndex] != null;
	}

	private T get(int nodeIndex) {
		return treeArray[nodeIndex];
	}

	private void ensureCapacity(int newCapacity) {
		if (newCapacity >= treeArray.length) {
			treeArray = Arrays.copyOf(treeArray, newCapacity + 1);
		}
	}

	private void set(int nodeIndex, T item) {
		this.treeArray[nodeIndex] = item;
	}

	@Override
	public String toString() {
		return Arrays.toString(treeArray);
	}
	
	public static void main(String[] args) {
		ArrayBinarySearchTree<Integer> tree = new ArrayBinarySearchTree<Integer>();
		System.out.println(tree);
		System.out.println();
		int element;
		
		element = 4;
		System.out.println("Adding " + element);
		tree.add(element);
		System.out.println(tree);
		System.out.println();
		
		
		element = 2;
		System.out.println("Adding " + element);
		tree.add(element);
		System.out.println(tree);
		System.out.println();
		
		
		element = 6;
		System.out.println("Adding " + element);
		tree.add(element);
		System.out.println(tree);
		System.out.println();
		
		
		element = 1;
		System.out.println("Adding " + element);
		tree.add(element);
		System.out.println(tree);
		System.out.println();
		
		
		element = 3;
		System.out.println("Adding " + element);
		tree.add(element);
		System.out.println(tree);
		System.out.println();
		
		
		element = 5;
		System.out.println("Adding " + element);
		tree.add(element);
		System.out.println(tree);
		System.out.println();
		
		
		element = 7;
		System.out.println("Adding " + element);
		tree.add(element);
		System.out.println(tree);
		System.out.println();
		
		element = 0;
		System.out.println("Adding " + element);
		tree.add(element);
		System.out.println(tree);
		System.out.println();
		
		element = 5;
		System.out.println("Adding " + element);
		tree.add(element);
		System.out.println(tree);
		System.out.println();
		
		System.out.println(tree.min());
		System.out.println(tree.max());
		
		tree.remove(6);
		System.out.println(tree);
		
		ArrayBinarySearchTree<String> testTree = new ArrayBinarySearchTree<String>();
		testTree.add("S");
		testTree.add("E");
		testTree.add("X");
		testTree.add("A");
		testTree.add("R");
		testTree.add("C");
		testTree.add("H");
		testTree.add("M");
		System.out.println(testTree);
		testTree.remove("E");
		System.out.println(testTree);
	}

	@Override
	public Iterable<T> diameter() {
		// TODO Auto-generated method stub
		return null;
	}

}
