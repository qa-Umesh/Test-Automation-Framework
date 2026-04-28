package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	
	public static Iterator<User> readExcelFile(String fileName) {

		File loginDatafile = new File(
				System.getProperty("user.dir") + File.separator + "testData" + File.separator + fileName);
		
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		List<User> userList = null;
		Iterator<Row> rowIterator;
		Row row;
		Cell emailAddress;
		Cell password;
		User user;

		try {
			workbook = new XSSFWorkbook(loginDatafile);
			sheet = workbook.getSheet("sheet1");

			rowIterator = sheet.iterator();
			rowIterator.next(); // skipping row 0 because it is header

			userList = new ArrayList<User>();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddress = row.getCell(0);
				password = row.getCell(1);

				user = new User(emailAddress.toString(), password.toString());
				userList.add(user);
				workbook.close();
				}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();

	}

}
