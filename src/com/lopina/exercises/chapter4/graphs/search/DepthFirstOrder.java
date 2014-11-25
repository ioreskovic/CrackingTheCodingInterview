package com.lopina.exercises.chapter4.graphs.search;

import java.util.ArrayDeque;
import java.util.Deque;

import com.lopina.exercises.chapter4.graphs.Digraph;

public class DepthFirstOrder {

	private boolean[] marked;
	private int[] pre;
	private int[] post;
	private Deque<Integer> preorder;
	private Deque<Integer> postorder;
	private int preCounter;
	private int postCounter;
	
	public DepthFirstOrder(Digraph digraph) {
		int vertices = digraph.V();
		
		this.marked = new boolean[vertices];
		this.pre = new int[vertices];
		this.post = new int[vertices];
		
		this.preorder = new ArrayDeque<Integer>();
		this.postorder = new ArrayDeque<Integer>();
		
		for (int v = 0; v < vertices; v++) {
			if (!marked[v]) {
				dfs(digraph, v);
			}
		}
	}

	private void dfs(Digraph digraph, int vertex) {
		marked[vertex] = true;
		pre[vertex] = preCounter++;
		preorder.offerLast(vertex);
		
		for (int w : digraph.adj(vertex)) {
			if (!marked[w]) {
				dfs(digraph, w);
			}
		}
		
		postorder.offerLast(vertex);
		post[vertex] = postCounter++;
	}
	
	public int pre(int vertex) {
		return pre[vertex];
	}
	
	public int post(int vertex) {
		return post[vertex];
	}
	
	public Deque<Integer> getPreorder() {
		return preorder;
	}
	
	public Deque<Integer> getPostorder() {
		return postorder;
	}
	
	public Deque<Integer> getReversePostorder() {
		Deque<Integer> reversePostorder = new ArrayDeque<Integer>();
		
		for (int vertex : postorder) {
			reversePostorder.offerFirst(vertex);
		}
		
		return reversePostorder;
	}
	
}
