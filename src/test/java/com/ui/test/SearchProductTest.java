package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listners.TestListner.class)
public class SearchProductTest extends BaseTest {

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed Summer Dress";

	@BeforeMethod(description = "Valid user is logged into the application")
	public void setUp() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("tilos23123@ryzid.com", "password");
	}

	@Test(description = "Verify if the logged in user is able to search the product for a product and result correct product are displayed.", groups = {
			"e2e", "sanity", "Somke" })
	public void verifyProductSearchTest() {
		boolean actualResult = myAccountPage.searchForProduct(SEARCH_TERM)
				.isSearchTermPresentInProductList(SEARCH_TERM);
		assertEquals(actualResult, true);

	}

}
