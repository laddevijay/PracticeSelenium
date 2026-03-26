package com.maven.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day27_TestNGxml {
	private static WebDriver driver;
	private static final String testUrl = "https://www.youtube.com/";

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
	public void setUp() {
		driver.get(testUrl);

		By searchBox = By.xpath("//input[@placeholder='Search']");

		WebElement searchBar = driver.findElement(searchBox);
		searchBar.click();
		searchBar.sendKeys("Selenium Tutorial");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
