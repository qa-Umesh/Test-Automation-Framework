package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class LoginPage extends BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static final By EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@id='email']");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.xpath("//input[@id='passwd']");
	private static final By SUMBIT_BUTTON_LOCATOR = By.xpath("//button[@id='SubmitLogin']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWith(String emailAddress, String password) {
		logger.info("Login with emailIds " + emailAddress + " and Password " + password);
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUMBIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}

}
