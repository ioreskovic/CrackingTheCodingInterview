package com.lopina.exercises.dynamic.editdistance.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.dynamic.editdistance.EditDistance;

public class EditDistanceTest {

	private String firstString;
	private String secondString;
	private EditDistance editDistance;
	private int editDistanceValue;
	
	@Before
	public void setUp() throws Exception {
		firstString = null;
		secondString = null;
		editDistance = null;
		editDistanceValue = -1;
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Edit distance for changing string \"" + firstString + "\" to \"" + secondString + "\" is " + editDistanceValue + ".");
		System.out.println("Steps:");
		for (String step : editDistance.getSteps()) {
			System.out.println("\t" + step);
		}
		System.out.println();
	}

	@Test
	public void test1() {
		this.firstString = "BOOK";
		this.secondString = "BOOK";
		this.editDistance = new EditDistance(firstString, secondString);
		this.editDistance.solve();
		this.editDistanceValue = this.editDistance.getEditDistanceValue();
	}
	
	@Test
	public void test2() {
		this.firstString = "BOOK";
		this.secondString = "BOOT";
		this.editDistance = new EditDistance(firstString, secondString);
		this.editDistance.solve();
		this.editDistanceValue = this.editDistance.getEditDistanceValue();
	}
	
	@Test
	public void test3() {
		this.firstString = "BOOK";
		this.secondString = "BORK";
		this.editDistance = new EditDistance(firstString, secondString);
		this.editDistance.solve();
		this.editDistanceValue = this.editDistance.getEditDistanceValue();
	}
	
	@Test
	public void test4() {
		this.firstString = "BOOK";
		this.secondString = "BEEK";
		this.editDistance = new EditDistance(firstString, secondString);
		this.editDistance.solve();
		this.editDistanceValue = this.editDistance.getEditDistanceValue();
	}
	
	@Test
	public void test5() {
		this.firstString = "BOOK";
		this.secondString = "LEET";
		this.editDistance = new EditDistance(firstString, secondString);
		this.editDistance.solve();
		this.editDistanceValue = this.editDistance.getEditDistanceValue();
	}
	
	@Test
	public void test6() {
		this.firstString = "BOOK";
		this.secondString = "BOOKLET";
		this.editDistance = new EditDistance(firstString, secondString);
		this.editDistance.solve();
		this.editDistanceValue = this.editDistance.getEditDistanceValue();
	}
	
	@Test
	public void test7() {
		this.firstString = "BOOK";
		this.secondString = "AUDIOBOOK";
		this.editDistance = new EditDistance(firstString, secondString);
		this.editDistance.solve();
		this.editDistanceValue = this.editDistance.getEditDistanceValue();
	}
	
	@Test
	public void test8() {
		this.firstString = "BOOKING";
		this.secondString = "AUDIOBOOK";
		this.editDistance = new EditDistance(firstString, secondString);
		this.editDistance.solve();
		this.editDistanceValue = this.editDistance.getEditDistanceValue();
	}
	
	@Test
	public void test9() {
		this.firstString = "00KKKK00DDDD";
		this.secondString = "IIII11KKKK11";
		this.editDistance = new EditDistance(firstString, secondString);
		this.editDistance.solve();
		this.editDistanceValue = this.editDistance.getEditDistanceValue();
	}

}
