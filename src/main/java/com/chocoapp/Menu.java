package com.chocoapp;

import com.chocoapp.menu.BuyCandies;
import com.chocoapp.menu.MenuInterface;
import com.chocoapp.menu.ReachUs;
import com.chocoapp.menu.ShowAllChocolates;
import com.chocoapp.menu.Transaction;

public class Menu {
	public static void List() throws Exception {
		int i=MenuInterface.Menu();
		switch(i){
			case 1:
				ShowAllChocolates.chocolatesList();
				break;
			case 2:
				BuyCandies.addCandy();
				break;
				//Buy Chocolates
			case 3:
				Transaction.transDetails();
				break;
				//Transaction Details
			case 4:
				ReachUs.contactUs();
				//Contact us
			case 5:
				Home.HomePage();
				break;
				//Back
			case 6:
				Home.HomePage();
				break;
				//Logout
			case 7:
				System.out.println("Thanks for shopping! :)");
				System.exit(0);
		}
}
}
