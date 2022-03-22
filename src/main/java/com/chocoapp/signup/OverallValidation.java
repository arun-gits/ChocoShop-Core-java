package com.chocoapp.signup;
import java.util.Scanner;

import com.chocoapp.Home;

import java.sql.ResultSet;

public class OverallValidation {
	static Scanner sc=new Scanner(System.in);
//	RegisterIn check=new RegisterIn(null, null, null, null);
	// Checking name
	public static int nameCheck(String name) {
		int count=0;
		if(name.isEmpty() || name.isBlank()) {
			System.err.println("Name cannot be empty !");
			System.out.println("Enter valid name:");
			count++;
		}
		return count;
	}

	// Checking number
	public static int numberCheck(String number) {
		int count=0;
		if(number.length()!=10) {
			System.err.println("Invalid number !!!");
			System.out.println("Enter mobile number:");
			return 1;
	}
		else{
			for(int i=0;i<number.length();i++) {
				char ch=number.charAt(i);
				if(!Character.isDigit(ch)) {
					count++;
					System.err.println("Invalid number !!!");
					System.out.println("Enter mobile number:");
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
//			System.err.println("Invalid number !!!");
//			System.out.println("Enter mobile number:");
//			return 1;
//		}
//		else {
//			return 0;
//	}

	// Checks password
	public static int passwordCheck(String password) {
		if (password.isEmpty() || password.isBlank() || password.length() < 8 || password.length() > 16) {
			System.err.println("Password should be minimum 8 characters and maximum 16 characters");
			System.err.println("Invalid Password");
			System.out.println("Enter password:");
			return 1;
		} 
	else
		return 0;
	}

	// Checks mail
	public static int mailCheck(String mail) {
		if (!mail.contains("@") || !mail.contains(".")) {
			System.err.println("Invalid mail");
			System.out.println("Enter email:");
			return 1;
		} else
			return 0;
	}
	public static void loginCheck(ResultSet check,String password) throws Exception {
		String mail=null;
		String key=null;
		int id=0;
		ResultSet data=check;
		while(data.next()) {
			mail=data.getString("email");
			key=data.getString("password");
			id=data.getInt("userid");
		}
		if(mail==null) {
			throw new Exception("You're not a registered user\n Refresh the page");
		}
		else if(key.equals(password)) {
			SessionID.setUserid(id);
			System.out.println("Logging in...\nWelcome :)");
		}
		else
		{
			System.err.println("Invalid Credentials ! :(");
			 System.out.println("New User...? Signup!\nEnter 1 to home");
			 String choice=sc.nextLine();
			 if(choice.equals("1"))
				Home.HomePage();
			 else
				 System.out.println("Sorry, wrong input!\nRefresh the page. :(");
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
			System.out.println("Thank You !");
			
		}
	
	}
}
