package com.magento.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.magento.utils.Variables;

public class OrderTest extends BaseTest {
	
	@Test (groups = {"regression"})
	public void TCOrder01() {
		//Añadir productos al carrito
		String expected_message = "shopping cart";
		
		homePage.goToLoginLink();
		loginPage.fillOutFormLogin("fatima.vasquez123@gmail.com", "Abcd123*");
		loginPage.clickSignin();
		
		//Item01
		cartPage.addProduct("Jade Yoga Jacket", "2", "S", "grey");
		
		//Item02
		cartPage.addProduct("Chloe Compete Tank", "3", "M", "red");
		
		//Item03
		cartPage.addProduct("Gwyn Endurance Tee", "1", "L", "black");
		
		WebElement actual_message = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("shopping cart")));
		
		assertEquals(actual_message.getText(), expected_message);
		
	}
	
	@Test (groups = {"regression"})
	public void TCOrder02() {
		//Eliminar productos del carrito
	
		homePage.goToLoginLink();
		loginPage.fillOutFormLogin("fatima.vasquez123@gmail.com", "Abcd123*");
		loginPage.clickSignin();
		cartPage.addProduct("Jade Yoga Jacket", "2", "S", "grey");
		cartPage.gotoMyCart();
		cartPage.deleteItemCart();
		cartPage.confirmDeleteItemCart();
		Duration.ofSeconds(Variables.TIME_OUT);
		
	}
	
	@Test (groups = {"functional", "integration"})
	public void TCOrder03() {
		//Modificar cantidad de productos en el carrito
		
		homePage.goToLoginLink();
		loginPage.fillOutFormLogin("fatima.vasquez123@gmail.com", "Abcd123*");
		loginPage.clickSignin();
		cartPage.addProduct("Jade Yoga Jacket", "2", "S", "grey");
		cartPage.gotoMyCart();
		cartPage.modifyQty("4");	
	}
	
	@Test (groups = {"functional", "integration"})
	public void TCOrder04() {
		//Creación de orden
		
		//String expected_message = "Your order number is:";
		
		homePage.goToLoginLink();
		loginPage.fillOutFormLogin("fatima.vasquez20@gmail.com", "Abcd123*");
		loginPage.clickSignin();
		
		//Item01
		cartPage.addProduct("Jade Yoga Jacket", "2", "S", "grey");
		
		//Item02
		cartPage.addProduct("Chloe Compete Tank", "3", "M", "red");
		
		//Item03
		cartPage.addProduct("Gwyn Endurance Tee", "1", "L", "black");
		
		cartPage.gotoMyCart();
		cartPage.gotoCheckoutPage();
		cartPage.completeShippingAddress("fatima.vasquez20@gmail.com", "Fatima", "Vasquez", "Los Andes #123", "Chiclayo", "43", "12345-6789", "US", "98562369");
		cartPage.placeOrder();
		
		//WebElement actual_message = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='checkout-success']/p")));
		
		//assertEquals(actual_message.getText(), expected_message);
		
	}
	
}
