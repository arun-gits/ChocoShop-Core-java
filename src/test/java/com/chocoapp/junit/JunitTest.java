package com.chocoapp.junit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.chocoapp.signup.OverallValidation;

public class JunitTest {
	public static boolean isValid(String name) {
		if(name.isBlank()||name.trim().length()==0) {
			return false;
		}
		return true;
	}
	public static int isValidNum(int number) {
		if(number%2==0) {
			return 1;
		}
		return 0;
	}
	@Test
	public void testName() {
		assertTrue(isValid("Arun"));
	}
	@Test
	public void testName2() {
		assertTrue(isValid("Kumar"));
	}
	@Test
	public void testName3() {
		assertTrue(isValid("    S  "));
	}
	@Test
	public void testNum() {
		assertEquals(1,isValidNum(20));
	}
	@Test
	public void testName4() {
		assertEquals(0,OverallValidation.nameCheck("Java"));
	}
}
