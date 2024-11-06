package com.example.domain;

public class Director extends Manager {
	
	private double budget;
	
	private double baseBonus = 500000;

	public Director(String name, String ssn, double salary, String dept, double budget, Branch branch) {
		super(name, ssn, salary, dept, branch);
		this.budget = budget;
		// TODO Auto-generated constructor stub
	}

	public double getBudget() {
		return budget;
	}

	@Override
	public String toString() {
		return super.toString() + "管理預算: " + this.getBranch().getCurrency() + formatter.format(this.budget) + "\n";
	}
	
	@Override
	public double getPay() {
		return this.getSalary() + this.employees.size() * 10000;
	}
	
	@Override
	public double getBonus() {
		return baseBonus * calcPerMultiplier();
	}

}
