package com.lopina.exercises.chapter2.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lopina.exercises.chapter2.LinkedListUtils;
import com.lopina.exercises.chapter2.MyLinkedList;

public class LinkedListQuestion4 {

	@Test
	public void shouldPartitionAroundPivotWhenProvidedPivotValue() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.appendToTail(0)
			.appendToTail(9)
			.appendToTail(1)
			.appendToTail(8)
			.appendToTail(2)
			.appendToTail(7)
			.appendToTail(3)
			.appendToTail(6)
			.appendToTail(4)
			.appendToTail(5);
		
		LinkedListUtils.partitionAround(list, 5);
		
		System.out.println(list.toString());
		
		Integer[] expecteds = new Integer[]{ 0, 1, 2, 3, 4, 7, 8, 6, 9, 5 };
		
		List<Integer> actuals = new ArrayList<Integer>();
		
		for (Integer i : list) {
			actuals.add(i);
		}
		
		assertArrayEquals(expecteds, actuals.toArray(new Integer[actuals.size()]));
	}

}
