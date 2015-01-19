package com.lopina.exercises.chapter1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.chapter1.MatrixUtils;

public class MatrixBinarySearchTest {

	private Integer[][] matrix;
	
	@Before
	public void setUp() throws Exception {
		matrix = new Integer[][] {
				{ 15, 20, 40, 55, 60 },
				{ 20, 35, 80, 95, 100 },
				{ 30, 50, 95, 105, 110 },
				{ 55, 80, 100, 120, 125 },
				{ 60, 85, 105, 125, 130 }
		};
	}

	@Test
	public void test() {
		System.out.println(MatrixUtils.contains(matrix, 55));
	}

}
