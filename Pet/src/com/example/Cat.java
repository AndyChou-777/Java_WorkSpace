package com.example;

public class Cat extends Animal implements Pet{

	private String name;
	
	public Cat() {
		super(4);
	}
	
	public Cat(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void eat() {
		if(name!=null && name.length()!=0)
			System.out.println(name+"最喜歡吃魚");
		else
			System.out.println("貓最喜歡吃魚");			
	}

	@Override
	public void play() {
		System.out.println("抓貓板!");
	}

}
