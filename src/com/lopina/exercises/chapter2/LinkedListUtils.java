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
	 * Time complexity is O(n)</br>
	 * Space complexity is O(1)
	 * @param list the provided list
	 * @param pivotValue the pivot value
	 */
	public static <T extends Comparable<T>> void partitionAround(MyLinkedList<T> list, T pivotValue) {
		checkForNullList(list, "The provided list was null");
		
		if (list.getHead() == null) {
			return;
		}
		
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
	
	/**
	 * Partitions the list around the provided pivot value in a way that every element </br>
	 * less than pivot is before any element greater than or equal pivot.
	 * Time complexity is O(n<sup>2</sup>) because while creating new list(s)<br>
	 * new elements are apended to tail, which takes O(n) for 1 element.</br>
	 * Space complexity is O(n)
	 * @param list the provided list
	 * @param pivotValue the pivot value
	 */
	public static <T extends Comparable<T>> MyLinkedList<T> partitionAroundSimple(MyLinkedList<T> list, T pivotValue) {
		checkForNullList(list, "The provided list was null");
		
		if (list.getHead() == null) {
			return new MyLinkedList<T>();
		}
		
		MyLinkedList<T> lessThanList = new MyLinkedList<T>();
		MyLinkedList<T> greaterThanOrEqualList = new MyLinkedList<T>();
		
		for (T element : list) {
			if (element.compareTo(pivotValue) < 0) {
				lessThanList.appendToBack(element);
			} else {
				greaterThanOrEqualList.appendToBack(element);
			}
		}
		
		MyLinkedList<T> partitionedList = new MyLinkedList<T>();
		
		for (T element : lessThanList) {
			partitionedList.appendToBack(element);
		}
		
		for (T element : greaterThanOrEqualList) {
			partitionedList.appendToBack(element);
		}
		
		return partitionedList;
	}
	
	/**
	 * Adds the 2 linked lists with integer values in their nodes. The numbers are represented in reverse order</br>
	 * E.g. number 912 is represented as <code>2 -> 1 -> 9</code></br>
	 * Time complexity is O(n) if adding to the end of the list can be done in O(1), O(n<sup>2</sup>) otherwise</br>
	 * where n is the log[10] of bigger number.
	 * Space complexity is O(n), because we are returning a list of elements that represent the number.
	 * @param a the first number as list in specified format
	 * @param b the second number as list in specified format
	 * @return the sum of the two numbers as list in specified format
	 * @throws NullPointerException if any of the lists are <code>null</code>
	 */
	public static MyLinkedList<Integer> add(MyLinkedList<Integer> a, MyLinkedList<Integer> b) {
		checkForNullList(a, "The first list was null");
		checkForNullList(a, "The second list was null");
		
		MyLinkedList<Integer> c = new MyLinkedList<Integer>();
		
		MyNode<Integer> aNode = a.getHead();
		MyNode<Integer> bNode = b.getHead();
		
		int carry = 0;
		
		while (aNode != null || bNode != null) {
			int aValue = getValueOrDefault(aNode, 0);
			int bValue = getValueOrDefault(bNode, 0);
			
			int cValue = aValue + bValue + carry;
			
			if (cValue >= 10) {
				carry = cValue / 10;
				cValue = cValue % 10;
			} else {
				carry = 0;
			}
			
			c.appendToBack(cValue);
			
			if (aNode != null) {
				aNode = aNode.next;
			}
			
			if (bNode != null) {
				bNode = bNode.next;
			}
		}
		
		if (carry > 0) {
			c.appendToBack(carry);
		}
		
		return c;
	}
	
	/**
	 * Adds the 2 linked lists with integer values in their nodes. The numbers are represented in straight order</br>
	 * E.g. number 912 is represented as <code>9 -> 1 -> 2</code>
	 * Time complexity is O(n) if adding to the end of the list can be done in O(1), O(n<sup>2</sup>) otherwise</br>
	 * where n is the log[10] of bigger number.
	 * Space complexity is O(n), because we are returning a list of elements that represent the number.
	 * @param a the first number as list in specified format
	 * @param b the second number as list in specified format
	 * @return the sum of the two numbers as list in specified format
	 * @throws NullPointerException if any of the lists are <code>null</code>
	 */
	public static MyLinkedList<Integer> addAlternate(MyLinkedList<Integer> a, MyLinkedList<Integer> b) {
		checkForNullList(a, "The first list was null");
		checkForNullList(a, "The second list was null");
		
		MyLinkedList<Integer> c = new MyLinkedList<Integer>();
		
		MyLinkedList<Integer> aReversed = reverseList(a);
		MyLinkedList<Integer> bReversed = reverseList(b);
		
		return reverseList(add(aReversed, bReversed));
	}
	
	/**
	 * Finds the start node in the provided circular list
	 * @param list the provided list
	 * @return the value of the loop start node if the list is a circular list, <code>null</code> otherwise
	 * @throws NullPointerException if the provided list is a null list
	 */
	public static <T> T findLoopStart(MyLinkedList<T> list) {
		checkForNullList(list, "The provided list was null");
		
		MyNode<T> slowRunner = list.getHead();
		MyNode<T> fastRunner = list.getHead();
		
		do {
			if (slowRunner == null || fastRunner == null) {
				return null;
			}
			
			slowRunner = slowRunner.next;
			
			fastRunner = fastRunner.next;
			if (fastRunner == null) {
				return null;
			}
			fastRunner = fastRunner.next;
		} while (slowRunner != fastRunner);
		
		slowRunner = list.getHead();
		
		while (slowRunner != fastRunner) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
		}
		
		return slowRunner.data;
	}
	
	public static <T> boolean isPalindrome(MyLinkedList<T> list) {
		checkForNullList(list, "The provided list was null");
		
		MyLinkedList<T> reverseList = reverseList(list);
		
		MyNode<T> forwardNode = list.getHead();
		MyNode<T> reverseNode = reverseList.getHead();
		
		while (forwardNode != null && reverseNode != null) {
			if (!forwardNode.data.equals(reverseNode.data)) {
				return false;
			}
			
			forwardNode = forwardNode.next;
			reverseNode = reverseNode.next;
		}
		
		return true;
	}
	
	public static MyLinkedList<Integer> createCircularList(int nonCircularLength, int circularLength) {
		MyLinkedList<Integer> circularList = new MyLinkedList<Integer>();
		
		MyNode<Integer> circularStartNode = null;
		
		for (int i = 0; i < nonCircularLength; i++) {
			circularList.appendToBack(i);
		}
		
		for (int i = 0; i < circularLength; i++) {
			circularList.appendToBack(nonCircularLength + i);
			
			if (i == 0) {
				circularStartNode = circularList.getTail();
			}
			
		}
		
		circularList.getTail().next = circularStartNode;
		
		return circularList;
	}
	
	private static <T> MyLinkedList<T> reverseList(MyLinkedList<T> list) {
		MyNode<T> node = list.getHead();
		MyLinkedList<T> reversedList = new MyLinkedList<T>();
		
		reverseAdd(node, reversedList);
		
		return reversedList;
	}
	
	private static <T> void reverseAdd(MyNode<T> node, MyLinkedList<T> list) {
		if (node != null) {
			reverseAdd(node.next, list);
			list.appendToBack(node.data);
		}
	}

	private static MyNode<Integer> getNextNodeOrDefault(MyNode<Integer> node, MyNode<Integer> defaultValue) {
		if (node == null) {
			return node.next;
		} else {
			return defaultValue;
		}
	}

	private static int getValueOrDefault(MyNode<Integer> node, int defaultValue) {
		if (node == null || node.data == null) {
			return defaultValue;
		} else {
			return node.data;
		}
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
