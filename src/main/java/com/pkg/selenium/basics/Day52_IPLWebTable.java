package com.pkg.selenium.basics;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day52_IPLWebTable {

	// Driver
	static WebDriver driver;
	static WebDriverWait wait;

	static String test_Url = "https://www.iplt20.com/";

	// Navigation
	static final By IplTable = By.linkText("POINTS TABLE");
	static final By cookies = By.xpath("//button[@class='cookie__accept cookie__accept_btn']");

	// Dropdowns
	static final By leagueDropDown = By.xpath("//div[@class='drop-down-filter']/*/div[1]");
	static final By seasonDropDown = By.xpath("//div[@class='drop-down-filter']/*/div[2]");

	static final By leagueDropDownOptions = By.xpath("//div[@class='cSBList active']/div");
	static final By seasonDropDownOptions = By.xpath("//div[@class='cSBListItems ng-binding ng-scope']");
	// Table
	static final By tableBody = By.id("pointsdata");
	static final By rowPath = By.tagName("tr");

	// SETUP
	@BeforeTest
	public void setup() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(test_Url);
	}

	// TEST
	@Test
	public void testWebTable() {

		driver.findElement(IplTable).click();

		driver.findElement(cookies).click();

		selectSeason("MEN", 2025);
		printTableTopper();
	}

	// BUSINESS LOGIC
	private void printTableTopper() {
		List<IPLTeam> teams = getPointsTableData();

		IPLTeam topper = teams.stream().max(Comparator.comparing(IPLTeam::getPoints).thenComparing(IPLTeam::getNrr))
				.get();

		System.out.println("Season Topper: " + topper.getTeamName());
	}

	private List<IPLTeam> getPointsTableData() {

		WebElement table = driver.findElement(tableBody);
		List<WebElement> rows = table.findElements(rowPath);

		List<IPLTeam> teams = new ArrayList<>();

		for (WebElement row : rows) {

			List<WebElement> columns = row.findElements(By.tagName("td"));

			// Defensive check
			if (columns.size() < 11) {
				continue;
			}

			String teamName = columns.get(2).getText();
			int points = Integer.parseInt(columns.get(10).getText());
			double nrr = Double.parseDouble(columns.get(7).getText());

			teams.add(new IPLTeam(teamName, nrr, points));
		}

		return teams;
	}

	// UI ACTIONS
	private void selectSeason(String gender, int year) {

		// Select League (MEN/WOMEN)
		driver.findElement(leagueDropDown).click();

		List<WebElement> leagues = driver.findElements(leagueDropDownOptions);
		for (WebElement league : leagues) {
			if (league.getText().equalsIgnoreCase(gender)) {
				league.click();
				break;
			}
		}

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(seasonDropDown));

		// Select Season
		driver.findElement(seasonDropDown).click();

		List<WebElement> seasons = driver.findElements(seasonDropDownOptions);
		for (WebElement season : seasons) {
			if (season.getText().contains(String.valueOf(year))) {
				season.click();
				break;
			}
		}
	}

	// TEARDOWN
	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // }
		}
	}
}
