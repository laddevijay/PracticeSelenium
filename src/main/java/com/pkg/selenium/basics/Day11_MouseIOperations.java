package com.pkg.selenium.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day11_MouseIOperations {
	private static WebDriver driver;
	private static final String testUrl = "https://www.ebay.com/?msockid=26c4f9d8448865bb0293ef3145ab64fd";

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

		By doubleClickBtn = By.id("doubleClickBtn");
		By rightClickBtn = By.id("rightClickBtn");
		By clickMeBtn = By.xpath("//button[text()='Click Me']");

		Actions act = new Actions(driver);
		/*
		 * act.doubleClick(driver.findElement(doubleClickBtn)).perform();
		 * act.contextClick(driver.findElement(rightClickBtn)).perform();;
		 * act.moveToElement(driver.findElement(clickMeBtn)).build().perform();
		 */

		By mouseHoverBtn = By.linkText("Toys");
		act.moveToElement(driver.findElement(mouseHoverBtn)).perform();
		
	}

}
