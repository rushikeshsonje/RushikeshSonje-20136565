package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/igt", "root", "Rushikesh@97");
		Statement statement = con.createStatement();

        // Execute a query to retrieve employee details
        String query = "SELECT * FROM employee2";
        ResultSet ResultSet = statement.executeQuery(query);

         // Iterate through the result set and print employee details
         while (ResultSet.next()) {
             int id = ResultSet.getInt("id");
             String name = ResultSet.getString("name");
             int age = ResultSet.getInt("age");
             int salary = ResultSet.getInt("salary");
             String design = ResultSet.getString("design");


             System.out.println("Employee ID: " + id);
             System.out.println("First Name: " + name);
             System.out.println("Last Name: " + age);
             System.out.println("Email: " + salary);
             System.out.println("Email: " + design);
             System.out.println("--------------------");
			
		}
		
		} catch (Exception e) {
			
		}
		
	}

}
