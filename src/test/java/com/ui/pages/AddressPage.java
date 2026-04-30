package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By COMPANY_TEXT_BOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXT_BOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXT_BOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXT_BOX_LOCATOR = By.id("city");
	private static final By POST_CODE_TEXT_BOX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_TEXT_BOX_LOCATOR = By.id("phone");
	private static final By PHONE_NUMBER_TEXT_BOX_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONAL_TEXT_BOX_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_TEXT_BOX_LOCATOR = By.id("alias");
	private static final By STATE_DROPDOWN_LOCATOR = By.xpath("//div[@class='selector']//select[@id=\"id_state\"]");
	private static final By SAVE_ADDRESS_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_HEADING=By.tagName("H3");

	public AddressPage(WebDriver driver) {
		super(driver);
	}

	public String saveAddress(AddressPOJO addressPojo) {
		enterText(COMPANY_TEXT_BOX_LOCATOR, addressPojo.getCompany());
		enterText(ADDRESS1_TEXT_BOX_LOCATOR, addressPojo.getAddressLine1());
		enterText(ADDRESS2_TEXT_BOX_LOCATOR, addressPojo.getAddress2Line());
		enterText(CITY_TEXT_BOX_LOCATOR, addressPojo.getCity());
		enterText(POST_CODE_TEXT_BOX_LOCATOR, addressPojo.getPostCode());
		enterText(HOME_PHONE_TEXT_BOX_LOCATOR, addressPojo.getHomePhone());
		enterText(PHONE_NUMBER_TEXT_BOX_LOCATOR, addressPojo.getMobileNo());
		enterText(ADDITIONAL_TEXT_BOX_LOCATOR, addressPojo.getOtherInformation());
		clearText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR, addressPojo.getAddressAlias());
		selectValueFromDropdown(STATE_DROPDOWN_LOCATOR, addressPojo.getState());
		clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
		String newAddress=getVisibleText(ADDRESS_HEADING);
		return newAddress;

	}
}
