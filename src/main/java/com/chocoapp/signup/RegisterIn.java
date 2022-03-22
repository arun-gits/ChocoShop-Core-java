package com.chocoapp.signup;

public class RegisterIn {
		public String name;
		public String number;
		private static String password;
		private static String mail;

		@SuppressWarnings("static-access")
		public RegisterIn(String name, String number, String password, String mail) {
			this.name = name;
			this.number = number;
			this.password = password;
			this.mail = mail;
		}
		public static String getmail()
		{
			return mail;
		}
		public static void setmail(String email)
		{
			mail=email;
		}
		public static String getpassword() {
			return password;
		}
		public static void setPassword(String pass) {
			password=pass;
		}

	}

