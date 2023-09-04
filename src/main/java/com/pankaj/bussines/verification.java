package com.pankaj.bussines;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pankaj.entity.user;
import com.pankaj.persistance.DatabaseOperations;



public class verification {
	
	public boolean newUserVerification(user user) 
	{
		DatabaseOperations operation = new DatabaseOperations();
		boolean var = false;
		try {
			var = operation.verifyNewUser(user);
			System.out.println(" var value : "+var);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(var==true)
			try {
				operation.insertData(user);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return var;
	}
	
	public int verifyUser(user user) 
	{
		DatabaseOperations Operation = new DatabaseOperations();
		int status = -2;
		try {
			status = Operation.verify(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	 

}
