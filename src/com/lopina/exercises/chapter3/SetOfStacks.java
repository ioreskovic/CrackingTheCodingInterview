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
		final List<Iterator<T>> iterators = new ArrayList<Iterator<T>>();
		
		for (int i = stacks.size() - 1; i >= 0; i--) {
			iterators.add(stacks.get(i).iterator());
		}
		
		return new Iterator<T>() {
			int currentIteratorIndex = 0;
			
			@Override
			public boolean hasNext() {
				if (currentIteratorIndex >= iterators.size()) {
					return false;
				}
				
				Iterator<T> currentIterator = iterators.get(currentIteratorIndex);
				
				if (currentIterator.hasNext()) {
					return true;
				} else {
					currentIteratorIndex++;
					
					if (currentIteratorIndex >= iterators.size()) {
						return false;
					}
					
					currentIterator = iterators.get(currentIteratorIndex);
					return currentIterator.hasNext();
				}
			}

			@Override
			public T next() {
				return iterators.get(currentIteratorIndex).next();
			}
		};
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
	
	public T popAt(int stackIndex) {
		T item = stacks.get(stackIndex).pop();
		
		int nextStackIndex = stackIndex + 1;
		MyStack<T> nextStack = getStack(nextStackIndex);
		
		while (nextStack != null && nextStack.size() > 0) {
			MyStack<T> reversedClone = new MyLinkedListStack<T>();
			
			for (T element : nextStack) {
				reversedClone.push(element);
			}
			
			stacks.get(stackIndex).push(reversedClone.pop());
			
			MyStack<T> forwardClone = new MyLinkedListStack<T>();
			
			for (T element : reversedClone) {
				forwardClone.push(element);
			}
			
			this.stacks.set(nextStackIndex, forwardClone);
			
			stackIndex++;
			nextStackIndex++;
			nextStack = getStack(nextStackIndex);
		}
		
		cleanUpStacks();
		
		return item;
	}

	private void cleanUpStacks() {
		for (int i = 1; i < stacks.size(); i++) {
			if (stacks.get(i).size() == 0) {
				stacks.remove(i);
			}
		}
	}

	private MyStack<T> getStack(int i) {
		if (i < this.stacks.size()) {
			return this.stacks.get(i);
		}
		return null;
	}

}
