package org.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgAdactinHotel {
	WebDriver driver;

	@BeforeClass
	private void Launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}

	@Parameters({"Username","Password"})
	@Test(priority = 0)
	private void LoginDetails(String Uname,String Upass) {
		WebElement txtUsername = driver.findElement(By.id("username"));
		txtUsername.sendKeys(Uname);
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys(Upass);
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
	}
	
	@Parameters({"Location","Hotels","Roomtype","NosofRooms","Datein","Dateout","Adults","Children"})
	@Test(priority = 1)
	private void SearchHotel(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8) {
		WebElement dDLocation = driver.findElement(By.id("location"));
		Select select = new Select(dDLocation);
		select.selectByVisibleText(s1);
		
		WebElement dDHotels = driver.findElement(By.id("hotels"));
		Select select1 = new Select(dDHotels);
		select1.selectByVisibleText(s2);
		
		WebElement dDRoom_Type = driver.findElement(By.id("room_type"));
		Select select2 = new Select(dDRoom_Type);
		select2.selectByVisibleText(s3);
		
		WebElement dDnumOfRooms = driver.findElement(By.id("room_nos"));
		Select select3 = new Select(dDnumOfRooms);
		select3.selectByVisibleText(s4);
		
		WebElement txtDate_in = driver.findElement(By.id("datepick_in"));
		txtDate_in.sendKeys(s5);
		
		WebElement txtDate_out = driver.findElement(By.id("datepick_out"));
		txtDate_out.sendKeys(s6);
		
		WebElement dDnumOfAdults = driver.findElement(By.id("room_nos"));
		Select select4 = new Select(dDnumOfAdults);
		select4.selectByVisibleText(s7);
		
		WebElement dDnumOfChildrens = driver.findElement(By.id("child_room"));
		Select select5 = new Select(dDnumOfChildrens);
		select5.selectByVisibleText(s8);
		
		WebElement btnSearch = driver.findElement(By.id("Submit"));
		btnSearch.click();
	}

	@Test(priority = 2)
	private void SelectHotel() {
		WebElement btnRadio = driver.findElement(By.id("radiobutton_0"));
		btnRadio.click();
		WebElement btnContinue = driver.findElement(By.id("continue"));
		btnContinue.click();
	}

	@Parameters({"fname","lname","add","cc","type","mnth","yr","cvv"})
	@Test(priority = 3)
	private void BookAHotel(String f1,String f2,String f3,String f4,String f5,String f6,String f7,String f8) throws InterruptedException {
		WebElement txtFirstName = driver.findElement(By.id("first_name"));
		txtFirstName.sendKeys(f1);

		WebElement txtLastName = driver.findElement(By.id("last_name"));
		txtLastName.sendKeys(f2);

		WebElement txtBillingAddress = driver.findElement(By.id("address"));
		txtBillingAddress.sendKeys(f3);

		WebElement txtCCNumber = driver.findElement(By.id("cc_num"));
		txtCCNumber.sendKeys(f4);

		WebElement dDCreditCardType = driver.findElement(By.id("cc_type"));
		Select select6 = new Select(dDCreditCardType);
		select6.selectByVisibleText(f5);

		WebElement cCMonth = driver.findElement(By.id("cc_exp_month"));
		Select select7 = new Select(cCMonth);
		select7.selectByVisibleText(f6);

		WebElement cCYear = driver.findElement(By.id("cc_exp_year"));
		Select select8 = new Select(cCYear);
		select8.selectByVisibleText(f7);

		WebElement txtCVV = driver.findElement(By.id("cc_cvv"));
		txtCVV.sendKeys(f8);

		WebElement btnBook = driver.findElement(By.id("book_now"));
		btnBook.click();

		Thread.sleep(10000);

		WebElement orderNumber = driver.findElement(By.id("order_no"));
		String text = orderNumber.getAttribute("value");
		System.out.println(text);

	}

	@AfterClass
	private void close() {
		driver.quit();
	}

}
