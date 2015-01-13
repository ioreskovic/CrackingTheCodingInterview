package com.lopina.exercises.chapter5.question7;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lopina.exercises.chapter5.BitUtils;

public class Chapter5Question7 {

	@Test
	public void test() {
		List<Integer> numbers = new ArrayList<Integer>();
		
		for (int i = 0; i < 17; i++) {
			numbers.add(i);
		}
		
		numbers.remove(4);
		
		int missingNumber = BitUtils.findMissingNumber(numbers);
		
		assertEquals(4, missingNumber);
	}

}
