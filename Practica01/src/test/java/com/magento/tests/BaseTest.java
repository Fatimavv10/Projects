package com.magento.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.magento.pages.OrderPage;
import com.magento.pages.HomePage;
import com.magento.pages.LoginPage;
import com.magento.pages.RegisterPage;

public class BaseTest {

	protected WebDriver driver;
	protected RegisterPage registerPage;
	protected HomePage	homePage;
	protected LoginPage loginPage;
	protected OrderPage cartPage;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		registerPage = new RegisterPage(driver);
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		cartPage = new OrderPage(driver);
	}


	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			//driver.quit();
		}
	}

}