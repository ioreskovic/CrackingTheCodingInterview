package com.lopina.exercises.dynamic.knapsack.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lopina.exercises.dynamic.knapsack.KnapsackItem;
import com.lopina.exercises.dynamic.knapsack.KnapsackProblem;
import com.lopina.exercises.dynamic.knapsack.ZeroOneKnapsackProblem;

public class ZeroOneKnapsackProblemTest {

	@Test
	public void test() {
		List<KnapsackItem> itemList = new ArrayList<KnapsackItem>();
		itemList.add(new KnapsackItem("Item 1", 1, 1));
		itemList.add(new KnapsackItem("Item 2", 2, 6));
		itemList.add(new KnapsackItem("Item 3", 5, 18));
		itemList.add(new KnapsackItem("Item 4", 6, 22));
		itemList.add(new KnapsackItem("Item 5", 4, 28));
		
		int maxWeight = 11;
		
		ZeroOneKnapsackProblem zkp = new ZeroOneKnapsackProblem(maxWeight, itemList);
		
		List<KnapsackItem> solution = zkp.solve();
		int solutionValue = zkp.getSolutionValue();
		int solutionWeight = zkp.getSolutionWeight();
		
		assertEquals(52, solutionValue);
		assertEquals(11, solutionWeight);
		
		System.out.println("Solution value: " + solutionValue);
		System.out.println("Solution weight: " + solutionWeight);
		
		for (KnapsackItem item : solution) {
			System.out.println(item);
		}
	}

}
