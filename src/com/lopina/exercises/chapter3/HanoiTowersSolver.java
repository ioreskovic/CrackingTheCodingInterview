package com.lopina.exercises.chapter3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class HanoiTowersSolver {
	private static final int TOWERS = 3;
	private int disks;
	private List<Deque<Integer>> towers;
	private List<Deque<Integer>> startingSnapshopt;
	private int moves;
	
	public HanoiTowersSolver(int disks) {
		super();
		this.disks = disks;
		init();
	}

	private void createTowers() {
		this.towers = new ArrayList<Deque<Integer>>();
		
		for (int i = 0; i < TOWERS; i++) {
			this.towers.add(new ArrayDeque<Integer>());
		}
	}
	
	private void setupDisks() {
		Deque<Integer> startingTower = getTower(0);
		
		for (int i = this.disks; i > 0; i--) {
			startingTower.offerFirst(i);
		}
		
		takeSnapshot();
	}

	private void takeSnapshot() {
		this.startingSnapshopt = new ArrayList<Deque<Integer>>();
		
		for (int i = 0; i < TOWERS; i++) {
			Deque<Integer> towerSnapshot = new ArrayDeque<Integer>();
			Deque<Integer> towerOriginal = getTower(i);
			
			for (Integer disk : towerOriginal) {
				towerSnapshot.offerLast(new Integer(disk));
			}
			
			this.startingSnapshopt.add(towerSnapshot);
		}
	}

	private Deque<Integer> getTower(int index) {
		if (index >= this.towers.size()) {
			return null;
		}
		
		return this.towers.get(index);
	}
	
	public void moveDisks() {
		moveRecursively(0, 2, disks);
	}

	private void moveRecursively(int srcTowerIndex, int dstTowerIndex, int nDisks) {
		int tmpTowerIndex = TOWERS - srcTowerIndex - dstTowerIndex;
		
//		System.out.println("moveRecursively(" + srcTowerIndex + ", " + dstTowerIndex + ", " + nDisks + ")");
//		System.out.println("\t" + toString());
		
		if (nDisks == 1) {
			getTower(dstTowerIndex).push(getTower(srcTowerIndex).pop());
			this.moves ++;
		} else {
			moveRecursively(srcTowerIndex, tmpTowerIndex, nDisks - 1);
			moveRecursively(srcTowerIndex, dstTowerIndex, 1);
			moveRecursively(tmpTowerIndex, dstTowerIndex, nDisks - 1);
		}
		
//		System.out.println("\t" + toString());
	}

	public String toString() {
		return stringify(this.towers);
	}
	
	public String snapshotToString() {
		return stringify(this.startingSnapshopt);
	}

	private String stringify(List<Deque<Integer>> zieTowers) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[ ");
		
		for (Deque<Integer> zieTower : zieTowers) {
			sb.append("( ");
			
			for (Integer disk : zieTower) {
				sb.append(disk).append(" ");
			}
			
			sb.append(") ");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	
	public int getMoves() {
		return this.moves;
	}
	
	public void reset() {
		init();
	}

	private void init() {
		this.moves = 0;
		createTowers();
		setupDisks();
	}
	
}
