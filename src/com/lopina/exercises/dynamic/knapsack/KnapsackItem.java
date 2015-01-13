package com.lopina.exercises.dynamic.knapsack;

public class KnapsackItem {
	private String name = null;
	private int weight = 0;
	private int value = 0;
	private int bounding = 1;
	private int inSolution = 0;
	
	public KnapsackItem(int weight, int value) {
		setWeight(weight);
		setValue(value);
	}
	
	public KnapsackItem(int weight, int value, int bounding) {
		setWeight(weight);
		setValue(value);
		setBounding(bounding);
	}
	
	public KnapsackItem(String name, int weight, int value) {
		setName(name);;
		setWeight(weight);
		setValue(value);
	}
	
	public KnapsackItem(String name, int weight, int value, int bounding) {
		setName(name);
		setWeight(weight);
		setValue(value);
		setBounding(bounding);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getBounding() {
		return bounding;
	}

	public void setBounding(int bounding) {
		this.bounding = bounding;
	}

	public int getInSolution() {
		return inSolution;
	}

	public void setInSolution(int inSolution) {
		this.inSolution = inSolution;
	}

	@Override
	public String toString() {
		return "KnapsackItem [name=" + name + ", weight=" + weight + ", value="
				+ value + ", bounding=" + bounding + ", inSolution="
				+ inSolution + "]";
	}
	
	
	
}
