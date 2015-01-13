package com.lopina.exercises.chapter4.test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.chapter4.BinarySearchTree;
import com.lopina.exercises.chapter4.SymbolTable.SymbolTableEntry;

public class Question3 {

	private SymbolTableEntry<Integer, Integer>[] sortedEntries;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		sortedEntries = new SymbolTableEntry[7];
		
		sortedEntries[0] = new SymbolTableEntry<Integer, Integer>(0, 0);
		sortedEntries[1] = new SymbolTableEntry<Integer, Integer>(1, 1);
		sortedEntries[2] = new SymbolTableEntry<Integer, Integer>(2, 2);
		sortedEntries[3] = new SymbolTableEntry<Integer, Integer>(3, 3);
		sortedEntries[4] = new SymbolTableEntry<Integer, Integer>(4, 4);
		sortedEntries[5] = new SymbolTableEntry<Integer, Integer>(5, 5);
		sortedEntries[6] = new SymbolTableEntry<Integer, Integer>(6, 6);
	}
	
	@Test
	public void test() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>(sortedEntries);
		
		for (Iterator<SymbolTableEntry<Integer, Integer>> it = bst.getLevelOrderIterator(); it.hasNext(); ) {
			System.out.print(it.next().getKey() + " ");
		}
	}

}
