package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {
	
	protected By inputSearch = By.id("search");
	protected By linkItemSearch = By.xpath("//div[@class='product-item-info']/a");
	protected By sizeXS = By.xpath("//div[@option-id='166']");
	protected By sizeS = By.xpath("//div[@option-id='167']");
	protected By sizeM = By.xpath("//div[@option-id='168']");
	protected By sizeL = By.xpath("//div[@option-id='169']");
	protected By sizeXL = By.xpath("//div[@option-id='170']");
	protected By colorGrey = By.xpath("//div[@option-id='52']");
	protected By colorOrange = By.xpath("//div[@option-id='56']");
	protected By colorPurple = By.xpath("//div[@option-id='57']");
	protected By colorRed = By.xpath("//div[@option-id='58']");
	protected By colorBlack = By.xpath("//div[@option-id='49']");
	protected By btnAddToCart = By.id("product-addtocart-button");
	protected By inputQty = By.id("qty");
	protected By btnMyCart = By.xpath("//a[contains(@class,'action showcart')]");
	protected By btnCheckout =  By.id("top-cart-btn-checkout");
	protected By btnDeleteItem =  By.xpath("//a[@class='action delete']");
	protected By btnConfirmDelete =  By.xpath("//button[@class='action-primary action-accept']");
	protected By inputModifyQty = By.xpath("//input[@class='item-qty cart-item-qty']");	
	protected By btnUpdateQty =  By.xpath("//button[@class='update-cart-item']");
	protected By inputCustomerEmail =  By.id("customer-email");
	protected By inputFirstname =  By.name("firstname");
	protected By inputLastname =  By.name("lastname");
	protected By inputStreet =  By.name("street[0]");
	protected By inputCity =  By.name("city");
	protected By inputPostCode =  By.name("postcode");
	protected By inputState =  By.name("region_id");
	protected By inputCountry =  By.name("country_id");
	protected By inputTelephone =  By.name("telephone");
	protected By inputShippingMethod =  By.name("ko_unique_1");
	protected By btnNext = By.xpath("//button[@class='button action continue primary']");
	protected By btnPlaceOrder = By.xpath("//button[@class='action primary checkout']");
	

	//protected By btnConfirmDelete =  By.xpath("//footer/button[2]");
	
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void searchItems(String product) {
        typeAndEnter(inputSearch, product);
    }
	
	public void selectItems() {
        click(linkItemSearch);
    }
	
	public void addToCart() {
		submit(btnAddToCart);
	}
	
	public void addQty(String qty) {
        find(inputQty).clear();
        type(inputQty, qty);
    }
	
	public void selectSize(String size) {
		if(size == "XS"){
			click(sizeXS);
		}
		if(size == "S"){
			click(sizeS);
		}
		if(size == "M"){
			click(sizeM);
		}
		if(size == "L"){
			click(sizeL);
		}
		if(size == "XL"){
			click(sizeXL);
		}
	}
	
	public void selectColor(String color) {
		if(color == "grey"){
			click(colorGrey);
		}
		if(color == "purple"){
			click(colorPurple);
		}
		if(color == "red"){
			click(colorRed);
		}
		if(color == "orange"){
			click(colorOrange);
		}
		if(color == "black"){
			click(colorBlack);
		}
	}
	
	public void addProduct(String nameProduct, String qty, String size, String color) {
		searchItems(nameProduct);
		selectItems();
		addQty(qty);
		selectSize(size);
		selectColor(color);
		addToCart();
	}
	
	public void gotoMyCart() {
        click(btnMyCart);
    }
	
	public void deleteItemCart() {
        click(btnDeleteItem);
    }
	
	public void confirmDeleteItemCart() {
        click(btnConfirmDelete);
    }
	
	public void gotoCheckoutPage() {
        click(btnCheckout);
    }
	
	public void modifyQty(String qty) {
		type(inputModifyQty, "");
        type(inputModifyQty, qty);
        click(btnUpdateQty);
    }
	
	public void completeShippingAddress(String email, String firstname, String lastname, String street, String city, String state, String postcode, String country, String telephone) {
		
		if (isDisplay(inputCustomerEmail)){
			type(inputCustomerEmail, email);
		}
		
		if (isDisplay(inputFirstname)) {
			type(inputFirstname, firstname);
			type(inputLastname, lastname);
			type(inputStreet, street);
			type(inputCity, city);
			selectByValue(inputState, state);
			type(inputPostCode, postcode);
			selectByValue(inputCountry, country);
			type(inputTelephone, telephone);	
		}
		click(inputShippingMethod);
		submit(btnNext);
	}
	
	public void placeOrder() {
		submit(btnPlaceOrder);
			
	}
	
}
