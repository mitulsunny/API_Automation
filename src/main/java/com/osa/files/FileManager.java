package com.osa.files;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class FileManager {

	public static void main(String[] args) {
		Object[][] ob=getData("C:\\Users\\aakbu\\Desktop\\Class\\Selenium.xlsx","personal");
		for(Object[] datas:ob) {
			for(Object data:datas) {
				System.out.println(data);
			}
			
		}
		
		
		
	}
	
	
//	public static void main(String[] args) {
//		Object [][]s=getValue("‪‪C:\\Users\\aakbu\\Desktop\\Class\\Selenium.xlsx","personal");
//		for (Object[] objects :s ) {
//			for (Object s1 : objects) {
//				System.out.println(s1);
//			}	
//		}
//		
//	//	System.out.println(readToExcelByCell("A3","‪‪C:\\Users\\aakbu\\Desktop\\Class\\Selenium.xlsx","personal"));
//		
//	}
	public static Object[][] getData(String path,String sname) {
		Object [][] value=null;
		DataFormatter dr=new DataFormatter();
		try {
			FileInputStream fs= new FileInputStream(new File(path));
			XSSFWorkbook wb=new XSSFWorkbook(fs);
			XSSFSheet st=wb.getSheet(sname);
						int rowsize =st.getPhysicalNumberOfRows();
						int colsize	=st.getRow(0).getLastCellNum();
						value=new Object[rowsize][colsize];
						
						Iterator<Row> rowiterate=st.rowIterator();
						int rownumber=0;
						while(rowiterate.hasNext()) {
							Row row=rowiterate.next();
							Iterator<Cell> celliterate= row.cellIterator();
							int colnumber=0;
							while(celliterate.hasNext()) {
							Cell cell=celliterate.next();
							
							value[rownumber][colnumber]=dr.formatCellValue(cell).trim();
							colnumber++;
							}
							rownumber++;
							}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return value;
	}
/*
	
	public static String readToExcelByCell(String cellNumber,String excelFilePath,String SheetName) {
		String value = null;
		// cellNumber.replace(oldChar, newChar)
		cellNumber = cellNumber.replace(":", "");
		try {
			InputStream file = new FileInputStream(excelFilePath);
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			XSSFSheet sheetName = workBook.getSheet(SheetName);
			CellReference cf = new CellReference(cellNumber);
			Row row = sheetName.getRow(cf.getRow());
			Cell cell = row.getCell(cf.getCol());
			value = cell.getStringCellValue();
			// System.out.println(value);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}*/
	
}
