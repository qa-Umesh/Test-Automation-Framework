package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listners.TestListner.class)
public class LoginTest extends BaseTest{

	

//	@Test(description = "Verfies with valid user is able to login into the applicaiton.", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "LoginTestJsonDataProvider")
//	public void loginJsonTest(User user) {
//
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(),
//				"Umesh kute");
//	}
//
//	@Test(description = "Verfies with valid user is able to login into the applicaiton.", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider",retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
//	public void loginCsvTest(User user) {
//
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(),
//				"Umesh kute");
//	}

	@Test(description = "Verfies with valid user is able to login into the applicaiton.", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
	public void loginTest2(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(),
				"Umesh kute");

	}

}
