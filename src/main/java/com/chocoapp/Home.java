package com.chocoapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import com.chocoapp.signup.RegisterOrLogin;


public class Home {
//	public static Logger log=LogManager.getLogger(Home.class);
	static Scanner sc=new Scanner(System.in);
	private static Logger log=LogManager.getLogger(Home.class);
	public static void HomePage() throws Exception {
		
		
			log.info("1. New User...? Signup!");
			log.info("2. Already a user? Login");
			log.info("3. Exit");
			String choice=sc.next();
			RegisterOrLogin.userSign(choice);
//			CandiesList.addCandies();
//			Connection connect=ConnectSQL.dataLink();
//			connect.close();
		}
	}
