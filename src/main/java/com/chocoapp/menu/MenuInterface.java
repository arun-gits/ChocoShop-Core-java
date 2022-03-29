package com.chocoapp.menu;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MenuInterface {
	static Scanner sc=new Scanner(System.in);
	private static Logger log=LogManager.getLogger(MenuInterface.class);
		public static int Menu() {
			int option=0;
			String choice=null;
		log.info("1. Show all chocolates");
		log.info("2. Buy chocolates");
		log.info("3. Transaction Details");
		log.info("4. Contact us");
		log.info("5. Back");
		log.info("6. Logout");
		log.info("7. Exit");
		log.info("Enter your choice:");
		choice=sc.nextLine();
		option=choiceCheck(choice);
		while(option==0) {
			System.err.println("Invalid choice !");
			log.warn("Enter valid choice:");
			choice=sc.nextLine();
			option=choiceCheck(choice);
		}
		return option;
		}
		public static int choiceCheck(String choice) {
			int opt=0;
			if(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")||choice.equals("5")||choice.equals("6")||choice.equals("7") ){
				opt=Integer.parseInt(choice);
				return opt;
			}
			else {
				return opt;
			}

		}
}