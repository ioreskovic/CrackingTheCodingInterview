
package com.lopina.important.take2.tree.binary.search;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class NodeBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {

	private class Node {
		T item;
		Node left;
		Node right;
		
		protected Node(T item) {
			this.item = item;
		}
	}
	
	private Node root;
	
	@Override
	public void add(T item) {
		root = add(root, item);
	}

	private void addIterative(T item) {
		if (root == null) {
			root = new Node(item);
			return;
		}
		
		Node parent = null;
		Node node = root;
		
		int cmp = 0;
		while (node != null) {
			cmp = item.compareTo(node.item);
			
			if (cmp == 0) {
				return;
			} else if (cmp < 0) {
				parent = node;
				node = node.left;
			} else {
				parent = node;
				node = node.right;
			}
		}
		
		Node child = new Node(item);
		
		if (cmp < 0) {
			parent.left = child;
		} else if (cmp > 0) {
			parent.right = child;
		}
	}
	
	private Node add(Node node, T item) {
		if (node == null) {
			return new Node(item);
		}
		
		int cmp = item.compareTo(node.item);
		
		if (cmp == 0) {
		} else if (cmp < 0) {
			node.left = add(node.left, item);
		} else {
			node.right = add(node.right, item);
			
		}
		
		return node;
	}

	@Override
	public void remove(T item) {
		root = remove(root, item);
		System.out.println(toString());
	}

	private Node remove(Node node, T item) {
		System.out.println(toString());
		if (node == null) {
			return null;
		}
		
		int cmp = item.compareTo(node.item);
		
		if (cmp < 0) {
			node.left = remove(node.left, item);
		} else if (cmp > 0) {
			node.right = remove(node.right, item);
		} else {
			if (node.right == null) {
				return node.left;
			}
			
			if (node.left == null) {
				return node.right;
			}
			
			Node temp = node;
			System.out.println(toString());
			node = min(temp.right);
			System.out.println(toString());
			node.right = deleteMin(temp.right);
			System.out.println(toString());
			node.left = temp.left;
			System.out.println(toString());
		}
		
		System.out.println(toString());
		return node;
	}

	@Override
	public T get(T item) {
		Node node = get(root, item);
		
		if (node != null) {
			return node.item;
		} else {
			return null;
		}
	}
	
	public void deleteMin() {
		if (root != null) {
			root = deleteMin(root);
		}
	}
	
	private Node deleteMin(Node node) {
		if (node.left == null) {
			return node.right;
		}
		
		node.left = deleteMin(node.left);
		
		return node;
	}

	@Override
	public T min() {
		Node minNode = min(root);
		
		if (minNode == null) {
			return null;
		}
		
		return minNode.item;
	}

	private Node min(Node node) {
		while (node != null && node.left != null) {
			node = node.left;
		}
		
		if (node == null) {
			return null;
		} else {
			return node;
		}
	}

	@Override
	public T max() {
		Node maxNode = max(root);
		
		if (maxNode == null) {
			return null;
		}
		
		return maxNode.item;
	}
	
	public void deleteMax() {
		if (root != null) {
			root = deleteMax(root);
		}
	}
	
	private Node deleteMax(Node node) {
		if (node.right == null) {
			return node.left;
		}
		
		node.right = deleteMax(node.right);
		
		return node;
	}
	
	private Node max(Node node) {
		while (node != null && node.right != null) {
			node = node.right;
		}
		
		if (node == null) {
			return null;
		} else {
			return node;
		}
	}

	private Node get(Node node, T item) {
		if (node == null) {
			return null;
		}
		
		int cmp = item.compareTo(node.item);
		
		if (cmp == 0) {
			return node;
		} else if (cmp < 0) {
			return get(node.left, item);
		} else {
			return get(node.right, item);
		}
	}

	@Override
	public boolean contains(T item) {
		return get(item) != null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		preOrderStringify(sb, root, 0, "├");
		
		return sb.toString();
	}

	private void preOrderStringify(StringBuilder sb, Node node, int depth, String x) {
		if (node == null) {
			return;
		}
		
		for (int i = 0; i < depth; i++) {
			sb.append("   ");
		}
		sb.append(x);
		sb.append("─[");
		sb.append(node.item.toString());
		sb.append("]");
		sb.append(System.getProperty("line.separator", "\n"));
		
		String leftX = node.right == null ? "├" : "├";
		String rightX = "├";
		preOrderStringify(sb, node.left, depth + 1, leftX);
		preOrderStringify(sb, node.right, depth + 1, rightX);
	}
	
	public static void main(String[] args) {
		NodeBinarySearchTree<Integer> tree = new NodeBinarySearchTree<Integer>();
		tree.add(4);
		tree.add(2);
		tree.add(6);
		tree.add(1);
		tree.add(3);
		tree.add(5);
		tree.add(7);
		tree.add(0);
		tree.add(5);
		
		System.out.println(tree.toString());
		
		System.out.println(tree.get(5));
		System.out.println(tree.get(9));
		
		tree.remove(6);
	}

	@Override
	public Iterable<T> diameter() {
		if (this.root == null) {
			return null;
		}
		
		Deque<T> diameterLeftPart = new ArrayDeque<T>();
		Deque<T> diameterRightPart = new ArrayDeque<T>();
		
		diameter(this.root.left, diameterLeftPart);
		diameter(this.root.right, diameterRightPart);
		
		Deque<T> diameter = new ArrayDeque<T>();
		
		for (Iterator<T> it = diameterLeftPart.iterator(); it.hasNext();) {
			diameter.offerLast(it.next());
		}
		
		diameter.offerLast(this.root.item);
		
		for (Iterator<T> it = diameterRightPart.descendingIterator(); it.hasNext();) {
			diameter.offerLast(it.next());
		}
		
		return diameter;
	}

	private void diameter(Node node, Deque<T> diameter) {
		if (node == null)  {
			return;
		}
		
		Deque<T> leftPart = new ArrayDeque<T>();
		Deque<T> rightPart = new ArrayDeque<T>();
		
		diameter(node.left, leftPart);
		diameter(node.right, rightPart);
		
		if (leftPart.size() > rightPart.size()) {
			diameter.addAll(leftPart);
		} else {
			diameter.addAll(rightPart);
		}
		
		diameter.offerLast(node.item);
	}

}
