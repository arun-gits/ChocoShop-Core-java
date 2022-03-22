package com.chocoapp.sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class ConnectSQL {
	
		public static Connection dataLink() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect=DriverManager.getConnection("jdbc:mysql://101.53.133.59:3306/revature_training_db","rev_user","rev_user");
//			System.out.println("Processing...");
//			System.out.println("Connection established:"+connect);
		
			return connect;
		}
		public static void sqlConnect(String addQuery) throws Exception {
			Connection connect=dataLink();
			Statement run=connect.createStatement();
			run.executeUpdate(addQuery);
//			connect.close();
	//		int rows=run.executeUpdate(addQuery);
	//		System.out.println("Number of rows inserted "+rows);
		}
		public static ResultSet javaConnect(String getQuery) throws ClassNotFoundException, SQLException{
			Connection connect=dataLink();
			Statement run=connect.createStatement();
			ResultSet get=run.executeQuery(getQuery);
			return get;
		}

}

