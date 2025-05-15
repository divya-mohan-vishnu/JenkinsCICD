package com.testautomation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverManager {

	public static WebDriver driver;

	public WebDriver getDriver() {
		try {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		if (driver == null)

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\vicho\\eclipse-workspace\\JenkinsProject\\src\\test\\resources\\driver\\chromedriver.exe");

		// Set ChromeOptions to run headlessly
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		options.addArguments("--headless"); // Run headless
		options.addArguments("--disable-gpu"); // Disable GPU for headless mode
		options.addArguments("--window-size=1920x1080"); // Set window size for headless mode

		
		driver = new ChromeDriver();
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null)
			driver.quit();
	}
}
