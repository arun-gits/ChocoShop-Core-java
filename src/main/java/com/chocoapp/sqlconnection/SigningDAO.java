package com.chocoapp.sqlconnection;

import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chocoapp.signup.RegisterIn;
import com.chocoapp.signup.SessionID;

public class SigningDAO  {
	private static Logger log=LogManager.getLogger(SigningDAO.class);
	public static void addUser(RegisterIn add) throws Exception {
		
	String query="insert into choco_users (name,mobile,email,password)values('"+ add.name +"','"+add.number+"','"+RegisterIn.getmail()+"','"+RegisterIn.getpassword()+"')";
	log.info("Processing....\n");
	ConnectSQL.sqlConnect(query);
	log.info("You are added as our new user");

	}
	public static ResultSet signingDataCheck(String mail) throws Exception {
		String query="SELECT userid,email,password,user_role FROM choco_users WHERE email='"+mail+"'";
		log.info("Processing....\n");
		ResultSet check=ConnectSQL.javaConnect(query);
		return check;
	}
	public static void sessionId(String mail) throws Exception{
		int id=0;
		String query="Select userid from choco_users where email='"+mail+"'";
		log.info("Processing....\n");
		ResultSet check=ConnectSQL.javaConnect(query);
		while(check.next()) {
			id=check.getInt("userid");
		}
		SessionID.setUserid(id);
	}
}
