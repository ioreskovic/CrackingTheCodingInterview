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
		
		MyLinkedList<T>.MyNode node = list.getHead();
		
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
		
		MyLinkedList<T>.MyNode prev = null;
		MyLinkedList<T>.MyNode node = list.getHead();
		
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
		
		MyLinkedList<T>.MyNode node = list.getHead();
		
		while (node!= null) {
			T element = node.data;
			MyLinkedList<T>.MyNode prevInner = node;
			MyLinkedList<T>.MyNode nodeInner = node.next;
			
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
		
		MyLinkedList<T>.MyNode runner = list.getHead();
		MyLinkedList<T>.MyNode node = list.getHead();
		
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
}
