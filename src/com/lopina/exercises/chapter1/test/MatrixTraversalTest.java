package com.lopina.exercises.chapter1.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.chapter1.MatrixUtils;

public class MatrixTraversalTest {

	private Integer[][] matrix = MatrixUtils.createIntegerMatrix(3, 3);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void diagonalTopRightToBottomLeft() {
		System.out.println(MatrixUtils.toString(matrix));
		System.out.println();
		MatrixUtils.traverseMatrixDiagonal1(matrix);
	}
	
	@Test
	public void diagonalTopLeftToBottomRight() {
		System.out.println(MatrixUtils.toString(matrix));
		System.out.println();
		MatrixUtils.traverseMatrixDiagonal2(matrix);
	}
	
	@Test
	public void spiralTraversal() {
		System.out.println(MatrixUtils.toString(matrix));
		System.out.println();
		MatrixUtils.traverseMatrixSpiral(matrix);
	}

}
