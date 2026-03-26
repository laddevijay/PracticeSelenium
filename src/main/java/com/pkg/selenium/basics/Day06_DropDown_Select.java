package com.pkg.selenium.basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day06_DropDown_Select {
	private static WebDriver driver;
	private static final String URL="https://practice.qabrains.com/registration";
	//private static final String URL = "https://phptravels.net/";

	private static void setupDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		setupDriver();
		dropdownWithSelect();
		//dropdownWithoutSelect();
	}

	private static void dropdownWithSelect() {
		driver.get(URL);
		By countryList = By.id("country");
		Select select = new Select(driver.findElement(countryList));
		// select.selectByIndex(2);
		// select.selectByValue("Bangladesh");
		select.selectByVisibleText("India");

		List<WebElement> allOptions = select.getOptions();
		System.out.println(allOptions.size());

		for (WebElement option : allOptions) {
			System.out.println(option.getText());
		}

		driver.close();
	}

	private static void dropdownWithoutSelect() {
		driver.get(URL);

		By coutry = By.xpath("getSelectedName()");
		By input = By.xpath("//input[@placeholder='Search country...']");
		By countryList = By.xpath("//div[@class='input-dropdown-item flex items-center gap-2']/span[2]");

		driver.findElement(coutry).click();
		driver.findElement(input).sendKeys("India");
		List<WebElement> allCountries = driver.findElements(countryList);
		System.out.println(allCountries.size());
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(
		    ExpectedConditions.elementToBeClickable(coutry)
		);
		element.sendKeys("India");
		
		for (WebElement country : allCountries) {
			System.out.println(country.getText());
		}

	}

}
