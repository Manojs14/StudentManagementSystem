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



@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileInputStream fis= null;
	Properties p=null;
	Connection con = null;
	PreparedStatement pstmt = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests
        processRequest(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests
        processRequest(request, response);
    }

protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String sid = request.getParameter("id"); 
		System.out.println("the id is "+sid);
		int id= Integer.parseInt(sid);
	
		

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
			System.out.println("line 49 ");
			
			//deleting the data whose id = ?(the id will be retrieved from the request parameter) 
			pstmt =con.prepareStatement("delete  from students where id = ?");
			pstmt.setInt(1, id);
			int rs=pstmt.executeUpdate();
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
