package com.lopina.exercises.dynamic.rod.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.dynamic.rod.RodCuttingProblem;

public class RodCuttingProblemTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int noCutOptions = 8;
		
		int[] cutLengths = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] cutValues = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int rodLength = 8;
		
		RodCuttingProblem rcp = new RodCuttingProblem(cutLengths, cutValues, rodLength);
		rcp.solve();
		
		System.out.println("Maximum profit for cutting a rod of length " + rodLength + " is " + rcp.getProfit());
		System.out.println("Cuts:");
		System.out.println(Arrays.toString(cutLengths));
		System.out.println(Arrays.toString(rcp.getSolution()));
	}

}
