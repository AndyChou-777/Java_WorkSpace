package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Employee;

public class EmployeeDAOMemoryImpl implements EmployeeDAO {

	private Employee[] employeeArray = new Employee[10];

	@Override
	public void add(Employee emp) throws DAOException {
		int id = emp.getId();
		try {
			if (employeeArray[id] != null) {
				throw new DAOException("員工編號已存在，新增失敗!");

			} else {
				employeeArray[id] = emp;
			}
		} catch (ArrayIndexOutOfBoundsException ae) {
			throw new DAOException("員工編號不得高於 10 ，新增失敗!", ae);
		}

	}

	@Override
	public void close() {
		System.out.println("資源關閉!");
	}

	@Override
	public void update(Employee emp) throws DAOException {
		int id = emp.getId();
		try {
			if (employeeArray[id] == null) {
				throw new DAOException("該員工編號不存在，修改失敗!");
			} else {
				employeeArray[id] = emp;
			}
		} catch (ArrayIndexOutOfBoundsException ae) {
			throw new DAOException("員工編號不得高於 10 ，修改失敗!", ae);
		}
	}

	@Override
	public void delete(int id) throws DAOException {
		try {
			if (employeeArray[id] == null) {
				throw new DAOException("此員工編號不存在，無法刪除!");
			} else {
				employeeArray[id] = null;
			}
		} catch (ArrayIndexOutOfBoundsException ae) {
			throw new DAOException("員工編號不得高於 10 ，刪除失敗!", ae);
		}

	}

	@Override
	public Employee findById(int id) throws DAOException {
		try {
			return employeeArray[id];
		} catch (ArrayIndexOutOfBoundsException ae) {
			throw new DAOException("員工編號不得高於 10 ，尋找失敗!", ae);
		}
	}

	// Return an array of all of the Employee records
	// We are using a collection List object to store the results
	// This makes it easier to just add to the collection
	@Override
	public Employee[] getAllEmployees() {
		List<Employee> emps = new ArrayList<>();
		// Iterate through the memory array and find Employee objects
		for (Employee e : employeeArray) {
			if (e != null) {
				emps.add(e);
			}
		}
		return emps.toArray(new Employee[0]);
	}

}
