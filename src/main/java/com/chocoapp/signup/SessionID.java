package com.chocoapp.signup;

public class SessionID {
	public static int userid;
	public static String email;
	public static void setUserid(int id)
	{
		userid=id;
	}
	public static void setEmail(String mail) {
		email=mail;
	}
	public static String getEmail() {
		return email;
	}
	public static int getUserid() {
		return userid;
	}
}
