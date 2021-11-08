package org.Test;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JunitWithBaseClassIntegration extends BaseClass {
	static JunitWithBaseClassIntegration ref = new JunitWithBaseClassIntegration();
	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		ref.chromeBrowserLaunch();
		ref.enterUrl("http://adactinhotelapp.com/index.php");
		ref.maximize();
	}

	@AfterClass
	public static void afterClass() {
		ref.closeAllWindow();
	}

	@Test
	public void login() throws InterruptedException, IOException {
		String username = ref.getData("Datas", 0, 1);
		String password = ref.getData("Datas", 1, 1);

		WebElement txtUsername = ref.findElementById("username");
		ref.sendKeys(txtUsername, username);

		WebElement txtPassword = ref.findElementById("password");
		ref.sendKeys(txtPassword, password);

		WebElement btnLogin = ref.findElementById("login");
		ref.clickButton(btnLogin);

		String location = ref.getData("Datas", 4, 0);
		String hotels = ref.getData("Datas", 4, 1);
		String roomType = ref.getData("Datas", 4, 2);
		String numberOfRooms = ref.getData("Datas", 4, 3);
		String checkInDate = ref.getData("Datas", 4, 4);
		String checkOutDate = ref.getData("Datas", 4, 5);
		String adultsPerRoom = ref.getData("Datas", 4, 6);
		String childernsPerRoom = ref.getData("Datas", 4, 7);

		WebElement dDLocation = ref.findElementById("location");
		ref.dropDowntext(dDLocation, location);
		WebElement dDHotels = ref.findElementById("hotels");
		ref.dropDowntext(dDHotels, hotels);
		WebElement dDRoomType = ref.findElementById("room_type");
		ref.dropDowntext(dDRoomType, roomType);
		WebElement dDnumberofRooms = ref.findElementById("room_nos");
		ref.dropDowntext(dDnumberofRooms, numberOfRooms);
		WebElement txtCheckinDate = ref.findElementById("datepick_in");
		ref.sendKeys(txtCheckinDate, checkInDate);
		WebElement txtCheckoutDate = ref.findElementById("datepick_out");
		ref.sendKeys(txtCheckoutDate, checkOutDate);
		WebElement dDAdultsPerRoom = ref.findElementById("adult_room");
		ref.dropDowntext(dDAdultsPerRoom, adultsPerRoom);
		WebElement dDchildernsperRoom = ref.findElementById("child_room");
		ref.dropDowntext(dDchildernsperRoom, childernsPerRoom);

		WebElement btnSubmit = ref.findElementById("Submit");
		ref.clickButton(btnSubmit);

		WebElement radiobtnClick = ref.findElementById("radiobutton_0");
		ref.clickButton(radiobtnClick);
		WebElement btnContinue = ref.findElementById("continue");
		ref.clickButton(btnContinue);

		String firstName = ref.getData("Datas", 7, 0);
		String lastName = ref.getData("Datas", 7, 1);
		String billingaddress = ref.getData("Datas", 7, 2);
		String creditCardNumeber = ref.getData("Datas", 7, 3);
		String creditCardType = ref.getData("Datas", 7, 4);
		String expiryMonth = ref.getData("Datas", 7, 5);
		String expiryYear = ref.getData("Datas", 7, 6);
		String cvvNumber = ref.getData("Datas", 7, 7);
		WebElement txtFirstName = ref.findElementById("first_name");
		ref.sendKeys(txtFirstName, firstName);
		WebElement txtLastName = ref.findElementById("last_name");
		ref.sendKeys(txtLastName, lastName);
		WebElement txtAddress = ref.findElementById("address");
		ref.sendKeys(txtAddress, billingaddress);
		WebElement txtCCnumber = ref.findElementById("cc_num");
		ref.sendKeys(txtCCnumber, creditCardNumeber);
		WebElement dDCreditCardType = ref.findElementById("cc_type");
		ref.dropDowntext(dDCreditCardType, creditCardType);
		WebElement dDExpiryMonth = ref.findElementById("cc_exp_month");
		ref.dropDowntext(dDExpiryMonth, expiryMonth);
		WebElement dDExpiryYear = ref.findElementById("cc_exp_year");
		ref.dropDowntext(dDExpiryYear, expiryYear);
		WebElement txtCVVnumber = ref.findElementById("cc_cvv");
		ref.sendKeys(txtCVVnumber, cvvNumber);

		WebElement btnBookNow = ref.findElementById("book_now");
		ref.clickButton(btnBookNow);

		ref.threadSleep(10000);
		WebElement generatedOrderId = ref.findElementById("order_no");
		String text = ref.getAttributevalue(generatedOrderId);
		System.out.println(text);
		ref.changeData("Datas", 10, 0, text);
	}

}
