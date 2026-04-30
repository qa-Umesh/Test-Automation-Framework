package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;

public class ProductCheckOutTest extends BaseTest {

	private static final String SEARCH_TERM = "Printed Summer Dress";

	private SearchResultPage searchResultpage;

	@BeforeMethod(description = "user logs into the application and searches for a product")
	public void setUp() {
		searchResultpage = homePage.goToLoginPage().doLoginWith("tilos23123@ryzid.com", "password")
				.searchForProduct(SEARCH_TERM);

	}

	@Test(description = "Verify if the user is able to buy a dress. ", groups = { "e2e", "Smoke",
			"sanity" }, retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
	public void checkOutTest() {

		String orderConfirmation = searchResultpage.clickOnTheProductAtIndex(0).changeSize("1").AddProductToCart()
				.proceedToCheckOut().confirmSummary().confirmAddress().AgreeToTermsConditions()
				.getConfirmationMessage();

		assertEquals(orderConfirmation, "No payment modules have been installed.");
	}

}
