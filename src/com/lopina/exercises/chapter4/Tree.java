package com.lopina.exercises.chapter4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public abstract class Tree<T> {
	static abstract class Node<T> {
		T data;
		
		public Node(T data) {
			this.data = data;
		}
		
		public abstract Node<T> getLeft();
		public abstract Node<T> getRight();
	}
	
	public abstract void add(T value);
	public abstract void delete(T value);
	public abstract boolean contains(T value);
	public abstract boolean isEmpty();
	public abstract int size();
	public abstract T get(T value);
	
	protected abstract Node<T> find(T value);
	protected abstract Node<T> getRoot();
	
	public Iterator<T> getInOrderIterator() {
		return new TreeInOrderIterator(getRoot());
	}
	
	public Iterator<T> getPreOrderIterator() {
		return new TreePreOrderIterator(getRoot());
	}
	
	public Iterator<T> getPostOrderIterator() {
		return new TreePostOrderIterator(getRoot());
	}
	
	public Iterator<T> getLevelOrderIterator() {
		return new TreeLevelOrderIterator(getRoot());
	}
	
	private abstract class AbstractBinaryTreeIterator implements Iterator<T> {

		Deque<Node<T>> deque = new ArrayDeque<Tree.Node<T>>();
		
		public AbstractBinaryTreeIterator(Node<T> node) {
			traverse(node);
		}
		
		protected abstract void traverse(Node<T> node);

		@Override
		public boolean hasNext() {
			return !deque.isEmpty();
		}

		@Override
		public T next() {
			return deque.pollFirst().data;
		}
		
		protected void visit(Node<T> node) {
			this.deque.offerLast(node);
		}
		
	}
	
	private class TreeInOrderIterator extends AbstractBinaryTreeIterator {

		public TreeInOrderIterator(Node<T> node) {
			super(node);
		}
		
		private void inOrder(Node<T> node) {
			if (node == null) {
				return;
			}
			
			inOrder(node.getLeft());
			visit(node);
			inOrder(node.getRight());
		}

		@Override
		protected void traverse(Node<T> node) {
			inOrder(node);
		}
		
	}
	
	private class TreePreOrderIterator extends AbstractBinaryTreeIterator {

		public TreePreOrderIterator(Node<T> node) {
			super(node);
		}
		
		private void preOrder(Node<T> node) {
			if (node == null) {
				return;
			}
			
			visit(node);
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}

		@Override
		protected void traverse(Node<T> node) {
			preOrder(node);
		}
		
	}
	
	private class TreePostOrderIterator extends AbstractBinaryTreeIterator {

		public TreePostOrderIterator(Node<T> node) {
			super(node);
		}
		
		private void postOrder(Node<T> node) {
			if (node == null) {
				return;
			}
			
			postOrder(node.getLeft());
			postOrder(node.getRight());
			visit(node);
		}

		@Override
		protected void traverse(Node<T> node) {
			postOrder(node);
		}
		
	}
	
	private class TreeLevelOrderIterator extends AbstractBinaryTreeIterator {

		public TreeLevelOrderIterator(Node<T> node) {
			super(node);
		}
		
		private void levelOrder(Node<T> node) {
			if (node == null) {
				return;
			}
			
			Deque<Node<T>> queue = new ArrayDeque<Tree.Node<T>>();
			queue.offerLast(node);
			
			while (!queue.isEmpty()) {
				Node<T> currentNode = queue.pollFirst();
				visit(currentNode);
				
				if (node.getLeft() != null) {
					queue.offerLast(node.getLeft());
				}
				
				if (node.getRight() != null) {
					queue.offerLast(node.getRight());
				}
			}
		}

		@Override
		protected void traverse(Node<T> node) {
			levelOrder(node);
		}
		
	}
}
