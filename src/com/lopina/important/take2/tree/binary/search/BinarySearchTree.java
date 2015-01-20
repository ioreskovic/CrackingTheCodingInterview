package com.lopina.important.take2.tree.binary.search;

import com.lopina.important.take2.tree.Tree;

public abstract class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
	public abstract T min();
	public abstract T max();
}
