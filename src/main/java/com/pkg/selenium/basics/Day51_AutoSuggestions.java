package com.pkg.selenium.basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day51_AutoSuggestions {

	static WebDriver driver;
	static WebDriverWait wait;

	static String testUrl = "https://www.amazon.in/";

	@BeforeMethod
	public void setup() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(testUrl);
	}

	@Test
public void autoSuggest() throws InterruptedException {

	// Search textbox
	By searchBox = By.id("twotabsearchtextbox");

	// Suggestions list
	By suggestionList = By.xpath("//div[@class='left-pane-results-container']/div");

	WebElement search = driver.findElement(searchBox);
	search.click();
	search.sendKeys("iphone");

	List<WebElement> suggestions = driver.findElements(suggestionList);

	for (WebElement option : suggestions) {
		System.out.println(option.getText());
	}
}
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
}
}