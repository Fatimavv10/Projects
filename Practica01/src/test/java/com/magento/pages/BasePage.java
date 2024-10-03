package com.magento.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.magento.tests.BaseTest;
import com.magento.utils.Variables;

public class BasePage extends BaseTest  {

	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
	}

	public void visit() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Variables.TIME_OUT));
		driver.get(Variables.BASE_URL);
	}

	public WebElement find(By locator) {
		return driver.findElement(locator);
	}

	public void type(By locator, String text) {
		find(locator).sendKeys(text);
	}

	public void click(By locator) {
		find(locator).click();
	}

	public void submit(By locator) {
		find(locator).submit();
	}
	
	public void typeAndEnter(By element, String text) {
        find(element).sendKeys(text, Keys.ENTER);
    }

	public void selectByValue(By element, String text) {
        Select dropDrown = new Select(find(element));
        dropDrown.selectByValue(text);
    }
	
	public boolean isDisplay(By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}

	
