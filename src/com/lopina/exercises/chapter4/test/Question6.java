package com.lopina.exercises.chapter4.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.chapter4.BinarySearchTree;
import com.lopina.exercises.chapter4.Tree;
import com.lopina.exercises.chapter4.SymbolTable.SymbolTableEntry;

public class Question6 {
	
	private BinarySearchTree<Integer, Integer> bst;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		SymbolTableEntry<Integer, Integer>[] sortedEntries;
		
		sortedEntries = new SymbolTableEntry[15];
		
		sortedEntries[0] = new SymbolTableEntry<Integer, Integer>(1, 1);
		sortedEntries[1] = new SymbolTableEntry<Integer, Integer>(2, 2);
		sortedEntries[2] = new SymbolTableEntry<Integer, Integer>(3, 3);
		sortedEntries[3] = new SymbolTableEntry<Integer, Integer>(4, 4);
		sortedEntries[4] = new SymbolTableEntry<Integer, Integer>(5, 5);
		sortedEntries[5] = new SymbolTableEntry<Integer, Integer>(6, 6);
		sortedEntries[6] = new SymbolTableEntry<Integer, Integer>(7, 7);
		sortedEntries[7] = new SymbolTableEntry<Integer, Integer>(8, 8);
		sortedEntries[8] = new SymbolTableEntry<Integer, Integer>(9, 9);
		sortedEntries[9] = new SymbolTableEntry<Integer, Integer>(10, 10);
		sortedEntries[10] = new SymbolTableEntry<Integer, Integer>(11, 11);
		sortedEntries[11] = new SymbolTableEntry<Integer, Integer>(12, 12);
		sortedEntries[12] = new SymbolTableEntry<Integer, Integer>(13, 13);
		sortedEntries[13] = new SymbolTableEntry<Integer, Integer>(14, 14);
		sortedEntries[14] = new SymbolTableEntry<Integer, Integer>(15, 15);
		
		bst = new BinarySearchTree<Integer, Integer>(sortedEntries);
		
		List<LinkedList<Tree.Node<Integer, Integer>>> levels = bst.getDeleveledTree();
		
		for (LinkedList<Tree.Node<Integer, Integer>> level : levels) {
			for (Tree.Node<Integer, Integer> node : level) {
				System.out.print(node.toString() + " - ");
			}
			System.out.println();
		}
	}
	
	@Test
	public void testPrevValue() {
		assertNull(bst.prevValue(1));
		assertEquals(Integer.valueOf(1), bst.prevValue(2));
		assertEquals(Integer.valueOf(2), bst.prevValue(3));
		assertEquals(Integer.valueOf(3), bst.prevValue(4));
		assertEquals(Integer.valueOf(4), bst.prevValue(5));
		assertEquals(Integer.valueOf(5), bst.prevValue(6));
		assertEquals(Integer.valueOf(6), bst.prevValue(7));
		assertEquals(Integer.valueOf(7), bst.prevValue(8));
		assertEquals(Integer.valueOf(8), bst.prevValue(9));
		assertEquals(Integer.valueOf(9), bst.prevValue(10));
		assertEquals(Integer.valueOf(10), bst.prevValue(11));
		assertEquals(Integer.valueOf(11), bst.prevValue(12));
		assertEquals(Integer.valueOf(12), bst.prevValue(13));
		assertEquals(Integer.valueOf(13), bst.prevValue(14));
		assertEquals(Integer.valueOf(14), bst.prevValue(15));
		assertEquals(Integer.valueOf(15), bst.prevValue(16));
	}
	
	@Test
	public void testNextValue() {
		assertEquals(Integer.valueOf(1), bst.nextValue(0));
		assertEquals(Integer.valueOf(2), bst.nextValue(1));
		assertEquals(Integer.valueOf(3), bst.nextValue(2));
		assertEquals(Integer.valueOf(4), bst.nextValue(3));
		assertEquals(Integer.valueOf(5), bst.nextValue(4));
		assertEquals(Integer.valueOf(6), bst.nextValue(5));
		assertEquals(Integer.valueOf(7), bst.nextValue(6));
		assertEquals(Integer.valueOf(8), bst.nextValue(7));
		assertEquals(Integer.valueOf(9), bst.nextValue(8));
		assertEquals(Integer.valueOf(10), bst.nextValue(9));
		assertEquals(Integer.valueOf(11), bst.nextValue(10));
		assertEquals(Integer.valueOf(12), bst.nextValue(11));
		assertEquals(Integer.valueOf(13), bst.nextValue(12));
		assertEquals(Integer.valueOf(14), bst.nextValue(13));
		assertEquals(Integer.valueOf(15), bst.nextValue(14));
		assertNull(bst.nextValue(15));
		assertNull(bst.nextValue(16));
	}

}
