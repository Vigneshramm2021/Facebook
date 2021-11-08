package org.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*import java.awt.AWTException;
import java.awt.Robot;*/
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;

	// launch the chrome browser
	public void chromeBrowserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// launch the Firefox browser
	public void MozillaFirefoxBrowserLaunch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	// launch the Edge browser
	public void EdgeBrowserLaunch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	// URL
	public void enterUrl(String data) {
		driver.get(data);
	}

	// Maximize Window
	public void maximize() {
		driver.manage().window().maximize();
	}

	// Insert value in textbox
	public void sendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	// click button
	public void clickButton(WebElement element) {
		element.click();
	}

	// Click ok in Alert
	public void alertAccept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	// Click cancel in Alert
	public void alertCancel() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	// Sendkeys-prompt alert
	public void sendKeysAlert(String data) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(data);
		al.accept();
	}

	// Get text from alert
	public String getTextAlert() {
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		return text;
	}

	// Get the text from the WebPage
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// Get the inserted value from the TextBox
	public String getAttributevalue(WebElement element) {
		String data = element.getAttribute("value");
		return data;
	}

	// close all windows
	public void closeAllWindow() {
		driver.quit();
	}

	// Close Current Window
	public void closeCurrentWindow() {
		driver.close();
	}

	// Get the title
	public String getTitle() {
		String data = driver.getTitle();
		return data;
	}

	// Get the entered URL
	public String getCurrentUrl() {
		String data = driver.getCurrentUrl();
		return data;
	}

	// find Element By id
	public WebElement findElementById(String data) {
		WebElement findElement = driver.findElement(By.id(data));
		return findElement;
	}

	// find Element by Xpath
	public WebElement findElementByXpath(String data) {
		WebElement findElement = driver.findElement(By.xpath(data));
		return findElement;
	}

	// find Element by name
	public WebElement findElementByName(String data) {
		WebElement findElement = driver.findElement(By.name(data));
		return findElement;
	}

	// find Element by Classname
	public WebElement findElementByClassName(String data) {
		WebElement findElement = driver.findElement(By.className(data));
		return findElement;
	}

	public void threadSleep(long data) throws InterruptedException {
		Thread.sleep(data);
	}

	// MouseOverAction-Move To element
	public void MouseHoverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// Drag and Drop
	public void dragandDrop(WebElement elementSource, WebElement elementDestination) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(elementSource, elementDestination).perform();
	}

	// rightClick-contextClick
	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	// DoubleClick
	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// DropDown option by Text
	public void dropDowntext(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}

	// DropDown option Deselect Visible Text
	public void dropDownDeSelectVisbileText(WebElement element, String data) {
		Select select = new Select(element);
		select.deselectByVisibleText(data);
		;
	}

	// DropDown option by value
	public void dropDownAttributeValue(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByValue(data);
	}

	// DropDown option Deselect value
	public void dropDownDeSelectValue(WebElement element, String data) {
		Select select = new Select(element);
		select.deselectByValue(data);
	}

	// DropDown option by Index
	public void dropDownbyIndex(WebElement element, int data) {
		Select select = new Select(element);
		select.selectByIndex(data);
	}

	// DropDown option DeSelect Index
	public void dropDownDeSelectIndex(WebElement element, int data) {
		Select select = new Select(element);
		select.deselectByIndex(data);
	}

	// Get DropDown All option
	public List<WebElement> getDropDownOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	// Deselect All DropDown
	public void deselectAllDropDown(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	// Get All selected Option
	public List<WebElement> getDropDownAllOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	// Get first selected Option
	public String getDropDownFirstSelectedOptions(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}

	// Check multiple is selected in drop down
	public boolean isDropDownMutipleSelected(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();

		return multiple;
	}

	// JavaScript executor - SetAttribute -insert value
	public void jsExecutorSetAttribute(String data, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	// JavaScript executor - getAttribute -get value
	public String jsExecutorgetAttribute(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("return arguments[0].setAttribute('value')", element);
		return (String) executeScript;
	}

	// JavaScript executor - Click
	public void jsExecutorClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("return arguments[0].click()", element);
	}

	// Scroll down -Js executor
	public void jsExecutorScrollDown(WebElement downelement) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("return arguments[0].scrollIntoView(true)", downelement);
	}

	// Scroll Up -Js executor
	public void jsExecutorScrollUp(WebElement upelement) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("return arguments[0].scrollIntoView(false)", upelement);
	}

	// Current window memory address
	public String currentWindowgetHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	// All window memory address
	public Set<String> AllWindowgetHandle() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	// Switch to different window-WindowId
	public void diffWindowWindowId(String WindowId) {
		driver.switchTo().window(WindowId);
	}

	// Switch to different window-Title
	public void diffWindowTitle(String Title) {
		driver.switchTo().window(Title);
	}

	// Switch to different window-Url
	public void diffWindowUrl(String Url) {
		driver.switchTo().window(Url);
	}

	// Read value from excel and find out it's a string number or date
	public String getData(String SheetName, int rownumber, int cellnumber) throws IOException {
		String data = null;
		File file = new File(
				"C:\\Users\\vigne\\eclipse-workspace\\FrameWorkClass930\\Excel Sheets\\Data to Sheet.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rownumber);
		Cell cell = row.getCell(cellnumber);
		int cellType = cell.getCellType();
		if (cellType == 1) {
			data = cell.getStringCellValue();
		}
		if (cellType == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat("dd/mm/yyyy");
				data = s.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				data = String.valueOf(l);
			}
		}
		return data;
	}

	// Modify the value in Excel
	public void changeData(String SheetName, int rownumber, int cellNumber, String data) throws IOException {
		File file = new File(
				"C:\\Users\\vigne\\eclipse-workspace\\FrameWorkClass930\\Excel Sheets\\Data to Sheet.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.createRow(rownumber);
		Cell cell = row.createCell(cellNumber);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

}
