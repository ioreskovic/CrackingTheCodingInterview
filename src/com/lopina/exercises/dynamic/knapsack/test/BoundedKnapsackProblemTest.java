package com.lopina.exercises.dynamic.knapsack.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lopina.exercises.dynamic.knapsack.BoundedKnapsackProblem;
import com.lopina.exercises.dynamic.knapsack.KnapsackItem;
import com.lopina.exercises.dynamic.knapsack.KnapsackProblem;

public class BoundedKnapsackProblemTest {

	@Test
	public void test() {
		int maxWeight = 400;
		List<KnapsackItem> itemList = new ArrayList<KnapsackItem>();
		
        itemList.add(new KnapsackItem("map", 9, 150, 1));
        itemList.add(new KnapsackItem("compass", 13, 35, 1));
        itemList.add(new KnapsackItem("water", 153, 200, 3));
        itemList.add(new KnapsackItem("sandwich", 50, 60, 2));
        itemList.add(new KnapsackItem("glucose", 15, 60, 2));
        itemList.add(new KnapsackItem("tin", 68, 45, 3));
        itemList.add(new KnapsackItem("banana", 27, 60, 3));
        itemList.add(new KnapsackItem("apple", 39, 40, 3));
        itemList.add(new KnapsackItem("cheese", 23, 30, 1));
        itemList.add(new KnapsackItem("beer", 52, 10, 3));
        itemList.add(new KnapsackItem("suntan cream", 11, 70, 1));
        itemList.add(new KnapsackItem("camera", 32, 30, 1));
        itemList.add(new KnapsackItem("t-shirt", 24, 15, 2));
        itemList.add(new KnapsackItem("trousers", 48, 10, 2));
        itemList.add(new KnapsackItem("umbrella", 73, 40, 1));
        itemList.add(new KnapsackItem("waterproof trousers", 42, 70, 1));
        itemList.add(new KnapsackItem("waterproof overclothes", 43, 75, 1));
        itemList.add(new KnapsackItem("note-case", 22, 80, 1));
        itemList.add(new KnapsackItem("sunglasses", 7, 20, 1));
        itemList.add(new KnapsackItem("towel", 18, 12, 2));
        itemList.add(new KnapsackItem("socks", 4, 50, 1));
        itemList.add(new KnapsackItem("book", 30, 10, 2));
        
        KnapsackProblem bkp = new BoundedKnapsackProblem(maxWeight, itemList);
        
        List<KnapsackItem> solution = bkp.solve();
        
        System.out.println("Solution value: " + bkp.getSolutionValue());
        System.out.println("Solution weight: " + bkp.getSolutionWeight());
        
        int value = 0;
        int weight = 0;
        
        for (KnapsackItem item : solution) {
        	if (item.getInSolution() > 0) {
        		value += (item.getInSolution() * item.getValue());
        		weight += (item.getInSolution() * item.getWeight());
        		System.out.println(item);
        	}
        }
        
        System.out.println("Reconstructed value: " + value);
        System.out.println("Reconstructed weight: " + weight);
	}

}
