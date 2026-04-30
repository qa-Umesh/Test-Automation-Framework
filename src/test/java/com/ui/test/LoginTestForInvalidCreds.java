package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listners.TestListner.class)
public class LoginTestForInvalidCreds extends BaseTest {

	private static final String EMAIL_ID="tilos23123@ryzid.com";
	private static final String PASSWORD="password";

	private static final String SEARCH_DATA = "";

	@Test(description = "Verfies if the proper error message is shown for the user when they enter invalid credentials", groups = {
			"e2e", "sanity", "Somke" })
	public void inValidLoginJsonTest() {

		assertEquals(homePage.goToLoginPage().doLoginWith(EMAIL_ID,PASSWORD).getUserNameText(), "Authentication failed.");
	}

}
