package com.lopina.exercises.chapter9.question1;

public class RunningChild {
	private int[] waysOfRunning;
	private int nStairs;
	
	public RunningChild(int nStairs) {
		this.nStairs = nStairs;
		this.waysOfRunning = new int[nStairs + 1];
	}
	
	public int possibleWaysToJump() {
		for (int i = 0; i <= nStairs; i++) {
			if (i == 0) {
				waysOfRunning[i] = 1;
			} else {
				waysOfRunning[i] = getWaysOfRunning(i - 1) + getWaysOfRunning(i - 2) + getWaysOfRunning(i - 3);
			}
		}
		
		return waysOfRunning[nStairs];
	}

	private int getWaysOfRunning(int i) {
		if (i < 0) {
			return 0;
		}
		
		return waysOfRunning[i];
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Ways of running for " + i  + " stairs = " + (new RunningChild(i)).possibleWaysToJump());
		}
	}
}
