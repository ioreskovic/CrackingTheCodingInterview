package com.lopina.exercises.dynamic.knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ZeroOneKnapsackProblem implements KnapsackProblem {

	private List<KnapsackItem> itemList = new ArrayList<KnapsackItem>();
	private int maxWeight = 0;
	private int solutionWeight = 0;
	private int solutionValue = 0;
	private boolean solved = false;
	
	public ZeroOneKnapsackProblem() {
	}
	
	public ZeroOneKnapsackProblem(List<KnapsackItem> itemList) {
		setItemList(itemList);
	}
	
	public ZeroOneKnapsackProblem(int maxWeight) {
		setMaxWeight(maxWeight);
	}
	
	public ZeroOneKnapsackProblem(int maxWeight, List<KnapsackItem> itemList) {
		setMaxWeight(maxWeight);
		setItemList(itemList);
	}
	
	@Override
	public List<KnapsackItem> solve() {
		int nItems = this.itemList.size();
		
		if (nItems > 0 && maxWeight > 0) {
			List<List<Integer>> memoValues = new ArrayList<List<Integer>>();
			List<Integer> current = new ArrayList<Integer>();
			memoValues.add(current);
			
			for (int w = 0; w <= maxWeight; w++) {
				current.add(0);
			}
			
			for (int i = 1; i <= nItems; i++) {
				List<Integer> previous = current;
				current = new ArrayList<Integer>();
				memoValues.add(current);
				
				for (int w = 0; w <= maxWeight; w++) {
					if (w > 0) {
						KnapsackItem currentItem = itemList.get(i - 1);
						int itemExcludedValue = previous.get(w);
						
						int itemIncludedCapacity = w - currentItem.getWeight();
						int itemIncludedValue = Integer.MIN_VALUE;
						
						if (itemIncludedCapacity >= 0 && itemIncludedCapacity <= maxWeight) {
							itemIncludedValue = previous.get(itemIncludedCapacity) + currentItem.getValue();
						}
						
						if (itemIncludedCapacity <= maxWeight && itemIncludedValue > itemExcludedValue) {
							current.add(itemIncludedValue);
						} else {
							current.add(itemExcludedValue);
						}
					} else {
						current.add(0);
					}
					
					
				}
			}
			
			/*
			 * Memo print
			 */
			for (List<Integer> memoRow : memoValues) {
				System.out.println(memoRow);
			}
			System.out.println();
			
			this.solutionValue = current.get(maxWeight);
			
			List<KnapsackItem> solution = reconstructSolution(memoValues);
			
			return solution;
		}
		
		return null;
		
	}
	
	private List<KnapsackItem> reconstructSolution(List<List<Integer>> memoValues) {
		int nItems = this.itemList.size();
		
		for (int i = nItems, w = maxWeight; i > 0 && w >= 0; i--) {
			int valueWithThisItem = memoValues.get(i).get(w);
			int valueWithoutThisItem = memoValues.get(i - 1).get(w);
			
			if ((i == 0 && valueWithThisItem > 0) || (i > 0 && valueWithThisItem != valueWithoutThisItem)) {
				KnapsackItem item = itemList.get(i - 1);
				int itemWeight = item.getWeight();
				w -= itemWeight;
				this.solutionWeight += itemWeight;
				item.setInSolution(1);
			}
		}
		
		this.solved = true;
		
		return this.itemList; 
	}

	@Override
	public void addItem(KnapsackItem item) {
		this.itemList.add(new KnapsackItem(item.getName(), item.getWeight(), item.getValue()));
	}
	
	@Override
	public void removeItem(String itemName) {
		for (Iterator<KnapsackItem> it = itemList.iterator(); it.hasNext(); ) {
			if (itemName.equals(it.next().getName())) {
				it.remove();
			}
		}
		initializeKnapsack();
	}
	
	@Override
	public void clearItems() {
		this.itemList.clear();
		initializeKnapsack();
	}
	
	private void setInKnapsackForAll(int inKnapsack) {
		for (KnapsackItem item : itemList) {
			if (inKnapsack > 0) {
				item.setInSolution(1);
			} else {
				item.setInSolution(0);
			}
		}
	}
	
	protected void initializeKnapsack() {
		setInKnapsackForAll(0);
		this.solutionValue = 0;
		this.solutionWeight = 0;
		this.solved = false;
	}
	
	public int getMaxWeight() {
		return maxWeight;
	}
	
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	public List<KnapsackItem> getItemList() {
		return itemList;
	}
	
	public void setItemList(List<KnapsackItem> itemList) {
		this.itemList = itemList;
		Collections.sort(
				itemList,
				new Comparator<KnapsackItem>() {

					@Override
					public int compare(KnapsackItem item1, KnapsackItem item2) {
						Double valueToWeightRatio1 = (double) item1.getValue() / (double) item1.getWeight();
						Double valueToWeightRatio2 = (double) item2.getValue() / (double) item2.getWeight();

						return valueToWeightRatio1.compareTo(valueToWeightRatio2);
					}
				}
		);
	}
	
	public int getSolutionValue() {
		return solutionValue;
	}
	
	public int getSolutionWeight() {
		return solutionWeight;
	}
	
	public boolean isSolved() {
		return solved;
	}

}
