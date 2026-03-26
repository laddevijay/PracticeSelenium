package com.pkg.selenium.basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day08_BrokenLinks {
	private static WebDriver driver;
	private static final String testUrl = "http://www.deadlinkcity.com/";
	static int timeout = 5000;
	
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

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Links: " + links.size());

		int brokenLinks = 0;

		// 🔹 Validate links
		for (WebElement link : links) {
			String urlLink = link.getAttribute("href");
			// Skip invalid links
			if (urlLink == null || urlLink.isEmpty() || urlLink.startsWith("javascript")) {
				continue;
			}

			HttpURLConnection connection = null;
			try {
				URL url = new URL(urlLink);
				connection = (HttpURLConnection) url.openConnection();

				connection.setConnectTimeout(timeout);
				connection.setReadTimeout(timeout);
				connection.setRequestMethod("HEAD");
				connection.connect();

				int responseCode = connection.getResponseCode();

				if (responseCode >= 400) {
					System.out.println("❌ Broken: " + urlLink);
					brokenLinks++;
				}

			} catch (Exception e) {
				System.out.println("❌ Exception/Broken: " + urlLink);
				brokenLinks++;
			} finally {
				if (connection != null) {
					connection.disconnect();
				}
			}
		}
		System.out.println("❌ Total Broken Links: " + brokenLinks);

		driver.quit();
	}
}