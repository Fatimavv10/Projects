package com.magento.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.magento.utils.Variables;

public class LoginTest extends BaseTest {


	@Test (groups = {"regression", "integration"})
	public void TCLogin01() {
		//Inicio de sesión exitoso

		String expected_tittle = "Home Page";

		homePage.goToLoginLink();
		loginPage.fillOutFormLogin("fatima.vasquez123@gmail.com", "Abcd123*");
		loginPage.clickSignin();

		String actual_tittle = driver.getTitle();
		assertEquals(actual_tittle,expected_tittle);

	}

	@Test (groups = "functional")
	public void TCLogin02() {
		//Inicio de sesión con credenciales incorrectas

		String expected_message = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";

		homePage.goToLoginLink();
		loginPage.fillOutFormLogin("fatima.vasquez123@hotmail.com", "Abcd12sd3*");
		loginPage.clickSignin();

		WebElement actual_message = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'sign-in')]")));

		assertEquals(actual_message.getText(),expected_message);
	}

	@Test (groups = "functional")
	public void TCLogin03() {
		//Credenciales en blanco

		String expected_message = "A login and a password are required.";

		homePage.goToLoginLink();
		loginPage.fillOutFormLogin("","");
		loginPage.clickSignin();

		WebElement actual_message = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'login')]")));

		assertEquals(actual_message.getText(),expected_message);
	}

	@Test (groups = "regression")
	public void TCLogin04() {
		//Correo electrónico no	registrado

		String expected_message = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";

		homePage.goToLoginLink();
		loginPage.fillOutFormLogin("fatima@gmal.com","asdasdasd");
		loginPage.clickSignin();

		WebElement actual_message = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'sign-in')]")));

		assertEquals(actual_message.getText(),expected_message);
	}

	@Test (groups = {"functional", "integration"})
	public void TCLogin05() {
		//Contraseña olvidada
		String email = "fatima.vasquez123@gmail.com";

		String expected_message = "If there is an account associated with " + email + " you will receive an email with a link to reset your password.";

		homePage.goToLoginLink();
		loginPage.clickForgotPassword();
		loginPage.fillOutFormForgotPassword(email);
		loginPage.clickReset();

		WebElement actual_message = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'account associated')]")));
		assertEquals(actual_message.getText(),expected_message);
	}


}
