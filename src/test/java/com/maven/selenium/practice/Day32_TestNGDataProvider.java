package com.maven.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day32_TestNGDataProvider {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");

}
@AfterMethod
public void tearDown() {
	driver.close();
}

//@Test(dataProvider = "ExampleloginData")
@Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
public void loginSauceDemo(String userName, String password) {
	By userNameField = By.id("user-name");
	By passwordField = By.id("password");
	By loginButton = By.id("login-button");

	driver.findElement(userNameField).sendKeys(userName);
	driver.findElement(passwordField).sendKeys(password);
	driver.findElement(loginButton).click();
}

@DataProvider(name = "ExampleloginData")
public Object[][] getData() {
	Object[][] data = new Object[3][2];
	
	data[4][0] = "standard_user";
	data[4][1] = "secret_sauce";

	data[0][0] = "locked_out_user";
	data[0][1] = "secret_sauce";
	
	data[1][0] = "problem_user";
	data[1][1] = "secret_sauce";
	
		return data;
	}
}
