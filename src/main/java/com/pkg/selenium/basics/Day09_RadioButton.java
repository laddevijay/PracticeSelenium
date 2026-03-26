package com.pkg.selenium.basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day09_RadioButton {
	private static WebDriver driver;
	private static final String testUrl = "https://www.calculator.net/";
	
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
		
		By radioButton = By.xpath("//input[@type='radio']/parent::label");
		
		List<WebElement> noOfRadiobuttons = driver.findElements(radioButton);
		
		System.out.println("Total no of radio buttons: " + noOfRadiobuttons.size());
		
		for(WebElement radio : noOfRadiobuttons) {
			System.out.println("Radio button text: " + radio.getText());
			if(radio.getText().equals("Rad")) {
				radio.click();
				break;
			};
		}
		
		driver.quit();
	}
	
}
