package com.pkg.selenium.basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day13_AlertHandling {
	private static WebDriver driver;
	private static final String testUrl = "https://demoqa.com/alerts";

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

	By alertButton = By.id("alertButton");
	By timerAlertButton = By.id("timerAlertButton");
	By confirmButton = By.id("confirmButton");
	By promtButton = By.id("promtButton");

	driver.findElement(promtButton).click();
	// Wait until alert is present
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	// Perform actions
	System.out.println(alert.getText());
	alert.accept();
	alert.dismiss();

	alert.sendKeys("Selenium Alert Handling");
	alert.accept();

}
}
