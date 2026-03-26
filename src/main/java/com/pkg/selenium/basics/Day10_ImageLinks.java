package com.pkg.selenium.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day10_ImageLinks {
	private static WebDriver driver;
	private static final String testUrl = "https://www.calculator.net/fitness-and-health-calculator.html";

	private static void setupDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		setupDriver();
		driver.get(testUrl);

		By imageLink = By.xpath("//img[@alt='Calculator.net']");

		if (driver.findElement(imageLink).isDisplayed()) {
			System.out.println("Image link is displayed.");
			driver.findElement(imageLink).click();

		} else {
			System.out.println("Image link is not displayed.");
		}

	}
}
