package com.pkg.selenium.basics;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day42_Cookies {
	static WebDriver driver;
	static String testUrl = "https://www.amazon.in/";
	@BeforeMethod
	public static void setupDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(testUrl);
	}
	
	@Test
	public void testCookies() {
	
		Set<Cookie> allCookies = driver.manage().getCookies();
		
		for(Cookie cookie : allCookies) {
				System.out.println("Name: " + cookie.getName()+
						", Value: " + cookie.getValue() +
						", Domain: " + cookie.getDomain());
		}
		
		Cookie newCookie = new Cookie("my_cookie", "https://www.amazon.in/");
		driver.manage().addCookie(newCookie);
		
		System.out.println("After adding new cookie:");
		
	Set<Cookie> allCookies2 = driver.manage().getCookies();
		
		for(Cookie cookie : allCookies2) {
				System.out.println("Name: " + cookie.getName()+
						", Value: " + cookie.getValue() +
						", Domain: " + cookie.getDomain());
		}
	
	}
	
	@AfterMethod
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}
	
	
}
