package com.example;

import com.example.domain.*;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Employee[] emps = new Employee[5];
		
		emps[0] = new Admin("Amy", "A123456789", 45000, 120, Branch.London);
		emps[1] = new Engineer("Hans", "F123456789", 50000, Branch.Paris);
		emps[2] = new Admin("Yu", "H123456789", 65000, 160, Branch.Taipei);
		emps[3] = new Manager("Lilian", "G123456789", 75000, "Sales", Branch.Tokyo);
		emps[4] = new Director("Echo", "Y123456789", 70000, "Marketing", 1000000, Branch.London);
		
		for (int i=0 ; i<emps.length ; i++) {
			System.out.println(emps[i]);
		}
		
		System.out.println("Hans 學會了新技能!");
		((Engineer)emps[1]).addskills("Java");
		((Engineer)emps[1]).addskills("Android");
		emps[1].raiseSalary(20000);
		
		System.out.println("======部門分配======");
		if (emps[3] instanceof Manager) {
			Manager m1 = (Manager)emps[3];
			m1.addEmployee(emps[0]);
			m1.addEmployee(emps[1]);
			m1.addEmployee(emps[2]);
		}
		
		((Manager)emps[4]).addEmployee(emps[3]);
		
		for (int i=0 ; i<emps.length ; i++) {
			System.out.println(emps[i]);
			System.out.println(emps[i].getName()+"本月薪資: " + emps[i].getBranch().getCurrency() +emps[i].getPay()+"元");
			if (emps[i] instanceof RegularStaff) {
				System.out.println("Bouns: " + emps[i].getBranch().getCurrency() + ((RegularStaff) emps[i]).getBonus());
				System.out.println("尾牙摸彩: " + RegularStaff.getLuckDraw());
			}
		}

	}
}
