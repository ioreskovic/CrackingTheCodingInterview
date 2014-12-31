package com.lopina.exercises.chapter7.question7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SimpleNaiveNumberer implements Numberer {
	private int[] blocks = new int[] { 
			3, 5, 7 
	};
	
	private Map<Integer, Deque<Integer>> queues;
	
	public SimpleNaiveNumberer() {
		queues = new HashMap<Integer, Deque<Integer>>();
		
		for (int b : blocks) {
			ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
			queues.put(b, queue);
		}
		
		queues.get(3).add(1);
	}
	
	public int getNextValue() {
		int v3 = peekValueFromQueue(3);
		int v5 = peekValueFromQueue(5);
		int v7 = peekValueFromQueue(7);
		
		int vMin = Math.min(v3, Math.min(v5,  v7));
		
		if (vMin == v3) {
			pollValueFromQueue(3);
			offerValueToQueue(3, vMin * 3);
			offerValueToQueue(5, vMin * 5);
			offerValueToQueue(7, vMin * 7);
		} else if (vMin == v5) {
			pollValueFromQueue(5);
			offerValueToQueue(5, vMin * 5);
			offerValueToQueue(7, vMin * 7);
		} else {
			pollValueFromQueue(7);
			offerValueToQueue(7, vMin * 7);
		}
		
		return vMin;
	}
	
	public int getKthNextValue(int k) {
		for (int i = 0; i < k; i++) {
			getNextValue();
		}
		
		return getNextValue();
	}

	private int peekValueFromQueue(int i) {
		Deque<Integer> queue = queues.get(i);
		
		if (queue == null || queue.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return queue.peek();
		}
	}
	
	private int pollValueFromQueue(int i) {
		Deque<Integer> queue = queues.get(i);
		
		if (queue == null || queue.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return queue.poll();
		}
	}

	private void offerValueToQueue(int i, int n) {
		Deque<Integer> queue = queues.get(i);
		
		if (queue == null || queue.isEmpty()) {
			queue = new ArrayDeque<Integer>();
			queues.put(i, queue);
		}
		
		queue.offer(n);
	}
}
