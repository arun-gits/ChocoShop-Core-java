package com.chocoapp.menu;


import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chocoapp.Home;


public class ShowAllChocolates {
	static Scanner sc=new Scanner(System.in);
	private static Logger log=LogManager.getLogger(ShowAllChocolates.class);
public static void chocolatesList() throws Exception {
	DisplayCandies.showAll();
	int choice=0;
	log.info("1. Buy chocolates");
	log.info("2. Sort by");
	log.info("3. Back");
	log.info("4. Exit");
	log.info("Enter your choice");
	choice=sc.nextInt();
	switch(choice) {
		case 1:
			BuyCandies.addMoreCandies();
			break;
		case 2:
			DisplayCandies.filterShow();
			break;
		case 3:
			MenuInterface.Menu();
		case 4:
			log.info("Thanks for shopping ! :)");
			System.exit(0);
			break;
		default:
			Home.HomePage();
	}
}
}
