package com.pankaj.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pankaj.bussines.verification;
import com.pankaj.entity.user;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		user user = new user(request.getParameter("userName"),request.getParameter("passWord"));
		
		verification verify = new verification();
		int status = verify.verifyUser(user);
		
		// status == 0 - match user + pass - login successful
	    // status == 1 - match user & forget pass - reset pass
		// status == 2 - Invalid user 
		
		PrintWriter out = response.getWriter();
		
		if(status==0)
		{
			out.println(" Home page ");
		} else if(status==1)
		{
			out.println(" Incorrect passWord ");
		} else if(status==2)
		{

			out.println("<a href='registration.html'>Invalid_User_Create_Account</a>");
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
