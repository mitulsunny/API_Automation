package com.osa.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileManager {
	
	public static void main(String[] args) {
		String value=readExcelFile("myTestData.xlsx","A3");
		System.out.println(value);
	}
	public static String readExcelFile(String fileName,String cellNumber) {
		String value = null;
		cellNumber = cellNumber.replace(":", "");
		try{
			InputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\"+fileName);
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			XSSFSheet sheetName = workBook.getSheet("Sheet1");
			CellReference cf = new CellReference(cellNumber);
			Row row = sheetName.getRow(cf.getRow());
			Cell cell = row.getCell(cf.getCol());
			value = cell.getStringCellValue();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

}
