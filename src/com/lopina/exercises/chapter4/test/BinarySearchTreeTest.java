package com.lopina.exercises.chapter4.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.lopina.exercises.chapter4.BinarySearchTree;
import com.lopina.exercises.chapter4.SymbolTable.SymbolTableEntry;

public class BinarySearchTreeTest {

	@Test
	public void shouldCreateEmptyBinarySearchTree() {
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		assertEquals(0, bst.size());
		assertNull(bst.get(0));
	}
	
	@Test
	public void shouldContainElementWhenInsertedInTree() {
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		
		bst.add(3, "Three");
		bst.add(1, "One");
		bst.add(5, "Five");
		bst.add(0, "Zero");
		bst.add(2, "Two");
		bst.add(4, "Four");
		bst.add(6, "Six");
		
		assertTrue(bst.contains(0));
		assertTrue(bst.contains(1));
		assertTrue(bst.contains(2));
		assertTrue(bst.contains(3));
		assertTrue(bst.contains(4));
		assertTrue(bst.contains(5));
		assertTrue(bst.contains(6));
	}
	
	@Test
	public void elementsShouldBeSortedAscendingWhenUsingInOrderTraversal() {
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		
		bst.add(3, "Three");
		bst.add(1, "One");
		bst.add(5, "Five");
		bst.add(0, "Zero");
		bst.add(2, "Two");
		bst.add(4, "Four");
		bst.add(6, "Six");
		
		List<String> actualValues = new ArrayList<String>();
		
		for (Iterator<SymbolTableEntry<Integer, String>> it = bst.getInOrderIterator(); it.hasNext();) {
			actualValues.add(it.next().getValue());
		}
		
		String[] expecteds = new String[] { "Zero", "One", "Two", "Three", "Four", "Five", "Six" };
		
		assertArrayEquals(expecteds, actualValues.toArray(new String[actualValues.size()]));
	}
	
	@Test
	public void elementsShouldBePreOrderedWhenUsingPreOrderTraversal() {
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		
		bst.add(3, "Three");
		bst.add(1, "One");
		bst.add(5, "Five");
		bst.add(0, "Zero");
		bst.add(2, "Two");
		bst.add(4, "Four");
		bst.add(6, "Six");
		
		List<String> actualValues = new ArrayList<String>();
		
		for (Iterator<SymbolTableEntry<Integer, String>> it = bst.getPreOrderIterator(); it.hasNext();) {
			actualValues.add(it.next().getValue());
		}
		
		String[] expecteds = new String[] { "Three", "One", "Zero", "Two", "Five", "Four", "Six" };
		
		assertArrayEquals(expecteds, actualValues.toArray(new String[actualValues.size()]));
	}
	
	@Test
	public void elementsShouldBePostOrderedWhenUsingPostOrderTraversal() {
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		
		bst.add(3, "Three");
		bst.add(1, "One");
		bst.add(5, "Five");
		bst.add(0, "Zero");
		bst.add(2, "Two");
		bst.add(4, "Four");
		bst.add(6, "Six");
		
		List<String> actualValues = new ArrayList<String>();
		
		for (Iterator<SymbolTableEntry<Integer, String>> it = bst.getPostOrderIterator(); it.hasNext();) {
			actualValues.add(it.next().getValue());
		}
		
		String[] expecteds = new String[] { "Zero", "Two", "One", "Four", "Six", "Five", "Three" };
		
		assertArrayEquals(expecteds, actualValues.toArray(new String[actualValues.size()]));
	}
	
	@Test
	public void elementsShouldBeLevelOrderedWhenUsingLevelOrderTraversal() {
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		
		bst.add(3, "Three");
		bst.add(1, "One");
		bst.add(5, "Five");
		bst.add(0, "Zero");
		bst.add(2, "Two");
		bst.add(4, "Four");
		bst.add(6, "Six");
		
		List<String> actualValues = new ArrayList<String>();
		
		for (Iterator<SymbolTableEntry<Integer, String>> it = bst.getLevelOrderIterator(); it.hasNext();) {
			actualValues.add(it.next().getValue());
		}
		
		String[] expecteds = new String[] { "Three", "One", "Five", "Zero", "Two", "Four", "Six" };
		
		assertArrayEquals(expecteds, actualValues.toArray(new String[actualValues.size()]));
	}
	
	@Test
	public void minElementInRightSubtreeShouldReplaceRootWhenDeletingRoot() {
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		
		bst.add(3, "Three");
		bst.add(1, "One");
		bst.add(5, "Five");
		bst.add(0, "Zero");
		bst.add(2, "Two");
		bst.add(4, "Four");
		bst.add(6, "Six");
		
		bst.delete(3);
		
		List<String> actualValues = new ArrayList<String>();
		
		for (Iterator<SymbolTableEntry<Integer, String>> it = bst.getLevelOrderIterator(); it.hasNext();) {
			actualValues.add(it.next().getValue());
		}
		
		String[] expecteds = new String[] { "Four", "One", "Five", "Zero", "Two", "Six" };
		
		assertArrayEquals(expecteds, actualValues.toArray(new String[actualValues.size()]));
	}

}
