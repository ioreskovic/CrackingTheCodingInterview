package com.lopina.exercises.chapter2.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lopina.exercises.chapter2.LinkedListUtils;
import com.lopina.exercises.chapter2.MyLinkedList;

public class LinkedListQuestion4 {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionWhenNullList() {
		MyLinkedList<Integer> list = null;
		
		LinkedListUtils.partitionAround(list, 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionWhenNullListSimple() {
		MyLinkedList<Integer> list = null;
		
		MyLinkedList<Integer> partitionedList = LinkedListUtils.partitionAroundSimple(list, 5);
	}
	
	
	
	@Test
	public void shouldReturnImmediatelyWhenEmptyList() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		LinkedListUtils.partitionAround(list, 5);
		
		assertNull(list.getHead());
	}
	
	@Test
	public void shouldReturnImmediatelyWhenEmptyListSimple() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		MyLinkedList<Integer> partitionedList = LinkedListUtils.partitionAroundSimple(list, 5);
		
		assertNull(partitionedList.getHead());
	}
	
	
	
	
	@Test
	public void shouldPartitionTheListProperlyWhenGivenAllSameElements() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5);
		
		LinkedListUtils.partitionAround(list, 5);
		
		Integer[] expecteds = new Integer[]{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : list) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	@Test
	public void shouldPartitionTheListProperlyWhenGivenAllSameElementsSimple() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5)
			.appendToBack(5);
		
		MyLinkedList<Integer> partitionedList = LinkedListUtils.partitionAroundSimple(list, 5);
		
		Integer[] expecteds = new Integer[]{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : partitionedList) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	
	
	
	@Test
	public void shouldPartitionAroundPivotWhenProvidedPivotValue() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(0)
			.appendToBack(9)
			.appendToBack(1)
			.appendToBack(8)
			.appendToBack(2)
			.appendToBack(7)
			.appendToBack(3)
			.appendToBack(6)
			.appendToBack(4)
			.appendToBack(5);
		
		LinkedListUtils.partitionAround(list, 5);
		
		Integer[] expecteds = new Integer[]{ 0, 1, 2, 3, 4, 7, 8, 6, 9, 5 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : list) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}
	
	@Test
	public void shouldPartitionAroundPivotWhenProvidedPivotValueSimple() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToBack(0)
			.appendToBack(9)
			.appendToBack(1)
			.appendToBack(8)
			.appendToBack(2)
			.appendToBack(7)
			.appendToBack(3)
			.appendToBack(6)
			.appendToBack(4)
			.appendToBack(5);
		
		MyLinkedList<Integer> partitionedList = LinkedListUtils.partitionAroundSimple(list, 5);
		
		Integer[] expecteds = new Integer[]{ 0, 1, 2, 3, 4, 9, 8, 7, 6, 5 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : partitionedList) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}

}
