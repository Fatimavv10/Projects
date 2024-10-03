package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	protected WebDriver driver;

	By registerLink = By.linkText("Create an Account");
	By loginLink = By.linkText("Sign In");

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		visit();
	}

	public void goToRegisterLink() {
		click(registerLink);
	}

	public void goToLoginLink() {
		click(loginLink);
	}

}
