package com.pkg.selenium.basics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Day16_Screenshot {
	private static WebDriver driver;
	private static final String testUrl = "https://www.drdo.gov.in/drdo/";

	private static void setupDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) throws IOException {
		setupDriver();
		driver.get(testUrl);

		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

		String path = System.getProperty("user.dir") + File.separator + "target" + File.separator + "Screenshots"
				+ File.separator + "screenshot_" + timestamp + ".png";

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File actualScreenshot = screenshot.getScreenshotAs(OutputType.FILE);

		File destinationFile = new File(path);

		FileUtils.copyFile(actualScreenshot, destinationFile);
		
		captureWeElementSC();

	}

	public static void captureFullpage() throws IOException {
		setupDriver();
		driver.get(testUrl);
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String path = System.getProperty("user.dir") + File.separator + "target" + File.separator + "Screenshots"
				+ File.separator + "screenshot_" + timestamp + ".png";
		// Capture full page screenshot
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);

		// Save image
		ImageIO.write(screenshot.getImage(), "PNG", new File(path));
	}

	public static void captureWeElementSC() throws IOException {
		setupDriver();
		driver.get(testUrl);
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		
		String path = System.getProperty("user.dir")
				+ File.separator + "target"
				+ File.separator + "Screenshots"
				+ File.separator + "screenshot_" + timestamp + ".png";
	
		By elementLocator = By.className("logoWrapper");
		
		File src = driver.findElement(elementLocator).getScreenshotAs(OutputType.FILE);
	
		FileUtils.copyFile(src, new File(path));
	}

}
