package com.lopina.exercises.practice.q10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TowerOfBoxes {
	public static Deque<Box> towerOfBoxesDynamic() {
		List<Box> boxes = new ArrayList<Box>();
		
		for (int w = 1; w <= 3; w++) {
			for (int h = 1; h <= 3; h++) {
				for (int d = 1; d <= 3; d++) {
					boxes.add(new Box(w, h, d));
				}
			}
		}
		
//		Comparator<Box> c = new Comparator<Box>() {
//
//			@Override
//			public int compare(Box o1, Box o2) {
//				if (o1.w < o2.w && o1.h < o2.h && o1.d < o2.d) {
//					return -1;
//				}
//				
//				if (o1.w > o2.w && o1.h > o2.h && o1.d > o2.d) {
//					return 1;
//				}
//				
//				return 0;
//			}
//		};
//		
//		Collections.sort(
//				boxes,
//				c
//		);
		
		Map<Box, ArrayDeque<Box>> bestTowerBelow = new HashMap<Box, ArrayDeque<Box>>();
		bestTowerBelow.put(null, new ArrayDeque<Box>());
		return createTower(boxes, null, bestTowerBelow);
	}
	
	
	private static ArrayDeque<Box> createTower(List<Box> boxes, Box bottom, Map<Box, ArrayDeque<Box>> bestTowerBelow) {
		if (bottom != null && bestTowerBelow.containsKey(bottom)) {
			return bestTowerBelow.get(bottom);
		}
		
		int heightMax = 0;
		ArrayDeque<Box> highest = null;
		for (Box box : boxes) {
			if (box.canBeAbove(bottom)) {
				ArrayDeque<Box> tower = copy(createTower(boxes, box, bestTowerBelow));
				
				int heightCurr = height(tower);
				if (heightCurr > heightMax) {
					heightMax = height(tower);
					highest = tower;
				}
			}
		}
		
		printBestTowers(bestTowerBelow);
		
		if (highest == null) {
			highest = new ArrayDeque<Box>();
		}
		
//		highest = copy(highest);
		
		if (bottom != null) {
			highest.push(bottom);
		}
		
		bestTowerBelow.put(bottom, highest);
		
		return highest;
	}


	private static ArrayDeque<Box> copy(ArrayDeque<Box> highest) {
		ArrayDeque<Box> copy = new ArrayDeque<Box>();
		
		for (Box box : highest) {
			copy.offer(box);
		}
		
		return copy;
	}


	private static void printBestTowers(Map<Box, ArrayDeque<Box>> bestTowerBelow) {
		for (Entry<Box, ArrayDeque<Box>> e : bestTowerBelow.entrySet()) {
			System.out.println("\t" + e.getKey() + "=" + e.getValue());
		}
		System.out.println();
	}


	private static int height(ArrayDeque<Box> towerSoFar) {
		int height = 0;
		
		for (Box box : towerSoFar) {
			height += box.h;
		}
		
		return height;
	}


	public static void towerOfBoxesLinearithmic() {
		List<Box> boxes = new ArrayList<Box>();
		
		for (int w = 1; w <= 3; w++) {
			for (int h = 1; h <= 3; h++) {
				for (int d = 1; d <= 3; d++) {
					boxes.add(new Box(w, h, d));
				}
			}
		}
		
		Comparator<Box> c = new Comparator<Box>() {

			@Override
			public int compare(Box o1, Box o2) {
				if (o1.w < o2.w && o1.h < o2.h && o1.d < o2.d) {
					return -1;
				}
				
				if (o1.w > o2.w && o1.h > o2.h && o1.d > o2.d) {
					return 1;
				}
				
				return 0;
			}
		};
		
		Collections.sort(
				boxes,
				c
		);
		
		Collections.reverse(boxes);
		System.out.println(boxes);
		
		Deque<Box> tower = new ArrayDeque<Box>();
		
		tower.push(boxes.get(0));
		
		for (int i = 1; i < boxes.size(); i++) {
			Box box = boxes.get(i);
			if (c.compare(box, tower.peek()) == -1) {
				tower.push(box);
			}
		}
		
		System.out.println(tower);
	}
	
	public static void main(String[] args) {
		towerOfBoxesLinearithmic();
		System.out.println(towerOfBoxesDynamic());
	}
}
