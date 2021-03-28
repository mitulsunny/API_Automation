package com.osa.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileManager2 {

	public static void main(String[] args) {
		System.out.println(readToExcelByCell("B2","‪‪C:\\Users\\aakbu\\Desktop\\test.xlsx","Sheet1"));
	}
	
	
	
	
	
	public static String readToExcelByCell(String cellNumber,String path,String SheetName) {
		String value = null;
		// cellNumber.replace(oldChar, newChar)
		cellNumber = cellNumber.replace(":", "");
		try {
			FileInputStream file = new FileInputStream(new File(path));
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			XSSFSheet sheetName = workBook.getSheet(SheetName);
			CellReference cf = new CellReference(cellNumber);
			Row row = sheetName.getRow(cf.getRow());
			Cell cell = row.getCell(cf.getCol());
			value = cell.getStringCellValue();
			// System.out.println(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	
	
	
}
