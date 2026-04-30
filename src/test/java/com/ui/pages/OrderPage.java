package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class OrderPage extends BrowserUtility {

	public OrderPage(WebDriver driver) {
		super(driver);
	}

	private static final By SUMMARY_PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By
			.xpath("//a[@href=\"https://automationpractice.techwithjatin.com/order?step=1\"]");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By
			.xpath("//button[@type=\"submit\"]//span[contains(text(),'Proceed to checkout')]");
	private static final By TERMS_CONDITIONS_CHECKBOX_LOCATOR = By.id("uniform-cgv");
	private static final By NO_PAYMENT_MODULE_LOCATOR = By.xpath("//p[contains(@class,'alert-warning')]");
	private static final By CONFIRM_CHECKOUT_BUTTON_LOCATOR = By
			.xpath("//span[contains(text(),'Proceed to checkout')]");

	public OrderPage confirmSummary() {
		scrollIntoElemenetView(SUMMARY_PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		clickOn(SUMMARY_PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new OrderPage(getDriver());
	}

	public OrderPage confirmAddress() {
		scrollIntoElemenetView(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new OrderPage(getDriver());

	}

	public OrderPage AgreeToTermsConditions() {
		clickOn(TERMS_CONDITIONS_CHECKBOX_LOCATOR);
		scrollIntoElemenetView(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new OrderPage(getDriver());

	}

	public String getConfirmationMessage() {
		return getVisibleText(NO_PAYMENT_MODULE_LOCATOR);

	}

}
