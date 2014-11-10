package com.lopina.exercises.chapter2;

import java.util.HashMap;
import java.util.Map;

import com.lopina.exercises.chapter2.MyLinkedList.MyNode;


public class LinkedListUtils {
	
	/**
	 * Removes duplicate occurrences of elements in the provided list.</br>
	 * Leaves last occurrences of elements to live.</br>
	 * Time complexity is O(n<sup>2</sup>) because it always iterates from the start when it finds an element to remove.
	 * @param list the list to remove duplicate elements from
	 * @return the modified list
	 */
	public static <T> MyLinkedList<T> removeDuplicatesFromHead(MyLinkedList<T> list) {
		checkForNullList(list, "The list was null");
		
		if (list.getHead() == null) {
			return list;
		}
		
		Map<T, Boolean> map = new HashMap<T, Boolean>();
		
		MyNode<T> node = list.getHead();
		
		while (node != null) {
			T element = node.data;
			
			boolean elementAlreadySeen = map.getOrDefault(element, false);
			
			if (elementAlreadySeen) {
				list.delete(element);
			} else {
				map.put(element, true);
			}
			
			node = node.next;
		}
		
		return list;
	}

	/**
	 * Removes duplicate occurrences of elements in the provided list.</br>
	 * Leaves last occurrences of elements to live.</br>
	 * Time complexity is O(n) because it does not go back to head every time when deletion is needed.
	 * @param list the list to remove duplicate elements from
	 * @return the modified list
	 */
	public static <T> MyLinkedList<T> removeDuplicatesFast(MyLinkedList<T> list) {
		checkForNullList(list, "The list was null");
		
		if (list.getHead() == null) {
			return list;
		}
		
		Map<T, Boolean> map = new HashMap<T, Boolean>();
		
		MyNode<T> prev = null;
		MyNode<T> node = list.getHead();
		
		while (node!= null) {
			T element = node.data;
			
			boolean elementAlreadySeen = map.getOrDefault(element, false);
			
			if (elementAlreadySeen) {
				prev.next = node.next;
				node = prev.next;
			} else {
				map.put(element, true);
				prev = node;
			}
			node = prev.next;
		}
		
		return list;
	}
	
	/**
	 * Removes duplicate occurrences of elements in the provided list.</br>
	 * Leaves last occurrences of elements to live.</br>
	 * Time complexity is O(n<sup>2</sup>) because it iterates over entire list to find a duplicate for each element.
	 * @param list the list to remove duplicate elements from
	 * @return the modified list
	 */
	public static <T> MyLinkedList<T> removeDuplicatesConstantSpace(MyLinkedList<T> list) {
		checkForNullList(list, "The list was null");
		
		if (list.getHead() == null) {
			return list;
		}
		
		MyNode<T> node = list.getHead();
		
		while (node!= null) {
			T element = node.data;
			MyNode<T> prevInner = node;
			MyNode<T> nodeInner = node.next;
			
			while (nodeInner != null) {
				if (nodeInner.data.equals(element)) {
					prevInner.next = nodeInner.next;
					nodeInner = prevInner.next;
				} else {
					prevInner = nodeInner;
				}
				nodeInner = prevInner.next;
			}
			
			node = node.next;
		}
		
		return list;
	}
	
	/**
	 * Retrieves kth to the last element in the provided list
	 * @param k the index of the element to retrieve, looking from the end of the list
	 * @param list the provided list
	 * @return kth to the last element in the provided list
	 * @throws NullPointerException if the provided list is null
	 * @throws IllegalArgumentException if the list's size is less than k
	 */
	public static <T> T getKthToTheEndElement(int k, MyLinkedList<T> list) {
		checkForNullList(list, "The provided list was null");
		checkForNegativeValue(k, "Index value k must not be less than zero. It was " + k);
		
		if (list.getHead() == null) {
			return null;
		}
		
		MyNode<T> runner = list.getHead();
		MyNode<T> node = list.getHead();
		
		int i = 0;
		
		while (i < k && runner != null) {
			runner = runner.next;
			i++;
		}
		
		if (runner == null) {
			throw new IllegalArgumentException("The list was too short for index " + k);
		}
		
		while (runner.next != null) {
			runner = runner.next;
			node = node.next;
		}
		
		return node.data;
	}
	
	/**
	 * Removes the given node from the list provided it is not at the end of the list.
	 * @param list the provided list
	 * @param node the node to remove
	 * @throws NullPointerException if the provided list is null
	 * @throws IllegalArgumentException if the provided node is null
	 * @throws IllegalArgumentException if the node is at the tail of the list
	 */
	public static <T> void deleteNodeAccessOnly(MyLinkedList<T> list, MyNode<T> node) {
		checkForNullList(list, "The provided list was null");
		checkForNullValue(node, "The provided node was null");
		checkForNullValue(node.next, "The node was not in the middle of the list");
		
		node.data = node.next.data;
		node.next = node.next.next;
		
		return;
	}
	
	/**
	 * Partitions the list around the provided pivot value in a way that every element </br>
	 * less than pivot is before any element greater than or equal pivot.
	 * @param list the provided list
	 * @param pivotValue the pivot value
	 */
	public static <T extends Comparable<T>> void partitionAround(MyLinkedList<T> list, T pivotValue) {
		MyNode<T> pivotNode = new MyNode<T>(pivotValue);
		MyNode<T> last = null;
		MyNode<T> curr = null;
		
		pivotNode.next = list.getHead();
		
		for (last = curr = pivotNode; curr != null; curr = curr.next) {
			if (curr.data.compareTo(pivotNode.data) < 0) {
				last = last.next;
				swapValues(last, curr);
			}
		}
		
		list.setHead(pivotNode.next);
	}
	
	private static <T> void swapValues(MyNode<T> aNode, MyNode<T> bNode) {
		T temp = aNode.data;
		aNode.data = bNode.data;
		bNode.data = temp;
	}
	
	private static <T> void checkForNullList(MyLinkedList<T> list, String message) {
		if (list == null) {
			throw new NullPointerException(message);
		}
	}
	
	private static void checkForNegativeValue(int k, String message) {
		if (k < 0) {
			throw new IllegalArgumentException(message);
		}
	}
	
	private static void checkForNullValue(Object o, String message) {
		if (o == null) {
			throw new IllegalArgumentException(message);
		}
	}
}
