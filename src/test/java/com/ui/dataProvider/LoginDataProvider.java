package com.ui.dataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name="LoginTestJsonDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		
		Gson gson = new Gson();
		
		File testDataFile = new File(System.getProperty("user.dir")+File.separator+"testData"+File.separator+"loginData.json");
		FileReader fileReader = new FileReader(testDataFile);
		TestData data =gson.fromJson(fileReader, TestData.class);  // de-serialization - converting json object to java object
		
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for(User user:data.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();
		
	}
	
	@DataProvider(name="LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvidor() {
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}
	
	@DataProvider(name="LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvidor() {
		return ExcelReaderUtility.readExcelFile("loginData.xlsx");
	}
}
