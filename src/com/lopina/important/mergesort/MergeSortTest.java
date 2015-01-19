package com.lopina.important.mergesort;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lopina.important.insertionsort.InsertionSort;

public class MergeSortTest {

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
		MergeSort.mergesort(sortedArray);
		System.out.println(Arrays.toString(sortedArray));
		
		System.out.println(Arrays.toString(duplicateArray));
		MergeSort.mergesort(duplicateArray);
		System.out.println(Arrays.toString(duplicateArray));
		
		System.out.println(Arrays.toString(reverseSortedArray));
		MergeSort.mergesort(reverseSortedArray);
		System.out.println(Arrays.toString(reverseSortedArray));
		
		System.out.println(Arrays.toString(randomArray));
		MergeSort.mergesort(randomArray);
		System.out.println(Arrays.toString(randomArray));
		System.out.println("<---- Sort ---->");
	}
	
	@Test
	public void bigSortTest() {
		Random random = new Random();
		Integer[] big = new Integer[25];
		for (int i = 0; i < big.length; i++) {
			big[i] = random.nextInt(100);
		}
		
		InsertionSort.sort(big, 0, big.length - 1);
		System.out.println(Arrays.toString(big));
	}
	
}
