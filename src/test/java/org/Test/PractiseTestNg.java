package org.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiseTestNg {
	WebDriver driver;
	@BeforeClass
	private void Launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@Parameters({"a","b"})
	@Test
	private void LoginDetails(String aa,String bb) {
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername.sendKeys(aa);
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys(bb);
	}
}
