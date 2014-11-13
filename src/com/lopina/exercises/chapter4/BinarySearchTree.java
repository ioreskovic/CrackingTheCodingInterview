package com.lopina.exercises.chapter4;

public class BinarySearchTree<T extends Comparable<T>> extends Tree<T> {
	private BSTNode<T> root;
	
	static class BSTNode<T extends Comparable<T>> extends Node<T> {

		private int subtreeSize;
		private BSTNode<T> left;
		private BSTNode<T> right;
		
		public BSTNode(T data, int subtreeSize) {
			super(data);
			this.subtreeSize = subtreeSize;
		}

		@Override
		public BSTNode<T> getLeft() {
			return this.left;
		}


		@Override
		public BSTNode<T> getRight() {
			return this.right;
		}
		
	}
	
	@Override
	public void add(T value) {
		root = addToSubTree(root, value);
	}

	private BSTNode<T> addToSubTree(BSTNode<T> node, T value) {
		if (node == null) {
			return new BSTNode<T>(value, 1);
		}
		
		int cmp = value.compareTo(node.data);
		
		if (cmp < 0) {
			node.left = addToSubTree(node.left, value);
		} else if (cmp > 0) {
			node.right = addToSubTree(node.right, value);
		} else {
			node.data = value;
		}
		
		node.subtreeSize = 1 + subtreeSize(node.left) + subtreeSize(node.right);
		
		return node;
	}

	@Override
	public void delete(T value) {
		root = deleteInSubtree(root, value);
	}
	
	private BSTNode<T> deleteInSubtree(BSTNode<T> node, T value) {
		if (node == null) {
			return null;
		}
		
		int cmp = value.compareTo(node.data);
		
		if (cmp < 0) {
			node.left = deleteInSubtree(node.left, value);
		} else if (cmp > 0) {
			node.right = deleteInSubtree(node.right, value);
		} else {
			if (node.right == null) {
				return node.left;
			}
			
			if (node.left == null) {
				return node.right;
			}
			
			BSTNode<T> temp = node;
			
			node = findMinInSubtree(node.right);
			node.right = deleteMinInSubtree(node.right);
			node.left = temp.left;
		}
		
		node.subtreeSize = 1 + subtreeSize(node.left) + subtreeSize(node.right);
		
		return node;
	}

	private BSTNode<T> findMinInSubtree(BSTNode<T> node) {
		if (node.left == null) {
			return node;
		}
		
		return findMinInSubtree(node.left);
	}

	private BSTNode<T> deleteMinInSubtree(BSTNode<T> node) {
		if (node.left == null) {
			return node.right;
		}
		
		node.left = deleteMinInSubtree(node.left);
		node.subtreeSize = 1 + subtreeSize(node.left) + subtreeSize(node.right);
		
		return node;
	}

	@Override
	public T get(T value) {
		BSTNode<T> node = find(value);
		
		if (node == null) {
			return null;
		} else {
			return node.data;
		}
	}

	@Override
	public boolean contains(T value) {
		return find(value) != null;
	}

	@Override
	protected BSTNode<T> find(T value) {
		return findInSubtree(root, value);
	}

	private BSTNode<T> findInSubtree(BSTNode<T> node, T value) {
		if (node == null) {
			return null;
		}
		
		int cmp = value.compareTo(node.data);
		
		if (cmp < 0) {
			return findInSubtree(node.getLeft(), value);
		} else if (cmp > 0) {
			return findInSubtree(node.getRight(), value);
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

	private int subtreeSize(BSTNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return node.subtreeSize;
		}
	}

	@Override
	protected BSTNode<T> getRoot() {
		return this.root;
	}

}
