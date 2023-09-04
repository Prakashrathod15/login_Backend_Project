package com.pankaj.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pankaj.bussines.verification;
import com.pankaj.entity.user;

/**
 * Servlet implementation class newUserServlet
 */
@WebServlet("/newUserServlet")
public class newUserServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		user user = new user(request.getParameter("userName"),request.getParameter("passWord"));
		
		PrintWriter out = response.getWriter();
		verification newUser = new verification();
	    
	   verification var = new verification();
	    
	    boolean key = var.newUserVerification(user);
	    
	    if(key==true)
	    {
	    	out.println("<h1> Your accout Successfully created </h1><a href='login.html' target='_blank'> please_login_here </a>");
	    }else
	    {       
	    	out.println("<a href='login.html' target='_blank'>User_Alreday_Have_Account_click_to_login</a>");
	    }
				
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
