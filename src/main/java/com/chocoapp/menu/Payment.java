package com.chocoapp.menu;
import java.util.Scanner;



public class Payment {
	static Scanner sc=new Scanner(System.in);
	public static String takeCaptcha() {
		int a = (int)(Math.random()*(9000-100+1)+100);  
		String b=String.valueOf(a);
		return b;
	}
	public static void PayMode() throws Exception {
		System.out.println("Enter the payment mode");
		System.out.println("1. UPI id");
		System.out.println("2. Debit/Credit card");
		System.out.println("3. Cash on Delivery");
		System.out.println("4. Back");
		System.out.println("5. Exit");
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
			System.out.println("Thanks for shopping ! :)");
			System.exit(0);
		}
		else {
			System.out.println("Enter valid input");
			PayMode();
		}
	}
	public static void PayOn(int a) throws Exception {
		switch(a) {
			case 1:
					System.out.println("Enter your UPI id:");
					String upi=sc.next();
						if (!upi.contains("@") || !upi.contains(".")) {
							System.err.println("Invalid UPI");
//							System.out.println("Enter valid UPI:");
							PayOn(1);
						}
						else {
							takeAddress();
							int capt=captchaVerification();
							if(capt==0) {
							System.out.println("Paid Successful");
						System.out.println("Returning you to main page");
							
						}
						}
						break;
			case 2:
					System.out.println("Enter Debit/Credit Card number");
					String deb=sc.next();
					sc.nextLine();
					if(deb.length()==16) {
						takeAddress();
						int capt=captchaVerification();
						if(capt==0) {
							System.out.println("Paid Successful");
							System.out.println("Returning you to main page");
							
						}
					}
					else {
						System.err.println("Invalid input");
						PayOn(2);
					}
					break;
			case 3:
					takeAddress();
					int capt=captchaVerification();
					if(capt==0) {
							
					System.out.println("Returning you to main page");				
					}
					break;
		
		}
	}
	@SuppressWarnings("unused")
	public static void takeAddress() {
		System.out.println("Enter your address in one line:");
		String addres=sc.next();
	}
	public static int captchaVerification() {
		String captcha=takeCaptcha();
		System.out.println(captcha);
		System.out.println("Enter the above captcha:");
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
