package com.lopina.exercises.chapter4;

public class BinarySearchTree<Key extends Comparable<Key>, Value> extends Tree<Key, Value> {
	private BSTNode<Key, Value> root;
	
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

	private BSTNode<Key, Value> findMinInSubtree(BSTNode<Key, Value> node) {
		if (node.left == null) {
			return node;
		}
		
		return findMinInSubtree(node.left);
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
