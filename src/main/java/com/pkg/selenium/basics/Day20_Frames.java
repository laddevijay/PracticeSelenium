package com.pkg.selenium.basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day20_Frames {

	private static WebDriver driver;
	private static final String testUrl = "https://www.rediff.com/";

	private static void setupDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

public static void main(String[] args) {
	setupDriver();
	driver.get(testUrl);
		
	By nseIndexPath = By.xpath("//span[@id='nseindex']");
	By bseIndexPath = By.xpath("//span[@id='bseindex']");
	
	List<WebElement> frames = driver.findElements(By.tagName("iframe"));
	System.out.println("Total Frames: " + frames.size());
	
    driver.switchTo().frame("moneyiframe"); 	// Switch to iframe

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // Wait for NSE element
    wait.until(d -> d.findElement(nseIndexPath).isDisplayed());
	
    WebElement nseIndex = driver.findElement(nseIndexPath);
    WebElement bseIndex = driver.findElement(bseIndexPath);

    System.out.println("NSE Index: " + nseIndex.getText());
    System.out.println("BSE Index: " + bseIndex.getText());

    driver.switchTo().defaultContent(); // Switch back to main page
}

}
