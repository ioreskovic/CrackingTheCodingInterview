package com.lopina.exercises.practice.q1;

public class Node {
	public int value;
	public Node prev;
	public Node next;
	
	public Node(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "(" + value + ")";
	}
	
	private static class NodePointer {
		public Node node;
		
		public NodePointer(Node node) {
			this.node = node;
		}
		
		public void goNext() {
			if (node != null) {
				node = node.next;
			}
		}
		
		public void goPrev() {
			if (node != null) {
				node = node.prev;
			}
		}
		
		public void setPrev(Node prev) {
			if (node != null) {
				node.prev = prev;
			}
		}
		
		public Node getPrev() {
			if (node != null) {
				return node.prev;
			}
			
			return null;
		}
		
		public void setNext(Node next) {
			if (node != null) {
				node.next = next;
			}
		}
		
		public Node getNext() {
			if (node != null) {
				return node.next;
			}
			
			return null;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(0);
		
		Node curr = head;
		curr.next = new Node(1);
		curr = curr.next;
		curr.next = new Node(1);
		curr = curr.next;
		curr.next = new Node(1);
		curr = curr.next;
		curr.next = new Node(2);
		curr = curr.next;
		curr.next = new Node(2);
		curr = curr.next;
		curr.next = new Node(2);
		curr = curr.next;
		curr.next = new Node(3);
		curr = curr.next;
		curr.next = new Node(3);
		curr = curr.next;
		curr.next = new Node(3);
		curr = curr.next;
		curr.next = new Node(4);
		curr = curr.next;
		curr.next = new Node(5);
		curr = curr.next;
		curr.next = new Node(6);
		curr = curr.next;
		
		curr = head;
		
		while (curr != null) {
			System.out.print(curr + " ");
			curr = curr.next;
		}
		System.out.println();
		
		head = removeDuplicatesFromSorted(head);
		
		curr = head;
		
		while (curr != null) {
			System.out.print(curr + " ");
			curr = curr.next;
		}
		System.out.println();
		
		Node root = toBST(new NodePointer(head), 7).node;
		
		Node tail = toDLL(root, new NodePointer(null)).node;
		curr = tail;
		
		while (curr != null) {
			System.out.print(curr + " ");
			head = curr;
			curr = curr.prev;
		}
		System.out.println();
		
		curr = head;
		
		while (curr != null) {
			System.out.print(curr + " ");
			curr = curr.next;
		}
		System.out.println();
		
	}
	
	private static Node removeDuplicatesFromSorted(Node head) {
		Node actualHead = head;
		
		Node prev = head;
		Node next = head.next;
		
		while (next != null) {
			if (prev.value == next.value) {
				prev.next = next.next;
			} else {
				prev = next;
			}
			
			next = prev.next;
		}
		
		return actualHead;
	}

	/**
	 * Runs in O(n)
	 * It simulates call by reference calls (recursion with a global variable, so to say)
	 * @param nodePointer
	 * @param length
	 * @return
	 */
	public static NodePointer toBST(NodePointer nodePointer, int length) {
		if (length == 0) {
			return new NodePointer(null);
		}
		
		
		Node left = toBST(nodePointer, length / 2).node;
		NodePointer root = new NodePointer(nodePointer.node);
		root.setPrev(left);
		nodePointer.goNext();
		root.setNext(toBST(nodePointer, length - length/2 - 1).node);
		
		return root;
	}
	
	public static NodePointer toDLL(Node head, NodePointer prevRef) {
		if (head == null) {
			return prevRef;
		}
		toDLL(head.prev, prevRef);
		head.prev = prevRef.node;
		System.out.println(head + ".prev=" + prevRef.node);
		prevRef.node = head;
		if (head.prev != null) {
			head.prev.next = head;
			System.out.println(head.prev + ".next=" + head);
			prevRef.node = head;
		}
		toDLL(head.next, prevRef);
		
		return prevRef;
	}
}
