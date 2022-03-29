package com.chocoapp.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chocoapp.AdminMenu;

import com.chocoapp.sqlconnection.*;
public class AdminCandiesList {
	static Scanner sc=new Scanner(System.in);
	private static Logger log=LogManager.getLogger(AdminCandiesList.class);
	public static void addCandies() throws Exception{
		Map<String,Integer> choco=new HashMap<String,Integer>();
		choco.put("5 Star mini",5);
		choco.put("5 Star Mega",10);
		choco.put("Crush Candy",20);
		choco.put("Dairy Milk Choco",10);
		choco.put("Dairy Milk Bubble",30);
		choco.put("Dairy Milk Silk",50);
		choco.put("Dairy Milk Love",100);
		choco.put("Gems chota",10);
		choco.put("Gems Big",20);
		choco.put("KitKat Bar",10);
		choco.put("KitKat Dessert",50);
		choco.put("MilkyBar",10);
		choco.put("Munch",10);
		choco.put("Perk",5);
		choco.put("Snickers",10);
		for(String c:choco.keySet()) 
		{
			int value=choco.get(c);
			String name=c;
			CandyDAO.addCandiesDAO(name,value);
		}
	}
public static void addCandy() throws Exception {
	log.info("Enter chocolate name:");
	String name=sc.next();
	log.info("Enter price:");
	int price=sc.nextInt();
	CandyDAO.addCandy(name, price);
	AdminMenu.adminMenu();
}
	}
