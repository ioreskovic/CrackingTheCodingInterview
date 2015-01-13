package com.lopina.exercises.chapter7.question7;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.princeton.cs.introcs.Stopwatch;

public class Chapter7Question7 {

	@Test
	public void test() {
		PriorityQueueNumberer pqn = new PriorityQueueNumberer(3, 5, 7);
		Stopwatch pqns = new Stopwatch();
		for (int i = 0; i < 10000; i++) {
//			System.out.println(
					pqn.getNextValue();
//			);
		}
		System.out.println(pqns.elapsedTime());	
		System.out.println();
		
		SimpleNaiveNumberer snn = new SimpleNaiveNumberer();
		Stopwatch snns = new Stopwatch();
		for (int i = 0; i < 10000; i++) {
//			System.out.println(
					snn.getNextValue();
//			);
		}
		System.out.println(snns.elapsedTime());	
		System.out.println();
		
		Numberer mqn = new MultipleQueuesNumberer(3, 5, 7);
		Stopwatch mqns = new Stopwatch();
		for (int i = 0; i < 10000; i++) {
//			System.out.println(
					mqn.getNextValue();
//			);
		}
		System.out.println(mqns.elapsedTime());	
		System.out.println();
		
		
//		PriorityQueueNumberer numberer = new PriorityQueueNumberer(2, 4, 8, 16, 32);
//		Stopwatch stopwatch = new Stopwatch();
//		numberer.getKthNextValue(256);
//		double time = stopwatch.elapsedTime();
//		System.out.println(time);
//		System.out.println();
		
		
//		PriorityQueueNumberer numberer = new PriorityQueueNumberer(3, 5, 7, 11, 13);
//		Stopwatch stopwatch = new Stopwatch();
//		numberer.getKthNextValue(256);
//		double time = stopwatch.elapsedTime();
//		System.out.println(time);
//		System.out.println();
	}

}
