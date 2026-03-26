package com.pkg.selenium.basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day01_Locators {

	public static void main(String[] args) {

		WebDriver driver;

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.saucedemo.com/");

		By inputUsername = By.id("user-name");
		By inputPassword = By.id("password");
		By btnLogin = By.id("login-button");
		By linkslb = By.linkText("Sauce Labs Backpack");
		By linkSauce = By.partialLinkText("Sauce");

		driver.findElement(inputUsername).sendKeys("standard_user");
		driver.findElement(inputPassword).sendKeys("secret_sauce");
		driver.findElement(btnLogin).click();
	List<WebElement> listofElements = driver.findElements(linkSauce);
		
		System.out.println("Total number of elements with link text 'Sauce Labs' are: " + listofElements.size());
		
		for(WebElement element : listofElements) {
			System.out.println(element.getText());
		}

		driver.findElement(linkslb).click();
		
	
		driver.quit();

	}
}
