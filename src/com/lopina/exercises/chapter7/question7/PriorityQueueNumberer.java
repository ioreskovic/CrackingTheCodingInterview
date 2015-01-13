package com.lopina.exercises.chapter7.question7;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Time complexity:
 *     Worst: O(log(b^k))
 *     Average: ?
 *     Best: O(log(b*k))
 * @author Lopina
 *
 */
public class PriorityQueueNumberer implements Numberer {
	private Set<Integer> blocks;
	private PriorityQueue<Integer> pq;
	private Set<Integer> alreadyPresent;
	
	public PriorityQueueNumberer(int ... blocks) {
		this.blocks = new TreeSet<Integer>();
		
		for (int block : blocks) {
			this.blocks.add(block);
		}
		
		this.pq = new PriorityQueue<Integer>();
		
		this.alreadyPresent = new HashSet<Integer>();
		
		initValues();
	}

	private void initValues() {
		int startingValue = 1;
		
		pq.offer(startingValue);
		alreadyPresent.add(startingValue);
	}
	
	public int getNextValue() {
		int min = pq.poll();
		alreadyPresent.remove(min);
		
		for (Integer block : blocks) {
			int possibleValue = min * block;
			if (!alreadyPresent.contains(possibleValue)) {
				pq.offer(possibleValue);
				alreadyPresent.add(possibleValue);
			}
		}
		
		return min;
	}
	
	public int getKthNextValue(int k) {
		for (int i = 0; i < k; i++) {
			getNextValue();
		}
		
		return getNextValue();
	}
	
}
