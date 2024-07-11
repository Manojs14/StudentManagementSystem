package com.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Handle GET requests
	        processRequest(request, response);
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Handle POST requests
	        processRequest(request, response);
	    }
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileInputStream fis= null;
		Properties p=null;
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		
		//usage of array list to add the details retrieve from database and forward it to list.jsp to diaplay in the form of table
		ArrayList<UserData> userDataList = new ArrayList<>();
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
			stmt=con.createStatement();
			rs= stmt.executeQuery("select * from students");
			
			
			while(rs.next()){
				//retrieving data from data base 
					int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String email = rs.getString("email");
	                int age = rs.getInt("age");
	                
	                 
			        UserData userData = new UserData(id, name, email, age);
			        //adding these object to the userdatalist
	                userDataList.add(userData);
			}
			System.out.println("last line read servlet");
			//setting userdatalist to request attribute
			request.setAttribute("data", userDataList);
			
			//forwading the request to list.jsp for displaying
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
		}catch (Exception e) {
		    e.printStackTrace();
		}finally {
			if (rs != null)
				try {
			rs.close();
				} catch (SQLException ignore) {
				}
			if (stmt != null)
				try {
			stmt.close();
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
