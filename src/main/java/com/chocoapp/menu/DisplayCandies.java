package com.chocoapp.menu;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chocoapp.Home;
import com.chocoapp.Menu;
import com.chocoapp.sqlconnection.ConnectSQL;
import java.util.Scanner;
public class DisplayCandies {
	static Scanner sc=new Scanner(System.in);
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
		System.out.println("    \tName             Price\t");
		while(set.next()) {
			int price=set.getInt("price");
			String name=set.getString("name");
			int id=set.getInt("chocoid");
			System.out.println(id+"."+name+"=====>\t"+price);
		}
		for(int i=0;i<50;i++) {
			System.out.printf("=");
		}
		System.out.println("\n");
	}
	public static void fullShow() throws Exception {
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
				filterShow();
				break;
			case 3:
				Menu.List();
			case 4:
				System.out.println("Thanks for shopping ! :)");
				System.exit(0);
				break;
			default:
				Home.HomePage();
		}
	}
	public static void filterShow() throws SQLException, Exception {
		System.out.println("1. Price lowest to highest");
		System.out.println("2. Price highest to lowest");
		System.out.println("3. Back");
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
			System.out.println("Thanks for shopping ! :)");
			System.exit(0);
		}
	}
}
