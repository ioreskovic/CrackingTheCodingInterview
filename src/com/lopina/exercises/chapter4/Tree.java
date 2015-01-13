package com.lopina.exercises.chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Tree<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>{
	public static abstract class Node<Key, Value> {
		Key key;
		Value value;
		
		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
		
		public abstract Node<Key, Value> getLeft();
		public abstract Node<Key, Value> getRight();
		
		@Override
		public String toString() {
			return "[" + key + "=" + value + "]";
		}
	}
	
	public abstract void add(Key key, Value value);
	public abstract void delete(Key key);
	public abstract boolean contains(Key key);
	public abstract boolean isEmpty();
	public abstract int size();
	public abstract Value get(Key key);
	
	protected abstract Node<Key, Value> find(Key key);
	protected abstract Node<Key, Value> getRoot();
	
	public Iterator<SymbolTableEntry<Key, Value>> getInOrderIterator() {
		return new TreeInOrderIterator(getRoot());
	}
	
	public Iterator<SymbolTableEntry<Key, Value>> getPreOrderIterator() {
		return new TreePreOrderIterator(getRoot());
	}
	
	public Iterator<SymbolTableEntry<Key, Value>> getPostOrderIterator() {
		return new TreePostOrderIterator(getRoot());
	}
	
	public Iterator<SymbolTableEntry<Key, Value>> getLevelOrderIterator() {
		return new TreeLevelOrderIterator(getRoot());
	}
	
	private abstract class AbstractBinaryTreeIterator implements Iterator<SymbolTableEntry<Key, Value>> {

		Deque<Node<Key, Value>> deque = new ArrayDeque<Tree.Node<Key, Value>>();
		
		public AbstractBinaryTreeIterator(Node<Key, Value> node) {
			traverse(node);
		}
		
		protected abstract void traverse(Node<Key, Value> node);

		@Override
		public boolean hasNext() {
			return !deque.isEmpty();
		}

		@Override
		public SymbolTableEntry<Key, Value> next() {
			Node<Key, Value> node = deque.pollFirst();
			return new SymbolTableEntry<Key, Value>(node.key, node.value);
		}
		
		protected void visit(Node<Key, Value> node) {
			this.deque.offerLast(node);
		}
		
	}
	
	private class TreeInOrderIterator extends AbstractBinaryTreeIterator {

		public TreeInOrderIterator(Node<Key, Value> node) {
			super(node);
		}
		
		private void inOrder(Node<Key, Value> node) {
			if (node == null) {
				return;
			}
			
			inOrder(node.getLeft());
			visit(node);
			inOrder(node.getRight());
		}

		@Override
		protected void traverse(Node<Key, Value> node) {
			inOrder(node);
		}
		
	}
	
	private class TreePreOrderIterator extends AbstractBinaryTreeIterator {

		public TreePreOrderIterator(Node<Key, Value> node) {
			super(node);
		}
		
		private void preOrder(Node<Key, Value> node) {
			if (node == null) {
				return;
			}
			
			visit(node);
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}

		@Override
		protected void traverse(Node<Key, Value> node) {
			preOrder(node);
		}
		
	}
	
	private class TreePostOrderIterator extends AbstractBinaryTreeIterator {

		public TreePostOrderIterator(Node<Key, Value> node) {
			super(node);
		}
		
		private void postOrder(Node<Key, Value> node) {
			if (node == null) {
				return;
			}
			
			postOrder(node.getLeft());
			postOrder(node.getRight());
			visit(node);
		}

		@Override
		protected void traverse(Node<Key, Value> node) {
			postOrder(node);
		}
		
	}
	
	private class TreeLevelOrderIterator extends AbstractBinaryTreeIterator {

		public TreeLevelOrderIterator(Node<Key, Value> node) {
			super(node);
		}
		
		private void levelOrder(Node<Key, Value> node) {
			if (node == null) {
				return;
			}
			
			Deque<Node<Key, Value>> queue = new ArrayDeque<Node<Key, Value>>();
			queue.offerLast(node);
			
			while (!queue.isEmpty()) {
				Node<Key, Value> currentNode = queue.pollFirst();
				visit(currentNode);
				
				if (currentNode.getLeft() != null) {
					queue.offerLast(currentNode.getLeft());
				}
				
				if (currentNode.getRight() != null) {
					queue.offerLast(currentNode.getRight());
				}
			}
		}

		@Override
		protected void traverse(Node<Key, Value> node) {
			levelOrder(node);
		}
		
	}
	
	@Override
	public Iterator<SymbolTableEntry<Key, Value>> iterator() {
		return getPreOrderIterator();
	}
	
	public abstract boolean isBalanced();
	
	public List<LinkedList<Node<Key, Value>>> getDeleveledTree() {
		List<LinkedList<Node<Key, Value>>> levels = new ArrayList<LinkedList<Node<Key,Value>>>();
		
		levelFoldTree(getRoot(), 0, levels);
		
		return levels;
	}
	private void levelFoldTree(Node<Key, Value> node, int level, List<LinkedList<Node<Key, Value>>> levels) {
		if (node == null) {
			return;
		}
		
		LinkedList<Node<Key, Value>> levelList = getLevelList(level, levels);
		
		levelList.add(node);
		levelFoldTree(node.getLeft(), level + 1, levels);
		levelFoldTree(node.getRight(), level + 1, levels);
	}
	
	private LinkedList<Node<Key, Value>> getLevelList(int level, List<LinkedList<Node<Key, Value>>> levels) {
		if (level >= levels.size()) {
			levels.add(new LinkedList<Tree.Node<Key,Value>>());
		}
		
		return levels.get(level);
	}
	
	public boolean isBinarySearchTree() {
		return isBinarySearchTree(getRoot());
	}
	
	private boolean isBinarySearchTree(Node<Key, Value> node) {
		if (node == null) {
			return true;
		}
		
		if (!isLeftChildSmaller(node.getLeft(), node) || !isRightChildBigger(node.getRight(), node)) {
			return false;
		}
		
		return isBinarySearchTree(node.getLeft()) && isBinarySearchTree(node.getRight());
	}
	
	private boolean isLeftChildSmaller(Node<Key, Value> leftChild, Node<Key, Value> parent) {
		if (leftChild == null) {
			return true;
		}
		
		return parent.key.compareTo(leftChild.key) > 0;
	}
	
	private boolean isRightChildBigger(Node<Key, Value> rightChild, Node<Key, Value> parent) {
		if (rightChild == null) {
			return true;
		}
		
		return parent.key.compareTo(rightChild.key) < 0;
	}
	
}
