package com.maven.selenium.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	// Initialize driver based on browser
	public static void initDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}

		getDriver().manage().window().maximize();
	}

	// Get driver for current thread
	public static WebDriver getDriver() {
		return driver.get();
	}

	// Quit driver
	public static void quitDriver() {
		getDriver().quit();
		driver.remove();
	}
}
