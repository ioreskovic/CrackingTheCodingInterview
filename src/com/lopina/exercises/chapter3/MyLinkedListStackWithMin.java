package com.lopina.exercises.chapter3;


public class MyLinkedListStackWithMin<T extends Comparable<T>> extends MyLinkedListStack<T> {
	private MyStack<T> minStack = null;
	
	public MyLinkedListStackWithMin() {
		super();
		this.minStack = new MyLinkedListStack<T>();
	}
	
	@Override
	public void push(T item) {
		super.push(item);
		T minSoFar = this.minStack.peek();
		
		if (minSoFar == null || item.compareTo(minSoFar) <= 0) {
			this.minStack.push(item);
		}
	}
	
	@Override
	public T pop() {
		T value = super.pop();
		T minSoFar = this.minStack.peek();
		
		if (value.compareTo(minSoFar) == 0) {
			this.minStack.pop();
		}
		
		return value;
	}
	
	/**
	 * Retrieves the minimum item in this stack.
	 * Time complexity is O(n)
	 * Space complexity is O(n) in the worst case, when </br>
	 * the stack is filled with same elements.
	 * @return the minimum element of this stack
	 */
	public T peekMin() {
		return this.minStack.peek();
	}
	
}
