package chp03_StacksAndQueues;

import java.util.LinkedList;

public class Shelter {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int index = 0;
	
	public void enqueue(Animal a) {
		a.setIndex(++index);
		
		if(a instanceof Dog)
			dogs.add((Dog)a);
		else if(a instanceof Cat)
			cats.add((Cat)a);
	}
	
	public Animal dequeue() {
		if(dogs.peek().isOlderThan(cats.peek()))
			return dogs.poll();
		else return cats.poll();
	}
	
	public Animal dequeueCat() {
		return cats.poll();
	}
	
	public Animal dequeueDog() {
		return dogs.poll();
	}
}

class Animal {
	String name;
	int index;
	
	public Animal (String name) {
		this.name = name;
	}
	
	public boolean isOlderThan(Animal a) {
		return this.index < a.index;
	}
	
	public void setIndex(int i) {
		index = i;
	}
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}	
}

class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
}