package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']//span");
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");
	private static final By SEARCH_RESULT_LOCATOR = By.xpath("//div[contains(@class,'right-block')]/h5//a");
	private static final By ADD_NEW_ADDRESS_LINK_LOCATOR = By.xpath("//a[@title=\"Add my first address\"]");
	private static final By RETURN_TO_HOME_LOCATOR=By.xpath("//a[@title='Return to Home']");

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserNameText() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

	public SearchResultPage searchForProduct(String ProductName) {
		enterText(SEARCH_TEXT_BOX_LOCATOR, ProductName);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);

		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
		return searchResultPage;
	}
	
	public AddressPage goToAddAddressPage() {
		clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);
		AddressPage addressPage = new AddressPage(getDriver());
		return addressPage;
	}
	
	public HomePage returnToHome() {
		clickOn(RETURN_TO_HOME_LOCATOR);
		HomePage homePage = new HomePage(getDriver());
		return homePage;
	}

}
