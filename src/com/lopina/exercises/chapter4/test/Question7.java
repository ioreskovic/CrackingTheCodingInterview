package com.lopina.exercises.chapter4.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.chapter4.BinarySearchTree;
import com.lopina.exercises.chapter4.Tree;
import com.lopina.exercises.chapter4.SymbolTable.SymbolTableEntry;

public class Question7 {

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
	public void test() {
		assertEquals(Integer.valueOf(1), bst.getFirstCommonAncestorKey(1, 1));
		assertEquals(Integer.valueOf(2), bst.getFirstCommonAncestorKey(1, 2));
		assertEquals(Integer.valueOf(2), bst.getFirstCommonAncestorKey(1, 3));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(1, 4));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(1, 5));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(1, 6));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(1, 7));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(1, 8));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(1, 9));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(1, 10));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(1, 11));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(1, 12));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(1, 13));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(1, 14));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(1, 15));
		
		assertEquals(Integer.valueOf(2), bst.getFirstCommonAncestorKey(2, 2));
		assertEquals(Integer.valueOf(2), bst.getFirstCommonAncestorKey(2, 3));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(2, 4));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(2, 5));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(2, 6));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(2, 7));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(2, 8));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(2, 9));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(2, 10));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(2, 11));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(2, 12));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(2, 13));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(2, 14));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(2, 15));
		
		assertEquals(Integer.valueOf(3), bst.getFirstCommonAncestorKey(3, 3));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(3, 4));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(3, 5));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(3, 6));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(3, 7));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(3, 8));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(3, 9));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(3, 10));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(3, 11));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(3, 12));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(3, 13));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(3, 14));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(3, 15));
		
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(4, 4));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(4, 5));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(4, 6));
		assertEquals(Integer.valueOf(4), bst.getFirstCommonAncestorKey(4, 7));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(4, 8));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(4, 9));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(4, 10));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(4, 11));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(4, 12));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(4, 13));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(4, 14));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(4, 15));
		
		assertEquals(Integer.valueOf(5), bst.getFirstCommonAncestorKey(5, 5));
		assertEquals(Integer.valueOf(6), bst.getFirstCommonAncestorKey(5, 6));
		assertEquals(Integer.valueOf(6), bst.getFirstCommonAncestorKey(5, 7));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(5, 8));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(5, 9));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(5, 10));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(5, 11));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(5, 12));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(5, 13));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(5, 14));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(5, 15));
		
		assertEquals(Integer.valueOf(6), bst.getFirstCommonAncestorKey(6, 6));
		assertEquals(Integer.valueOf(6), bst.getFirstCommonAncestorKey(6, 7));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(6, 8));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(6, 9));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(6, 10));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(6, 11));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(6, 12));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(6, 13));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(6, 14));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(6, 15));
		
		assertEquals(Integer.valueOf(7), bst.getFirstCommonAncestorKey(7, 7));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(7, 8));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(7, 9));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(7, 10));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(7, 11));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(7, 12));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(7, 13));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(7, 14));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(7, 15));
		
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(8, 8));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(8, 9));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(8, 10));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(8, 11));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(8, 12));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(8, 13));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(8, 14));
		assertEquals(Integer.valueOf(8), bst.getFirstCommonAncestorKey(8, 15));
		
		assertEquals(Integer.valueOf(9), bst.getFirstCommonAncestorKey(9, 9));
		assertEquals(Integer.valueOf(10), bst.getFirstCommonAncestorKey(9, 10));
		assertEquals(Integer.valueOf(10), bst.getFirstCommonAncestorKey(9, 11));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(9, 12));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(9, 13));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(9, 14));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(9, 15));
		
		assertEquals(Integer.valueOf(10), bst.getFirstCommonAncestorKey(10, 10));
		assertEquals(Integer.valueOf(10), bst.getFirstCommonAncestorKey(10, 11));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(10, 12));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(10, 13));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(10, 14));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(10, 15));
		
		assertEquals(Integer.valueOf(11), bst.getFirstCommonAncestorKey(11, 11));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(11, 12));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(11, 13));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(11, 14));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(11, 15));
		
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(12, 12));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(12, 13));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(12, 14));
		assertEquals(Integer.valueOf(12), bst.getFirstCommonAncestorKey(12, 15));
		
		assertEquals(Integer.valueOf(13), bst.getFirstCommonAncestorKey(13, 13));
		assertEquals(Integer.valueOf(14), bst.getFirstCommonAncestorKey(13, 14));
		assertEquals(Integer.valueOf(14), bst.getFirstCommonAncestorKey(13, 15));
		
		assertEquals(Integer.valueOf(14), bst.getFirstCommonAncestorKey(14, 14));
		assertEquals(Integer.valueOf(14), bst.getFirstCommonAncestorKey(14, 15));
		
		assertEquals(Integer.valueOf(15), bst.getFirstCommonAncestorKey(15, 15));
	}

}
