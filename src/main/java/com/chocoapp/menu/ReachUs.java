package com.chocoapp.menu;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chocoapp.Menu;

@SuppressWarnings("unused")
public class ReachUs {
	static Scanner sc=new Scanner(System.in);
	private static Logger log=LogManager.getLogger(ReachUs.class);

public static void contactUs() throws Exception {
		log.info("Enter your name:");
		String name=sc.next();
		log.info("Enter your email:");
		String email=sc.next();
		log.info("Message without newline");
		String message=sc.next();
		log.info("Thanks, we will reply you soon");
		log.info("\n\n");
		log.info("Also You can reach us at\n");
		log.info("Email us: chocoshop@gmail.com");
		log.info("Instagram: chocoshop_kvcet");
		log.info("Website: www.chocoshop.com");
		log.info("Enter 1 to back");
		int a=sc.nextInt();
		if(a==1) {
			Menu.List();
		}
		else {
			log.warn("Sorry, wrong input!\nRefresh the page.");
			System.exit(0);
		}
	}
}
