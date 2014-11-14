package com.lopina.exercises.chapter4.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter4.Trie;

public class TrieTest {

	@Test
	public void test() {
		Trie<Integer> trie = new Trie<Integer>();
		
		trie.put("by", 4);
		trie.put("sea", 6);
		trie.put("sells", 1);
		trie.put("she", 0);
		trie.put("shells", 3);
		trie.put("shore", 7);
		trie.put("the", 5);
		
		System.out.println(trie.keys());
		System.out.println(trie.keysWithPrefix("s"));
		System.out.println(trie.keysThatMatch(".he.l."));
		System.out.println(trie.keysThatMatch("......*"));
	}

}
