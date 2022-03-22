package com.chocoapp.menu;
import java.util.Scanner;

public class MenuInterface {
	static Scanner sc=new Scanner(System.in);
		public static int Menu() {
			int option=0;
			String choice=null;
		System.out.println("1. Show all chocolates");
		System.out.println("2. Buy chocolates");
		System.out.println("3. Transaction Details");
		System.out.println("4. Contact us");
		System.out.println("5. Back");
		System.out.println("6. Logout");
		System.out.println("7. Exit");
		System.out.println("Enter your choice:");
		choice=sc.nextLine();
		option=choiceCheck(choice);
		while(option==0) {
			System.err.println("Invalid choice !");
			System.out.println("Enter valid choice:");
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