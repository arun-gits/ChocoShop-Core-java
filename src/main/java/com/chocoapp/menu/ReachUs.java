package com.chocoapp.menu;
import java.util.Scanner;

import com.chocoapp.Menu;
public class ReachUs {
	static Scanner sc=new Scanner(System.in)
;	@SuppressWarnings("unused")
public static void contactUs() throws Exception {
		System.out.println("Enter your name:");
		String name=sc.next();
		System.out.println("Enter your email:");
		String email=sc.next();
		System.out.println("Message without newline");
		String message=sc.next();
		System.out.println("Thanks, we will reply you soon");
		System.out.println("\n\n");
		System.out.println("Also You can reach us at\n");
		System.out.println("Email us: chocoshop@gmail.com");
		System.out.println("Instagram: chocoshop_kvcet");
		System.out.println("Website: www.chocoshop.com");
		System.out.println("Enter 1 to back");
		int a=sc.nextInt();
		if(a==1) {
			Menu.List();
		}
		else {
			System.out.println("Sorry, wrong input!\nRefresh the page.");
			System.exit(0);
		}
	}
}
