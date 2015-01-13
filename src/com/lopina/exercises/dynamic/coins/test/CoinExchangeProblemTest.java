package com.lopina.exercises.dynamic.coins.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lopina.exercises.dynamic.coins.CoinExchangeProblem;

public class CoinExchangeProblemTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int[] coinValues = new int[] { 1, 2, 3 };
		int sum = 5;
		CoinExchangeProblem cep = new CoinExchangeProblem(coinValues, sum);
		cep.solve();
		System.out.println("Minimum number of coins needed to achieve sum of: " + sum + " is " + cep.getCoinsUsed());
		System.out.println("Distributon:");
		System.out.println(Arrays.toString(coinValues));
		System.out.println(Arrays.toString(cep.getSolution()));
	}

}
