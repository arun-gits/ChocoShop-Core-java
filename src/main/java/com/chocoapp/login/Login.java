package com.chocoapp.login;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chocoapp.Home;
import com.chocoapp.signup.RegisterIn;
import com.chocoapp.signup.OverallValidation;
import com.chocoapp.sqlconnection.SigningDAO;
public class Login {
	static Scanner sc=new Scanner(System.in);
	private static Logger log=LogManager.getLogger(Login.class);
	public static void loginUser() throws Exception {
		//String email,String password
		log.info("Enter your email");
		String email=sc.nextLine();
		int chk4=OverallValidation.mailCheck(email);
		while(chk4!=0) {
			email=sc.nextLine();
			chk4=OverallValidation.mailCheck(email);
		}
		RegisterIn.setmail(email);
		log.info("Enter your password:");
		String password=sc.nextLine();
		int ch3=OverallValidation.passwordCheck(password);
		while(ch3!=0) {
			password=sc.nextLine();
			ch3=OverallValidation.passwordCheck(password);
		}
		RegisterIn.setPassword(password);
		try {
			OverallValidation.loginCheck(SigningDAO.signingDataCheck(RegisterIn.getmail()), RegisterIn.getpassword());
		} 
		catch (Exception e) {
			log.warn(e.getMessage());
			//e.printStackTrace();
			Home.HomePage();
		}
		
		
}
	
}
