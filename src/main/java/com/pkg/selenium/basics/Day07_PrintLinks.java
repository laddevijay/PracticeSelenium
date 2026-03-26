package com.pkg.selenium.basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Day07_PrintLinks {

    private static WebDriver driver;
    private static final String URL = "https://www.calculator.net/";

    public static void main(String[] args) {
        setupDriver();
        printAllLinks();
        tearDown();
    }

    private static void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get(URL);
    }
    

    private static void printAllLinks() {
    	// Find all anchor (<a>) elements on the webpage
    	List<WebElement> links = driver.findElements(By.tagName("a"));

    	System.out.println("Total number of links: " + links.size());

    	for (WebElement link : links) {

    	    // Get visible text of the link and remove leading/trailing spaces
    	    String text = link.getText().trim();

    	    // Get the value of href attribute (URL of the link)
    	    String href = link.getAttribute("href");
    	    if (!text.isEmpty() && href != null) {
    	        System.out.println(text + " : " + href);
    	    }
    	}
    }

    private static void tearDown() {
        driver.quit();
    }
}