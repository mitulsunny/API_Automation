package com.osa.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileManager {
	public static void main(String[] args) {
		Object[][] s = getValue("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx", "JsonData");
		for (Object[] objects : s) {
			for (Object s1 : objects) {
				System.out.println(s1);
			}
		}
		readToExcelByCell("a1");
	}

	public static Object[][] getValue(String filePath, String sheetName) {
		Object[][] value = null;
		DataFormatter formate = new DataFormatter();
		try {
			FileInputStream fileInput = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowSize = sheet.getPhysicalNumberOfRows();
			int colSize = sheet.getRow(0).getLastCellNum();
			value = new Object[rowSize][colSize];
			Iterator<Row> rowIterator = sheet.rowIterator();
			int rowNumber = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int colNumber = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					value[rowNumber][colNumber] = formate.formatCellValue(cell).trim();
					colNumber++;
				}
				rowNumber++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	public static String readToExcelByCell(String cellNumber/* ,String excelFilePath,String sheetName */) {
		String value = null;
		// cellNumber.replace(oldChar, newChar)
		cellNumber = cellNumber.replace(":", "");
		try {
			InputStream file = new FileInputStream(
					"C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx"/* excelFilePath */);
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			XSSFSheet sheetName = workBook.getSheet("JsonData"/* sheetName */);
			CellReference cf = new CellReference(cellNumber);
			Row row = sheetName.getRow(cf.getRow());
			Cell cell = row.getCell(cf.getCol());
			value = cell.getStringCellValue();
			System.out.println("ExcelReadByCell " + "CellNumber is = " + cellNumber + " and the value is = " + value);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}



}
