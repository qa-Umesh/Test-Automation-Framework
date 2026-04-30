package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final By SIZE_DROP_DOWN_LOCATOR = By.id("group_1");

	private static final By ADD_TO_CART_BUTTONG_LOCATOR = By
			.xpath("//button[@type='submit']//span[contains(text(),'Add to cart')]");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath(
			"//a[@href='https://automationpractice.techwithjatin.com/order']//span[contains(text(),'Proceed to checkout')]");
	private static final By IFRAME_LOCATOR = By.xpath("//iframe[contains(@id,'fancybox-frame')]");

	public ProductDetailsPage AddProductToCart() {
		clickOn(ADD_TO_CART_BUTTONG_LOCATOR);
		return new ProductDetailsPage(getDriver());
		
	}
	public OrderPage proceedToCheckOut() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		OrderPage cartPage = new OrderPage(getDriver());
		return cartPage;

	}

	public ProductDetailsPage changeSize(String value) {
		selectValueFromDropdown(SIZE_DROP_DOWN_LOCATOR, value);
		return new ProductDetailsPage(getDriver());

	}

}
