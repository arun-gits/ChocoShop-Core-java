package com.chocoapp.signup;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chocoapp.AdminMenu;
import com.chocoapp.Home;
import com.chocoapp.Menu;

import java.sql.ResultSet;

public class OverallValidation {
	static Scanner sc=new Scanner(System.in);
	private static Logger log=LogManager.getLogger(OverallValidation.class);
//	RegisterIn check=new RegisterIn(null, null, null, null);
	// Checking name
	public static int nameCheck(String name) {
		int count=0;
		if(name.isEmpty() || name.isBlank()) {
			log.warn("Name cannot be empty !");
			log.info("Enter valid name:");
			count++;
		}
		return count;
	}

	// Checking number
	public static int numberCheck(String number) {
		int count=0;
		if(number.length()!=10) {
			log.warn("Invalid number !!!");
			log.info("Enter mobile number:");
			return 1;
	}
		else{
			for(int i=0;i<number.length();i++) {
				char ch=number.charAt(i);
				if(!Character.isDigit(ch)) {
					count++;
					log.warn("Invalid number !!!");
					log.info("Enter mobile number:");
				break;
			}
			}
			return count;
	}
	}
//		if(number.length()==10) {
//			int count=0;
//		for (int i = 0; i < number.length(); i++) {
//			char ch = number.charAt(i);
//			if (!Character.isDigit(ch)) {
//				count++;
//			}
//		if (count!=0) {
//			log.warn("Invalid number !!!");
//			log.info("Enter mobile number:");
//			return 1;
//		}
//		else {
//			return 0;
//	}

	// Checks password
	public static int passwordCheck(String password) {
		if (password.isEmpty() || password.isBlank() || password.length() < 8 || password.length() > 16) {
			log.warn("Password should be minimum 8 characters and maximum 16 characters");
			log.warn("Invalid Password");
			log.info("Enter password:");
			return 1;
		} 
	else
		return 0;
	}

	// Checks mail
	public static int mailCheck(String mail) {
		if (!mail.contains("@") || !mail.contains(".")) {
			log.warn("Invalid mail");
			log.info("Enter email:");
			return 1;
		} else
			return 0;
	}
	public static void loginCheck(ResultSet check,String password) throws Exception {
		String mail=null;
		String key=null;
		String role=null;
		int id=0;
		ResultSet data=check;
		while(data.next()) {
			mail=data.getString("email");
			key=data.getString("password");
			id=data.getInt("userid");
			role=data.getString("user_role");
		}
		if(mail==null) {
			throw new Exception("You're not a registered user\n Refresh the page");
		}
		else if(key.equals(password)) {
			SessionID.setUserid(id);
			log.info("Logging in...\nWelcome :)");
			if(role.equals("admin")) {
				AdminMenu.adminMenu();
			}
			else if(role.equals("user")){
				Menu.List();
			}
		}
		else
		{
			log.warn("Invalid Credentials ! :(");
			 log.info("New User...? Signup!\nEnter 1 to home");
			 String choice=sc.nextLine();
			 if(choice.equals("1"))
				Home.HomePage();
			 else
				 log.warn("Sorry, wrong input!\nRefresh the page. :(");
			 	 System.exit(0);
		}
	}
	public static void signupCheck(ResultSet check)throws Exception{
		String mail=null;
		while(check.next()) {
			mail=check.getString("email");
		}
		if(mail!=null) {
			throw new Exception("Error! You're an existing user :(");
		}
		else {
			log.info("Thank You !");
			
		}
	
	}
}
