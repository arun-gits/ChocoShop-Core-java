package com.chocoapp.sqlconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.chocoapp.Menu;
import com.chocoapp.signup.SessionID;

public class CandyDAO {
	private static Logger log=LogManager.getLogger(CandyDAO.class);
	
	public static void addCandiesDAO(String name, int price) throws Exception {
		String query="insert into choco_list (name,price) values('"+name+"','"+price+"')";
		ConnectSQL.sqlConnect(query);
		log.info(name+" added");
	}
	public static void BuyCandies(List<Integer> chocoids) throws Exception {
		LocalDate date=LocalDate.now();
		int id=SessionID.getUserid();
		for(Integer i:chocoids) {
			String query="insert into choco_trans (userid,chocoid,purchased_on) values('"+id+"','"+i+"','"+date+"')";
			ConnectSQL.sqlConnect(query);
		}
		log.info("Order Placed Succesfully");
		log.info("Returning to main page");
		Menu.List();
		
	}
	public static ResultSet transDetails(int id) throws ClassNotFoundException, SQLException {	
		String query="SELECT choco_list.name,choco_list.price,choco_trans.purchased_on FROM choco_list INNER JOIN choco_trans ON choco_trans.chocoid=choco_list.chocoid WHERE userid='"+id+"'";
		log.info("Processing....");
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
		log.info("Total price is "+total);
		log.info("\n");
	}
	public static void addCandy(String name,int price) throws Exception{
		Connection connect=ConnectSQL.dataLink();
		String query="call add_candy(?,?,?)";
		String message=null;
		CallableStatement add= connect.prepareCall(query);
		add.setString(1,name);
		add.setInt(2, price);
		add.registerOutParameter(3,java.sql.Types.VARCHAR);
		add.executeUpdate();
		message=add.getString(3);
		log.info(name+" is "+message);
		
	}
}
