package com.chocoapp.menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.chocoapp.sqlconnection.CandyDAO;

public class BuyCandies {
	static Scanner sc=new Scanner(System.in);
	public static List<Integer> chocoids=new ArrayList<Integer>();
	public static void addCandy() throws Exception {
	
		DisplayCandies.fullShow();
		addMoreCandies();
	}
	public static void addMoreCandies() throws Exception {
		System.out.println("Select the choco_list you want with chocoid one at a time");
		int chocoid=0,choice=0;
		chocoid=sc.nextInt();
		chocoids.add(chocoid);
		System.out.println("1. Add more chocolates");
		System.out.println("2. Continue to payment");
		choice=sc.nextInt();
		
		if(choice==1)
		{
			addMoreCandies();
//			System.out.println("Enter chocolate:");
		}
		else if(choice==2)
		{
			System.out.println("Chocolates Added");
			CandyDAO.totalPrice(chocoids);
			Payment.PayMode();
			CandyDAO.BuyCandies(chocoids);
		}
		else {
			System.out.println("Sorry, wrong input!\nRefresh the page.");
			System.exit(0);
		}
	}

	}
