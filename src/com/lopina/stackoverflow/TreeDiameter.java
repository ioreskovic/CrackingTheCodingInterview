package com.lopina.stackoverflow;

import com.lopina.important.take2.tree.Tree;
import com.lopina.important.take2.tree.binary.search.NodeBinarySearchTree;

public class TreeDiameter {
	public static void main(String[] args) {
		Tree<Integer> tree = new NodeBinarySearchTree<Integer>();
		tree.add(5);
		tree.add(2);
		tree.add(8);
		tree.add(1);
		tree.add(3);
		tree.add(7);
		tree.add(9);
		tree.add(4);
		tree.add(6);
		tree.add(-1);
		tree.add(-2);
		tree.add(10);
		
		for (Integer diameterNode : tree.diameter()) {
			System.out.print(diameterNode + " ");
		}
	}
}
