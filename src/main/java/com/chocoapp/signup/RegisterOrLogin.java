package com.chocoapp.signup;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chocoapp.Home;
import com.chocoapp.login.Login;
//import com.chocoapp.login.Login;
import com.chocoapp.sqlconnection.SigningDAO;

public class RegisterOrLogin {

	static Scanner sc = new Scanner(System.in);
	private static Logger log=LogManager.getLogger(RegisterOrLogin.class);
public static void userSign(String option) throws Exception{

	if(option.equals("1")) {
		log.info("Enter name:");
		String name = sc.nextLine();
		int ch1=OverallValidation.nameCheck(name);
		while(ch1!=0) {
			name=sc.nextLine();
			ch1=OverallValidation.nameCheck(name);
		}
		
		log.info("Enter mobile number:");
		String number = sc.nextLine();
		int ch2=OverallValidation.numberCheck(number);
		while(ch2!=0) {
			number=sc.nextLine();
			ch2=OverallValidation.numberCheck(number);
		}
		
		log.info("Enter mail:");
		String email = sc.nextLine();
		int chk4=OverallValidation.mailCheck(email);
		while(chk4!=0) {
			email=sc.nextLine();
			chk4=OverallValidation.mailCheck(email);
		}
		RegisterIn.setmail(email);
		
		log.info("Enter password:");
		String password = sc.nextLine();
		int ch3=OverallValidation.passwordCheck(password);
		while(ch3!=0) {
			password=sc.nextLine();
			ch3=OverallValidation.passwordCheck(password);
		}
		OverallValidation.signupCheck(SigningDAO.signingDataCheck(email));
		
	RegisterIn add=new RegisterIn(name,number,password,email);
	SigningDAO.addUser(add);
	log.info("Hello " + name + "!\nWelcome to chocolate shop");
//	SessionID.setEmail(add.getmail());
	Home.HomePage();
//	log.info("mail is:"+SessionID.getEmail());
	}

	else if(option.equals("2")){
		Login.loginUser();
	}
	else if(option.equals("3")){
		log.info("Thanks for shopping ! :)");
		System.exit(0);
	}
	else {
	log.warn("Enter valid input");
	String opt=sc.nextLine();
	userSign(opt);
	}
	}

}

