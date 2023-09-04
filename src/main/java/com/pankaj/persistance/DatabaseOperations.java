package com.pankaj.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pankaj.entity.user;

public class DatabaseOperations {
	
	public boolean verifyNewUser(user user) throws SQLException, ClassNotFoundException
	{   
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginProject","root","Vinayaksir@2022");
		
	    Statement stmt  = con.createStatement(); 
	    
	    String query = "select username from login";
	    
	    ResultSet rs = stmt.executeQuery(query);
	    
	    boolean var = true;
	    
	    String key = user.getUserName();
	    
	    while(rs.next())
	    {
	    	if(key.equals(rs.getString(1)))
	    	{
	    		var = false;
	    		System.out.println(" var : "+var);
	    	}
	    	System.out.println(" user :"+user.getUserName()+" rs :"+rs.getString(1));
	    }
	    
	    stmt.close();
	    con.close();
	    return var;
       
	}
	public boolean insertData(user user) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginProject","root","Vinayaksir@2022");
		
		String query = "insert into login values(?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassWord());
		
		
		 boolean var = true;
		 var = pstmt.execute();
		
		 pstmt.close();
		 con.close();
		 
		 return var;

	}
	public int verify(user user) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginProject","root","Vinayaksir@2022");
		
		Statement stmt = con.createStatement();
		
		String query = "Select * from login";
		
		
		ResultSet rs = stmt.executeQuery(query);
		
		String userName = user.getUserName();
		String passWord = user.getPassWord();
		int status = -1;
		
		// status == 0 - match user + pass - login successful
		// status == 1 - match user & forget pass - reset pass
		// status == 2 - Invalid user 
		
		if(!verifyNewUser(user))
		  {    		
    			   while(rs.next())
				   {
					   if((userName.equals(rs.getString(1)))&&(passWord.equals(rs.getString(2))))
						{
							status = 0;
						}
				   }
				   
				   if(status==-1)
				   status = 1;
		  } else {
			  status = 2;
		  }
		
		stmt.close();
		con.close();
		return status;
	}
	
	

}
