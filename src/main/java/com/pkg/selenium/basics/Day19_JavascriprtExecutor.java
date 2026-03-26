package com.pkg.selenium.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day19_JavascriprtExecutor {

	private static WebDriver driver;
	private static final String testUrl = "https://www.saucedemo.com/";

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
		JavaScriptUtility jsUtil = new JavaScriptUtility(driver);
		jsUtil.zoomPage("75%");
		By usernameField = By.xpath("//input[@placeholder='Username']");
		
		jsUtil.enterTextByJS(driver.findElement(usernameField), "performance_glitch_user");
		
		By loginButton = By.id("login-button");
		jsUtil.clickElementByJS(driver.findElement(loginButton));
		
		jsUtil.refreshPageByJS();
		
		System.out.println(jsUtil.getDomainByJS());
		System.out.println(jsUtil.getTitleByJS());
		System.out.println(jsUtil.getURLByJS());
		jsUtil.drawBorder(driver.findElement(usernameField));
		 System.out.println("Inner Height: " + jsUtil.getInnerHeight());
	     System.out.println("Inner Width: " + jsUtil.getInnerWidth());
	
	     try {
			jsUtil.flash(driver.findElement(loginButton));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	    // jsUtil.generateAlert("This is a JavaScript Alert!");
	     
	     jsUtil.navigateToURL("https://www.drdo.gov.in/drdo/");
	     jsUtil.scrollSlowly(driver, 100, 100, 200);
	}

}
