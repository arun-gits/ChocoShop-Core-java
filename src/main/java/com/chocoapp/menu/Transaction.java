package com.chocoapp.menu;

import com.chocoapp.Home;
import com.chocoapp.Menu;
import com.chocoapp.signup.SessionID;
import com.chocoapp.sqlconnection.CandyDAO;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;


public class Transaction {
	static Scanner sc=new Scanner(System.in);
	private static Logger log=LogManager.getLogger(Transaction.class);
	public static void transDetails() throws Exception {
		int id=SessionID.getUserid();
		String choconame=null;
		String purchased_on=null;
		int price=0;
		int total=0;
		ResultSet details=CandyDAO.transDetails(id);
		for(int i=0;i<50;i++) {
			System.out.printf("=");
		}
		log.info("\n");
		while(details.next()) {
			choconame=details.getString("name");
			price=details.getInt("price");
			purchased_on=details.getString("purchased_on");
			log.info(choconame+"===>"+price+" purchased on "+purchased_on);
			total+=price;
		}
		if(choconame==null) {
			log.warn("No records found");
			log.info("Enter 1 to main menu");
			int b=sc.nextInt();
			if(b==1) {
				Menu.List();
			}
			else {
				log.warn("Wrong input! :(\nRefresh the page");
				System.exit(0);
			}
		}
		else {
			for(int i=0;i<50;i++) {
				System.out.printf("=");
			}
			log.info("\n");
		log.info("Total Price===>"+total);
		log.info("1. Back");
		log.info("2. Exit");
		log.info("Enter option:");
		int a=sc.nextInt();	
		switch(a) {
			case 1:
				Menu.List();
				break;
			case 2:
				log.info("Thanks for shopping ! :)");
				System.exit(0);
				break;
			default:
				Home.HomePage();
		}
	}
	
}
}