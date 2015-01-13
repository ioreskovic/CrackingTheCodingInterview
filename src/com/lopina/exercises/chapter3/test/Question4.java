package com.lopina.exercises.chapter3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter3.HanoiTowersSolver;

public class Question4 {

	@Test
	public void shouldProperlyCreateHanoiTowers() {
		HanoiTowersSolver hts = new HanoiTowersSolver(1);
		String state = hts.toString();
		String snapshopt = hts.toString();
		
		assertEquals(state, snapshopt);
		
		System.out.println(state);
	}
	
	@Test
	public void shouldProperlySolveWhenOneDisk() {
		HanoiTowersSolver hts = new HanoiTowersSolver(1);
		String startState = hts.toString();
		System.out.println("Start - " + startState);
		hts.moveDisks();
		String finalState = hts.toString();
		System.out.println("Final - " + finalState);
		System.out.println("Solved in " + hts.getMoves() + " moves");
		assertEquals((int) Math.pow(2, 1) - 1, hts.getMoves());
	}
	
	@Test
	public void shouldProperlySolveWhenTwoDisks() {
		HanoiTowersSolver hts = new HanoiTowersSolver(2);
		String startState = hts.toString();
		System.out.println("Start - " + startState);
		hts.moveDisks();
		String finalState = hts.toString();
		System.out.println("Final - " + finalState);
		System.out.println("Solved in " + hts.getMoves() + " moves");
		assertEquals((int) Math.pow(2, 2) - 1, hts.getMoves());
	}
	
	@Test
	public void shouldProperlySolveWhenThreeDisks() {
		HanoiTowersSolver hts = new HanoiTowersSolver(3);
		String startState = hts.toString();
		System.out.println("Start - " + startState);
		hts.moveDisks();
		String finalState = hts.toString();
		System.out.println("Final - " + finalState);
		System.out.println("Solved in " + hts.getMoves() + " moves");
		assertEquals((int) Math.pow(2, 3) - 1, hts.getMoves());
	}
	
	@Test
	public void shouldProperlySolveWhenFourDisks() {
		HanoiTowersSolver hts = new HanoiTowersSolver(4);
		String startState = hts.toString();
		System.out.println("Start - " + startState);
		hts.moveDisks();
		String finalState = hts.toString();
		System.out.println("Final - " + finalState);
		System.out.println("Solved in " + hts.getMoves() + " moves");
		assertEquals((int) Math.pow(2, 4) - 1, hts.getMoves());
	}
	
	@Test
	public void shouldProperlySolveWhenFiveDisks() {
		HanoiTowersSolver hts = new HanoiTowersSolver(5);
		String startState = hts.toString();
		System.out.println("Start - " + startState);
		hts.moveDisks();
		String finalState = hts.toString();
		System.out.println("Final - " + finalState);
		System.out.println("Solved in " + hts.getMoves() + " moves");
		assertEquals((int) Math.pow(2, 5) - 1, hts.getMoves());
	}

}
