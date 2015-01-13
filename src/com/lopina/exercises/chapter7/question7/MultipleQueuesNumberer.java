package com.lopina.exercises.chapter7.question7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class MultipleQueuesNumberer implements Numberer {
	private Set<Integer> blocks;
	private Map<Integer, Deque<Integer>> queues;
	
	public MultipleQueuesNumberer(int ... blocks) {
		initBlocks(blocks);
		initQueues();
	}
	
	private void initBlocks(int[] blocks) {
		this.blocks = new TreeSet<Integer>();
		
		for (int block : blocks) {
			this.blocks.add(block);
		}
	}

	private void initQueues() {
		this.queues = new HashMap<Integer, Deque<Integer>>();
		
		for (int b : blocks) {
			ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
			queues.put(b, queue);
		}
		
		queues.get(blocks.iterator().next()).add(1);
	}

	@Override
	public int getNextValue() {
		Map<Integer, Integer> peekValues = new HashMap<Integer, Integer>();
		
		for (int queueIndex : blocks) {
			peekValues.put(queueIndex, peekValueFromQueue(queueIndex));
		}
		
		Entry<Integer, Integer> minValueEntry = getMinValueEntry(peekValues);
		
		for (int queueIndex : blocks) {
			if (queueIndex <= minValueEntry.getKey()) {
				if (queueIndex == minValueEntry.getKey()) {
					pollValueFromQueue(queueIndex);
				}
				offerValueToQueue(queueIndex, minValueEntry.getValue() * queueIndex);
			}
		}
		
		return minValueEntry.getValue();
	}

	private Entry<Integer, Integer> getMinValueEntry(Map<Integer, Integer> peekValues) {
		int minValue = Integer.MAX_VALUE;
		Entry<Integer, Integer> minEntry = null;
		
		for (Entry<Integer, Integer> entry : peekValues.entrySet()) {
			if (entry.getValue() < minValue) {
				minValue = entry.getValue();
				minEntry = entry;
			}
		}
		
		return minEntry;
	}

	private int peekValueFromQueue(int queueIndex) {
		Deque<Integer> queue = queues.get(queueIndex);
		
		if (queue == null || queue.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return queue.peek();
		}
	}

	private int pollValueFromQueue(int queueIndex) {
		Deque<Integer> queue = queues.get(queueIndex);
		
		if (queue == null || queue.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return queue.poll();
		}
	}

	private void offerValueToQueue(int queueIndex, int n) {
		Deque<Integer> queue = queues.get(queueIndex);
		
		if (queue == null || queue.isEmpty()) {
			queue = new ArrayDeque<Integer>();
			queues.put(queueIndex, queue);
		}
		
		queue.offer(n);
	}

	@Override
	public int getKthNextValue(int k) {
		for (int i = 0; i < k; i++) {
			getNextValue();
		}
		
		return getNextValue();
	}

}
