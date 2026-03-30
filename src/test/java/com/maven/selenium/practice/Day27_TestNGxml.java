package com.maven.selenium.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day27_TestNGxml {
	private static WebDriver driver;
	private String testUrl = "https://www.youtube.com/";

	@BeforeMethod
	public void beforeMethod() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void Test_NavigateYoutube() {
		driver.get(testUrl);
		System.out.println("Title of the page: " + driver.getTitle());
		By searchBox = By.xpath("//input[@placeholder='Search']");

		WebElement searchBar = driver.findElement(searchBox);
		searchBar.click();
		searchBar.sendKeys("Selenium Tutorial");
	}
	
	@Test
	public void Test_NavigateAmazon() {
		testUrl = "https://www.amazon.com/";
		driver.get(testUrl);
		System.out.println("Title of the page: " + driver.getTitle());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class: Setting up resources for the test class.");
		
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class: Cleaning up resources for the test class.");
	}
	

}
