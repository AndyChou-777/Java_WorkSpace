package com.example.domain;

public class Admin extends Employee {
	
	private int hours;

	public Admin(String name, String ssn, double salary, int hours, Branch branch) {
		super(name, ssn, salary, branch);
		this.hours = hours;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPay() {
		// TODO Auto-generated method stub
		return this.getSalary()/160*hours;
	}
	
	

}
