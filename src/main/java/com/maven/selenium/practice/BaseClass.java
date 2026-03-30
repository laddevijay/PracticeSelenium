package com.maven.selenium.practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		DriverFactory.initDriver(browser);
		DriverFactory.getDriver().get("https://example.com");
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
