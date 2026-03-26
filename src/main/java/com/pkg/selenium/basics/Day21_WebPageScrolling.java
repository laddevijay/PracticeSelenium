package com.pkg.selenium.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day21_WebPageScrolling {

	private static WebDriver driver;
	private static final String testUrl = "https://www.drdo.gov.in/drdo/";

	private static void setupDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) throws InterruptedException {
		setupDriver();
		driver.get(testUrl);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		/*
		 * // Scroll down by 500 pixels js.executeScript("window.scrollBy(0, 2000);");
		 * Thread.sleep(2000); // Pause to see the scroll effect
		 * js.executeScript("window.scrollBy(0, -1500);");
		 */

		By scrollButton = By.xpath("block-drdo-dbim-quicktabskeyofferings");
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(scrollButton));
	}

}
