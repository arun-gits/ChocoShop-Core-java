package com.chocoapp.sqlconnection;

import java.sql.ResultSet;
import com.chocoapp.signup.RegisterIn;
import com.chocoapp.signup.SessionID;

public class SigningDAO  {
	
	public static void addUser(RegisterIn add) throws Exception {
		
	String query="insert into choco_users (name,mobile,email,password)values('"+ add.name +"','"+add.number+"','"+RegisterIn.getmail()+"','"+RegisterIn.getpassword()+"')";
	System.out.println("Processing....");
	ConnectSQL.sqlConnect(query);
	System.out.println("You are added as our new user");

	}
	public static ResultSet signingDataCheck(String mail) throws Exception {
		String query="SELECT userid,email,password FROM choco_users WHERE email='"+mail+"'";
		System.out.println("Processing....");
		ResultSet check=ConnectSQL.javaConnect(query);
		return check;
	}
	public static void sessionId(String mail) throws Exception{
		int id=0;
		String query="Select userid from choco_users where email='"+mail+"'";
		System.out.println("Processing....");
		ResultSet check=ConnectSQL.javaConnect(query);
		while(check.next()) {
			id=check.getInt("userid");
		}
		SessionID.setUserid(id);
	}
}
