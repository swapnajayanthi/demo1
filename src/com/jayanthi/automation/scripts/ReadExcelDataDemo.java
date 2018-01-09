package com.jayanthi.automation.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.SheetBuilder;

import com.jayanthi.automation.utilities.ExcelReader;

public class ReadExcelDataDemo {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	FileInputStream fis = new FileInputStream("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\src\\com\\jayanthi\\automation\\excelsheets\\gmail.xls.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
   // wb.getSheet(sheet1);
  
    			
    }
    
	}

