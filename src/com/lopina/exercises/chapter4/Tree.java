package com.lopina.exercises.chapter4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public abstract class Tree<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>{
	static abstract class Node<Key, Value> {
		Key key;
		Value value;
		
		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
		
		public abstract Node<Key, Value> getLeft();
		public abstract Node<Key, Value> getRight();
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
}
