package com.lopina.exercises.chapter4;

import com.lopina.exercises.chapter4.SymbolTable.SymbolTableEntry;

public interface SymbolTable<Key extends Comparable<Key>, Value> extends Iterable<SymbolTableEntry<Key, Value>> {
	public static class SymbolTableEntry<Key, Value> {
		private Key key;
		private Value value;
		
		public SymbolTableEntry(Key key, Value value) {
			super();
			this.key = key;
			this.value = value;
		}
		
		public Key getKey() {
			return key;
		}
		
		public Value getValue() {
			return value;
		}
	}
	
	public abstract void add(Key key, Value value);
	public abstract void delete(Key key);
	public abstract boolean contains(Key key);
	public abstract boolean isEmpty();
	public abstract int size();
	public abstract Value get(Key value);
}
