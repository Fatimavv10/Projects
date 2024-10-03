package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

	protected WebDriver driver;

	By inputfirstname = By.id("firstname");
	By inputlastname = By.id("lastname");
	By inputemail = By.id("email_address");
	By inputpassword = By.id("password");
	By inputrepassword = By.id("password-confirmation");
	By btnregister = By.xpath("//*[@id='form-validate']/div/div[1]/button");

	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickRegister() {
		submit(btnregister);
	}
	
	public void fillOutFormRegister(String firstname, String lastname,String email, String password, String repassword) {
		type(inputfirstname, firstname);
		type(inputlastname, lastname);
		type(inputemail, email);
		type(inputpassword, password);
		type(inputrepassword, repassword);
	}

}
