package com.chocoapp;

import java.util.Scanner;

import com.chocoapp.menu.AdminCandiesList;
import com.chocoapp.menu.AdminMenuInterface;

public class AdminMenu {
	static Scanner sc=new Scanner(System.in);
	public static void adminMenu() throws Exception {
		int i=AdminMenuInterface.Menu();
		switch(i) {
		case 1:
			AdminCandiesList.addCandy();
			break;
		case 2:
			//
			break;
//		default:
//			System.out.println("Wrong input\nRefresh the page");
//			System.exit(1);
		
		}
	}
}
