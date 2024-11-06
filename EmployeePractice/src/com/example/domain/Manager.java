package com.example.domain;

import java.util.ArrayList;

public class Manager extends Employee implements RegularStaff{
	protected ArrayList employees;

	private String deptName;
	
	private double baseBonus = 100000;

	public Manager(String name, String ssn, double salary, String dept, Branch branch) {
		super(name, ssn, salary, branch);
		deptName = dept;
		employees = new ArrayList();
	}

	public String getDeptName() {
		return deptName;
	}

	public String getStaffDetails() {
		StringBuilder sb = new StringBuilder();
		if (employees.size() > 0) {
		    sb.append(getName() + "管理員工");
			for (Object obj : employees) {
				if (obj instanceof Employee) {
					Employee e = (Employee) obj;
					sb.append(String.format(" %s(%d)", e.getName(), e.getEmpId()));
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return super.toString() + "管理部門 : "+ deptName + "\n" + this.getStaffDetails();
	}

	public boolean addEmployee(Employee e) {
		if (employees.contains(e)) {
			return false;
		} else {
			employees.add(e);
			return true;
		}
	}

	public boolean removeEmployee(Employee e) {
		if (!employees.contains(e)) {
			return false;
		} else {
			employees.remove(e);
			return true;
		}
	}

	@Override
	public double getPay() {
		return this.getSalary() + employees.size() * 2000;
	}

	@Override
	public double getBonus() {
		return baseBonus * calcPerMultiplier();
	}
	
	

}
