package com.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	
	FileInputStream fis= null;
	Properties p=null;
	Connection con = null;
	PreparedStatement pst = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		//collecting the parameters from form
		String name = request.getParameter("name");	
		String email = request.getParameter("email");
		String agestud = request.getParameter("age");
		int age =Integer.parseInt(agestud);
		System.out.println(email+" "+name + " " +age);

		

		try {
			
			//load the properties from properties file using file input stream
			fis =new FileInputStream("C:\\Users\\91974\\OneDrive\\Desktop\\tap assignment\\Crud_form\\src\\main\\java\\com\\servlet\\utilities\\dbdetails.properties");
			p= new Properties();
			p.load(fis);
			String url= p.getProperty("url");
			String username=p.getProperty("un");
			String password= p.getProperty("pass");
			
			// Load the JDBC driver
			System.out.println("hello");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded");

			// Establish connection
			con = DriverManager.getConnection(url, username, password);
			System.out.println("connected");
			System.out.println("line 47 in addposthand.jsp");

			// Insert the into database
			String query1 = "INSERT INTO students (`name`, `email`, `age`) VALUES (?,?, ?)";
			System.out.println("line 60 in CreateServlet.java");
			pst = con.prepareStatement(query1);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setInt(3, age);
			int result = pst.executeUpdate();
			System.out.println("the result in CreateServlet.java   " + result);
			
			
			//if result is >0 request is forworded to readservlet
			if (result >0) {
				request.getRequestDispatcher("/ReadServlet").forward(request, response);
			}
			
			
			//else it is forworded to indexpage
			else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
	
		}
		
		//if any exception is cought it is stack traced
		 catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (pst != null)
					try {
				pst.close();
					} catch (SQLException ignore) {
					}
				if (con != null)
					try {
				con.close();
					} catch (SQLException ignore) {
					}
			}
	}
}
