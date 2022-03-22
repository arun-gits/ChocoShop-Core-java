package com.chocoapp.sqlconnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.List;

import com.chocoapp.Menu;
import com.chocoapp.signup.SessionID;

public class CandyDAO {
	
	public static void addCandiesDAO(String name, int price) throws Exception {
		String query="insert into choco_list (name,price) values('"+name+"','"+price+"')";
		ConnectSQL.sqlConnect(query);
		System.out.println(name+" added");
	}
	public static void BuyCandies(List<Integer> chocoids) throws Exception {
		LocalDate date=LocalDate.now();
		int id=SessionID.getUserid();
		for(Integer i:chocoids) {
			String query="insert into choco_trans (userid,chocoid,purchased_on) values('"+id+"','"+i+"','"+date+"')";
			ConnectSQL.sqlConnect(query);
		}
		System.out.println("Order Placed Succesfully");
		System.out.println("Returning to main page");
		Menu.List();
		
	}
	public static ResultSet transDetails(int id) throws ClassNotFoundException, SQLException {	
		String query="SELECT choco_list.name,choco_list.price,choco_trans.purchased_on FROM choco_list INNER JOIN choco_trans ON choco_trans.chocoid=choco_list.chocoid WHERE userid='"+id+"'";
		System.out.println("Processing....");
		ResultSet data=ConnectSQL.javaConnect(query);
		return data;
	}
	public static void totalPrice(List<Integer> chocoids) throws ClassNotFoundException, SQLException {
		int total=0;
		for(Integer i:chocoids) {
			String query="select price from choco_list where chocoid="+i+"";
			ResultSet data=ConnectSQL.javaConnect(query);
			while(data.next()) {
				total=total+data.getInt("price");
			}
		}
		System.out.println("Total price is "+total);
		System.out.println("\n");
	}
}
