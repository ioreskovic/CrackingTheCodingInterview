package com.lopina.exercises.chapter4.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.chapter4.BinarySearchTree;
import com.lopina.exercises.chapter4.SymbolTable.SymbolTableEntry;
import com.lopina.exercises.chapter4.Tree;

public class Question4 {

	private BinarySearchTree<Integer, Integer> bst;
	
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
	}
	
	@Test
	public void test() {
		List<LinkedList<Tree.Node<Integer, Integer>>> levels = bst.getDeleveledTree();
		
		for (LinkedList<Tree.Node<Integer, Integer>> level : levels) {
			for (Tree.Node<Integer, Integer> node : level) {
				System.out.print(node.toString() + " - ");
			}
			System.out.println();
		}
	}

}
