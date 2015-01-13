package com.lopina.exercises.dynamic.maxtrix.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.chapter1.MatrixUtils;
import com.lopina.exercises.dynamic.maxtrix.MaximumSumSubmatrix;

public class MaximumSumSubmatrixTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Integer[][] matrix = new Integer[][] {
				{1, 0,  2, 4},
				{3, 7,  1, 6},
				{5, 8, 11, 6},
				{9, 12, 2, 1}
		};
		
		MaximumSumSubmatrix mss = new MaximumSumSubmatrix(matrix, 2);
		mss.solve();
		
		System.out.println("Solution");
		System.out.println(MatrixUtils.toString(mss.getSolution()));
	}

}
