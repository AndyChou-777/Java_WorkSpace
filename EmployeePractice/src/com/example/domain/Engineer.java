package com.example.domain;

import java.util.Arrays;

public class Engineer extends Employee implements RegularStaff{
	
	private String[] skills;
	private int skillCount;

	public Engineer(String name, String ssn, double salary, Branch branch) {
		super(name, ssn, salary, branch);
		skills = new String[5];
	}
	
	public void addskills( String skill) {
		if (skillCount < 5) {
			skills[skillCount++] = skill;
		} else {
		    System.out.println("技能已達上限!");
		}
	}

	@Override
	public double getPay() {
		return this.getSalary() + skillCount*3000;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		if (skillCount > 0) {
			sb.append("技能: ");
			for(int i = 0 ; i < skillCount ; i++) {
				sb.append(" "+skills[i]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public double getBonus() {
		return getSalary() * calcPerMultiplier();
	}

}
