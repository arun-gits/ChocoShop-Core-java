package com.chocoapp.menu;

import com.chocoapp.Home;
import com.chocoapp.Menu;
import com.chocoapp.signup.SessionID;
import com.chocoapp.sqlconnection.CandyDAO;
import java.util.Scanner;
import java.sql.ResultSet;


public class Transaction {
	static Scanner sc=new Scanner(System.in);
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
		System.out.println("\n");
		while(details.next()) {
			choconame=details.getString("name");
			price=details.getInt("price");
			purchased_on=details.getString("purchased_on");
			System.out.println(choconame+"===>"+price+" purchased on "+purchased_on);
			total+=price;
		}
		if(choconame==null) {
			System.err.println("No records found");
			System.out.println("Enter 1 to main menu");
			int b=sc.nextInt();
			if(b==1) {
				Menu.List();
			}
			else {
				System.out.println("Wrong input! :(\nRefresh the page");
				System.exit(0);
			}
		}
		else {
			for(int i=0;i<50;i++) {
				System.out.printf("=");
			}
			System.out.println("\n");
		System.out.println("Total Price===>"+total);
		System.out.println("1. Back");
		System.out.println("2. Exit");
		System.out.println("Enter option:");
		int a=sc.nextInt();	
		switch(a) {
			case 1:
				Menu.List();
				break;
			case 2:
				System.out.println("Thanks for shopping ! :)");
				System.exit(0);
				break;
			default:
				Home.HomePage();
		}
	}
	
}
}