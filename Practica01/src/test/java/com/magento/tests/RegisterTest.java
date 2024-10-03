package com.magento.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.magento.utils.Variables;

public class RegisterTest extends BaseTest {


	@Test (groups = "functional")
	public void TCRegister01() {
		//Registro exitoso

		homePage.goToRegisterLink();
		registerPage.fillOutFormRegister("Fatima", "Vasquez", "fatima.vasquez.123@gmail.com", "Abcd123*", "Abcd123*");
		registerPage.clickRegister();

		String expected_header = "Account Information";

		WebElement header_account = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='block-title']//strong[text()='Account Information']")));

		Assert.assertEquals(header_account.getText(), expected_header);
	}

	@Test (groups = {"functional", "integration"})
	public void TCRegister02() {
		//Registro con campos obligatorios faltantes

		homePage.goToRegisterLink();
		registerPage.fillOutFormRegister("", "", "", "", "");
		registerPage.clickRegister();

		String error_message = "This is a required field.";

		WebElement firstname_error = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.id("firstname-error")));
		WebElement lastname_error = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.id("lastname-error")));
		WebElement email_address_error = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.id("email_address-error")));
		WebElement password_error = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.id("password-error")));
		WebElement password_confirmation_error = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.id("password-confirmation-error")));

		Duration.ofSeconds(Variables.TIME_OUT);
		
		Assert.assertEquals(firstname_error.getText(), error_message);
		Assert.assertEquals(lastname_error.getText(), error_message);
		Assert.assertEquals(email_address_error.getText(), error_message);
		Assert.assertEquals(password_error.getText(), error_message);
		Assert.assertEquals(password_confirmation_error.getText(), error_message);
	}

	@Test (groups = {"functional", "regression"})
	public void TCRegister03() {
		//Formato de correo electrónico válido

		String error_message = "Please enter a valid email address (Ex: johndoe@domain.com).";

		homePage.goToRegisterLink();
		registerPage.fillOutFormRegister("Fatima", "Vasquez", "fatima.vasquez", "Abcd123*", "Abcd123*");
		registerPage.clickRegister();

		WebElement email_address_error = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.id("email_address-error")));


		Assert.assertEquals(email_address_error.getText(), error_message);
	}


	@Test (groups = {"regression"})
	public void TCRegister04_01() {
		//Contraseña segura

		String error_message = "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";

		homePage.goToRegisterLink();
		registerPage.fillOutFormRegister("Fatima", "Vasquez", "fatima.vasquez.1230@gmail.com", "1234567", "1234567");
		registerPage.clickRegister();
		
		Duration.ofSeconds(Variables.TIME_OUT);

		WebElement password_error = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.id("password-error")));


		Assert.assertEquals(password_error.getText(), error_message);
	}

	@Test (groups = {"regression"})
	public void TCRegister04_02() {
		//Contraseña segura

		String error_message = "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.";

		homePage.goToRegisterLink();
		registerPage.fillOutFormRegister("Fatima", "Vasquez", "fatima.vasquez.1230@gmail.com", "12345678", "12345678");
		registerPage.clickRegister();

		Duration.ofSeconds(Variables.TIME_OUT);
		
		WebElement password_error = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.id("password-error")));


		Assert.assertEquals(password_error.getText(), error_message);
	}

	@Test (groups = {"functional", "integration"})
	public void TCRegister05() {
		//Confirmación de contraseña

		String error_message = "Please enter the same value again.";

		homePage.goToRegisterLink();
		registerPage.fillOutFormRegister("Fatima", "Vasquez", "fatima.vasquez.1230@gmail.com", "Abcd123*", "12345678");
		registerPage.clickRegister();

		WebElement password_error = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.id("password-confirmation-error")));

		Assert.assertEquals(password_error.getText(), error_message);
	}

	@Test (groups = "integration")
	public void TCRegister06() {
		//Correo electrónico único
		String link_text = "click here";

		homePage.goToRegisterLink();
		registerPage.fillOutFormRegister("Fatima", "Vasquez", "fatima.vasquez.123@gmail.com", "Abcd123*", "Abcd123*");
		registerPage.clickRegister();

		WebElement label_message = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.linkText(link_text)));
		Assert.assertEquals(label_message.getText(), link_text);
	}

}
