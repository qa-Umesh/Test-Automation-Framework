package com.ui.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;

public class MyRetryAnalyzer implements IRetryAnalyzer {

//	private static final int MAX_NO_OF_ATTEMPTS = Integer
//			.parseInt(PropertiesUtil.readProperties(Env.QA, "MAX_NO_OF_ATTEMPTS"));  // reading from properties file
	
	private static final int MAX_NO_OF_ATTEMPTS = JSONUtility.readJSON(Env.QA).getMAX_NO_OF_ATTEMPTS();  // reading form JSON file
	private static int count = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (count <= MAX_NO_OF_ATTEMPTS) {
			count++;
			return true;
		}
		return false;
	}

}
