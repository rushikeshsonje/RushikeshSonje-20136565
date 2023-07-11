package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Student() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("sid"));
        String name = request.getParameter("sname");
        int phone = Integer.parseInt(request.getParameter("phone"));
        int marks = Integer.parseInt(request.getParameter("marks"));
        String branch = request.getParameter("branch");


        PrintWriter out = response.getWriter();

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/igt", "root", "Rushikesh@97");

            PreparedStatement p = con.prepareStatement("insert into student values(?, ?, ?, ?, ?)");

            p.setInt(1, id);
            p.setString(2, name);
            p.setInt(3, phone);
            p.setInt(4, marks);
            p.setString(5, branch);

            p.execute();
//            p.close();

            out.print("<h1>");
            out.print("Congrats you are successfully registered");
            out.print("</h1>");
            RequestDispatcher rd = request.getRequestDispatcher("Student.html");
    		rd.include(request, response);
        } catch(Exception e) {

            System.out.println(e);
        } 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

