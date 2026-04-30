package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listners.TestListner.class)
public class LoginTestForInvalidCreds extends BaseTest {

	private static final String EMAIL_ID="umeskute453@gmail.com";
	private static final String PASSWORD="password";


	@Test(description = "Verfies if the proper error message is shown for the user when they enter invalid credentials", groups = {
			"e2e", "sanity", "Somke" })
	public void inValidLoginJsonTest() {

		assertEquals(homePage.goToLoginPage().doLoginWith(EMAIL_ID,PASSWORD).getUserNameText(), "Authentication failed.");
	}

}
