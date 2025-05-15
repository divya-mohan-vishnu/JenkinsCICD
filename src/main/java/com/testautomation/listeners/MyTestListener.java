package com.testautomation.listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getName());
		WebDriver driver = com.testautomation.utils.DriverManager.driver;
		if (driver != null) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);

			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String fileName = "screenshot_" + result.getName() + "_" + timestamp + ".png";

			try {
				Files.copy(srcFile.toPath(), new File("screenshots/" + fileName).toPath());
				System.out.println("Screenshot saved: " + fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getName());

		WebDriver driver = com.testautomation.utils.DriverManager.driver;

		if (driver != null) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);

			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String fileName = "screenshot_" + result.getName() + "_" + timestamp + ".png";

			try {
				Files.copy(srcFile.toPath(), new File("screenshots/" + fileName).toPath());
				System.out.println("Screenshot saved: " + fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getName());
	}
}
