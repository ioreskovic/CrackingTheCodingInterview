package com.lopina.exercises.chapter3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SetOfStacks<T> implements MyStack<T> {

	private List<MyStack<T>> stacks;
	private int stackCapacity = 8;
	private int currentStackIndex = 0;
	
	public SetOfStacks(int stackCapacity) {
		this.stackCapacity = stackCapacity;
		this.stacks = new ArrayList<MyStack<T>>();
		this.stacks.add(new MyLinkedListStack<T>());
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO
		return null;
	}

	@Override
	public void push(T item) {
		pushToLastNonEmptyStack(item);
		checkForExpanding();
	}

	private void pushToLastNonEmptyStack(T item) {
		stacks.get(currentStackIndex).push(item);
	}

	@Override
	public T pop() {
		T value = popFromLastNonEmptyStack();
		checkForShrinking();
		
		return value;
	}

	private T popFromLastNonEmptyStack() {
		int lastNonEmptyStackIndex = currentStackIndex;
		
		if (stacks.get(currentStackIndex).size() == 0 && stacks.size() > 1) {
			lastNonEmptyStackIndex = currentStackIndex - 1;
		}
		
		return stacks.get(lastNonEmptyStackIndex).pop();
	}

	@Override
	public T peek() {
		return peekFromLastNonEmptyStack();
	}

	private T peekFromLastNonEmptyStack() {
		int lastNonEmptyStackIndex = currentStackIndex;
		
		if (stacks.get(currentStackIndex).size() == 0 && stacks.size() > 1) {
			lastNonEmptyStackIndex = currentStackIndex - 1;
		}
		return stacks.get(lastNonEmptyStackIndex).peek();
	}

	@Override
	public int size() {
		return combinedSize();
	}

	private int combinedSize() {
		return stackCapacity * currentStackIndex + stacks.get(currentStackIndex).size();
	}
	
	private void checkForExpanding() {
		if (stacks.get(currentStackIndex).size() == stackCapacity) {
			stacks.add(new MyLinkedListStack<T>());
			currentStackIndex++;
		}
	}
	
	private void checkForShrinking() {
		if (stacks.get(currentStackIndex).size() == 0 && stacks.size() > 1) {
			stacks.remove(currentStackIndex);
			currentStackIndex--;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("{ ");
		
		for (int i = stacks.size() - 1; i >= 0; i--) {
			MyStack<T> stack = stacks.get(i);
			
			sb.append("[ ");
			
			for (T element : stack) {
				sb.append(element.toString()).append(" ");
			}
			
			sb.append("] ");
		}
		
		sb.append("}");
		
		return sb.toString();
	}

}
