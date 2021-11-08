package org.Test;

import org.openqa.selenium.WebElement;

public class DemoAutomationTestingParentClass {

	public static void main(String[] args) {
		BaseClass ref = new BaseClass();
		ref.chromeBrowserLaunch();
		ref.enterUrl("http://demo.automationtesting.in/Register.html");
		WebElement txtFirstName = ref.findElementByXpath("//input[@placeholder='First Name']");
		ref.sendKeys(txtFirstName, "Vignesh");
		WebElement txtLastName = ref.findElementByXpath("//input[@placeholder='Last Name']");
		ref.sendKeys(txtLastName, "Ram");
		WebElement txtAddress = ref.findElementByXpath("//textarea[@ng-model='Adress']");
		ref.sendKeys(txtAddress, "Canada");
		WebElement txtEmail = ref.findElementByXpath("//input[@ng-model='EmailAdress']");
		ref.sendKeys(txtEmail, "1vigneshram@gmail.com");
		WebElement txtPhonenumber = ref.findElementByXpath("//input[@ng-model='Phone']");
		ref.sendKeys(txtPhonenumber, "9962444941");
		WebElement maleRadio = ref.findElementByXpath("//input[@value='Male']");
		ref.clickButton(maleRadio);
		WebElement cricketCheckBox = ref.findElementById("checkbox1");
		ref.clickButton(cricketCheckBox);
		WebElement MoviesCheckBox = ref.findElementById("checkbox2");
		ref.clickButton(MoviesCheckBox);
		WebElement HockeyCheckBox = ref.findElementById("checkbox3");
		ref.clickButton(HockeyCheckBox);
		WebElement ddSkills = ref.findElementById("Skills");
		ref.dropDowntext(ddSkills, "Java");
		WebElement ddSelectCountry = ref.findElementById("country");
		ref.dropDownbyIndex(ddSelectCountry, 1);
		WebElement ddYear = ref.findElementById("yearbox");
		ref.dropDownAttributeValue(ddYear, "1997");
		WebElement ddMonth = ref.findElementByXpath("//select[@ng-model='monthbox']");
		ref.dropDownAttributeValue(ddMonth, "January");
		WebElement ddDay = ref.findElementById("daybox");
		ref.dropDownAttributeValue(ddDay, "30");
		WebElement txtPassword = ref.findElementById("firstpassword");
		ref.sendKeys(txtPassword,"Superman@123");
		WebElement txtConfirmPassword = ref.findElementById("secondpassword");
		ref.sendKeys(txtConfirmPassword,"Superman@123");
	WebElement btnSubmit = ref.findElementById("submitbtn");
		ref.clickButton(btnSubmit);
	
		
		

	}

}
