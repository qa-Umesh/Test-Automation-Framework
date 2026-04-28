package com.ui.listners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.BaseTest;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListner implements ITestListener {
	private Logger logger = LoggerUtility.getLogger(this.getClass());

//	//ExtentSparkReporter extentSparkReport;
//	ExtentReports extentReport;
//	ExtentTest extentTest;

	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ExtentReportUtility.setUpSparkReprort("report.html");

	}

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.creatExtentTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReportUtility.getExtentTest().log(Status.PASS, result.getMethod().getMethodName());

	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getExtentTest().log(Status.FAIL, result.getMethod().getMethodName());
		ExtentReportUtility.getExtentTest().log(Status.FAIL, result.getThrowable().getMessage());

		Object testclass = result.getInstance();

		BrowserUtility browserUtility = ((BaseTest) testclass).getInstance();
		logger.info("Capturing screenshot for failed tests");

		String screenShotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("Attacting the  screenshot to HTML File");

		ExtentReportUtility.getExtentTest().addScreenCaptureFromPath(screenShotPath);

	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReportUtility.getExtentTest().log(Status.SKIP, result.getMethod().getMethodName());

	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
		ExtentReportUtility.flushReport();

	}

}
