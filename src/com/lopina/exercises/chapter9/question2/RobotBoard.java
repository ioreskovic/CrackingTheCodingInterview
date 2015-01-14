package com.lopina.exercises.chapter9.question2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotBoard {
	public int x;
	public int y;
	
	private int[][] ways;
	
	private Map<Point, List<Point>> paths;
	
	public RobotBoard(int x, int y) {
		this.x = x;
		this.y = y;
		
		this.ways = new int[x + 1][y + 1];
		
		this.paths = new HashMap<Point, List<Point>>();
	}
	
	public int getWays() {
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				if (i == 0 || j == 0) {
					ways[i][j] = 1;
				} else {
					ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
				}
				
				
				
				Point p = new Point(i, j);
				Point pLeft = new Point(i, j - 1);
				Point pUp = new Point(i - 1, j);
				
				List<Point> pathFromLeft = paths.getOrDefault(pLeft, new ArrayList<Point>());
				List<Point> pathFromUp = paths.getOrDefault(pUp, new ArrayList<Point>());
				
				List<Point> path = new ArrayList<Point>();
				
			}
		}
		
		return ways[x][y];
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("Ways to move to (" + i + ", " + j + ") = " + (new RobotBoard(i, j).getWays()));
			}
		}
	}
}
