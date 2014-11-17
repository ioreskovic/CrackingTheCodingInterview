package com.lopina.exercises.chapter4;

import java.util.ArrayDeque;
import java.util.Deque;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import com.sun.scenario.effect.Flood;

public class BinarySearchTree<Key extends Comparable<Key>, Value> extends Tree<Key, Value> {
	private BSTNode<Key, Value> root;
	
	public BinarySearchTree() {
	}
	
	public BinarySearchTree(SymbolTableEntry<Key, Value> ... entries) {
		populateFromSorted(entries, 0, entries.length - 1);
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
		} else if (cmp > 0) {
			node.right = addToSubTree(node.right, key, value);
		} else {
			node.value = value;
		}
		
		node.subtreeSize = 1 + subtreeSize(node.left) + subtreeSize(node.right);
		
		return node;
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
		} else if (cmp > 0) {
			node.right = deleteInSubtree(node.right, key);
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

	public SymbolTableEntry<Key, Value> min(Key key) {
		BSTNode<Key, Value> node = findMinInSubtree(root);
		
		if (node == null) {
			return null;
		}
		
		return new SymbolTableEntry<Key, Value>(node.key, node.value);
	}
	
	private BSTNode<Key, Value> findMinInSubtree(BSTNode<Key, Value> node) {
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
	
}
