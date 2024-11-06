package com.example;

public class PetMain {

	public static void main(String[] args) {
		Animal[] animals = new Animal[3];
		
		animals[0] = new Spider();
		animals[1] = new Cat("加菲");
		animals[2] = new Fish();
		
		for(Animal a : animals) {
			a.eat();
			a.walk();
			playWithAnimal(a);
			System.out.println();
		}
		
	}
	
	public static void playWithAnimal(Animal a) {
		if (a instanceof Pet) {
			((Pet) a).play();
		} else {
			System.out.println("非寵物!");
		}
	}

}
