package org.Test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Junits {
	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void afterClass() {
		driver.quit();
	}

	
	@Test
	public void login() {
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys("VickyRam");
		String name = txtUserName.getAttribute("value");
		Assert.assertEquals("VerifyName","VickyRam", name);
		
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("62F3E2");
		String password = txtPassword .getAttribute("value");
		Assert.assertEquals("VerifyPassword","62F3E2",password);
		
		WebElement btnClick = driver.findElement(By.id("login"));
		btnClick.click();
	}

}
