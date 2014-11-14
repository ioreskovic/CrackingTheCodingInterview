package com.lopina.exercises.chapter4;

import java.util.ArrayDeque;
import java.util.Deque;

public class Trie<Value> {
	private static final int R = 256;
	
	private TrieNode root;
	private int N;
	
	private static class TrieNode {
		private Object value;
		private TrieNode[] next = new TrieNode[R];
	}
	
	public Trie() {
		
	}
	
	@SuppressWarnings("unchecked")
	public Value get(String key) {
		TrieNode node = get(root, key, 0);
		
		if (node == null) {
			return null;
		}
		
		return (Value) node.value;
	}
	
	public boolean contains(String key) {
		return get(key) != null;
	}
	
	private TrieNode get(TrieNode node, String key, int d) {
		if (node == null) {
			return null;
		}
		
		if (d == key.length()) {
			return node;
		}
		
		char c = key.charAt(d);
		
		return get(node.next[c], key, d + 1);
	}
	
	public void put(String key, Value value) {
		if (value == null) {
			delete(key);
		} else {
			root = put(root, key, value, 0);
		}
	}
	
	private TrieNode put(TrieNode node, String key, Value value, int d) {
		if (node == null) {
			node = new TrieNode();
		}
		
		if (d == key.length()) {
			if (node.value == null) {
				N++;
				node.value = value;
				return node;
			}
		}
		
		char c = key.charAt(d);
		node.next[c] = put(node.next[c], key, value, d + 1);
		
		return node;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Iterable<String> keys() {
		return keysWithPrefix("");
	}
	
	public Iterable<String> keysWithPrefix(String prefix) {
		Deque<String> results = new ArrayDeque<String>();
		TrieNode node = get(root, prefix, 0);
		collect(node, new StringBuilder(prefix), results);
		return results;
	}
	
	private void collect(TrieNode node, StringBuilder prefix, Deque<String> results) {
		if (node == null) {
			return;
		}
		
		if (node.value != null) {
			results.offerLast(prefix.toString());
		}
		
		for (char c = 0; c < R; c++) {
			prefix.append(c);
			collect(node.next[c], prefix, results);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}
	
	public Iterable<String> keysThatMatch(String pattern) {
		Deque<String> results = new ArrayDeque<String>();
		collect(root, new StringBuilder(), pattern, results);
		
		return results;
	}
	
	private void collect(TrieNode node, StringBuilder prefix, String pattern, Deque<String> results) {
		if (node == null) {
			return;
		}
		
		int d = prefix.length();
		
		if (d == pattern.length() && node.value != null) {
			results.offerLast(prefix.toString());
		}
		
		if (d == pattern.length()) {
			return;
		}
		
		char c = pattern.charAt(d);
		
		if (c == '.') {
			for (char ch = 0; ch < R; ch++) {
				prefix.append(ch);
				collect(node.next[ch], prefix, pattern, results);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		} else {
			prefix.append(c);
			collect(node.next[c], prefix, pattern, results);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}
	
	public String longestPrefixOf(String query) {
		int length = longestPrefixOf(root, query, 0, 0);
		return query.substring(0, length);
	}
	
	private int longestPrefixOf(TrieNode node, String query, int d, int length) {
		if (node == null) {
			return length;
		}
		
		if (node.value != null) {
			length = d;
		}
		
		if (d == query.length()) {
			return length;
		}
		
		char c = query.charAt(d);
		
		return longestPrefixOf(node.next[c], query, d + 1, length);
	}
	
	public void delete(String key) {
		root = delete(root, key, 0);
	}
	
	private TrieNode delete(TrieNode node, String key, int d) {
		if (node == null) {
			return null;
		}
		
		if (d == key.length()) {
			if (node.value != null) {
				N--;
			}
			
			node.value = null;
		} else {
			char c = key.charAt(d);
			node.next[c] = delete(node.next[c], key, d + 1);
		}
		
		if (node.value != null) {
			return node;
		}
		
		for (char c = 0; c < R; c++) {
			if (node.next[c] != null) {
				return node;
			}
		}
		
		return null;
	}
}
