package com.chocoapp.menu;


import java.util.Scanner;
import com.chocoapp.Home;


public class ShowAllChocolates {
	static Scanner sc=new Scanner(System.in);
public static void chocolatesList() throws Exception {
	DisplayCandies.showAll();
	int choice=0;
	System.out.println("1. Buy chocolates");
	System.out.println("2. Sort by");
	System.out.println("3. Back");
	System.out.println("4. Exit");
	System.out.println("Enter your choice");
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
			System.out.println("Thanks for shopping ! :)");
			System.exit(0);
			break;
		default:
			Home.HomePage();
	}
}
}
