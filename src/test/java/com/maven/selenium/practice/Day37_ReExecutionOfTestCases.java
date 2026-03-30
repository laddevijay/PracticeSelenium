package com.maven.selenium.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day37_ReExecutionOfTestCases {

	@Test
	public void testCase1() {
		System.out.println("This is test case 1");
		Assert.assertTrue(false);
	}
	@Test
	public void testCase2() {
		System.out.println("This is test case 2");
		Assert.assertTrue(true);
	}
	@Test
	public void testCase3() {
		System.out.println("This is test case 3");
		Assert.assertTrue(false);
	}
	@Test
	public void testCase4() {
		System.out.println("This is test case 4");
		Assert.assertTrue(true);
	}
}
