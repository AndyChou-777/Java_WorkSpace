package com.example;

import java.sql.*;
import java.util.Date;

public class MyTransactionExample {

	public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/EmployeeDB";
        String username = "root";
        String password = "abc123";
        try (Connection con = DriverManager.getConnection(url, username, password);
                Statement stmt = con.createStatement()){
               con.setAutoCommit(false);
               stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES (7, 'Sam', 'Li', '1974-03-21', 75000)");
               Savepoint sp = con.setSavepoint();
               stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES (8, 'Sue', 'Hu', '1975-11-26', 50000.00)");            
               con.rollback(sp);
               stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES (9, 'Ivy', 'Lin', '1988-07-24', 48000.00)");
               con.commit(); 
               ResultSet rs = stmt.executeQuery("SELECT * FROM Employee WHERE id < 10");

               while (rs.next()) {
                   int empID = rs.getInt("ID");
                   String first = rs.getString("FirstName");
                   String last = rs.getString("LastName");
                   Date birthDate = rs.getDate("BirthDate");
                   float salary = rs.getFloat("Salary");
                   System.out.printf("Employee ID: %d%nEmployee Name: %s %s%n", empID, first, last);
                   System.out.printf("Birth Date: %tF%nSalary: %f%n%n", birthDate, salary); 
               }
               con.commit();
               rs.close();
           } catch (SQLException ex) {
               System.out.println(ex);
           }
       }
   }

