package com.example.dao;

import java.util.*;

import com.example.model.Employee;

public class EmployeeDAOMapImpl implements EmployeeDAO {

	private SortedMap<Integer, Employee> employees = new TreeMap<>();

	@Override
	public void close() {
		System.out.println("資源關閉!");
	}

	@Override
	public void add(Employee emp) throws DAOException {
		int id = emp.getId();
		if (employees.containsKey(id)) {
			throw new DAOException("該員工編號已存在，新增失敗!");
		} else {
			employees.put(id, emp);
		}
	}

	@Override
	public void update(Employee emp) throws DAOException {
		int id = emp.getId();
		if (employees.containsKey(id)) {
			employees.put(id, emp);
		} else {
			throw new DAOException("該員工編號不存在，修改失敗!");
		}
	}

	@Override
	public void delete(int id) throws DAOException {
		if (employees.containsKey(id)) {
			employees.remove(id);
		} else {
			throw new DAOException("此員工編號不存在，無法刪除!");
		}
	}

	@Override
	public Employee findById(int id) throws DAOException {
		Employee emp = employees.get(id);
		if (emp == null) {
			throw new DAOException("該員工不存在，無法查詢");
		} else {
			return emp;
		}
	}

	@Override
	public Employee[] getAllEmployees() throws DAOException {
		return employees.values().toArray(new Employee[0]);
	}

}
