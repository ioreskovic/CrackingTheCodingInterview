package com.lopina.exercises.chapter4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.chapter4.BinarySearchTree;
import com.lopina.exercises.chapter4.SymbolTable.SymbolTableEntry;

public class Question5 {
	
	private BinarySearchTree<Integer, Integer> bst;
	private BinarySearchTree<Integer, Integer> nonBst;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		SymbolTableEntry<Integer, Integer>[] sortedEntries;
		
		sortedEntries = new SymbolTableEntry[7];
		
		sortedEntries[0] = new SymbolTableEntry<Integer, Integer>(0, 0);
		sortedEntries[1] = new SymbolTableEntry<Integer, Integer>(1, 1);
		sortedEntries[2] = new SymbolTableEntry<Integer, Integer>(2, 2);
		sortedEntries[3] = new SymbolTableEntry<Integer, Integer>(3, 3);
		sortedEntries[4] = new SymbolTableEntry<Integer, Integer>(4, 4);
		sortedEntries[5] = new SymbolTableEntry<Integer, Integer>(5, 5);
		sortedEntries[6] = new SymbolTableEntry<Integer, Integer>(6, 6);
		
		bst = new BinarySearchTree<Integer, Integer>(sortedEntries);
		
		SymbolTableEntry<Integer, Integer>[] unsortedEntries;
		
		unsortedEntries = new SymbolTableEntry[7];
		
		unsortedEntries[6] = new SymbolTableEntry<Integer, Integer>(6, 6);
		unsortedEntries[5] = new SymbolTableEntry<Integer, Integer>(5, 5);
		unsortedEntries[4] = new SymbolTableEntry<Integer, Integer>(4, 4);
		unsortedEntries[3] = new SymbolTableEntry<Integer, Integer>(3, 3);
		unsortedEntries[2] = new SymbolTableEntry<Integer, Integer>(2, 2);
		unsortedEntries[1] = new SymbolTableEntry<Integer, Integer>(1, 1);
		unsortedEntries[0] = new SymbolTableEntry<Integer, Integer>(0, 0);
		
		nonBst = new BinarySearchTree<Integer, Integer>(unsortedEntries);
	}

	@Test
	public void test() {
		assertTrue(bst.isBinarySearchTree());
	}
	
	@Test
	public void test2() {
		assertTrue(nonBst.isBinarySearchTree());
	}

}
