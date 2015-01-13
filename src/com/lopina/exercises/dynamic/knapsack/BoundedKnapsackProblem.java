package com.lopina.exercises.dynamic.knapsack;

import java.util.ArrayList;
import java.util.List;

public class BoundedKnapsackProblem extends ZeroOneKnapsackProblem {

	public BoundedKnapsackProblem() {
		super();
	}

	public BoundedKnapsackProblem(int maxWeight, List<KnapsackItem> itemList) {
		super(maxWeight, itemList);
	}

	public BoundedKnapsackProblem(int maxWeight) {
		super(maxWeight);
	}

	public BoundedKnapsackProblem(List<KnapsackItem> itemList) {
		super(itemList);
	}

	@Override
	public List<KnapsackItem> solve() {
		List<KnapsackItem> itemListUnrolled = new ArrayList<KnapsackItem>();
		
		for (KnapsackItem item : getItemList()) {
			for (int i = 0; i < item.getBounding(); i++) {
				itemListUnrolled.add(
						new KnapsackItem(
								item.getName() + "_" + (i + 1), 
								item.getWeight(), 
								item.getValue()
						)
				);
			}
		}
		
		List<KnapsackItem> originalItemList = getItemList();
		
		setItemList(itemListUnrolled);
		
		List<KnapsackItem> solvedItemList = super.solve();
		
		System.out.println("Solved item list");
		for (KnapsackItem item : solvedItemList) {
			System.out.println(item);
		}
		System.out.println();
		
		for (int i = 0, k = 0; i < originalItemList.size(); i++) {
			KnapsackItem originalItem = originalItemList.get(i);
			int originalItemBounding = originalItem.getBounding();
			int originalItemsInSolution = 0;
			
			for (int j = k; j < k + originalItemBounding; j++) {
				originalItemsInSolution += solvedItemList.get(j).getInSolution();
			}
			
			originalItem.setInSolution(originalItemsInSolution);
			
			k += originalItemBounding;
		}
		
		return originalItemList;
	}
}
