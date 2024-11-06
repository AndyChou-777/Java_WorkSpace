package com.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Employee;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {

	private Connection con;

	public EmployeeDAOJDBCImpl() {
		String url = "jdbc:mysql://localhost:3306/employeedb";
		String username = "root";
		String password = "andy1998227";
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("資料庫連線失敗!" + e.getMessage());
			System.exit(0);
		}
	}

	@Override
	public void close() throws Exception {
		if (con != null && !con.isClosed()) {
			try {
				con.close();
			} catch (SQLException e) {
				throw new Exception("關閉資料庫時發生錯誤!" + e.getMessage());
			}
		}
	}

	@Override
	public void add(Employee emp) throws DAOException {
		String sql = "insert into employee values (?,?,?,?,?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setDate(4, new java.sql.Date(emp.getBirthDate().getTime()));
			pstmt.setFloat(5, emp.getSalary());

			if (pstmt.executeUpdate() != 1) {
				System.out.println("員工新增失敗!");
			}
		} catch (SQLException e) {
			throw new DAOException("資料庫發生錯誤!" + e.getMessage());
		}

	}

	@Override
	public void update(Employee emp) throws DAOException {
		String sql = "update employee set FirstName=?, LastName=?, BirthDate=?, Salary=? where id=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, emp.getFirstName());
			pstmt.setString(2, emp.getLastName());
			pstmt.setDate(3, new java.sql.Date(emp.getBirthDate().getTime()));
			pstmt.setFloat(4, emp.getSalary());
			pstmt.setInt(5, emp.getId());

			if (pstmt.executeUpdate() != 1) {
				System.out.println("員工更新失敗!");
			}
		} catch (Exception e) {
			throw new DAOException("資料庫發生錯誤!" + e.getMessage());
		}
	}

	@Override
	public void delete(int id) throws DAOException {
		String sql = "delete from employee where id=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);

			if (pstmt.executeUpdate() != 1) {
				System.out.println("刪除員工失敗!");
			}
		} catch (Exception e) {
			throw new DAOException("資料庫發生錯誤!" + e.getMessage());
		}
	}

	@Override
	public Employee findById(int id) throws DAOException {
		String sql = "select * from employee where id=?";
		Employee emp = null;
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					String fn = rs.getString("firstname");
					String ln = rs.getString("lastname");
					Date bd = rs.getDate("BirthDate");
					Float s = rs.getFloat("Salary");
					emp = new Employee(id, fn, ln, bd, s);
				}
			}
		} catch (Exception e) {
			throw new DAOException("資料庫發生錯誤!" + e.getMessage());
		}
		return emp;
	}

	@Override
	public Employee[] getAllEmployees() throws DAOException {
		String sql = "select * from employee";
		ArrayList<Employee> list = new ArrayList<>();
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String fn = rs.getString("FirstName");
				String ln = rs.getString("LastName");
				Date bd = rs.getDate("BirthDate");
				Float s = rs.getFloat("Salary");
				list.add(new Employee(id, fn, ln, bd, s));
			}
		} catch (Exception e) {
			throw new DAOException("資料庫發生錯誤!" + e.getMessage());
		}
		return list.toArray(new Employee[0]);
	}

}
