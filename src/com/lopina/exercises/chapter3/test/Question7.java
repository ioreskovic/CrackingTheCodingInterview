package com.lopina.exercises.chapter3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lopina.exercises.chapter3.Animal;
import com.lopina.exercises.chapter3.AnimalShelterAdoptionQueue;
import com.lopina.exercises.chapter3.Cat;
import com.lopina.exercises.chapter3.Dog;

public class Question7 {

	@Test
	public void shouldReturnNullWhenShelterIsEmpty() {
		AnimalShelterAdoptionQueue<Animal> queue = new AnimalShelterAdoptionQueue<Animal>();
		
		Animal animal = queue.dequeueAny();
		Dog dog = queue.dequeueDog();
		Cat cat = queue.dequeueCat();
		
		assertNull(animal);
		assertNull(dog);
		assertNull(cat);
	}
	
	@Test
	public void shouldReturnOnlyCatsWhenThereAreNoDogs() {
		AnimalShelterAdoptionQueue<Animal> queue = new AnimalShelterAdoptionQueue<Animal>();
		
		queue.enqueue(new Cat("Cat1"));
		queue.enqueue(new Cat("Cat2"));
		queue.enqueue(new Cat("Cat3"));
		queue.enqueue(new Cat("Cat4"));
		queue.enqueue(new Cat("Cat5"));
		queue.enqueue(new Cat("Cat6"));
		queue.enqueue(new Cat("Cat7"));
		
		Dog dog = queue.dequeueDog();
		assertNull(dog);
		
		Animal animal = queue.dequeueAny();
		assertNotNull(animal);
		assertEquals(Cat.class, animal.getClass());
		assertEquals("Cat1", animal.getName());
		
		Cat cat = queue.dequeueCat();
		assertNotNull(cat);
		assertEquals("Cat2", cat.getName());
	}

}
