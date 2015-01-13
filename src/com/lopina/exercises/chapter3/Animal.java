package com.lopina.exercises.chapter3;

public abstract class Animal {
	
	private Integer order;
	private String name;
	public abstract String talk();
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String describe() {
		return talk() + " I am " + this.name + " with order name " + this.order;
	}
	
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	public Integer getOrder() {
		return order;
	}
	
	public String getName() {
		return name;
	}
}
