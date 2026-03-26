package com.pkg.selenium.basics;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {

    JavascriptExecutor js;

    // Constructor
    public JavaScriptUtility(WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    // Type text into input field
    public void enterTextByJS(WebElement element, String text) {
    	js.executeScript("arguments[0].value = arguments[1];", element, text);
    }

    // Click using JavaScript
    public void clickElementByJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    // Refresh page
    public void refreshPageByJS() {
        js.executeScript("history.go(0);");
    }

    // Get domain name
    public String getDomainByJS() {
        return js.executeScript("return document.domain;").toString();
    }

    // Get page title
    public String getTitleByJS() {
        return js.executeScript("return document.title;").toString();
    }

    // Get page URL
    public String getURLByJS() {
        return js.executeScript("return document.URL;").toString();
    }

    // Draw border around element
    public void drawBorder(WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid red';", element);
    }

    // Zoom page
    public void zoomPage(String zoomPercentage) {
        js.executeScript("document.body.style.zoom='" + zoomPercentage + "';");
    }

    // Get inner height
    public String getInnerHeight() {
        return js.executeScript("return window.innerHeight;").toString();
    }

    // Get inner width
    public String getInnerWidth() {
        return js.executeScript("return window.innerWidth;").toString();
    }

    // Scroll down
    public void scrollDown() {
        js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
    }

    // Scroll up
    public void scrollUp() {
        js.executeScript("window.scrollBy(0, -document.body.scrollHeight);");
    }

    // Generate alert
    public void generateAlert(String message) {
        js.executeScript("alert('" + message + "');");
    }

    // Navigate to URL
    public void navigateToURL(String url) {
        js.executeScript("window.location='" + url + "';");
    }

    // Flash element
    public void flash(WebElement element) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            js.executeScript("arguments[0].style.backgroundColor='yellow';", element);
            Thread.sleep(500);

            js.executeScript("arguments[0].style.backgroundColor='blue';", element);
            Thread.sleep(500);
        }
    }

    // Sleep helper method
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // Method to scroll slowly up or down (use +ve for scrolling down and -ve for scrolling up)
public void scrollSlowly(WebDriver driver, int pixels, int steps, int delay) {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    for (int i = 0; i < steps; i++) {
        js.executeScript("window.scrollBy(0, " + pixels + ");");
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
}