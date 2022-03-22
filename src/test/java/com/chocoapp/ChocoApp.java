package com.chocoapp;
import java.util.Scanner;


import com.chocoapp.menu.AdminCandiesList;
//import com.chocoapp.candiesmenu.CandiesShow;
//import com.chocoapp.candies.CandiesList;
//import com.chocoapp.signup.RegisterOrLogin;
import com.chocoapp.sqlconnection.ConnectSQL;
//import com.chocoapp.sqlconnection.SigningDAO;

import java.sql.Connection;
//import java.sql.ResultSet;

public class ChocoApp {
static Scanner sc = new Scanner(System.in);
public static String choice;
public static void main(String[] args) throws Exception {
		Home.HomePage();
	
//		CandiesShow.showAll();
//	AdminCandiesList.addCandies();
//	BuyCandies.addCandy();
		Connection connect=ConnectSQL.dataLink();
		connect.close();
}

}