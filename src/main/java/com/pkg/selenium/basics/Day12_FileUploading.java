package com.pkg.selenium.basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day12_FileUploading {
	private static WebDriver driver;
	private static final String testUrl = "https://demoqa.com/upload-download";

	private static void setupDriver() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<>();

		prefs.put("download.default_directory", "D:\\Downloads");
		prefs.put("profile.default_content_settings.popups", 0);

		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) throws AWTException {
		setupDriver();
		driver.get(testUrl);
		String filePath = "D:\\SDET-Training\\Git-SDET.pdf";

		By fileUploadInput = By.id("uploadFile");

		// Webelement creates by type="file"
		driver.findElement(fileUploadInput).sendKeys(filePath);

		// without using sendKeys() method, we can use Robot class
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(fileUploadInput)).click().perform();

		// Copy file path to clipboard/Notepad
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = new Robot();
		robot.delay(2000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		downloadFile();

	}

	private static void downloadFile() {
		By downloadBtn = By.id("downloadButton");
		driver.findElement(downloadBtn).click();
		
	}

}
