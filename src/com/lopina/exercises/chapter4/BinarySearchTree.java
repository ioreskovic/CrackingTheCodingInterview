package com.lopina.exercises.chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<Key extends Comparable<Key>, Value> extends Tree<Key, Value> {
	private BSTNode<Key, Value> root;
	
	public BinarySearchTree() {
	}
	
	public BinarySearchTree(SymbolTableEntry<Key, Value> ... entries) {
		populateFromSorted(entries, 0, entries.length - 1);
	}
	
	public BinarySearchTree(boolean x, SymbolTableEntry<Key, Value> ... entries) {
		this.root = populateFromSortedNative(entries, 0, entries.length - 1);
	}
	
	private BSTNode<Key, Value> populateFromSortedNative(SymbolTableEntry<Key, Value>[] entries, int from, int to) {
		if (from > to) {
			return null;
		}
		
		int mid = (to + from + 1) / 2;
		BSTNode<Key, Value> node = new BSTNode<Key, Value>(entries[mid].getKey(), entries[mid].getValue(), 1);
		
		node.left = populateFromSortedNative(entries, from, mid - 1);
		node.right = populateFromSortedNative(entries, mid + 1, to);	
		
		return node;
	}

	private void populateFromSorted(SymbolTableEntry<Key, Value>[] entries, int from, int to) {
		System.out.println("populate(" + from + ", " + to + ")");
		if (from > to) {
			return;
		}
		
		int mid = (to + from + 1) / 2;
		
		add(entries[mid].getKey(), entries[mid].getValue());
		
		populateFromSorted(entries, from, mid - 1);
		populateFromSorted(entries, mid + 1, to);
	}

	static class BSTNode<Key extends Comparable<Key>, Value> extends Node<Key, Value> {

		private int subtreeSize;
		private BSTNode<Key, Value> parent;
		private BSTNode<Key, Value> left;
		private BSTNode<Key, Value> right;
		
		public BSTNode(Key key, Value value, int subtreeSize) {
			super(key, value);
			this.subtreeSize = subtreeSize;
		}

		@Override
		public BSTNode<Key, Value> getLeft() {
			return this.left;
		}


		@Override
		public BSTNode<Key, Value> getRight() {
			return this.right;
		}
		
	}
	
	@Override
	public void add(Key key, Value value) {
		root = addToSubTree(root, key, value);
	}

	private BSTNode<Key, Value> addToSubTree(BSTNode<Key, Value> node, Key key, Value value) {
		if (node == null) {
			return new BSTNode<Key, Value>(key, value, 1);
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) {
			node.left = addToSubTree(node.left, key, value);
			setParent(node.left, node);
		} else if (cmp > 0) {
			node.right = addToSubTree(node.right, key, value);
			setParent(node.right, node);
		} else {
			node.value = value;
		}
		
		node.subtreeSize = 1 + subtreeSize(node.left) + subtreeSize(node.right);
		
		return node;
	}

	private void setParent(BSTNode<Key, Value> child, BSTNode<Key, Value> parent) {
		child.parent = parent;
	}

	@Override
	public void delete(Key key) {
		root = deleteInSubtree(root, key);
	}
	
	private BSTNode<Key, Value> deleteInSubtree(BSTNode<Key, Value> node, Key key) {
		if (node == null) {
			return null;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) {
			node.left = deleteInSubtree(node.left, key);
			setParent(node.left, node);
		} else if (cmp > 0) {
			node.right = deleteInSubtree(node.right, key);
			setParent(node.right, node);
		} else {
			if (node.right == null) {
				return node.left;
			}
			
			if (node.left == null) {
				return node.right;
			}
			
			BSTNode<Key, Value> temp = node;
			
			node = findMinInSubtree(temp.right);
			node.right = deleteMinInSubtree(temp.right);
			node.left = temp.left;
		}
		
		node.subtreeSize = 1 + subtreeSize(node.left) + subtreeSize(node.right);
		
		return node;
	}

	public Value prevValue(Key key) {
		BSTNode<Key, Value> prevNode = prev(root, key);
		
		if (prevNode == null) {
			return null;
		}
		
		return prevNode.value;
	}
	
	public Value nextValue(Key key) {
		BSTNode<Key, Value> nextNode = next(root, key);
		
		if (nextNode == null) {
			return null;
		}
		
		return nextNode.value;
	}
	
	private BSTNode<Key, Value> prev(BSTNode<Key, Value> node, Key key) {
		if (node == null) {
			return null;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp == 0) {
			return findMaxInSubtree(node.left);
		} else if (cmp < 0) {
			return prev(node.left, key);
		} else {
			BSTNode<Key, Value> tmp = prev(node.right, key);
			if (tmp == null) {
				return node;
			} else {
				return tmp;
			}
		}
	}
	
	private BSTNode<Key, Value> next(BSTNode<Key, Value> node, Key key) {
		if (node == null) {
			return null;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp == 0) {
			return findMinInSubtree(node.right);
		} else if (cmp > 0) {
			return next(node.right, key);
		} else {
			BSTNode<Key, Value> tmp = next(node.left, key);
			if (tmp == null) {
				return node;
			} else {
				return tmp;
			}
		}
	}
	
	public SymbolTableEntry<Key, Value> min(Key key) {
		BSTNode<Key, Value> node = findMinInSubtree(root);
		
		if (node == null) {
			return null;
		}
		
		return new SymbolTableEntry<Key, Value>(node.key, node.value);
	}
	
	private BSTNode<Key, Value> findMinInSubtree(BSTNode<Key, Value> node) {
		if (node == null) {
			return null;
		}
		
		if (node.left == null) {
			return node;
		}
		
		return findMinInSubtree(node.left);
	}
	
	public SymbolTableEntry<Key, Value> max(Key key) {
		BSTNode<Key, Value> node = findMaxInSubtree(root);
		
		if (node == null) {
			return null;
		}
		
		return new SymbolTableEntry<Key, Value>(node.key, node.value);
	}
	
	private BSTNode<Key, Value> findMaxInSubtree(BSTNode<Key, Value> node) {
		if (node == null) {
			return null;
		}
		
		if (node.right == null) {
			return node;
		}
		
		return findMaxInSubtree(node.right);
	}
	
	public int rank(Key key) {
		return rank(root, key);
	}
	
	private int rank(BSTNode<Key, Value> node, Key key) {
		if (node == null) {
			return 0;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) {
			return rank(node.left, key);
		} else if (cmp > 0) {
			return 1 + subtreeSize(node.left) + rank(node.right, key);
		} else {
			return subtreeSize(node.left);
		}
	}
	
	public SymbolTableEntry<Key, Value> floor(Key key) {
		BSTNode<Key, Value> node = findFloorInSubtree(root, key);
		
		if (node == null) {
			return null;
		}
		
		return new SymbolTableEntry<Key, Value>(node.key, node.value);
	}
	
	private BSTNode<Key, Value> findFloorInSubtree(BSTNode<Key, Value> node, Key key) {
		if (node == null) {
			return null;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp == 0) {
			return node;
		} else if (cmp < 0) {
			return findFloorInSubtree(node.left, key);
		} else {
			BSTNode<Key, Value> tmp = findFloorInSubtree(node.right, key);
			if (tmp != null) {
				return tmp;
			} else {
				return node;
			}
		}
	}
	
	public SymbolTableEntry<Key, Value> ceil(Key key) {
		BSTNode<Key, Value> node = findCeilingInSubtree(root, key);
		
		if (node == null) {
			return null;
		}
		
		return new SymbolTableEntry<Key, Value>(node.key, node.value);
	}
	
	private BSTNode<Key, Value> findCeilingInSubtree(BSTNode<Key, Value> node, Key key) {
		if (node == null) {
			return null;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp == 0) {
			return node;
		} else if (cmp > 0) {
			return findCeilingInSubtree(node.right, key);
		} else {
			BSTNode<Key, Value> tmp = findCeilingInSubtree(node.left, key);
			if (tmp != null) {
				return tmp;
			} else {
				return node;
			}
		}
	}
	
	public SymbolTableEntry<Key, Value> kthOrderStatistic(int k) {
		BSTNode<Key, Value> kthNode = selectKthInSubtree(root, k);
		
		if (kthNode == null) {
			return null;
		}
		
		return new SymbolTableEntry<Key, Value>(kthNode.key, kthNode.value);
	}
	
	private BSTNode<Key, Value> selectKthInSubtree(BSTNode<Key, Value> node, int k) {
		if (node == null) {
			return null;
		}
		
		int lessThanCount = subtreeSize(node.left);
		
		if (lessThanCount > k) {
			return selectKthInSubtree(node.left, k);
		} else if (lessThanCount < k) {
			return selectKthInSubtree(node.right, k - lessThanCount - 1);
		} else {
			return node;
		}
	}
	
	public Iterable<Key> keys(Key low, Key high) {
		Deque<Key> queue = new ArrayDeque<Key>();
		
		keys(root, queue, low, high);
		
		return queue;
	}

	private void keys(BSTNode<Key, Value> node, Deque<Key> queue, Key low, Key high) {
		if (node == null) {
			return;
		}
		
		int cmpLow = low.compareTo(node.key);
		int cmpHigh = high.compareTo(node.key);
		
		if (cmpLow < 0) {
			keys(node.left, queue, low, high);
		}
		
		if (cmpLow <= 0 && cmpHigh >= 0) {
			queue.offerLast(node.key);
		}
		
		if (cmpHigh > 0) {
			keys(node.right, queue, low, high);
		}
	}
	
	public Iterable<Value> select(Key low, Key high) {
		Deque<Value> queue = new ArrayDeque<Value>();
		
		select(root, queue, low, high);
		
		return queue;
	}

	private void select(BSTNode<Key, Value> node, Deque<Value> queue, Key low, Key high) {
		int cmpLow = low.compareTo(node.key);
		int cmpHigh = high.compareTo(node.key);
		
		if (cmpLow < 0) {
			select(node.left, queue, low, high);
		}
		
		if (cmpLow <= 0 && cmpHigh >= 0) {
			queue.offerLast(node.value);
		}
		
		if (cmpHigh > 0) {
			select(node.right, queue, low, high);
		}
	}

	private BSTNode<Key, Value> deleteMinInSubtree(BSTNode<Key, Value> node) {
		if (node.left == null) {
			return node.right;
		}
		
		node.left = deleteMinInSubtree(node.left);
		node.subtreeSize = 1 + subtreeSize(node.left) + subtreeSize(node.right);
		
		return node;
	}
	
	public Key getFirstCommonAncestorKey(Key key1, Key key2) {
		return fca(root, key1, key2);
	}

	private Key fca(BSTNode<Key, Value> node, Key key1, Key key2) {
		if (node == null) {
			return null;
		}
		
		Key low = key1.compareTo(key2) < 0 ? key1 : key2;
		Key high = key1.compareTo(key2) >= 0 ? key1 : key2;
		
		int cmpLow = low.compareTo(node.key);
		int cmpHigh = high.compareTo(node.key);
		
		if (cmpLow <= 0 && cmpHigh >= 0) {
			return node.key;
		}
		
		if (cmpLow < 0 && cmpHigh < 0) {
			return fca(node.left, key1, key2);
		}
		
		if (cmpLow > 0 && cmpHigh > 0) {
			return fca(node.right, key1, key2);
		}
		
		return null;
	}

	@Override
	public Value get(Key key) {
		BSTNode<Key, Value> node = find(key);
		
		if (node == null) {
			return null;
		} else {
			return node.value;
		}
	}

	@Override
	public boolean contains(Key key) {
		return find(key) != null;
	}

	@Override
	protected BSTNode<Key, Value> find(Key key) {
		return findInSubtree(root, key);
	}

	private BSTNode<Key, Value> findInSubtree(BSTNode<Key, Value> node, Key key) {
		if (node == null) {
			return null;
		}
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) {
			return findInSubtree(node.getLeft(), key);
		} else if (cmp > 0) {
			return findInSubtree(node.getRight(), key);
		} else {
			return node;
		}
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return subtreeSize(this.root);
	}

	private int subtreeSize(BSTNode<Key, Value> node) {
		if (node == null) {
			return 0;
		} else {
			return node.subtreeSize;
		}
	}

	@Override
	protected BSTNode<Key, Value> getRoot() {
		return this.root;
	}
	
	/**
	 * Time complexity is O(n)</br>
	 * Space complexity is O(treeHeight)</br>
	 */
	@Override
	public boolean isBalanced() {
		return isBalanced(this.root);
	}

	private boolean isBalanced(BSTNode<Key, Value> node) {
		if (getHeight(node) == -1) {
			return false;
		} else {
			return true;
		}
	}

	private int getHeight(BSTNode<Key, Value> node) {
		if (node == null) {
			return 0;
		} 
		
		int leftHeight = getHeight(node.left);
		
		if (leftHeight == -1) {
			return -1;
		}
		
		int rightHeight = getHeight(node.right);
		
		if (rightHeight == -1) {
			return -1;
		}
		
		int heightDiff = leftHeight - rightHeight;
		
		if (Math.abs(heightDiff) > 1) {
			return -1;
		} else {
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}
	
	public boolean isSubtree(BinarySearchTree<Key, Value> other) {
		if (other == null || other.root == null) {
			return true;
		}
		
		BSTNode<Key, Value> thisSubRoot = findInSubtree(this.root, other.root.key);
		if (thisSubRoot == null) {
			return false;
		}
		
		return isSubtree(thisSubRoot, other.root);
	}

	private boolean isSubtree(BSTNode<Key, Value> thisNode, BSTNode<Key, Value> otherNode) {
		if (thisNode == null && otherNode == null) {
			return true;
		}
		
		if (thisNode != null && otherNode != null) {
			if (!thisNode.key.equals(otherNode.key)) {
				return false;
			}
			
			if (!thisNode.value.equals(otherNode.value)) {
				return false;
			}
			
			return isSubtree(thisNode.left, otherNode.left) &&
				   isSubtree(thisNode.right, otherNode.right);
			
		} else {
			return false;
		}
	}
	
	public static <T extends Comparable<T>> void sumPaths(BinarySearchTree<T, Integer> tree, int sumValue) {
		int depth = depth(tree.root);
		Integer[] path = new Integer[depth];
		collectSums(tree.root, sumValue, path, 0);
	}
	
	private static <T extends Comparable<T>> void collectSums(BSTNode<T, Integer> node, int sumValue, Integer[] path, int level) {
		if (node == null) {
			return;
		}
		
		path[level] = node.value;
		
		int t = 0;
		
		for (int i = level; i >= 0; i--) {
			t += path[i];
			
			if (t == sumValue) {
				print(path, i, level);
			}
		}
		
		collectSums(node.left, sumValue, path, level + 1);
		collectSums(node.right, sumValue, path, level + 1);
		
		path[level] = null;
	}
	
	private static void print(Integer[] path, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(path[i] + "-");
		}
		System.out.println();
	}

	private static <Key extends Comparable<Key>, Value> int depth(BSTNode<Key, Value> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + Math.max(depth(node.left), depth(node.right));
		}
	}
}
