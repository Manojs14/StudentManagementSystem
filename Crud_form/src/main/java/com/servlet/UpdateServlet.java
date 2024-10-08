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

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileInputStream fis= null;
	Properties p=null;
	Connection con = null;
	PreparedStatement pstmt = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sid = request.getParameter("id"); 
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String sage = request.getParameter("age");
		int id= Integer.parseInt(sid);
		int age= Integer.parseInt(sage);
		System.out.println("the id in updateservlet is "+name+ " "+ email +" "+id+ " "+age);
		
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
			
			
			

			// update the data  into database
			pstmt=con.prepareStatement("Update students set `name`=?,`email`=?,`age`=? where id= ?");
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setInt(3, age);
			pstmt.setInt(4, id);
			
			
			
			//Execute the update into database
			int count=pstmt.executeUpdate();
			System.out.println("the result in addposthand.jsp   " + count);
			request.getRequestDispatcher("/ReadServlet").forward(request, response);
			
			
	
		}
		 catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null)
					try {
				pstmt.close();
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
