package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;
import com.github.javafaker.PhoneNumber;

public abstract class BrowserUtility {

	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private WebDriverWait wait;
	private JavascriptExecutor js;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching browser for " + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));

		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));

		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching browser for " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));

			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));

			}
		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));

			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));

			}
		}
	}

	// redirect to website
	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize(); // Method chaining
	}

	public void clickOn(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("finding the element with the locator" + locator);
		element.click();
		logger.info("element found and performing click ");

	}

	public void clickOn(WebElement element) {
		logger.info("element found and performing click ");
		element.click();

	}

	public void javaScriptClick(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		js = (JavascriptExecutor) driver.get();
		js.executeScript("arguments[0].click();", element);

	}

	public void enterText(By locator, String textToEnter) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("finding the element with the locator" + locator);
		element.sendKeys(textToEnter);
		logger.info("element found and entering text " + textToEnter);

	}

	public void selectValueFromDropdown(By dropdownLocator, String value) {
		logger.info("finding the element with the locator" + dropdownLocator);
		WebElement element=driver.get().findElement(dropdownLocator);
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
		Select select = new Select(element);
		logger.info("selecting the option " + value);
		select.selectByValue(value);

	}

	public void selectVisibleTextFromDropdown(By dropdownLocator, String textToSelect) {
		logger.info("finding the element with the locator" + dropdownLocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));
		Select select = new Select(element);
		logger.info("selecting the option " + textToSelect);

		select.selectByVisibleText(textToSelect);

	}

	public void clearText(By textBoxLocator) {
		logger.info("finding the element with the locator" + textBoxLocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
		logger.info("Element found and clearing the text box field ");
		element.clear();
	}

	public void enterSpecialKey(By locator, Keys key) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("finding the element with the locator" + locator);
		element.sendKeys(key);
		logger.info("element found and now enter special key " + key);

	}

	public String getVisibleText(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("finding the element with the locator" + locator);
		logger.info("returning visible text " + element.getText());
		return element.getText();
	}

	public String getVisibleText(WebElement element) {
		logger.info("Returning the Visible Text", element.getText());

		return element.getText();
	}

	public void scrollIntoElemenetView(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		js = (JavascriptExecutor) driver.get();
		logger.info("scroll into element to view " + element);
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth',block:'center'})", element);

	}

	public void hoverAndClickAction(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Actions action = new Actions(getDriver());
		logger.info("hover to element and performing click action " + element);
		action.moveToElement(element).click().perform();
	}

	public void switchToFrame(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.get().switchTo().frame(element);

	}

	public void switchToDefaultFrame() {
		driver.get().switchTo().defaultContent();
	}

	public List<String> getAllVisibleText(By locator) {
		List<WebElement> listOfElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		logger.info("Element found and printing the list of Elements.");

		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : listOfElement) {
			visibleTextList.add(getVisibleText(element));
			return visibleTextList;

		}
		return null;
	}

	public List<WebElement> getAllElements(By locator) {
//		List<WebElement> elementList = driver.get().findElements(locator);//
		List<WebElement> listOfElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		logger.info("Element found and printing the list of Elements.");

		return listOfElement;
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenShot = (TakesScreenshot) driver.get();
		File screenShotData = screenShot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "." + File.separator + "ScreenShots" + File.separator + name + ".png";

		File file = new File(path);
		try {
			FileUtils.copyFile(screenShotData, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}
}
