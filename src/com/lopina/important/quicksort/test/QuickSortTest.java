package com.lopina.important.quicksort.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lopina.important.quicksort.QuickSort;

public class QuickSortTest {

	private Integer[] sortedArray;
	private Integer[] duplicateArray;
	private Integer[] reverseSortedArray;
	private Integer[] randomArray;
	
	private static Integer[] randomStatic;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		Random random = new Random();
		
		randomStatic = new Integer[20];
		for (int i = 0; i < randomStatic.length; i++) {
			randomStatic[i] = random.nextInt(100);
		}
	}
	
	@Before
	public void setUp() {
		sortedArray = new Integer[20];
		for (int i = 0; i < sortedArray.length; i++) {
			sortedArray[i] = i;
		}
		
		duplicateArray = new Integer[20];
		for (int i = 0; i < duplicateArray.length; i++) {
			duplicateArray[i] = 0;
		}
		
		reverseSortedArray = new Integer[20];
		for (int i = 0; i < reverseSortedArray.length; i++) {
			reverseSortedArray[i] = 19 - i;
		}
		
		randomArray = Arrays.copyOf(randomStatic, randomStatic.length);
	}
	
	@Test
	public void sort() {
		System.out.println("<---- Sort ---->");
		System.out.println(Arrays.toString(sortedArray));
		QuickSort.sort(sortedArray);
		System.out.println(Arrays.toString(sortedArray));
		
		System.out.println(Arrays.toString(duplicateArray));
		QuickSort.sort(duplicateArray);
		System.out.println(Arrays.toString(duplicateArray));
		
		System.out.println(Arrays.toString(reverseSortedArray));
		QuickSort.sort(reverseSortedArray);
		System.out.println(Arrays.toString(reverseSortedArray));
		
		System.out.println(Arrays.toString(randomArray));
		QuickSort.sort(randomArray);
		System.out.println(Arrays.toString(randomArray));
		System.out.println("<---- Sort ---->");
	}
	
	@Test
	public void partialSort() {
		System.out.println("<---- Partial Sort ---->");
		QuickSort.partialSort(sortedArray, 5);
		System.out.println(Arrays.toString(sortedArray));
		
		QuickSort.partialSort(duplicateArray, 5);
		System.out.println(Arrays.toString(duplicateArray));
		
		QuickSort.partialSort(reverseSortedArray, 5);
		System.out.println(Arrays.toString(reverseSortedArray));
		
		QuickSort.partialSort(randomArray, 5);
		System.out.println(Arrays.toString(randomArray));
		System.out.println("<---- Partial Sort ---->");
	}
	
	@Test
	public void kThOrderStatistic() {
		System.out.println("<---- Kth Order Statistic ---->");
		for (int i = 0; i < 20; i++) {
			Integer kSortedArray = QuickSort.select(sortedArray, i);
			QuickSort.sort(sortedArray);
			System.out.print(kSortedArray + " ");
			assertEquals(sortedArray[i], kSortedArray);
		}
		System.out.println();
		
		for (int i = 0; i < 20; i++) {
			Integer kSortedArray = QuickSort.select(duplicateArray, i);
			QuickSort.sort(duplicateArray);
			System.out.print(kSortedArray + " ");
			assertEquals(duplicateArray[i], kSortedArray);
		}
		System.out.println();
		
		for (int i = 0; i < 20; i++) {
			Integer kSortedArray = QuickSort.select(reverseSortedArray, i);
			QuickSort.sort(reverseSortedArray);
			System.out.print(kSortedArray + " ");
			assertEquals(reverseSortedArray[i], kSortedArray);
		}
		System.out.println();
		
		for (int i = 0; i < 20; i++) {
			Integer kSortedArray = QuickSort.select(randomArray, i);
			QuickSort.sort(randomArray);
			System.out.print(kSortedArray + " ");
			assertEquals(randomArray[i], kSortedArray);
		}
		System.out.println();
		System.out.println("<---- Kth Order Statistic ---->");
	}
	
	@Test
	public void bigSortTest() {
		Random random = new Random();
		Integer[] big = new Integer[128];
		for (int i = 0; i < big.length; i++) {
			big[i] = random.nextInt(100);
		}
		System.out.println(Arrays.toString(big));
		QuickSort.sort(big);
		System.out.println(Arrays.toString(big));
	}

}
