package com.lopina.exercises.chapter4.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.chapter4.BinarySearchTree;
import com.lopina.exercises.chapter4.Tree;
import com.lopina.exercises.chapter4.SymbolTable.SymbolTableEntry;

public class Question9 {
	
	private BinarySearchTree<Integer, Integer> tree;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		SymbolTableEntry<Integer, Integer>[] bigEntries;
		bigEntries = new SymbolTableEntry[15];
		bigEntries[0] = new SymbolTableEntry<Integer, Integer>(1, 1);
		bigEntries[1] = new SymbolTableEntry<Integer, Integer>(5, 5);
		bigEntries[2] = new SymbolTableEntry<Integer, Integer>(15, 15);
		bigEntries[3] = new SymbolTableEntry<Integer, Integer>(7, 7);
		bigEntries[4] = new SymbolTableEntry<Integer, Integer>(2, 2);
		bigEntries[5] = new SymbolTableEntry<Integer, Integer>(11, 11);
		bigEntries[6] = new SymbolTableEntry<Integer, Integer>(14, 14);
		bigEntries[7] = new SymbolTableEntry<Integer, Integer>(8, 8);
		bigEntries[8] = new SymbolTableEntry<Integer, Integer>(3, 3);
		bigEntries[9] = new SymbolTableEntry<Integer, Integer>(6, 6);
		bigEntries[10] = new SymbolTableEntry<Integer, Integer>(13, 13);
		bigEntries[11] = new SymbolTableEntry<Integer, Integer>(9, 9);
		bigEntries[12] = new SymbolTableEntry<Integer, Integer>(4, 4);
		bigEntries[13] = new SymbolTableEntry<Integer, Integer>(10, 10);
		bigEntries[14] = new SymbolTableEntry<Integer, Integer>(12, 12);
		tree = new BinarySearchTree<Integer, Integer>(false, bigEntries);
		
		List<LinkedList<Tree.Node<Integer, Integer>>> levels = tree.getDeleveledTree();
		
		for (LinkedList<Tree.Node<Integer, Integer>> level : levels) {
			for (Tree.Node<Integer, Integer> node : level) {
				System.out.print(node.toString() + " - ");
			}
			System.out.println();
		}
		
	}
	
	@Test
	public void test() {
		BinarySearchTree.sumPaths(tree, 15);
	}

}
