package com.ui.test;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;
import com.utility.LoggerUtility;

public class BaseTest {

	protected HomePage homePage;
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLamdaTest;

	@Parameters({ "browser", "isLamdaTest", "isheadLess" })
	@BeforeMethod(description = "Load the Home page of the Website")
	public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLamdaTest,
			@Optional("false") boolean isheadLess, ITestResult result) {

		this.isLamdaTest = isLamdaTest;
		WebDriver lamdaDriver;
		if (isLamdaTest) {
			lamdaDriver = LamdaTestUtility.intializedLambadTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lamdaDriver);

		} else {
			logger.info("Load the Home page of the Website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isheadLess);
		}

	}

	@AfterMethod
	public void tearDown() {
		if (isLamdaTest) {
			LamdaTestUtility.quiteSession();
		} else {
			homePage.quite(); // local machine session

		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

}
