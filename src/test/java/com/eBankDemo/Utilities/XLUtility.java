package com.eBankDemo.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {

	public FileInputStream fis;
	public FileOutputStream fos;
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	
	public XLUtility(String filePath, String sheetName) 
	{
		try {
			fis=new FileInputStream(filePath);
			workbook=new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getRowCount() {
		return sheet.getLastRowNum();		
	}
	
	public int getFirstNumber() {
		return sheet.getFirstRowNum();
	}
	
	public int getColumnCount(int row) {
		return sheet.getRow(row).getLastCellNum();   //getPhysicalNumberOfCells()
	}
	
	public String getCellDate(int rowNum, int colNum) {
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(cell);
	}
	
	public void SetCellData(String filePath, String sheetName, int cRow, int cCol, String value) {
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(cRow);
		cell=row.createCell(cCol);
		cell.setCellValue(value);
		try {
			fos=new FileOutputStream(filePath);
			workbook.write(fos);
			fos.close();
		}catch (Exception e) {
		System.out.println(e.getMessage());
		}
	}
	
}
