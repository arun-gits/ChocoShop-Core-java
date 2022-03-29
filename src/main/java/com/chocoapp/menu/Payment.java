package com.chocoapp.menu;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class Payment {
	private static Logger log=LogManager.getLogger(Payment.class);
	static Scanner sc=new Scanner(System.in);
	public static String takeCaptcha() {
		int a = (int)(Math.random()*(9000-100+1)+100);  
		String b=String.valueOf(a);
		return b;
	}
	public static void PayMode() throws Exception {
		log.info("Enter the payment mode");
		log.info("1. UPI id");
		log.info("2. Debit/Credit card");
		log.info("3. Cash on Delivery");
		log.info("4. Back");
		log.info("5. Exit");
		int choice=sc.nextInt();
		if(choice==1) {
			PayOn(choice);
		}
		else if(choice==2) {
			PayOn(choice);
		}
		else if(choice==3){
			PayOn(choice);
		}
		else if(choice==4) {
			BuyCandies.addCandy();
		}
		else if(choice==5) {
			log.info("Thanks for shopping ! :)");
			System.exit(0);
		}
		else {
			log.warn("Enter valid input");
			PayMode();
		}
	}
	public static void PayOn(int a) throws Exception {
		switch(a) {
			case 1:
					log.info("Enter your UPI id:");
					String upi=sc.next();
						if (!upi.contains("@") || !upi.contains(".")) {
							System.err.println("Invalid UPI");
//							log.info("Enter valid UPI:");
							PayOn(1);
						}
						else {
							takeAddress();
							int capt=captchaVerification();
							if(capt==0) {
							log.info("Paid Successful");
						log.info("Returning you to main page");
							
						}
						}
						break;
			case 2:
					log.info("Enter Debit/Credit Card number");
					String deb=sc.next();
					sc.nextLine();
					if(deb.length()==16) {
						takeAddress();
						int capt=captchaVerification();
						if(capt==0) {
							log.info("Paid Successful");
							log.info("Returning you to main page");
							
						}
					}
					else {
						log.warn("Invalid input");
						PayOn(2);
					}
					break;
			case 3:
					takeAddress();
					int capt=captchaVerification();
					if(capt==0) {
							
					log.info("Returning you to main page");				
					}
					break;
		
		}
	}
	@SuppressWarnings("unused")
	public static void takeAddress() {
		log.info("Enter your address in one line:");
		String addres=sc.next();
	}
	public static int captchaVerification() {
		String captcha=takeCaptcha();
		log.info(captcha);
		log.info("Enter the above captcha:");
		String input=sc.next();
		if(input.equals(captcha)) {
			return 0;
		}
		else {
			captchaVerification();
		}
		return 1;
	}
}
