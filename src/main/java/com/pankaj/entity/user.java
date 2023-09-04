package com.pankaj.entity;

public class user {
	
	String userName;
	String passWord;
	
	public user()
	{
		
	}

	public user(String userName, String passWord) {
		
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	

}
