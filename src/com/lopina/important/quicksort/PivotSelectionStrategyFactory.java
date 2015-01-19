package com.lopina.important.quicksort;

import com.lopina.important.quicksort.test.MedianPivotSelectionStrategy;

public class PivotSelectionStrategyFactory {
	private PivotSelectionStrategyFactory() {
	}

	public static RandomPivotSelectionStrategy getRandomPivotSelectionStrategy() {
		return new RandomPivotSelectionStrategy();
	}
	
	public static MedianPivotSelectionStrategy getMedianPivotSelectionStrategy() {
		return new MedianPivotSelectionStrategy();
	}
	
	public static MedianOfMediansPivotSelectionStrategy getMedianOfMediansPivotSelectionStrategy() {
		return new MedianOfMediansPivotSelectionStrategy();
	}
}
