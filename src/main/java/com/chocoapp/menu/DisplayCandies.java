package com.chocoapp.menu;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chocoapp.Home;
import com.chocoapp.Menu;
import com.chocoapp.sqlconnection.ConnectSQL;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class DisplayCandies {
	static Scanner sc=new Scanner(System.in);
	private static Logger log=LogManager.getLogger(DisplayCandies.class);
	public static void showAll() throws Exception{
		String query="SELECT * FROM choco_list";
		ResultSet set=ConnectSQL.javaConnect(query);
		Show(set);
	}
	public static void SortInAsc() throws Exception, SQLException {
		String query="SELECT * FROM choco_list ORDER BY price ASC";
		ResultSet set=ConnectSQL.javaConnect(query);
		Show(set);
	}
	public static void SortInDesc() throws Exception, SQLException {
		String query="SELECT * FROM choco_list ORDER BY price DESC";
		ResultSet set=ConnectSQL.javaConnect(query);
		Show(set);
	
	}
	public static void Show(ResultSet set) throws Exception {
		log.info("    \tName             Price\t");
		while(set.next()) {
			int price=set.getInt("price");
			String name=set.getString("name");
			int id=set.getInt("chocoid");
			log.info(id+"."+name+"=====>\t"+price);
		}
		for(int i=0;i<50;i++) {
			System.out.printf("=");
		}
		log.info("\n");
	}
	public static void fullShow() throws Exception {
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
				filterShow();
				break;
			case 3:
				Menu.List();
			case 4:
				log.info("Thanks for shopping ! :)");
				System.exit(0);
				break;
			default:
				Home.HomePage();
		}
	}
	public static void filterShow() throws SQLException, Exception {
		log.info("1. Price lowest to highest");
		log.info("2. Price highest to lowest");
		log.info("3. Back");
		int choice=0;
		choice=sc.nextInt();
		if(choice==1) {
			SortInAsc();
			BuyCandies.addMoreCandies();
		}
		else if(choice==2) {
			SortInDesc();
			BuyCandies.addMoreCandies();
		}
		else if(choice==3){
			DisplayCandies.fullShow();
		}
		else {
			log.info("Thanks for shopping ! :)");
			System.exit(0);
		}
	}
}
