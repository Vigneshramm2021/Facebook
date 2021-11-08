package org.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



import io.github.bonigarcia.wdm.WebDriverManager;

public class EnterIntoExcel {

	public static void main(String[] args) throws IOException {
		//metion the path of the excel
		File file=new File("C:\\Users\\vigne\\eclipse-workspace\\FrameWorkClass930\\Excel Sheets\\NewExcelByCode.xlsx");
		//create the workbook
		Workbook workbook=new XSSFWorkbook();
		//create the sheet
		Sheet sheet = workbook.createSheet("Datas");
		
		//to configure the browser
		WebDriverManager.chromedriver().setup();
		//to launch the browser
		WebDriver driver=new ChromeDriver();
		//to open the url
		driver.get("http://demo.automationtesting.in/Register.html");
		
		
		
		//drop down locator
		WebElement Ddown = driver.findElement(By.id("Skills"));
		Select select=new Select(Ddown);
		List<WebElement> options = select.getOptions();
		
		for(int i=0;i<options.size();i++) {
			WebElement Eachoptions = options.get(i);
			String e = Eachoptions.getText();
			Row row=sheet.createRow(i);
			Cell cell=row.createCell(0);
			cell.setCellValue(e);

		}
		FileOutputStream out=new FileOutputStream(file);
		workbook.write(out);
	System.out.println("Done------------------------------------------------------------");
		
	}

}
