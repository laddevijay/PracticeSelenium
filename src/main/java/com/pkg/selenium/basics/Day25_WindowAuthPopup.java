package com.pkg.selenium.basics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day25_WindowAuthPopup {
	private static WebDriver driver;
	private static String testUrl = "https://the-internet.herokuapp.com/basic_auth";

	private static void setupDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) throws InterruptedException {
		setupDriver();

		// https://username:password@url
		String username = "admin";
		String password = "admin";

		driver.get("https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth");
	}

}
