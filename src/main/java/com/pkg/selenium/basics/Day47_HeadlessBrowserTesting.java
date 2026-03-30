package com.pkg.selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day47_HeadlessBrowserTesting {
	WebDriver driver;
	
	@Test
public void testHeadlessBrowser() {

	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
	driver = new ChromeDriver(options);
	
	driver.get("https://www.google.com/");
	System.out.println("Title: " + driver.getTitle());
	System.out.println("URL: " + driver.getCurrentUrl());
	
	driver.navigate().to("https://www.amazon.in/");
	System.out.println("Title: " + driver.getTitle());
	
	driver.quit();
}
}
