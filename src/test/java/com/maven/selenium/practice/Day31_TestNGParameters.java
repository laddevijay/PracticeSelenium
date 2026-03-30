package com.maven.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day31_TestNGParameters {
	WebDriver driver;
	

	@Test(enabled = false)
	@Parameters({ "numOne", "numTwo" })
	public void substraction(int numberOne, int numberTwo) {
		int difference = numberOne - numberTwo;
		System.out.println("The difference of " + numberOne + " and " + numberTwo + " is: " + difference);
	}
	
@Test
@Parameters({ "userName", "password" })
public void loginSauceDemo(String userName, String password) {
	By userNameField = By.id("user-name");
	By passwordField = By.id("password");
	By loginButton = By.id("login-button");

	driver.findElement(userNameField).sendKeys(userName);
	driver.findElement(passwordField).sendKeys(password);
	driver.findElement(loginButton).click();
}
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		
	}

}
