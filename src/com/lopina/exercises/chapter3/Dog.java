package com.lopina.exercises.chapter3;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}
	
	@Override
	public String talk() {
		return "Woof!";
	}

}
