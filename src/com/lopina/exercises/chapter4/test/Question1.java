package com.lopina.exercises.chapter4.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter4.BinarySearchTree;

public class Question1 {

	@Test
	public void shouldBeBalancedWhenEmptyTree() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		assertTrue(bst.isBalanced());
	}
	
	@Test
	public void shouldBeBalancedWhenOnlyRoot() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		bst.add(8, 8);
		
		assertTrue(bst.isBalanced());
	}
	
	@Test
	public void shouldBeBalancedWhenOnly2Elements() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		bst.add(8, 8);
		bst.add(6, 6);
		
		assertTrue(bst.isBalanced());
	}
	
	@Test
	public void shouldBeBalancedWhenOnlyRootWithLeftAndRightChild() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		bst.add(8, 8);
		bst.add(6, 6);
		bst.add(10, 10);
		
		assertTrue(bst.isBalanced());
	}
	
	@Test
	public void shouldBeBalancedWhenHeightDifferenceIsNoMoreThanOne() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		bst.add(8, 8);
		
		bst.add(6, 6);
		bst.add(10, 10);
		
		bst.add(4, 4);
		
		assertTrue(bst.isBalanced());
	}
	
	@Test
	public void shouldBeBalancedWhenHeightDifferenceIsNoMoreThanOneOnBothSides() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		bst.add(8, 8);
		
		bst.add(6, 6);
		bst.add(10, 10);
		
		bst.add(4, 4);
		bst.add(12, 12);
		
		assertTrue(bst.isBalanced());
	}
	
	@Test
	public void shouldNotBeBalancedWhenHeightDifferenceIsGreaterThanOneDeepDownInTree() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		bst.add(8, 8);
		
		bst.add(6, 6);
		bst.add(10, 10);
		
		bst.add(4, 4);
		bst.add(12, 12);
		
		bst.add(2, 2);
		bst.add(14, 14);
		
		assertFalse(bst.isBalanced());
	}
	
	@Test
	public void shouldNotBeBalancedWhenHeightDifferenceIsGreaterThanOneDeepDownInTreeTest2() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		bst.add(8, 8);
		
		bst.add(6, 6);
		bst.add(10, 10);
		
		bst.add(4, 4);
		bst.add(12, 12);
		
		bst.add(2, 2);
		bst.add(14, 14);
		
		bst.add(5, 5);
		
		assertFalse(bst.isBalanced());
	}
	
	@Test
	public void shouldNotBeBalancedWhenHeightDifferenceIsGreaterThanOneDeepDownInTreeTest3() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		bst.add(8, 8);
		
		bst.add(6, 6);
		bst.add(10, 10);
		
		bst.add(4, 4);
		bst.add(12, 12);
		
		bst.add(2, 2);
		bst.add(14, 14);
		
		bst.add(5, 5);
		bst.add(11, 11);
		
		assertFalse(bst.isBalanced());
	}
	
	@Test
	public void shouldNotBeBalancedWhenHeightDifferenceIsGreaterThanOneDeepDownInTreeTest4() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		bst.add(8, 8);
		
		bst.add(6, 6);
		bst.add(10, 10);
		
		bst.add(4, 4);
		bst.add(12, 12);
		
		bst.add(2, 2);
		bst.add(14, 14);
		
		bst.add(5, 5);
		bst.add(11, 11);
		
		bst.add(7, 7);
		
		assertFalse(bst.isBalanced());
	}
	
	@Test
	public void shouldNotBeBalancedWhenHeightDifferenceIsGreaterThanOneDeepDownInTreeTest5() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		bst.add(8, 8);
		
		bst.add(6, 6);
		bst.add(10, 10);
		
		bst.add(4, 4);
		bst.add(12, 12);
		
		bst.add(2, 2);
		bst.add(14, 14);
		
		bst.add(5, 5);
		bst.add(11, 11);
		
		bst.add(7, 7);
		bst.add(9, 9);
		
		assertTrue(bst.isBalanced());
	}

}
