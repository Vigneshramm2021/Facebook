package org.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException {
		// Mention the path of the excel sheet
		File file = new File(
				"C:\\Users\\vigne\\eclipse-workspace\\FrameWorkClass930\\Excel Sheets\\Data from Excel.xlsx");

		// Get the objects,char,audio,video,img
		FileInputStream stream = new FileInputStream(file);

		// Mention the workbook-collection of sheets
		Workbook workbook = new XSSFWorkbook(stream);

		// Get the Sheet
		Sheet sheet = workbook.getSheet("Datas");

		// TO print the rows and cells
		// To iterate over the rows
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);

			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				// System.out.println(cell);
				int type = cell.getCellType();
				// System.out.println(cellType);
				if(type==1) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				}

				if (type == 0) {
					
					if(DateUtil.isCellDateFormatted(cell)) {
						 
							Date date = cell.getDateCellValue();
							// System.out.println(date);
							SimpleDateFormat dateformats = new SimpleDateFormat("dd-MMM-yy");
							String data = dateformats.format(date);
							System.out.println(data);

						
					}
					else {
						double numericCellValue = cell.getNumericCellValue(); 
						  long d = (long)
						  numericCellValue; String valueOf = String.valueOf(d);
						  System.out.println(valueOf);
						  } 
					
					
			}
		}
	}
	}
}


