package com.lopina.exercises.chapter3;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	@Override
	public String talk() {
		return "Meow!";
	}

}
