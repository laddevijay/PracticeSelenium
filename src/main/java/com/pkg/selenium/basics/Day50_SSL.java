package com.pkg.selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day50_SSL {

	
	WebDriver driver;
	@Test
	public void invokeBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--maximized");
		driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		
	}
}
