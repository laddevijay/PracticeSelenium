package com.maven.selenium.practice;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	@DataProvider(name = "loginData")
	public Object[][] getData() {
		Object[][] data = new Object[5][2];
		
		data[4][0] = "standard_user";
		data[4][1] = "secret_sauce";

		data[0][0] = "locked_out_user";
		data[0][1] = "secret_sauce";
		
		data[1][0] = "problem_user";
		data[1][1] = "secret_sauce";
		
		data[2][0] = "performance_glitch_user";
		data[2][1] = "secret_sauce";
		
		data[3][0] = "error_user";
		data[3][1] = "secret_sauce";
		
		return data;
	}
}
