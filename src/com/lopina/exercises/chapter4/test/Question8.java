package com.lopina.exercises.chapter4.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.chapter4.BinarySearchTree;
import com.lopina.exercises.chapter4.Tree;
import com.lopina.exercises.chapter4.SymbolTable.SymbolTableEntry;

public class Question8 {

	private BinarySearchTree<Integer, Integer> bigBst;
	private BinarySearchTree<Integer, Integer> smallSubBst;
	private BinarySearchTree<Integer, Integer> nonSubBst;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		SymbolTableEntry<Integer, Integer>[] bigEntries;
		bigEntries = new SymbolTableEntry[15];
		bigEntries[0] = new SymbolTableEntry<Integer, Integer>(1, 1);
		bigEntries[1] = new SymbolTableEntry<Integer, Integer>(2, 2);
		bigEntries[2] = new SymbolTableEntry<Integer, Integer>(3, 3);
		bigEntries[3] = new SymbolTableEntry<Integer, Integer>(4, 4);
		bigEntries[4] = new SymbolTableEntry<Integer, Integer>(5, 5);
		bigEntries[5] = new SymbolTableEntry<Integer, Integer>(6, 6);
		bigEntries[6] = new SymbolTableEntry<Integer, Integer>(7, 7);
		bigEntries[7] = new SymbolTableEntry<Integer, Integer>(8, 8);
		bigEntries[8] = new SymbolTableEntry<Integer, Integer>(9, 9);
		bigEntries[9] = new SymbolTableEntry<Integer, Integer>(10, 10);
		bigEntries[10] = new SymbolTableEntry<Integer, Integer>(11, 11);
		bigEntries[11] = new SymbolTableEntry<Integer, Integer>(12, 12);
		bigEntries[12] = new SymbolTableEntry<Integer, Integer>(13, 13);
		bigEntries[13] = new SymbolTableEntry<Integer, Integer>(14, 14);
		bigEntries[14] = new SymbolTableEntry<Integer, Integer>(15, 15);
		bigBst = new BinarySearchTree<Integer, Integer>(bigEntries);
		
		
		SymbolTableEntry<Integer, Integer>[] smallSubEntries;
		smallSubEntries = new SymbolTableEntry[3];
		smallSubEntries[0] = new SymbolTableEntry<Integer, Integer>(1, 1);
		smallSubEntries[1] = new SymbolTableEntry<Integer, Integer>(2, 2);
		smallSubEntries[2] = new SymbolTableEntry<Integer, Integer>(3, 3);
		smallSubBst = new BinarySearchTree<Integer, Integer>(smallSubEntries);

		
		SymbolTableEntry<Integer, Integer>[] nonSubEntries;
		nonSubEntries = new SymbolTableEntry[15];
		nonSubEntries[0] = new SymbolTableEntry<Integer, Integer>(1, 1);
		nonSubEntries[1] = new SymbolTableEntry<Integer, Integer>(2, 2);
		nonSubEntries[2] = new SymbolTableEntry<Integer, Integer>(3, 3);
		nonSubEntries[3] = new SymbolTableEntry<Integer, Integer>(4, 4);
		nonSubEntries[4] = new SymbolTableEntry<Integer, Integer>(5, 5);
		nonSubEntries[5] = new SymbolTableEntry<Integer, Integer>(6, 6);
		nonSubEntries[6] = new SymbolTableEntry<Integer, Integer>(7, 7);
		nonSubEntries[7] = new SymbolTableEntry<Integer, Integer>(8, 8);
		nonSubEntries[8] = new SymbolTableEntry<Integer, Integer>(9, 9);
		nonSubEntries[9] = new SymbolTableEntry<Integer, Integer>(10, 10);
		nonSubEntries[10] = new SymbolTableEntry<Integer, Integer>(11, 11);
		nonSubEntries[11] = new SymbolTableEntry<Integer, Integer>(12, 12);
		nonSubEntries[12] = new SymbolTableEntry<Integer, Integer>(13, 13);
		nonSubEntries[13] = new SymbolTableEntry<Integer, Integer>(14, 14);
		nonSubEntries[14] = new SymbolTableEntry<Integer, Integer>(16, 16);
		nonSubBst = new BinarySearchTree<Integer, Integer>(nonSubEntries);
		
	}
	
	@Test
	public void test() {
		assertTrue(bigBst.isSubtree(smallSubBst));
		assertFalse(bigBst.isSubtree(nonSubBst));
		
		assertFalse(smallSubBst.isSubtree(bigBst));
		assertFalse(smallSubBst.isSubtree(nonSubBst));
		
		assertTrue(nonSubBst.isSubtree(smallSubBst));
		assertFalse(nonSubBst.isSubtree(bigBst));
	}

}
