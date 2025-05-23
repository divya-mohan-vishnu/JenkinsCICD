package com.testautomation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(name = "email")
	private WebElement userEmail;

	@FindBy(name = "pass")
	private WebElement password;

	@FindBy(xpath = "//span[contains(text(),'username')]")
	private WebElement userName;

	@FindBy(xpath = "//span[contains(text(),'Password')]")
	private WebElement userPassword;

	@FindBy(xpath = "//a[contains(text(),'Create new account']")
	private WebElement loginButton;

	public void login(String username, String password) {
		userName.sendKeys(username);
		userPassword.sendKeys(password);
		loginButton.click();

	}

	public void goToLoginPage(String url) {
		driver.get(url);
	}

	public void enteruserandpassword(String username, String userpassword) {

		userEmail.sendKeys(username);
		password.sendKeys(userpassword);

	}

	public void ClickOnLoginButton() {
		loginButton.click();
		
	}
}
