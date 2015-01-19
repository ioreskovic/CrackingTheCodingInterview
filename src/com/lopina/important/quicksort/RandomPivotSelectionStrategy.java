package com.lopina.important.quicksort;

import java.util.Random;

public class RandomPivotSelectionStrategy implements PivotSelectionStrategy {

	private Random random = new Random();
	
	@Override
	public <T extends Comparable<T>> int selectPivot(T[] array, int from, int to) {
		return random.nextInt(to - from + 1) + from;
	}

}
