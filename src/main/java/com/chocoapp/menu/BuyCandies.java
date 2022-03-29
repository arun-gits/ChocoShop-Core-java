package com.chocoapp.menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.chocoapp.sqlconnection.CandyDAO;

public class BuyCandies {
	static Scanner sc=new Scanner(System.in);
	private static Logger log=LogManager.getLogger(BuyCandies.class);
	public static List<Integer> chocoids=new ArrayList<Integer>();
	public static void addCandy() throws Exception {
	
		DisplayCandies.fullShow();
		addMoreCandies();
	}
	public static void addMoreCandies() throws Exception {
		log.info("Select the choco_list you want with chocoid one at a time");
		int chocoid=0,choice=0;
		chocoid=sc.nextInt();
		chocoids.add(chocoid);
		log.info("1. Add more chocolates");
		log.info("2. Continue to payment");
		choice=sc.nextInt();
		
		if(choice==1)
		{
			addMoreCandies();
//			log.info("Enter chocolate:");
		}
		else if(choice==2)
		{
			log.info("Chocolates Added");
			CandyDAO.totalPrice(chocoids);
			Payment.PayMode();
			CandyDAO.BuyCandies(chocoids);
		}
		else {
			log.warn("Sorry, wrong input!\nRefresh the page.");
			System.exit(0);
		}
	}

	}
