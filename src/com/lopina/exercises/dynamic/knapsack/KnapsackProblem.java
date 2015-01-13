package com.lopina.exercises.dynamic.knapsack;

import java.util.List;

public interface KnapsackProblem {
	public List<KnapsackItem> solve();
	public void addItem(KnapsackItem item);
	public void removeItem(String itemName);
	public void clearItems();
	public int getSolutionWeight();
	public int getSolutionValue();
}
