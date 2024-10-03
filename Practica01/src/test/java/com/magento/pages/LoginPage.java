package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	protected WebDriver driver;

	By email = By.id("email");
	By password = By.id("pass");
	By btnsignin = By.id("send2");
	By btnforgotpassword = By.xpath("//a[contains(@href, 'forgotpassword')]");
	By email_address = By.id("email_address");
	By btnreset = By.xpath("//button[@class='action submit primary']");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickSignin() {
		submit(btnsignin);
	}

	public void clickForgotPassword() {
		click(btnforgotpassword);
	}

	public void clickReset() {
		click(btnreset);
	}
	
	public void fillOutFormLogin(String strEmail, String strPassword) {
		type(email, strEmail);
		type(password, strPassword);
	}

	public void fillOutFormForgotPassword(String strEmail) {
		//Credenciales en blanco
		type(email_address, strEmail);
	}

}
