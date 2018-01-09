package com.jayanthi.automation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	private String excelFilePath;
	private Workbook workbook;
	private String gsheet;
	public String sheet;
	public ExcelReader(String excelFilePath) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
	{
		this.excelFilePath = excelFilePath;
		/*FileInputStream fis = new FileInputStream(excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);*/
		workbook = WorkbookFactory.create(new FileInputStream(excelFilePath));
		workbook.getSheet(excelFilePath);
	}
	public int getRowCount(String sheetName)
	{
		int rowCount=0;
		rowCount = workbook.getSheet(sheetName).getLastRowNum() + 1;
		return rowCount;	
	}
	public String getCellData(String sheetName, int rowNum, int cloumnNum)
	{
		String cellValue = "";
		if(workbook.getSheet(sheetName).getRow(rowNum).getCell(cloumnNum).getCellType() == workbook.getSheet(sheetName).getRow(rowNum).getCell(cloumnNum).CELL_TYPE_STRING)
			
        {
			cellValue = workbook.getSheet(sheetName).getRow(rowNum).getCell(cloumnNum).getStringCellValue().trim();
        }
		else
		{
		  double cellValue1 = workbook.getSheet(sheetName).getRow(rowNum).getCell(cloumnNum).getNumericCellValue();
			
		}
		return cellValue;
    }
    public void setCellValue(String sheetName, int rowNum, int columnNum, String value) throws IOException
    {
    	workbook.getSheet(sheetName).getRow(rowNum).getCell(columnNum).setCellValue(value);
    	FileOutputStream fos = new FileOutputStream(excelFilePath);
    	workbook.write(fos);
    	fos.close();
    }
}
