package com.lopina.exercises.chapter3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class AnimalShelterAdoptionQueue<T extends Animal> {

	private Deque<Cat> catDeque;
	private Deque<Dog> dogDeque;
	private Integer lastOrder;
	
	
	public AnimalShelterAdoptionQueue() {
		this.catDeque = new ArrayDeque<Cat>();
		this.dogDeque = new ArrayDeque<Dog>();
		this.lastOrder = 0;
	}
	
	public void enqueue(Animal animal) {
		animal.setOrder(++lastOrder);
		
		if (animal instanceof Cat) {
			this.catDeque.offerLast((Cat) animal);
		} else if (animal instanceof Dog) {
			this.dogDeque.offerLast((Dog) animal);
		} else {
			System.out.println("Sorry, we cannot hold " + animal.getClass().getSimpleName());
		}
	}
	
	public Dog dequeueDog() {
		return this.dogDeque.pollFirst();
	}
	
	public Cat dequeueCat() {
		return this.catDeque.pollFirst();
	}
	
	public Animal dequeueAny() {
		if (this.dogDeque.isEmpty()) {
			return dequeueCat();
		} else if (this.catDeque.isEmpty()) {
			return dequeueCat();
		} else {
			Dog oldestDog = this.dogDeque.peek();
			Cat oldestCat = this.catDeque.peek();
			
			return getOldest(oldestDog, oldestCat);
		}
	}

	private Animal getOldest(Animal ... animals) {
		Arrays.sort(animals, new Comparator<Animal>() {

			@Override
			public int compare(Animal o1, Animal o2) {
				return o1.getOrder().compareTo(o2.getOrder());
			}
		});
		
		return animals[0];
	}
}
