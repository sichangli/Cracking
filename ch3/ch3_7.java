import java.util.*;

public class ch3_7 {

}

class Animal {
	private int order;
	private String name;

	public Animal(String _name) {
		name = _name;
	}

	public void setOrder(int o) {
		order = o;
	}

	public int getOrder() {
		return order;
	}

	public boolean isOlderThan(Animal a) {
		return order < a.order;
	}
}

class Cat extends Animal {
	public Cat(String _name) {
		super(_name);
	}

}

class Dog extends Animal {
	public Dog(String _name) {
		super(_name);
	}

}

class MyQueue {
	private LinkedList<Cat> cats;
	private LinkedList<Dog> dogs;
	private int order;

	public MyQueue() {
		cats = new LinkedList<Cat>();
		dogs = new LinkedList<Dog>();
	}

	public void enqueue(Animal a) {
		a.setOrder(order++);
		if (a instanceof Cat) {
			cats.add((Cat) a);
		} else {
			dogs.add((Dog) a);
		}
	}

	public Animal dequeueAny() {
		if (cats.isEmpty() && dogs.isEmpty()) {
			return null;
		} else if (cats.isEmpty()) {
			return dequeueDog();
		} else if (dogs.isEmpty()) {
			return dequeueCat();
		} else {
			if (cats.peek().isOlderThan(dogs.peek())) {
				return dequeueCat();
			} else {
				return dequeueDog();
			}
		}
	}

	public Cat dequeueCat() {
		return cats.pollFirst();
	}

	public Dog dequeueDog() {
		return dogs.pollFirst();
	}
}