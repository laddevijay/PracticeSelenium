package com.pkg.selenium.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day15_Tooltip {
	private static WebDriver driver;
	private static final String testUrl = "https://www.globalsqa.com/demo-site/tooltip/";

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
		
		By tooltipButton = By.xpath("//div[@class='ui-widget photo']/a/img");
		
		WebElement tool= driver.findElement(tooltipButton);
		Actions actions = new Actions(driver);
		actions.moveToElement(tool).perform();
		System.out.println(tool.getText());
		
	}

}
